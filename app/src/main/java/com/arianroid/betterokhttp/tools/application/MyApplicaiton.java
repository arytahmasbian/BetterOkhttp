package com.arianroid.betterokhttp.tools.application;


import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.arianroid.betterokhttp.tools.exceptionHandler.CustomThreadExceptionHandler;

public class MyApplicaiton extends Application {

    public static Context busContext;
    public static String dataDir, versionName;
    public static int versionCode;

    public static void getAppDataDir() {
        PackageManager m = MyApplicaiton.busContext.getPackageManager();
        String name = MyApplicaiton.busContext.getPackageName();
        try {
            PackageInfo p = m.getPackageInfo(name, 0);
            name = p.applicationInfo.dataDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        MyApplicaiton.dataDir = name;
    }

    public static void getAppPackageInfo() {
        try {
            versionName = busContext.getPackageManager()
                    .getPackageInfo(getAppPackageName(), 0).versionName;
            versionCode = busContext.getPackageManager()
                    .getPackageInfo(getAppPackageName(), 0).versionCode;

        } catch (PackageManager.NameNotFoundException e) {
            versionCode = 0;
            versionName = "";
        }
    }

    private static String getAppPackageName() {
        return busContext.getPackageName();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new CustomThreadExceptionHandler());
        busContext = getApplicationContext();

        try {
            getAppDataDir();
            getAppPackageInfo();
        } catch (Exception e) {
            //maybe has been filtered
//            Crashlytics.logException(e);
        }

    }

}
