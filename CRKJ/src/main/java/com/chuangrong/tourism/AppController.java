package com.chuangrong.tourism;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.chuangrong.tourism.util.LogUtil;
import com.chuangrong.tourism.util.SPUtils;
import com.chuangrong.tourism.util.ToastUtil;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by DELL on 2017/5/8.
 */

public class AppController extends Application {

    private String TAG = "QSJ";
    private boolean logFlag = true;

    private String sharePreName = "config";

    @Override
    public void onCreate() {
        super.onCreate();
        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext()))) {
            initFresco();
            initToastUtil();
            initLogUtil();
            intiSPUtil();
        }

    }

    /**
     * 初始化Fresco
     */
    private void initFresco() {
        Fresco.initialize(this);
    }

    /**
     * 初始化LogUtil
     */
    private void initLogUtil() {
        LogUtil.init(TAG, logFlag);
        LogUtil.show("初始化成功");
    }

    /**
     * 初始化Toast
     */
    private void initToastUtil() {
        ToastUtil.init(getApplicationContext());
    }

    /**
     * 初始化SPUtils
     */
    private void intiSPUtil() {
        SPUtils.init(getSharedPreferences(sharePreName, MODE_PRIVATE));
    }


    /**
     * 获取当前进程名字的方法
     *
     * @param context
     * @return
     */
    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}
