package com.chuangrong.tourism.util;

import android.content.Context;

import com.chuangrong.tourism.api.RetrofitApi;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bigyu on 2016/11/9.
 */

public class HttpUtils {
    private static HttpUtils httpUtils = null;
    private static final int DEFAULT_TIMEOUT = 7;
    //测试用
    //public static final String BASE_URL = "http://by-api.jackyzhong.com/";
    public static final String BASE_WEB_URL = "http://192.168.3.127:802/";
    //正式
    //public static final String BASE_WEB_URL = "http://wechat.91qszy.com/";

    //    public static final String BASE_URL = "http://api.91qszy.com/";
    private RetrofitApi retrofitApi;

    //appinfo : {"platform" :"iOS Android", "version":4.2  }
    private HttpUtils() {
        // Exists only to defeat instantiation.
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                //     .addHeader("appinfo", addAppInfo())
                                .build();
                        return chain.proceed(request);
                    }
                })
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();

        retrofitApi = new Retrofit.Builder()
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(GlobalVars.getVars().baseUrl)
                .build()
                .create(RetrofitApi.class);
    }


    public static HttpUtils getInstance(Context context) {
        if (httpUtils == null) {
            httpUtils = new HttpUtils();
        }
        return httpUtils;
    }

    public RetrofitApi getRetrofit() {
        return retrofitApi;
    }

}
