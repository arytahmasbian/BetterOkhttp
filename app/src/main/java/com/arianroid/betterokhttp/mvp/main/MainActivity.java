package com.arianroid.betterokhttp.mvp.main;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.arianroid.betterokhttp.R;
import com.arianroid.betterokhttp.tools.base.BaseActivity;
import com.arianroid.betterokhttp.tools.views.message.MessageHelper;
import com.github.ybq.android.spinkit.style.RotatingCircle;
import com.github.ybq.android.spinkit.style.WanderingCubes;

public class MainActivity
        extends
        BaseActivity
        implements
        IMainView {

    private MainPresenter presenter;
    private ProgressBar progressBar;
    private WanderingCubes wanderingCubes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActivity();
        createPresenter();

    }

    private void createPresenter() {
        presenter = new MainPresenter();
        presenter.initial(this);
        presenter.viewIsReady();
    }

    private void initActivity() {
        progressBar = findViewById(R.id.progressBar);
        wanderingCubes = new WanderingCubes();
        wanderingCubes.setColorFilter(getColor(R.color.whiteBlue), PorterDuff.Mode.MULTIPLY);
        progressBar.setIndeterminateDrawable(wanderingCubes);
        closeWaiting();
    }

    public void onClick(View view) {
        presenter.onClick(view.getId());
    }

    @Override
    public void showMsg(int msgId) {
        MessageHelper.showMessage(this, msgId);
    }


    @Override
    public void showWaiting() {
        progressBar.setIndeterminate(true);
        progressBar.setIndeterminateDrawable(wanderingCubes);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void closeWaiting() {
        progressBar.setIndeterminate(false);
        progressBar.setVisibility(View.INVISIBLE);
    }
}
