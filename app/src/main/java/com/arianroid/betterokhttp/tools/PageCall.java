package com.arianroid.betterokhttp.tools;


import android.content.Context;
import android.content.Intent;

import com.arianroid.betterokhttp.mvp.main.MainActivity;
import com.arianroid.betterokhttp.mvp.splash.SplashActivity;

public class PageCall {


    public static void startMainActivityPage(Context context) {

        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
                |Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }


    public static void startSplashPage(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }


}
