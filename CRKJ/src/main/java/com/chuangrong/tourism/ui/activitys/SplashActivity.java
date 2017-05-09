package com.chuangrong.tourism.ui.activitys;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.chuangrong.tourism.R;
import com.chuangrong.tourism.widget.TimeCountWidget;
import com.facebook.drawee.view.SimpleDraweeView;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView img;
    private TimeCountWidget countWidget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //不显示系统的通知栏（）全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        initView();
    }


    private void initView() {
        img = (SimpleDraweeView) findViewById(R.id.img);
        countWidget = (TimeCountWidget) findViewById(R.id.countWidget);
        countWidget.setOnClickListener(this);
        countWidget.setOnStopListener(new TimeCountWidget.OnStopListener() {
            @Override
            public void stop() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && countWidget != null)
            countWidget.startCount();
    }

    @Override
    public void onClick(View v) {
        if (countWidget != null) countWidget.stopCount();
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}
