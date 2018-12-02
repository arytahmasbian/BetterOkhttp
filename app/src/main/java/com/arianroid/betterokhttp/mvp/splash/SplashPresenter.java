package com.arianroid.betterokhttp.mvp.splash;

import com.arianroid.betterokhttp.R;
import com.arianroid.betterokhttp.tools.internet.InternetTools;

class SplashPresenter {

    private ISplashView view;

    void init(ISplashView view) {
        this.view = view;
    }

    void viewIsReady() {
        if (InternetTools.isOnline()) {
            view.showWaiting();
            new android.os.Handler().postDelayed(() -> {
                view.goToMainPage();
            }, 500);
        }else view.showMsg(R.string.internetError);
    }

}
