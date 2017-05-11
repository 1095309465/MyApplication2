package com.chuangrong.tourism.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chuangrong.tourism.R;
import com.chuangrong.tourism.ui.bean.ScenicBean;
import com.chuangrong.tourism.util.ImageLoaderUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by DELL on 2017/5/10.
 */

public class HomeRecycleAdapter2 extends RecyclerView.Adapter<HomeRecycleAdapter2.Holder> {
    private Context mContext;
    private List<ScenicBean> mList;

    public HomeRecycleAdapter2(Context mContext, List<ScenicBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public HomeRecycleAdapter2.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_recycle, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(HomeRecycleAdapter2.Holder holder, int position) {
        ScenicBean scenicBean = mList.get(position);
        ImageLoaderUtils.load(holder.img, scenicBean.getUrl());
        holder.tv_title.setText(scenicBean.getName());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        SimpleDraweeView img;
        TextView tv_title;

        public Holder(View itemView) {
            super(itemView);
            img = (SimpleDraweeView) itemView.findViewById(R.id.img);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}