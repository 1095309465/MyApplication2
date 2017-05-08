package com.chuangrong.tourism.util;

import android.net.Uri;
import android.text.TextUtils;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by DELL on 2017/5/8.
 */

public class ImageLoaderUtils {

    public static void load(SimpleDraweeView imageview, String url) {
        if (!TextUtils.isEmpty(url)) {
            Uri uri = Uri.parse(url);
            imageview.setImageURI(uri);
        }
    }
}
