package com.chuangrong.tourism.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chuangrong.tourism.R;

/**
 * Created by DELL on 2017/5/9.
 */

public class Main2Fragment extends Fragment {


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
}
