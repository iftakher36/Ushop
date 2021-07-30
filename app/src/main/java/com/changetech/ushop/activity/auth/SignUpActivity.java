package com.changetech.ushop.activity.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.changetech.ushop.CONSTANTS.UshopConst;
import com.changetech.ushop.R;
import com.changetech.ushop.ViewModel.UserViewModel;
import com.changetech.ushop.activity.HomeActivity;
import com.changetech.ushop.db.table.User;
import com.changetech.ushop.utils.Tools;
import com.google.android.material.textfield.TextInputEditText;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.linearLayout_sign_up)
    LinearLayout linearLayoutSignUp;
    @BindView(R.id.textView_sign_in)
    TextView textViewSignIn;
    UserViewModel userViewModel;
    @BindView(R.id.textinputedittext_name)
    TextInputEditText textInputEditTextName;
    @BindView(R.id.textinputedittext_pass)
    TextInputEditText textInputEditTextPass;
    @BindView(R.id.textinputedittext_phone)
    TextInputEditText textInputEditTextPhone;
    @BindView(R.id.imageView_back)
    ImageView imageViewBack;
    Boolean isObserved=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Tools.setSystemBarColor(this, R.color.colorPrimary);
        ButterKnife.bind(this);
        linearLayoutSignUp.setOnClickListener(this);
        imageViewBack.setOnClickListener(this);
        textViewSignIn.setOnClickListener(this);
        userViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(UserViewModel.class);
    }

    @Override
    public void onClick(View v) {
        if (v == linearLayoutSignUp) {
            if (!(textInputEditTextName.getText().toString().isEmpty() || textInputEditTextPhone.getText().toString().isEmpty() || textInputEditTextPass.getText().toString().isEmpty())) {
                if (textInputEditTextPhone.getText().toString().length() == 11 && textInputEditTextPass.getText().toString().length() >= 8) {
                    userViewModel.getUser(textInputEditTextPhone.getText().toString()).observe(SignUpActivity.this, new Observer<User>() {
                        @Override
                        public void onChanged(User user) {
                            try {
                                if (user.getPassword() != null && !isObserved ) {
                                    Toast.makeText(SignUpActivity.this, ""+user.getPassword(), Toast.LENGTH_SHORT).show();
                                }
                            }catch (Exception e)
                            {
                                try {
                                    User userToInsert = new User(textInputEditTextName.getText().toString(), textInputEditTextPhone.getText().toString(), encrypt(textInputEditTextPass.getText().toString()), null, null, true);
                                    userViewModel.insert(userToInsert);
                                    textInputEditTextName.setText("");
                                    textInputEditTextPass.setText("");
                                    textInputEditTextPhone.setText("");
                                    Toast.makeText(SignUpActivity.this, "Successfully Signed Up", Toast.LENGTH_SHORT).show();
                                    isObserved=true;
                                    Intent intent=new Intent(getApplicationContext(), HomeActivity.class);
                                    startActivity(intent);
                                } catch (Exception exception) {
                                    exception.printStackTrace();
                                }
                            }

                        }
                    });
                } else if (textInputEditTextPhone.getText().toString().length() < 11) {
                    Toast.makeText(this, "Phone number must be 11 digit", Toast.LENGTH_SHORT).show();
                } else if (textInputEditTextPass.getText().toString().length() < 8) {
                    Toast.makeText(this, "Password minimum requirement 8 character", Toast.LENGTH_SHORT).show();
                }
            } else if (textInputEditTextName.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please fill user name", Toast.LENGTH_SHORT).show();
            } else if (textInputEditTextPhone.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please fill phone number", Toast.LENGTH_SHORT).show();
            } else if (textInputEditTextPass.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please fill password", Toast.LENGTH_SHORT).show();
            }
        } else if (v == textViewSignIn) {
            finish();
        } else if (v == imageViewBack) {
            finish();
        }

    }


    public String encrypt(String pass) throws Exception {
        SecretKeySpec secretKeySpec = generateKey(UshopConst.ENCRYPTIONKEY);
        Cipher c = Cipher.getInstance(UshopConst.AES);
        c.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encVal = c.doFinal(pass.getBytes());
        String encValue = Base64.encodeToString(encVal, Base64.DEFAULT);
        return encValue;

    }

    public SecretKeySpec generateKey(String pass) throws Exception {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = pass.getBytes("UTF-8");
        digest.update(bytes, 0, bytes.length);
        byte[] key = digest.digest();
        return new SecretKeySpec(key, "AES");
    }
}
  /* try {
           if (userInfo.getPassword() != null) {
           Toast.makeText(SignUpActivity.this, "Already have an account associated with this", Toast.LENGTH_SHORT).show();
           }else {
           Toast.makeText(this, ""+userInfo.getPassword(), Toast.LENGTH_SHORT).show();
           }
           } catch (Exception e) {
           if (e instanceof NullPointerException) {
           try {
           User userToInsert = new User(textInputEditTextName.getText().toString(), textInputEditTextPhone.getText().toString(), encrypt(textInputEditTextPass.getText().toString()), null, null, true);
           userViewModel.insert(userToInsert);
           textInputEditTextName.setText("");
           textInputEditTextPass.setText("");
           textInputEditTextPhone.setText("");
           Toast.makeText(SignUpActivity.this, "Successfully Signed Up", Toast.LENGTH_SHORT).show();
           } catch (Exception exception) {
           exception.printStackTrace();
           }
           }
           Log.d("pass", " "+e.toString());
           }*/