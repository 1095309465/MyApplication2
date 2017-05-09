package com.example.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.UtilsTools.JsonPostAsyncTask;
import com.example.UtilsTools.JsonPostAsyncTask.CallBack;
import com.example.UtilsTools.UrlConstantUtils;
import com.example.adapter.GameDetailTalkAdapter;
import com.example.bean.GameDetailTalkBean;
import com.example.bean.GameDetailTalkInfo;
import com.example.custom.MyListView;
import com.example.custom.MyListView.OnRefreshListener;
import com.example.game_assistent.R;

public class GameDetailFragment3 extends Fragment {
	private GameDetailTalkAdapter adapter;
	private MyListView  lv;
	private List<GameDetailTalkInfo> info;
	private Map<String,String> map;
	private String id;

	public GameDetailFragment3(String id) {
		Bundle bundle = new Bundle();
		bundle.putString("id", id);
		setArguments(bundle); 
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_listview, null);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		id=getArguments()==null?"":getArguments().getString("id");
		lv=(MyListView) view.findViewById(R.id.lv_gift);
		info=new ArrayList<GameDetailTalkInfo>();
		adapter=new GameDetailTalkAdapter(getActivity(), info);
		lv.setAdapter(adapter);
		init();
		lv.setonRefreshListener(new OnRefreshListener() {
			
			@Override
			public void onRefresh() {
				init();
				
			}
		});
		
	}
	public  void init(){
		map=new HashMap<String, String>();
		map.put("id", id);
		new JsonPostAsyncTask<GameDetailTalkBean>(map, GameDetailTalkBean.class,new CallBack<GameDetailTalkBean>() {

			@Override
			public void getData(GameDetailTalkBean result) {
				if(result!=null){
					info.clear();
					info.addAll(result.getInfo());
					adapter.notifyDataSetChanged();
					
					
				}
				
			}
		}).execute(UrlConstantUtils.GAME_DETAIL_Talk);
		
	}

}
