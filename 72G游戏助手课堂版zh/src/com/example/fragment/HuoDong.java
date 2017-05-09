package com.example.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;

import com.example.UtilsTools.DiglogUtil;
import com.example.UtilsTools.ImageTask;
import com.example.UtilsTools.ImageTask.CallBackImage;
import com.example.UtilsTools.JsonPostAsyncTask;
import com.example.UtilsTools.JsonPostAsyncTask.CallBack;
import com.example.UtilsTools.UrlConstantUtils;
import com.example.adapter.HuoDongAdapter;
import com.example.bean.HuoDongBean;
import com.example.bean.HuoDongImageBean;
import com.example.bean.HuoDongImageInfo;
import com.example.bean.HuoDongInfo;
import com.example.custom.MyListView;
import com.example.custom.MyListView.OnRefreshListener;
import com.example.game_assistent.Game_Detail;
import com.example.game_assistent.HuoDongDetail;
import com.example.game_assistent.R;

public class HuoDong extends Fragment {
	private ImageView topimage;
	private MyListView lv;
	private List<HuoDongInfo> list;
	private Map<String, String> map;
	private HuoDongAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.detail_fragment2, null);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		topimage = (ImageView) view.findViewById(R.id.topimage);
		lv = (MyListView) view.findViewById(R.id.lv_gift);
		DiglogUtil.setDiglog(getActivity());
		map = new HashMap<String, String>();
		list = new ArrayList<HuoDongInfo>();
		adapter = new HuoDongAdapter(getActivity(), list);
		lv.setAdapter(adapter);
		init();
		listinit();
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(getActivity(), HuoDongDetail.class);
				intent.putExtra("id", list.get(position-1).getId());
				startActivity(intent);

			}
		});
		lv.setonRefreshListener(new OnRefreshListener() {

			@Override
			public void onRefresh() {
				listinit();

			}
		});

	}

	public void listinit() {
		map.clear();
		map.put("platform", "2");
		map.put("compare", "5f2c32f51faa05ba2c5b087cf50e7ab8");
		new JsonPostAsyncTask<HuoDongBean>(map, HuoDongBean.class,
				new CallBack<HuoDongBean>() {

					@Override
					public void getData(HuoDongBean result) {
						if (result != null) {
							list.clear();
							list.addAll(result.getInfo());
							adapter.notifyDataSetChanged();
						}
						DiglogUtil.stopDiglog();
						lv.onRefreshComplete();

					}
				}).execute(UrlConstantUtils.URL_ACTIVELIST);
	}

	public void init() {
		
		map.clear();
		map.put("platform", "2");
		map.put("pos", "1");
		map.put("compare", "65dcae2018c98b3a96f8263d05e3538c");
		new JsonPostAsyncTask<HuoDongImageBean>(map, HuoDongImageBean.class,
				new CallBack<HuoDongImageBean>() {

					@Override
					public void getData(HuoDongImageBean result) {
						if (result != null) {
							HuoDongImageInfo info = result.getInfo().get(0);
							new ImageTask(getActivity(), new CallBackImage() {

								@Override
								public void getData(ImageView iv,
										int position_, Bitmap result) {
									if (result != null) {
										topimage.setImageBitmap(result);
									}

								}
							}).execute(info.getBimg());
						}
					}
				}).execute(UrlConstantUtils.URL_BANNERINFO);

	}

}
