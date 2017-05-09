package com.example.game_assistent;

import java.util.HashMap;
import java.util.Map;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.DownLoadUtil.DownApkMoreThread;
import com.example.DownLoadUtil.OneThreadDown;
import com.example.UtilsTools.DiglogUtil;
import com.example.UtilsTools.ImageTask;
import com.example.UtilsTools.ImageTask.CallBackImage;
import com.example.UtilsTools.JsonPostAsyncTask;
import com.example.UtilsTools.JsonPostAsyncTask.CallBack;
import com.example.UtilsTools.UrlConstantUtils;
import com.example.bean.GiftDetailBean;
import com.example.bean.GiftDetailInfo;
import com.example.custom.XCRoundImageView;

public class Gift_Detail extends Activity {
	private XCRoundImageView icon;
	private TextView name;
	private TextView consume;
	private TextView lbxq_remain;
	private ProgressBar pb;
	private TextView lbxq_rq;
	private ImageView lbxq_android;
	private ImageView lbxq_ios;
	private TextView game_type;
	private TextView size;
	private TextView content;
	private TextView howget;
	private Map<String, String> map;
	private GiftDetailInfo model;
	private ImageView lbxq_lin1_image1;
	private ImageView lbxq_lin1_image2;
	private Dialog dialog;
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			if (msg.what == 0 && dialog != null) {
				dialog.dismiss();
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gift__detail);
		DiglogUtil.setDiglog(Gift_Detail.this);
		icon = (XCRoundImageView) findViewById(R.id.icon);
		name = (TextView) findViewById(R.id.name);
		consume = (TextView) findViewById(R.id.consume);
		lbxq_remain = (TextView) findViewById(R.id.lbxq_remain);
		pb = (ProgressBar) findViewById(R.id.progressBar1);
		lbxq_rq = (TextView) findViewById(R.id.lbxq_rq);
		lbxq_android = (ImageView) findViewById(R.id.lbxq_android);
		lbxq_ios = (ImageView) findViewById(R.id.lbxq_ios);
		game_type = (TextView) findViewById(R.id.game_type);
		size = (TextView) findViewById(R.id.size);
		content = (TextView) findViewById(R.id.content);
		howget = (TextView) findViewById(R.id.howget);
		lbxq_lin1_image1 = (ImageView) findViewById(R.id.lbxq_lin1_image1);
		lbxq_android.setVisibility(View.GONE);
		lbxq_ios.setVisibility(View.GONE);
		lbxq_lin1_image1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();

			}
		});
		lbxq_lin1_image2 = (ImageView) findViewById(R.id.lbxq_lin1_image2);
		lbxq_lin1_image2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				dialog = new Dialog(Gift_Detail.this, R.style.processDialog);
				final View view = LayoutInflater.from(Gift_Detail.this)
						.inflate(R.layout.diglog2, null);
				Button btn_no = (Button) view.findViewById(R.id.btn_no);
				btn_no.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {

						ObjectAnimator oa1 = ObjectAnimator.ofFloat(view,
								View.TRANSLATION_Y, 0f, 1200f);
						AnimatorSet set = new AnimatorSet();
						oa1.setDuration(500);
						set.play(oa1);
						set.start();
						handler.sendEmptyMessageDelayed(0, 500);

					}
				});

				dialog.setContentView(view);
				dialog.show();
				ObjectAnimator oa1 = ObjectAnimator.ofFloat(view,
						View.TRANSLATION_Y, 1200f, 0f);
				AnimatorSet set = new AnimatorSet();
				oa1.setDuration(500);
				set.play(oa1);
				set.start();

			}
		});

		init();

	}

	public void btn(View v) {  
		switch (v.getId()) {
		case R.id.lbxq_lin_btn:
			if (model == null)
				return;
			Toast.makeText(this, "开始下载", 0).show();
			Log.i("123", "下载链接:" + model.getAndroid_dl());
			OneThreadDown otd=new OneThreadDown(Gift_Detail.this,model.getAndroid_dl());
			otd.Down();
//			OneThreadDown.Downstart(model.getAndroid_dl(), Gift_Detail.this);
			
			break;

		default:
			break;
		}
	}

	public void init() {
		map = new HashMap<String, String>();
		String id = getIntent().getStringExtra("id");
		map.put("id", id);
		map.put("compare", "83c5251c58aca6e7343cfef0a8448db7");
		new JsonPostAsyncTask<GiftDetailBean>(map, GiftDetailBean.class,
				new CallBack<GiftDetailBean>() {

					@Override
					public void getData(GiftDetailBean result) {
						if (result != null) {
							model = result.getInfo();
							LoadData1();

						}
					}
				}).execute(UrlConstantUtils.URL_GIFT_DETAIL);

	}

	public void LoadData1() {
		DownImage();
		name.setText(model.getName());
		consume.setText(model.getConsume() + "币");
		lbxq_remain.setText(model.getRemain() + "/" + model.getTotal());
		pb.setMax(Integer.parseInt(model.getTotal()));
		pb.setProgress(Integer.parseInt(model.getRemain()));
		lbxq_rq.setText("有效期:" + model.getStime() + "——" + model.getEtime());
		if (!TextUtils.isEmpty(model.getAndroid_dl())) {
			lbxq_android.setVisibility(View.VISIBLE);
		}
		if (!TextUtils.isEmpty(model.getIos_dl())) {
			lbxq_ios.setVisibility(View.VISIBLE);
		}
		game_type.setText("类型:" + model.getGame_type());
		size.setText("大小:" + model.getSize());
		content.setText(model.getContent());
		howget.setText(model.getHowget());

	}

	public void DownImage() {
		new ImageTask(Gift_Detail.this, new CallBackImage() {

			@Override
			public void getData(ImageView iv, int position_, Bitmap result) {
				if (result != null) {
					icon.setImageBitmap(result);
				}
				DiglogUtil.stopDiglog();

			}
		}).execute(model.getIcon());

	}
}
