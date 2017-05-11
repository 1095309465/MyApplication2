package com.chuangrong.tourism.util;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chuangrong.tourism.ui.adapters.HomeRecycleAdapter;
import com.chuangrong.tourism.ui.adapters.HomeRecycleAdapter2;
import com.chuangrong.tourism.ui.bean.ScenicBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2017/5/10.
 */

public class HomeRecycleUtil2 {

    private RecyclerView recyclerView;
    private Context mContext;
    private HomeRecycleAdapter2 homeRecycleAdapter;
    private List<ScenicBean> mList;

    public HomeRecycleUtil2(Context mContext, RecyclerView recyclerView) {
        mList = new ArrayList<>();
        this.mContext = mContext;
        this.recyclerView = recyclerView;
        this.recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        homeRecycleAdapter = new HomeRecycleAdapter2(mContext, mList);
        this.recyclerView.setAdapter(homeRecycleAdapter);
    }

    public void loadData() {
        mList.clear();
        ScenicBean bean1 = new ScenicBean();
        bean1.setUrl("http://qszy.oss-cn-shanghai.aliyuncs.com/CityPicture/banner2.png");
        bean1.setName("巴黎");
        ScenicBean bean2 = new ScenicBean();
        bean2.setUrl("http://qszy.oss-cn-shanghai.aliyuncs.com/CityPicture/banner1.png");
        bean2.setName("美国");
        ScenicBean bean3 = new ScenicBean();
        bean3.setUrl("http://qszy.oss-cn-shanghai.aliyuncs.com/CityPicture/banner3.png");
        bean3.setName("巴黎");
        ScenicBean bean4 = new ScenicBean();
        bean4.setUrl("http://qszy.oss-cn-shanghai.aliyuncs.com/CityPicture/banner4.png");
        bean4.setName("巴黎");
        mList.add(bean1);
        mList.add(bean2);
        mList.add(bean3);
        mList.add(bean4);
        homeRecycleAdapter.notifyDataSetChanged();

    }
}
