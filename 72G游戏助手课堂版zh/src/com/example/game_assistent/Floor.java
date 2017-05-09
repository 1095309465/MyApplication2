package com.example.game_assistent;

import java.util.HashMap;
import java.util.Map;

import com.example.UtilsTools.DialogShowImage;
import com.example.UtilsTools.DiglogUtil;
import com.example.UtilsTools.JsonPostAsyncTask;
import com.example.UtilsTools.JsonPostAsyncTask.CallBack;
import com.example.UtilsTools.UrlConstantUtils;
import com.example.bean.FloorBean;
import com.example.bean.FloorInfo;
import com.example.bean.HuoDongDetailTalkBean;
import com.example.bean.HuoDongDetailTalkInfo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Floor extends Activity {
	private String max;
	private String id;
	private String floor;
	private TextView tv1;
	private TextView tv2;
	private TextView tv3;
	private TextView tv4;
	private TextView tv5;
	private TextView tv6;
	private EditText ed;
	private Map<String, String> map;
	private View view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view=LayoutInflater.from(Floor.this).inflate(R.layout.activity_floor, null);
		setContentView(view);
		DiglogUtil.setDiglog(Floor.this);
		tv1 = (TextView) findViewById(R.id.tv1);
		tv2 = (TextView) findViewById(R.id.tv2);
		tv3 = (TextView) findViewById(R.id.tv3);
		tv4 = (TextView) findViewById(R.id.tv4);
		tv5 = (TextView) findViewById(R.id.tv5);
		tv6 = (TextView) findViewById(R.id.tv6);
		ed = (EditText) findViewById(R.id.ed);

		map = new HashMap<String, String>();
		if (getIntent() != null) {
			id = getIntent().getStringExtra("id");
			floor = getIntent().getStringExtra("floor");
			max = getIntent().getStringExtra("max");
			ed.setText(floor);

			tv6.setText("共" + max + "楼");
		}
		init(id, floor);
		Log.i("123", "id=" + id + "        " + "floor=" + floor
				+ "         max=" + max);
		map = new HashMap<String, String>();

	}

	public void btn(View v) {
		switch (v.getId()) {
		case R.id.lbxq_lin1_image1:
			finish();
			break;
		case R.id.btn:
			String floors = ed.getText().toString();
			init(id, floors);

			break;

		default:
			break;
		}
	}

	public void init(String id, String floor) {
		if (id == null || floor == null)
			return;
		tv1.setText("指定楼层(第" + floor + "楼)");
		tv4.setText(floor + "楼");
		map.clear();
		map.put("id", id);
		map.put("floor", floor);
		Log.i("123", "执行1");
		new JsonPostAsyncTask<FloorBean>(map, FloorBean.class,
				new CallBack<FloorBean>() {

					@Override
					public void getData(FloorBean result) {
						if (result != null) {
							Log.i("123", "执行3");
							FloorInfo info = result.getInfo();
							if (info == null) {
								Toast.makeText(Floor.this, "你的输入有误，请重试", 0);
								return;
							}
							tv2.setText(info.getNickname());
							tv3.setText(info.getId());
							tv5.setText(info.getContent());
							
							DialogShowImage.showImage(info.getLitpic(), view,
									info.getImg(), Floor.this);
						}
						DiglogUtil.stopDiglog();

					}

				}).execute(UrlConstantUtils.Floor);
	}

}
