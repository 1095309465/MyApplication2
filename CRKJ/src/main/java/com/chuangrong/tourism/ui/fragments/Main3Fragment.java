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

public class Main3Fragment extends Fragment {

    public Main3Fragment() {

    }

    public static Main3Fragment newInstance() {
        Main3Fragment main3Fragment = new Main3Fragment();
        main3Fragment.setArguments(null);
        return main3Fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_main3, null);
        return contentView;
    }
}
