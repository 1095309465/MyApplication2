package com.chuangrong.tourism.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chuangrong.tourism.R;
import com.chuangrong.tourism.util.HttpStringUtil;
import com.chuangrong.tourism.util.HttpUtils;
import com.chuangrong.tourism.util.LogUtil;
import com.chuangrong.tourism.util.ToastUtil;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DELL on 2017/5/9.
 */

public class Main2Fragment extends Fragment implements View.OnClickListener {


    public Main2Fragment() {

    }

    public static Main2Fragment newInstance() {
        Main2Fragment main2Fragment = new Main2Fragment();
        main2Fragment.setArguments(null);
        return main2Fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_main2, null);
        return contentView;
    }


    @Override
    public void onClick(View v) {
        HttpUtils.getInstance(getActivity().getApplicationContext()).getRetrofit().getAllScenicSpot("1", "2").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonStr = HttpStringUtil.getJsonString(response);
                if (!TextUtils.isEmpty(jsonStr)) {
                    LogUtil.show("服务器数据=" + jsonStr);

                } else {
                    ToastUtil.show("服务器异常=");
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                ToastUtil.show("网络异常=" + t.getMessage());

            }
        });


    }
}
