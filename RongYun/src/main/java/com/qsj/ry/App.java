package com.qsj.ry;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by DELL on 2017/5/4.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initRongYun();
    }

    private void initRongYun() {
        RongIM.init(this);
    }
}
