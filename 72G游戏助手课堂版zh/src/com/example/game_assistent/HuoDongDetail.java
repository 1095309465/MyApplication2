package com.example.game_assistent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.UtilsTools.DiglogUtil;
import com.example.UtilsTools.ImageTask;
import com.example.UtilsTools.ImageTask.CallBackImage;
import com.example.UtilsTools.JsonPostAsyncTask;
import com.example.UtilsTools.JsonPostAsyncTask.CallBack;
import com.example.UtilsTools.UrlConstantUtils;
import com.example.adapter.HuoDongDetailTalkAdapter;
import com.example.bean.HuoDongDetailBean;
import com.example.bean.HuoDongDetailInfo;
import com.example.bean.HuoDongDetailTalkBean;
import com.example.bean.HuoDongDetailTalkInfo;
import com.example.custom.MyListView;
import com.example.custom.MyListView.OnLoadMore;
import com.example.custom.MyListView.OnRefreshListener;
import com.example.game_assistent.R;
import com.example.game_assistent.R.id;
import com.example.game_assistent.R.layout;

public class HuoDongDetail extends Activity {
	private String id;
	private MyListView lv;
	private List<HuoDongDetailTalkInfo> list2;
	private HuoDongDetailTalkAdapter adapter;
	private Map<String, String> map;
	private int currentPage = 1;
	private LinearLayout lin;
	private RelativeLayout re;
	private EditText ed;
	private TextView tv6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.huo_dong_detail);
		DiglogUtil.setDiglog(HuoDongDetail.this);
		lv = (MyListView) findViewById(R.id.lv);
		tv6=(TextView) findViewById(R.id.tv6);
		lin = (LinearLayout) findViewById(R.id.lin);
		re = (RelativeLayout) findViewById(R.id.re);
		ed = (EditText) findViewById(R.id.ed);
		id = getIntent().getStringExtra("id");
		map = new HashMap<String, String>();
		list2 = new ArrayList<HuoDongDetailTalkInfo>();
		adapter = new HuoDongDetailTalkAdapter(id, this, list2);
		lv.setAdapter(adapter);

		reFrash();
		lv.setonRefreshListener(new OnRefreshListener() {

			@Override
			public void onRefresh() {
				reFrash();

			}
		});
		lv.setOnLoadMore(new OnLoadMore() {

			@Override
			public void getState() {
				LoadMore(++currentPage);

			}
		});

	}

	public void btn(View v) {
		switch (v.getId()) {
		case R.id.btn_tz:
			lin.setVisibility(View.GONE);
			re.setVisibility(View.VISIBLE);
			break;
		case R.id.btn_y:
			String str = ed.getText().toString();
			if (TextUtils.isEmpty(str)||Integer.parseInt(str)<=0)
			return;
			Intent intent = new Intent(this, Floor.class);
			intent.putExtra("id", id);
			intent.putExtra("floor", str);
			if(list2==null)
				return ;
			intent.putExtra("max",list2.get(0).getFloor() );
			startActivity(intent);

			break;
		case R.id.btn_n:
			re.setVisibility(View.GONE);
			lin.setVisibility(View.VISIBLE);

			break;

		default:
			break;
		}

	}

	protected void LoadMore(int page) {
		lv.setLoadMoreBefore();
		map.clear();
		map.put("id", id);
		map.put("compare", "89ad351d7a61031f509c580bf5fe143e");
		map.put("page", currentPage + "");
		new JsonPostAsyncTask<HuoDongDetailTalkBean>(map,
				HuoDongDetailTalkBean.class,
				new CallBack<HuoDongDetailTalkBean>() {

					@Override
					public void getData(HuoDongDetailTalkBean result) {
						if (result != null) {
							if (result.getInfo().size() == 0) {
								lv.setLoadMoreAfter();
								Toast.makeText(getApplicationContext(),
										"已经是1楼", 0).show();

							}
							list2.addAll(result.getInfo());

							adapter.notifyDataSetChanged();
						}
						lv.setLoadMoreAfter();
					}

				}).execute(UrlConstantUtils.HuoDongDetailTalk);

	}

	public void reFrash() {
		map.clear();
		map.put("id", id);
		map.put("compare", "89ad351d7a61031f509c580bf5fe143e");
		new JsonPostAsyncTask<HuoDongDetailTalkBean>(map,
				HuoDongDetailTalkBean.class,
				new CallBack<HuoDongDetailTalkBean>() {

					@Override
					public void getData(HuoDongDetailTalkBean result) {
						if (result != null) {
							list2.clear();
							list2.addAll(result.getInfo());
							adapter.notifyDataSetChanged();
							currentPage = 1;
							tv6.setText("共"+list2.get(0).getFloor()+"楼");
						}
						DiglogUtil.stopDiglog();
						lv.onRefreshComplete();
					}

				}).execute(UrlConstantUtils.HuoDongDetailTalk);
	}

}
