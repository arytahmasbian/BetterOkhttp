package com.arianroid.betterokhttp.mvp.splash;

public interface ISplashView {


    void showMsg(int msgId);

    void showWaiting();

    void closeWaiting();

    void goToMainPage();

}
