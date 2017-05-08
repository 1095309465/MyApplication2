package com.chuangrong.tourism.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.chuangrong.tourism.R;
import com.chuangrong.tourism.widget.TimeCountWidget;
import com.facebook.drawee.view.SimpleDraweeView;

public class SplashActivity extends AppCompatActivity {
    private SimpleDraweeView img;
    private TimeCountWidget countWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //不显示系统的通知栏（）全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        img = (SimpleDraweeView) findViewById(R.id.img);
        countWidget = (TimeCountWidget) findViewById(R.id.countWidget);
    }
}
