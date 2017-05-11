package com.chuangrong.tourism.ui.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.chuangrong.tourism.R;
import com.chuangrong.tourism.ui.fragments.Main2Fragment;
import com.chuangrong.tourism.ui.fragments.Main3Fragment;
import com.chuangrong.tourism.ui.fragments.Main4Fragment;
import com.chuangrong.tourism.ui.fragments.MainFragment;
import com.chuangrong.tourism.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    Button btnMain;
    Button btnMain2;
    Button btnMain3;
    Button btnMain4;
    FrameLayout lyContent;
    RelativeLayout activityMain;


    private List<Fragment> mList;
    private int fragmentIndex = -1;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void initView() {
        btnMain = (Button) findViewById(R.id.btn_main);
        btnMain2 = (Button) findViewById(R.id.btn_main2);
        btnMain3 = (Button) findViewById(R.id.btn_main3);
        btnMain4 = (Button) findViewById(R.id.btn_main4);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void initListener() {
        btnMain.setOnClickListener(this);
        btnMain2.setOnClickListener(this);
        btnMain3.setOnClickListener(this);
        btnMain4.setOnClickListener(this);
    }

    @Override
    public void initData() {
        mList = new ArrayList<>();
        addFragment();
    }

    private void addFragment() {
        mList.clear();
        mList.add(MainFragment.newInstance());
        mList.add(Main2Fragment.newInstance());
        mList.add(Main3Fragment.newInstance());
        mList.add(Main4Fragment.newInstance());
        for (int i = 0; i < mList.size(); i++) {
            Fragment fragment = mList.get(i);
            if (i == 0) {
                getSupportFragmentManager().beginTransaction().add(R.id.ly_content, fragment).show(fragment).commit();
            } else {
                getSupportFragmentManager().beginTransaction().add(R.id.ly_content, fragment).hide(fragment).commit();

            }

        }
    }

    private void showFragment(int index) {
        if (fragmentIndex == index) {
            return;
        }
        for (int i = 0; i < mList.size(); i++) {
            Fragment fragment = mList.get(i);
            if (i == index) {
                getSupportFragmentManager().beginTransaction().show(fragment).commit();
                fragmentIndex = index;
                LogUtil.show("显示=" + i);
            } else {
                getSupportFragmentManager().beginTransaction().hide(fragment).commit();

            }

        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_main:
                showFragment(0);
                break;
            case R.id.btn_main2:
                showFragment(1);
                break;
            case R.id.btn_main3:
                showFragment(2);
                break;
            case R.id.btn_main4:
                showFragment(3);
                break;
        }

    }
}
