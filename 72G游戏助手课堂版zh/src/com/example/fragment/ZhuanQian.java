package com.example.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.UtilsTools.DiglogUtil;
import com.example.UtilsTools.JsonPostAsyncTask;
import com.example.UtilsTools.JsonPostAsyncTask.CallBack;
import com.example.UtilsTools.UrlConstantUtils;
import com.example.adapter.ZhuanQianAdapter;
import com.example.bean.ZhuanQianBean;
import com.example.bean.ZhuanQianInfo;
import com.example.custom.MyListView;
import com.example.custom.MyListView.OnRefreshListener;
import com.example.game_assistent.JiFenShangCheng;
import com.example.game_assistent.R;
import com.example.game_assistent.WebViewShow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ZhuanQian extends Fragment {

	private List<ZhuanQianInfo> list;
	private Map<String, String> map;
	private ZhuanQianAdapter adapter;
	private MyListView lv;
	private Button btn_jfsc;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.detail_fragment4, null);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		DiglogUtil.setDiglog(getActivity());
		lv = (MyListView) view.findViewById(R.id.lv);
		btn_jfsc = (Button) view.findViewById(R.id.btn_jfsc);
		list = new ArrayList<ZhuanQianInfo>();
		map = new HashMap<String, String>();
		adapter = new ZhuanQianAdapter(getActivity(), list);
		lv.setAdapter(adapter);
		init();
		btn_jfsc.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), JiFenShangCheng.class);
				startActivity(intent);

			}
		});
		lv.setonRefreshListener(new OnRefreshListener() {

			@Override
			public void onRefresh() {
				init();

			}
		});

	}

	public void init() {
		map.put("platform", "2");
		new JsonPostAsyncTask<ZhuanQianBean>(map, ZhuanQianBean.class,
				new CallBack<ZhuanQianBean>() {

					@Override
					public void getData(ZhuanQianBean result) {
						if (result != null) {
							list.clear();
							list.addAll(result.getInfo());
							adapter.notifyDataSetChanged();
						}
						lv.onRefreshComplete();
						DiglogUtil.stopDiglog();

					}
				}).execute(UrlConstantUtils.URL_MONEYLIST);
	}

}
