package com.chuangrong.tourism.util;

import android.util.Log;

/**
 * Created by DELL on 2017/5/8.
 */

public class LogUtil {
    private static String TAG = "qsj";
    private static boolean flag = false;

    public static void init(String tag, boolean flag) {
        LogUtil.TAG = tag;
        LogUtil.flag = flag;
    }

    public static void show(String content) {
        if (!flag) return;
        Log.e(TAG, content);

    }
}
