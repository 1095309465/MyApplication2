package com.example.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.UtilsTools.DiglogUtil;
import com.example.UtilsTools.JsonPostAsyncTask;
import com.example.UtilsTools.JsonPostAsyncTask.CallBack;
import com.example.UtilsTools.UrlConstantUtils;
import com.example.adapter.JiFenShangChengAdapter;
import com.example.bean.ZuiXinJiangPinBean;
import com.example.bean.ZuiXinJiangPinInfo;
import com.example.custom.MyListView;
import com.example.custom.MyListView.OnRefreshListener;
import com.example.game_assistent.JiFenShangCheng;
import com.example.game_assistent.R;

public class LeftFragment4 extends Fragment {
	private MyListView lv;
	private List<ZuiXinJiangPinInfo> list;
	private Map<String, String> map;
	private JiFenShangChengAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_listview, null);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		lv = (MyListView) view.findViewById(R.id.lv_gift);
		list = new ArrayList<ZuiXinJiangPinInfo>();
		
		adapter = new JiFenShangChengAdapter(getActivity(), list);
		lv.setAdapter(adapter);
		init();
		lv.setonRefreshListener(new OnRefreshListener() {
			
			@Override
			public void onRefresh() {
				init();
				
			}
		});
	}

	private void init() {
		map = new HashMap<String, String>();
		map.put("type", "1");
		new JsonPostAsyncTask<ZuiXinJiangPinBean>(map, ZuiXinJiangPinBean.class, new CallBack<ZuiXinJiangPinBean>() {

			@Override
			public void getData(ZuiXinJiangPinBean result) {
				if(result!=null){
					list.clear();
					list.addAll(result.getInfo());
					adapter.notifyDataSetChanged();
					
					
				}
				DiglogUtil.stopDiglog();
				lv.onRefreshComplete();
				
			}
		}).execute(UrlConstantUtils.URL_GAINSHOP);
	}

}
