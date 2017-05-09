package com.chuangrong.tourism.ui.activitys;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.chuangrong.tourism.util.LogUtil;
import com.chuangrong.tourism.util.ToastUtil;

/**
 * Created by DELL on 2017/5/9.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private long startTime;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBeforeLayout();

        setContentView(getLayoutId());
        initView();
        initListener();
        initData();
    }

    @Override
    public void onBackPressed() {
        long nowTime = System.currentTimeMillis();
        long dexTime = (nowTime - startTime) / 1000;
        if (dexTime > 1) {
            startTime = nowTime;
            ToastUtil.show("再按一次退出");
        } else {
            super.onBackPressed();
        }

    }

    public abstract int getLayoutId();

    public void initBeforeLayout() {

    }

    public void initView() {

    }

    public void initData() {

    }
    public void initListener(){

    }

}
