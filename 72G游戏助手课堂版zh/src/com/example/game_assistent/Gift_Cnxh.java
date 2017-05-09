package com.example.game_assistent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.UtilsTools.DiglogUtil;
import com.example.UtilsTools.ImageTask;
import com.example.UtilsTools.ImageTask.CallBackImage;
import com.example.UtilsTools.JsonPostAsyncTask;
import com.example.UtilsTools.JsonPostAsyncTask.CallBack;
import com.example.UtilsTools.UrlConstantUtils;
import com.example.bean.CaiNiXiHuanBean;
import com.example.bean.CaiNiXiHuanInfo;
import com.example.game_assistent.R;
import com.example.game_assistent.R.id;
import com.example.game_assistent.R.layout;

public class Gift_Cnxh extends Activity implements OnClickListener {
	private ImageView image0;
	private List<CaiNiXiHuanInfo> list;
	private Map<String, String> map;
	private LinearLayout Lin;
	private ImageView image;
	private TextView tv1;
	private TextView tv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gift_cnxh);
		DiglogUtil.setDiglog(Gift_Cnxh.this);
		image0 = (ImageView) findViewById(R.id.image0);
		Lin = (LinearLayout) findViewById(R.id.Lin);
		image0.setOnClickListener(this);
		init();

	}

	private void init() {
		list = new ArrayList<CaiNiXiHuanInfo>();
		map = new HashMap<String, String>();
		map.put("id", "1");
		map.put("compare", "8fe26c6dc128f40a099837ec2673c543");
		new JsonPostAsyncTask<CaiNiXiHuanBean>(map, CaiNiXiHuanBean.class,
				new CallBack<CaiNiXiHuanBean>() {

					@Override
					public void getData(CaiNiXiHuanBean result) {
						if (result != null) {
							list.addAll(result.getInfo());
							loadData();
						}

					}

				}).execute(UrlConstantUtils.URL_GIFTSEARCHLIST);
	}

	public void loadData() {
		for (int i = 0; i < Lin.getChildCount(); i++) {
			LinearLayout lin = (LinearLayout) Lin.getChildAt(i);
			image = (ImageView) lin.getChildAt(0);
			tv1 = (TextView) lin.getChildAt(1);
			tv2 = (TextView) lin.getChildAt(2);
			final CaiNiXiHuanInfo model = list.get(i);
			tv1.setText(model.getName());
			tv2.setText(model.getCount_dl() + "次下载");
			image.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(Gift_Cnxh.this,
							Game_Detail.class);
					intent.putExtra("id", model.getId());
					startActivity(intent);

				}
			});

			new ImageTask(image, 0, Gift_Cnxh.this, new CallBackImage() {

				@Override
				public void getData(ImageView iv, int position_, Bitmap result) {
					if (result != null) {
						iv.setImageBitmap(result);
						
					}
					DiglogUtil.stopDiglog();
				}
			}).execute(model.getIcon());

		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.image0:
			finish();
			break;

		default:
			break;
		}
	}

}
