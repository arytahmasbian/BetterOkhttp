package com.arianroid.betterokhttp.tools.internet;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

import com.arianroid.betterokhttp.tools.application.MyApplicaiton;

public class InternetTools {

    private static NetworkInfo networkInfo;

    public static boolean isOnline() {
        return getNetworkInfoState();
    }

    private static boolean getNetworkInfoState() {
        boolean internetConnectionIsOn = false;
        WifiManager wifiManager = (WifiManager) MyApplicaiton.busContext.getSystemService(Context.WIFI_SERVICE);
        if (wifiManager.isWifiEnabled()) {
            internetConnectionIsOn = true;
        }

        ConnectivityManager cm = (ConnectivityManager) MyApplicaiton.busContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = cm.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            internetConnectionIsOn = true;
        }

        return internetConnectionIsOn;
    }

    public NetworkInfo getNetworkInfo() {
        ConnectivityManager cm = (ConnectivityManager) MyApplicaiton.busContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = cm.getActiveNetworkInfo();

        return networkInfo;
    }
}
