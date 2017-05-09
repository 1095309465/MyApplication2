package com.chuangrong.tourism.ui.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chuangrong.tourism.R;
import com.chuangrong.tourism.ui.adapters.MainFragmentPagerAdapter;
import com.chuangrong.tourism.util.HomeViewPagerUtil;
import com.chuangrong.tourism.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

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
        mContext = getActivity().getApplicationContext();
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        lin_dot = (LinearLayout) view.findViewById(R.id.lin_dot);

    }

    private void initData() {
        viewPagerUtil = new HomeViewPagerUtil(mContext, viewPager, fragmentPagerAdapter, urlList, lin_dot);

    }

}
