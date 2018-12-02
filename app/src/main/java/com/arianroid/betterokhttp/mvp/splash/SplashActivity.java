package com.arianroid.betterokhttp.mvp.splash;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;

import com.arianroid.betterokhttp.R;
import com.arianroid.betterokhttp.tools.PageCall;
import com.arianroid.betterokhttp.tools.base.BaseActivity;
import com.arianroid.betterokhttp.tools.views.message.MessageHelper;
import com.github.ybq.android.spinkit.style.RotatingCircle;

public class SplashActivity
        extends
        BaseActivity
        implements
        ISplashView {

    private ProgressBar progressBar;
    private RotatingCircle rotatingCircle;
    private SplashPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        initActivity();
        createPresenter();
    }

    private void initActivity() {
        progressBar = findViewById(R.id.progressBar);
        rotatingCircle = new RotatingCircle();
        rotatingCircle.setColorFilter(getColor(R.color.whiteBlue), PorterDuff.Mode.MULTIPLY);
        progressBar.setIndeterminateDrawable(rotatingCircle);
    }

    private void createPresenter() {
        presenter = new SplashPresenter();
        presenter.init(this);
        presenter.viewIsReady();
    }

    @Override
    public void showMsg(int msgId) {
        MessageHelper.showMessage(this, msgId);
    }

    @Override
    public void showWaiting() {
        progressBar.setIndeterminate(true);
        progressBar.setIndeterminateDrawable(rotatingCircle);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void closeWaiting() {
        progressBar.setIndeterminate(false);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void goToMainPage() {
        PageCall.startMainActivityPage(this);
    }
}
