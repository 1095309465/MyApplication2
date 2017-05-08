package com.qsj.test;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by DELL on 2017/5/8.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
    }
}
