package com.chuangrong.tourism.util;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Response;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by DELL on 2017/5/10.
 */

public class HttpStringUtil {

    public static String getJsonString(Response<ResponseBody> response) {
        if (response == null || response.body() == null) return "";
        BufferedSource source = response.body().source();
        try {
            source.request(Long.MAX_VALUE); // Buffer the entire body.
        } catch (IOException e) {
            e.printStackTrace();
        }
        Buffer buffer = source.buffer();
        Charset charset = UTF_8;
        MediaType contentType = response.body().contentType();
        if (contentType != null) {
            charset = contentType.charset(UTF_8);
            String str = buffer.clone().readString(charset);
            return str;
        }
        return "";
    }
}
