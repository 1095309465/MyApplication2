package com.example.game_assistent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RatingBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.example.UtilsTools.DiglogUtil;
import com.example.UtilsTools.ImageTask;
import com.example.UtilsTools.ImageTask.CallBackImage;
import com.example.UtilsTools.JsonPostAsyncTask;
import com.example.UtilsTools.JsonPostAsyncTask.CallBack;
import com.example.UtilsTools.UrlConstantUtils;
import com.example.bean.GameDetailBean;
import com.example.bean.GameDetailInfo;
import com.example.fragment.GameDetailFragment1;
import com.example.fragment.GameDetailFragment2;
import com.example.fragment.GameDetailFragment3;
import com.example.game_assistent.R;
import com.example.game_assistent.R.id;
import com.example.game_assistent.R.layout;

public class Game_Detail extends FragmentActivity {
	private String id;
	private ViewPager viewpager;
	private List<Fragment> list;
	private MyAdapterDetail adapter;
	private RadioButton btn1;
	private RadioButton btn2;
	private RadioButton btn3;
	private Button btn4;
	private TextView tv1;
	private TextView tv2;
	private TextView tv3;
	private TextView tv4;
	private ImageView image1;
	private ImageView image2;
	private Map<String, String> map;
	private RatingBar rb;
	private String str;
	private ImageView image3;
	private ImageView image4;
	private ImageView top;
	private GameDetailInfo model;
	private RadioGroup rg;
	private LinearLayout Lin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game__detail);
		DiglogUtil.setDiglog(Game_Detail.this);
		id = getIntent().getStringExtra("id");
		tv1 = (TextView) findViewById(R.id.tv1);
		tv2 = (TextView) findViewById(R.id.tv2);
		tv3 = (TextView) findViewById(R.id.tv3);
		tv4 = (TextView) findViewById(R.id.tv4);
		image1 = (ImageView) findViewById(R.id.image1);
		image2 = (ImageView) findViewById(R.id.image2);
		image3 = (ImageView) findViewById(R.id.image3);
		image4 = (ImageView) findViewById(R.id.image4);
		rg = (RadioGroup) findViewById(R.id.rg);
		rb = (RatingBar) findViewById(R.id.rb);
		btn1 = (RadioButton) findViewById(R.id.btn1);
		btn2 = (RadioButton) findViewById(R.id.btn2);
		btn3 = (RadioButton) findViewById(R.id.btn3);
		Lin = (LinearLayout) findViewById(R.id.lin);
		btn4 = (Button) findViewById(R.id.btn4);
		top = (ImageView) findViewById(R.id.top);
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		list = new ArrayList<Fragment>();

		adapter = new MyAdapterDetail(getSupportFragmentManager());
		viewpager.setAdapter(adapter);
		init();
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:
					btn1.setChecked(true);
					break;
				case 1:
					btn2.setChecked(true);

					break;
				case 2:
					btn3.setChecked(true);

					break;

				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.btn1:
					if (viewpager.getCurrentItem() != 0) {

						viewpager.setCurrentItem(0);
					}
					break;
				case R.id.btn2:
					if (viewpager.getCurrentItem() != 1) {

						viewpager.setCurrentItem(1);
					}
					break;
				case R.id.btn3:
					if (viewpager.getCurrentItem() != 2) {

						viewpager.setCurrentItem(2);
					}
					break;

				default:
					break;
				}
			}
		});

	}

	public void listAdd() {
		list.add(new GameDetailFragment1(id, model.getGame_desc()));
		list.add(new GameDetailFragment2());
		list.add(new GameDetailFragment3(id));
	}

	public void btn(View v) {
		switch (v.getId()) {
		case R.id.image1:
			finish();
			break;
		case R.id.image2:
			AlertDialog.Builder builder = new AlertDialog.Builder(
					Game_Detail.this);
			View view = LayoutInflater.from(Game_Detail.this).inflate(
					R.layout.diglog2, null);
			builder.setView(view);
			builder.create();
			builder.show();
			break;
		case R.id.btn4:
			Toast.makeText(this, "暂时不能下载", 0).show();
			break;
		case R.id.image3:
			ObjectAnimator oa1 = ObjectAnimator.ofFloat(Lin,
					View.TRANSLATION_Y, 0f, Lin.getHeight());
			oa1.setDuration(2500);
			AnimatorSet set = new AnimatorSet();
			set.play(oa1);

			set.start();

			break;
		case R.id.top:
			ObjectAnimator oa2 = ObjectAnimator.ofFloat(Lin,
					View.TRANSLATION_Y, Lin.getHeight(), 0f);

			oa2.setDuration(500);
			AnimatorSet set2 = new AnimatorSet();
			set2.play(oa2);
			set2.start();

			break;

		default:
			break;
		}
	}

	public void init() {
		map = new HashMap<String, String>();
		map.put("id", id);
		new JsonPostAsyncTask<GameDetailBean>(map, GameDetailBean.class,
				new CallBack<GameDetailBean>() {

					@Override
					public void getData(GameDetailBean result) {
						if (result != null) {
							model = result.getInfo();
							listAdd();
							adapter.notifyDataSetChanged();
							lodaData();
						}

					}
				}).execute(UrlConstantUtils.URL_GIFT_CNXH_DETAIL);

	}

	public void lodaData() {
		tv1.setText(model.getName());
		rb.setProgress((int) (Math.round(Double.parseDouble(model.getScore()))));
		tv2.setText("版本: " + model.getVersion());
		tv3.setText(model.getSize());
		tv4.setText(model.getCount_dl() + "人下载");
		btn4.setText("下载(奖" + model.getDl_back_jifen() + "Q币)");

		new ImageTask(Game_Detail.this, new CallBackImage() {

			@Override
			public void getData(ImageView iv, int position_, Bitmap result) {
				if (result != null) {
					Log.i("123", "加载广告大图片");
					image3.setImageBitmap(result);
					top.setImageBitmap(result);
				}
				DiglogUtil.stopDiglog();

			}
		}).execute(model.getSnapshot());
		new ImageTask(Game_Detail.this, new CallBackImage() {

			@Override
			public void getData(ImageView iv, int position_, Bitmap result) {
				if (result != null) {
					image4.setImageBitmap(result);
				}

			}
		}).execute(model.getIcon());

	}

	public class MyAdapterDetail extends FragmentPagerAdapter {

		public MyAdapterDetail(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {

			return list.get(arg0);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

	}

}
