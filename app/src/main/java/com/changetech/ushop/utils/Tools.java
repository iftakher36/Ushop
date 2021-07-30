package com.changetech.ushop.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.core.widget.NestedScrollView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.changetech.ushop.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {
    AlertDialog alertDialog;
    public static Dialog dialog;
    Activity activity;

//    public Tools(Activity activity){
//        this.activity = activity;
//    }

    public static void setSystemBarColor(Activity act) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = act.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(act.getResources().getColor(R.color.colorPrimary));
        }
    }

    public static void setSystemBarColor(Activity act, @ColorRes int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = act.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(act.getResources().getColor(color));
        }
    }

    public static void setSystemBarColorInt(Activity act, @ColorInt int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = act.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(color);
        }
    }

    public static void setSystemBarColorDialog(Context act, Dialog dialog, @ColorRes int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = dialog.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(act.getResources().getColor(color));
        }
    }

    public static void setSystemBarLight(Activity act) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View view = act.findViewById(android.R.id.content);
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            Window window = act.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(act.getResources().getColor(R.color.white));
        }
    }

    public static void setSystemBarLightDialog(Dialog dialog) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View view = dialog.findViewById(android.R.id.content);
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
        }
    }

    public static void clearSystemBarLight(Activity act) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = act.getWindow();
            window.setStatusBarColor(ContextCompat.getColor(act, R.color.colorPrimaryDark));
        }
    }

    /**
     * Making notification bar transparent
     */
    public static void setSystemBarTransparent(Activity act) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = act.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static void setFullScreen(Activity act){
//        act.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        act.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Window window = act.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        else{
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

//            if(isTextBlack){
//                View view = act.findViewById(android.R.id.content);
//                int flags = view.getSystemUiVisibility();
//                flags |= SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
//                view.setSystemUiVisibility(flags);
//            }
        }
    }


    public static String getFormattedDateShort(Long dateTime) {
        SimpleDateFormat newFormat = new SimpleDateFormat("MMM dd, yyyy");
        return newFormat.format(new Date(dateTime));
    }

    public static String getFormattedDateSimple(Long dateTime) {
        SimpleDateFormat newFormat = new SimpleDateFormat("MMMM dd, yyyy");
        newFormat.setTimeZone(java.util.TimeZone.getTimeZone("GMT+6"));
        return newFormat.format(new Date(dateTime));
    }

    public static String getFormattedDateEvent(Long dateTime) {
        SimpleDateFormat newFormat = new SimpleDateFormat("EEE, MMM dd yyyy");
        newFormat.setTimeZone(java.util.TimeZone.getTimeZone("GMT+6"));
        return newFormat.format(new Date(dateTime));
    }

    public static String getFormattedTimeEvent(Long time) {
        SimpleDateFormat newFormat = new SimpleDateFormat("h:mm a");
        newFormat.setTimeZone(java.util.TimeZone.getTimeZone("GMT+6"));
        return newFormat.format(new Date(time));
    }



    public static void nestedScrollTo(final NestedScrollView nested, final View targetView) {
        nested.post(new Runnable() {
            @Override
            public void run() {
                nested.scrollTo(800, targetView.getBottom());
            }
        });
    }

    public static Date getDateWithoutTimeUsingFormat()
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.parse(formatter.format(new Date()));
    }


    public static String dateTimeFormatter(String time) {
        String inputPattern = "yyyy-MM-dd HH:mm:ss";
        String outputPattern = "d MMM, yyyy hh:mm aa";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String formatNumber(String data, boolean hasComma){
        NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
        String value = nf.format(Double.parseDouble(data));

        if(!hasComma){
            value = value.replace(",", "");
        }

        return value;
    }


    public static long getDateDiff(SimpleDateFormat format, String oldDate, String newDate) {
        try {
            return TimeUnit.DAYS.convert(format.parse(newDate).getTime() - format.parse(oldDate).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void displayImageRound(final Context ctx, final ImageView img, int drawable) {
        try {
            Glide.with(ctx).asBitmap().load(drawable).centerCrop().into(new BitmapImageViewTarget(img) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(ctx.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    img.setImageDrawable(circularBitmapDrawable);
                }
            });
        } catch (Exception e) {
        }
    }


    public static void displayImageRound(final Context ctx, final ImageView img, String url, int placeholder) {
        try {
            Glide.with(ctx).asBitmap().load(url).placeholder(placeholder).into(new BitmapImageViewTarget(img) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(ctx.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    img.setImageDrawable(circularBitmapDrawable);
                }
            });
        } catch (Exception e) {
        }
    }


    public static String getEmailFromName(String name) {
        if (name != null && !name.equals("")) {
            String email = name.replaceAll(" ", ".").toLowerCase().concat("@mail.com");
            return email;
        }
        return name;
    }


    public static void displayImageOriginal(Context ctx, ImageView img, @DrawableRes int drawable) {
        try {
            Glide.with(ctx)
                    .load(drawable)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(img);

        } catch (Exception e) {
        }
    }

    public static int dpToPx(Context c, int dp) {
        Resources r = c.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


    public static void imageLoad(Activity context, ImageView imageView, String path, int placeholder) {
        Glide.with(context).load(path).placeholder(placeholder).into(imageView);
    }

    public static void imageLoad(Activity context, ImageView imageView, int drawable, int placeholder) {
        Glide.with(context).load(drawable).placeholder(placeholder).into(imageView);

    }

    public static void imageLoad(Activity context, ImageView imageView, Drawable path) {
        Glide.with(context).load(path).into(imageView);
    }

    public static void setBackgroundImage(Activity context, final View view, String path) {

        Glide.with(context).load(path).into(new CustomTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                view.setBackground(resource);
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {
            }
        });

    }

    public static void setBackgroundImage(Activity context, final View view, Drawable path) {

        Glide.with(context).load(path).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                return false;
            }
        }).into(new CustomTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                view.setBackground(resource);
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {
            }
        });

    }

    public static String getValidNumber(String number){
        if(number.isEmpty()){
            return null;
        }
        // replace all characters except 0-9 with blank
        number = number.replaceAll("\\D+","");

        if (number.startsWith("8801") && number.length() == 13){
            number = number.substring(2);
        }
        else if(number.startsWith("1") && number.length() == 10){
            number = "0"+number;
        }

        if(number.startsWith("01") && number.length() == 11){
            return number;
        }

        return null;
    }

    public static void showLoadingDialog(Activity activity) {
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
//        dialog.setContentView(R.layout.loading_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.show();
    }

    public static void hideLoadingDialog(){
        if(dialog != null){
            dialog.cancel();
        }
    }

    public static boolean validatePassword(final String password) {
        if(password == null){
            return false;
        }
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.!_])(?=\\S+$).{8,}$";
//        final String PASSWORD_PATTERN = "^.{6,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

    public static String formattedAmount(Double balance) {
        String formatted;

        if (balance==0){
            formatted="0";
        }else {
            String n = String.valueOf(balance);
            double amount = Double.parseDouble(n);
//            DecimalFormat formatter = new DecimalFormat("#,###,###,###.00");
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            formatted = formatter.format(amount);
        }

        return formatted;
    }

}
