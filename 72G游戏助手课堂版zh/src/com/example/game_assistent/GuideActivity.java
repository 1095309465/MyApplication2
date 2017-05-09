package com.example.game_assistent;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ImageView.ScaleType;

import com.example.UtilsTools.MyOpenHelper;
import com.example.game_assistent.R;
import com.example.game_assistent.R.drawable;
import com.example.game_assistent.R.id;
import com.example.game_assistent.R.layout;

public class GuideActivity extends Activity implements OnPageChangeListener{
	private ViewPager mViewPager;
	private Button mBtnGuide;
	private List<View> listImgs;
	private MyViewPagerAdapter mAdapter;
	private SharedPreferences shref;
	private int[] drawable = new int[] { R.drawable.bg_guide_01,
			R.drawable.bg_guide_02, R.drawable.bg_guide_03 };
	private LinearLayout lin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		shref=getSharedPreferences("myapp", Context.MODE_PRIVATE);
		//读取配置文件
		boolean isLogin=shref.getBoolean("isFirst",true);
		//不是第一次登陆的处理情况
		if(!isLogin){
			//跳转界面
			Intent intent=new Intent(this,AnimtorActivity.class);
			startActivity(intent);
			finish();
		}
		setContentView(R.layout.activity_guide);
		lin=(LinearLayout) findViewById(R.id.Lin);
		mViewPager = (ViewPager) findViewById(R.id.vp_guide);
		mBtnGuide = (Button) findViewById(R.id.btn_guide);
		mBtnGuide.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(GuideActivity.this,AnimtorActivity.class);
				startActivity(intent);
				shref.edit().putBoolean("isFirst", false).apply();
				MyOpenHelper sql=new MyOpenHelper(GuideActivity.this);
				
				finish();
			}
		});
		
		initView();
		init() ;
		mAdapter=new MyViewPagerAdapter();
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener((OnPageChangeListener) this);
			
		
		
	}
	public void init() {
		for (int i = 0; i < drawable.length; i++) {
			ImageView image = new ImageView(this);
			image.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			image.setPadding(0, 0, 10, 0);
			image.setScaleType(ScaleType.CENTER);
			if (i == 0) {
				image.setImageResource(R.drawable.dot01);
			} else {
				image.setImageResource(R.drawable.dot00);
			}
			lin.addView(image);
		}
	}

	/**
	 * 初始化ViewPager视图
	 */
	private void initView() {
		listImgs = new ArrayList<View>();
		int[] imgIds = new int[] { R.drawable.bg_guide_01,
				R.drawable.bg_guide_02, R.drawable.bg_guide_03 };
		// 动态加载ImageView
		for (int i = 0; i < imgIds.length; i++) {
			// 动态添加ImageView
			ImageView iv = new ImageView(this);
			// 设置属性
			// 宽度高度
			iv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, // 宽度，全部撑满
					LayoutParams.MATCH_PARENT));// 高度，全部撑满
			iv.setImageResource(imgIds[i]);
			iv.setScaleType(ScaleType.FIT_XY);// 拉伸(自适应的时候是没有效果的)
			listImgs.add(iv);
		}

	}

	public class MyViewPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return listImgs.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(listImgs.get(position%3));
			return listImgs.get(position);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(listImgs.get(position));
		}

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
		
	}

	@Override
	public void onPageSelected(int arg0) {
		for (int i = 0; i < lin.getChildCount(); i++) {
			ImageView image=(ImageView) lin.getChildAt(i);
			if(i==arg0){
				image.setImageResource(R.drawable.dot01);
			}else{
				image.setImageResource(R.drawable.dot00);
				
			}
		}
		if(listImgs.size()-1==arg0){
			//显示Button
			mBtnGuide.setVisibility(View.VISIBLE);
			
			
		}else{
			mBtnGuide.setVisibility(View.GONE);
			
		}
		
	}

}
