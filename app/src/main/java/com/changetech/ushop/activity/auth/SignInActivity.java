package com.changetech.ushop.activity.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.changetech.ushop.CONSTANTS.UshopConst;
import com.changetech.ushop.R;
import com.changetech.ushop.ViewModel.UserViewModel;
import com.changetech.ushop.db.table.User;
import com.changetech.ushop.utils.Tools;
import com.google.android.material.textfield.TextInputEditText;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.linearLayout_sign_in)
    LinearLayout linearLayoutSignIn;
    UserViewModel userViewModel;
    @BindView(R.id.textinputedittext_phone)
    TextInputEditText editTextPhone;
    @BindView(R.id.textinputedittext_pass)
    TextInputEditText editTextPassword;
    @BindView(R.id.textView_sign_up)
    TextView textViewSignUp;
    @BindView(R.id.imageView_back)
    ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Tools.setSystemBarColor(this, R.color.colorPrimary);
        ButterKnife.bind(this);
        textViewSignUp.setOnClickListener(this);
        linearLayoutSignIn.setOnClickListener(this);
        imageViewBack.setOnClickListener(this);
        userViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory
                        .getInstance(getApplication()))
                .get(UserViewModel.class);
    }

    @Override
    public void onClick(View v) {
        if (v == linearLayoutSignIn) {
            userViewModel.getUser(editTextPhone.getText().toString()).observe(SignInActivity.this, new Observer<User>() {
                @Override
                public void onChanged(User user) {
                    try {

                        Toast.makeText(SignInActivity.this, "" + decrypt(user.getPassword()), Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        if (e instanceof NullPointerException) {
                            Toast.makeText(SignInActivity.this, "we didn't found any account associate with this number" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

        } else if (v == textViewSignUp) {
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(intent);
        } else if (v == imageViewBack) {
            finish();
        }

    }

    public String decrypt(String pass) throws Exception {
        SecretKeySpec secretKeySpec = generateKey(UshopConst.ENCRYPTIONKEY);
        Cipher c = Cipher.getInstance(UshopConst.AES);
        c.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decodeValue = Base64.decode(pass, Base64.DEFAULT);
        byte[] decValue = c.doFinal(decodeValue);
        return new String(decValue);

    }

    public SecretKeySpec generateKey(String pass) throws Exception {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = pass.getBytes("UTF-8");
        digest.update(bytes, 0, bytes.length);
        byte[] key = digest.digest();
        return new SecretKeySpec(key, "AES");
    }
}