package com.arianroid.betterokhttp.mvp.main;

import android.util.Log;

import com.arianroid.betterokhttp.R;
import com.arianroid.betterokhttp.tools.api.ReqResApi;
import com.arianroid.betterokhttp.tools.internet.InternetTools;

class MainPresenter {
    private IMainView view;
    private int message = 0;


    void initial(IMainView view) {
        this.view = view;
    }

    void viewIsReady() {

    }

    void onClick(int id) {
        switch (id) {
            case R.id.submitGet:
                getUser();
                break;
            case R.id.submitPost:
                postUser();
                break;
        }
    }

    private void getUser() {

        if (InternetTools.isOnline()) {
            view.showWaiting();

            int fakeUserId = 2;
            ReqResApi.getUser(fakeUserId,
                    response -> {

                        if (response.isServiceUnavailable()) {
                            message = R.string.serverExceptionMessage;
                        } else {

                            //read json
                            Log.i("Log", "response is : " + response.getBodyString());

                            message = R.string.responseIsOk;

                        }

                        view.closeWaiting();
                        view.showMsg(message);

                    });
        } else {
            view.closeWaiting();
            view.showMsg(R.string.internetError);
        }


    }

    private void postUser() {

        if (InternetTools.isOnline()) {
            view.showWaiting();

            String name = "Arianroid";
            String job = "Android developer";

            ReqResApi.createUser(
                    name,
                    job,
                    response -> {

                        if (response.isServiceUnavailable()) {
                            message = R.string.serverExceptionMessage;
                        } else {

                            //read response
                            Log.i("Log", "response is : " + response.getBodyString());
                            message = R.string.responseIsOk;

                        }

                        view.closeWaiting();
                        view.showMsg(message);
                    });
        }
        else {
            view.closeWaiting();
            view.showMsg(R.string.internetError);
        }

    }


}
