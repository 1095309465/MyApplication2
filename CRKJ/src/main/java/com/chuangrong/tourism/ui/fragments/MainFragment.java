package com.chuangrong.tourism.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chuangrong.tourism.R;
import com.chuangrong.tourism.ui.adapters.MainFragmentPagerAdapter;
import com.chuangrong.tourism.ui.bean.ScenicBean2;
import com.chuangrong.tourism.util.HomeRecycleUtil;
import com.chuangrong.tourism.util.HomeRecycleUtil2;
import com.chuangrong.tourism.util.HomeRecycleUtil3;
import com.chuangrong.tourism.util.HomeViewPagerUtil;
import com.chuangrong.tourism.util.HttpStringUtil;
import com.chuangrong.tourism.util.HttpUtils;
import com.chuangrong.tourism.util.LogUtil;
import com.chuangrong.tourism.util.ToastUtil;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DELL on 2017/5/9.
 */

public class MainFragment extends Fragment {
    private ViewPager viewPager;
    private LinearLayout lin_dot;
    private MainFragmentPagerAdapter fragmentPagerAdapter;
    private List<String> urlList;
    private Context mContext;
    private HomeViewPagerUtil viewPagerUtil;


    private HomeRecycleUtil homeRecycleUtil;
    private HomeRecycleUtil homeRecycleUtil2;
    private HomeRecycleUtil homeRecycleUtil3;

    private RecyclerView recycleView;
    private RecyclerView recycleView2;
    private RecyclerView recyclerView3;

    public MainFragment() {

    }

    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        mainFragment.setArguments(null);
        return mainFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        initView(view);
        loadData();
        return view;
    }

    private void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        lin_dot = (LinearLayout) view.findViewById(R.id.lin_dot);
        recycleView = (RecyclerView) view.findViewById(R.id.recycleView);
        recycleView2 = (RecyclerView) view.findViewById(R.id.recycleView2);
        recyclerView3 = (RecyclerView) view.findViewById(R.id.recycleView3);
    }

    private void initData(List<ScenicBean2.DataBean> list) {
        LogUtil.show("initData");
        viewPagerUtil = new HomeViewPagerUtil(mContext, viewPager, fragmentPagerAdapter, urlList, lin_dot);
        homeRecycleUtil = new HomeRecycleUtil(mContext, recycleView, list, 1);
        homeRecycleUtil2 = new HomeRecycleUtil(mContext, recycleView2, list, 2);
        homeRecycleUtil3 = new HomeRecycleUtil(mContext, recyclerView3, list, 0);
    }

    public void loadData() {
        HttpUtils.getInstance(mContext).getRetrofit().getAllScenicSpot("1", "2").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonStr = HttpStringUtil.getJsonString(response);
                if (!TextUtils.isEmpty(jsonStr)) {
                    LogUtil.show("服务器数据=" + jsonStr);
                    ScenicBean2 bean = new Gson().fromJson(jsonStr, ScenicBean2.class);
                    int code = bean.getCode();
                    if (code == 200) {
                        if (bean.getData().size() > 0) {
                            LogUtil.show("bean.getData().size()=" + bean.getData().size());

                            initData(bean.getData());

                        }
                    } else {
                        ToastUtil.show("服务器异常code==200");
                    }
                    LogUtil.show("ScenicBean2=" + bean.toString());
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
