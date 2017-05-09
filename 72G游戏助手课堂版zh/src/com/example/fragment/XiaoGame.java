package com.example.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.UtilsTools.DiglogUtil;
import com.example.UtilsTools.JsonPostAsyncTask;
import com.example.UtilsTools.JsonPostAsyncTask.CallBack;
import com.example.UtilsTools.UrlConstantUtils;
import com.example.adapter.XiaoGameAdapter;
import com.example.bean.XiaoGameZuiXinBean;
import com.example.bean.XiaoGameZuiXinInfo;
import com.example.custom.MyListView;
import com.example.custom.MyListView.OnLoadMore;
import com.example.custom.MyListView.OnRefreshListener;
import com.example.game_assistent.R;
import com.example.game_assistent.WebViewShow;

public class XiaoGame extends Fragment {
	private List<XiaoGameZuiXinInfo> info;
	private Map<String, String> map;
	private XiaoGameAdapter adapter;
	private MyListView lv;
	private int page = 1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.xiaogame, null);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		lv = (MyListView) view.findViewById(R.id.lv);
		info = new ArrayList<XiaoGameZuiXinInfo>();
		DiglogUtil.setDiglog(getActivity());
		map = new HashMap<String, String>();
		adapter = new XiaoGameAdapter(getActivity(), info);
		lv.setAdapter(adapter);
		init();
		lv.setonRefreshListener(new OnRefreshListener() {

			@Override
			public void onRefresh() {
				init();

			}
		});
		lv.setOnLoadMore(new OnLoadMore() {

			@Override
			public void getState() {
				LoadMore(++page);
			}
		});
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent=new Intent(getActivity(),WebViewShow.class);
				if(info!=null){
				intent.putExtra("url", info.get(position-1).getH5src());
				startActivity(intent);
				}
			}
		});
	}

	public void init() {
		map.clear();
		map.put("platform", "2");
		map.put("compare", "4baf6f981db2e4e3ca54281ab4db5884");
		new JsonPostAsyncTask<XiaoGameZuiXinBean>(map,
				XiaoGameZuiXinBean.class, new CallBack<XiaoGameZuiXinBean>() {

					@Override
					public void getData(XiaoGameZuiXinBean result) {
						if (result != null) {
							info.clear();
							info.addAll(result.getInfo());
							adapter.notifyDataSetChanged();
						}
						page = 1;
						lv.onRefreshComplete();
						DiglogUtil.stopDiglog();

					}

				}).execute(UrlConstantUtils.XiaoGame_ZuiXin);

	}

	public void LoadMore(int page) {
		map.clear();
		map.put("platform", "2");
		map.put("page", page + "");
		map.put("compare", "4baf6f981db2e4e3ca54281ab4db5884");
		new JsonPostAsyncTask<XiaoGameZuiXinBean>(map,
				XiaoGameZuiXinBean.class, new CallBack<XiaoGameZuiXinBean>() {

					@Override
					public void getData(XiaoGameZuiXinBean result) {
						if (result != null) {
							info.addAll(result.getInfo());
							adapter.notifyDataSetChanged();
						}
						lv.setLoadMoreAfter();

					}

				}).execute(UrlConstantUtils.XiaoGame_ZuiXin);

	}

}
