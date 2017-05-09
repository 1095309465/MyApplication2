package com.chuangrong.tourism.ui.adapters;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.chuangrong.tourism.R;
import com.chuangrong.tourism.util.ImageLoaderUtils;
import com.chuangrong.tourism.util.LogUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2017/5/9.
 */

public class MainFragmentPagerAdapter extends PagerAdapter {

    public List<View> mList;
    public List<String> strList;

    public MainFragmentPagerAdapter() {
        mList = new ArrayList<>();
        strList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        if (mList.size() == 0) {
            return 0;
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int index = position % mList.size();
        View contentView = mList.get(index);
        if (contentView.getParent() != null) {
            container.removeView(contentView);
        }
        SimpleDraweeView img = (SimpleDraweeView) contentView.findViewById(R.id.img);
        String url = strList.get(index);
        ImageLoaderUtils.load(img, url);
        container.addView(mList.get(index));
        return mList.get(index);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
