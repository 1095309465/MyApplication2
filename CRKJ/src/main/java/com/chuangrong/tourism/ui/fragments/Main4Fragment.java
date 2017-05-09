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

public class Main4Fragment extends Fragment {


    public Main4Fragment() {

    }

    public static Main4Fragment newInstance() {
        Main4Fragment main4Fragment = new Main4Fragment();
        main4Fragment.setArguments(null);
        return main4Fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_main4, null);
        return contentView;
    }
}
