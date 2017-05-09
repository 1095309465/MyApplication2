package com.example.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.example.adapter.ShouYouInfoAdapter;
import com.example.bean.ShouYouBean;
import com.example.bean.ShouYouInfo;
import com.example.custom.MyListView;
import com.example.custom.MyListView.OnLoadMore;
import com.example.custom.MyListView.OnRefreshListener;
import com.example.game_assistent.Gift_Detail;
import com.example.game_assistent.R;

@SuppressLint("ValidFragment")
public class GiftListFragment extends Fragment {
	private int type;
	private List<ShouYouInfo> list;
	private ShouYouInfoAdapter adapter;
	private int currentPage = 1;
	private MyListView lv;
	private Map<String, String> map;

	/**
	 * 如果type=0表示显示手游的数据 1 表示显示页游的数据
	 * 
	 * @param type
	 */
	public GiftListFragment(int type) {
		Bundle bundle = new Bundle();
		bundle.putInt("type", type);
		setArguments(bundle);

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		type = getArguments() == null ? 0 : getArguments().getInt("type");

	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_listview, null);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		lv = (MyListView) view.findViewById(R.id.lv_gift);
		DiglogUtil.setDiglog(getActivity());
		map = new HashMap<String, String>();
		list = new ArrayList<ShouYouInfo>();
		adapter = new ShouYouInfoAdapter(getActivity(), list);
		lv.setAdapter(adapter);
		freshData(type);

		lv.setonRefreshListener(new OnRefreshListener() {

			@Override
			public void onRefresh() {
				freshData(type);

			}
		});
		lv.setOnLoadMore(new OnLoadMore() {

			@Override
			public void getState() {
				loadMore(++currentPage, type);

			}
		});
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String _id = null;
				Intent intent = new Intent(getActivity(), Gift_Detail.class);
				_id = list.get(position - 1).getId();
				intent.putExtra("id", _id);
				startActivity(intent);

			}
		});

	}

	public void freshData(int type) {
		map.clear();
		map.put("platform", "2");
		map.put("gifttype", (++type) + "");
		map.put("compare", "6e269664c9f849a87e094e95e3c18c1a");
		new JsonPostAsyncTask<ShouYouBean>(map, ShouYouBean.class,
				getActivity(),new CallBack<ShouYouBean>() {

					@Override
					public void getData(ShouYouBean result) {
						if (result != null) {
							list.clear();
							list.addAll(result.getInfo());
							currentPage = 1;
							adapter.notifyDataSetChanged();
						}
						lv.onRefreshComplete();
						DiglogUtil.stopDiglog();

					}
				}).execute(UrlConstantUtils.URL_GIFTLIST);

	}

	private void loadMore(int page, int type) {

		map.clear();
		map.put("platform", "2");
		map.put("gifttype", (++type) + "");
		map.put("page", page + "");
		map.put("compare", "6e269664c9f849a87e094e95e3c18c1a");
		new JsonPostAsyncTask<ShouYouBean>(map, ShouYouBean.class,
				new CallBack<ShouYouBean>() {

					@Override
					public void getData(ShouYouBean result) {
						if (result != null) {
							list.addAll(result.getInfo());
							adapter.notifyDataSetChanged();
						}
						lv.setLoadMoreAfter();

					}
				}).execute(UrlConstantUtils.URL_GIFTLIST);

	}

}
