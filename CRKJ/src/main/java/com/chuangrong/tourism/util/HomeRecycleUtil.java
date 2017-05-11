package com.chuangrong.tourism.util;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.chuangrong.tourism.R;
import com.chuangrong.tourism.ui.adapters.HomeRecycleAdapter;
import com.chuangrong.tourism.ui.bean.ScenicBean;
import com.chuangrong.tourism.ui.bean.ScenicBean2;
import com.chuangrong.tourism.widget.FullLinearLayout;
import com.chuangrong.tourism.widget.FullyLinearLayoutManager;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DELL on 2017/5/10.
 */

public class HomeRecycleUtil {

    private RecyclerView recyclerView;
    private HomeRecycleAdapter homeRecycleAdapter;
    private List<ScenicBean2.DataBean> mList;
    private Context mContext;

    public HomeRecycleUtil(Context mContext, RecyclerView recyclerView, List<ScenicBean2.DataBean> list, int type) {
        mList = null;
        mList = new ArrayList<>();
        mList.addAll(list);
        this.mContext = mContext;
        int resourId = 0;

        switch (type) {
            case 0:
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                resourId = R.layout.item_home_recycle3;
                break;
            case 1:
                recyclerView.setLayoutManager(new FullLinearLayout(mContext, 8));
                recyclerView.setHasFixedSize(true);
                resourId = R.layout.item_home_recycle;
                break;
            case 2:
                recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
                resourId = R.layout.item_home_recycle;
                break;
        }
        homeRecycleAdapter = null;
        homeRecycleAdapter = new HomeRecycleAdapter(mContext, mList, type, resourId);
        recyclerView.setAdapter(homeRecycleAdapter);
    }

}
