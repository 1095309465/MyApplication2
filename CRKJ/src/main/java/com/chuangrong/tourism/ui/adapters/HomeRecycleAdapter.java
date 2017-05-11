package com.chuangrong.tourism.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chuangrong.tourism.R;
import com.chuangrong.tourism.ui.bean.ScenicBean2;
import com.chuangrong.tourism.util.ImageLoaderUtils;
import com.chuangrong.tourism.util.LogUtil;
import com.chuangrong.tourism.util.ScreenUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by DELL on 2017/5/10.
 */

public class HomeRecycleAdapter extends RecyclerView.Adapter<HomeRecycleAdapter.Holder> {
    private Context mContext;
    private List<ScenicBean2.DataBean> mList;
    private int type = -1;
    private int width = 0;
    private int resourId;

    public HomeRecycleAdapter(Context mContext, List<ScenicBean2.DataBean> mList, int type, int resourId) {
        this.mContext = mContext;
        this.mList = mList;
        this.type = type;
        this.resourId = resourId;
        width = ScreenUtils.getScreenWidth(mContext);
    }

    @Override
    public HomeRecycleAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(resourId, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(HomeRecycleAdapter.Holder holder, int position) {
        ScenicBean2.DataBean scenicBean = mList.get(position);
        ImageLoaderUtils.load(holder.img, scenicBean.getCoverPhoto());
        holder.tv_title.setText(scenicBean.getScenicSpot_Name());

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
