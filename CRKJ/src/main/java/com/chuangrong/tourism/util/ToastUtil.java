package com.chuangrong.tourism.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by DELL on 2017/5/9.
 */

public class ToastUtil {

    public static Context mContext;

    public static void init(Context context) {
        ToastUtil.mContext = context;
    }

    public static void show(String content) {
        Toast.makeText(mContext, content, Toast.LENGTH_SHORT).show();
    }
}
