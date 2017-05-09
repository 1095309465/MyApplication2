package com.example.game_assistent;

import java.util.ArrayList;
import java.util.List;

import com.example.UtilsTools.DiglogUtil;
import com.example.fragment.LeftFragment4;
import com.example.fragment.RightFragment4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class JiFenShangCheng extends FragmentActivity {
	private ViewPager viewPager;
	private List<Fragment> list;
	private Fragment4Adapter adapter;
	private RadioButton btn2;
	private RadioButton btn3;
	private ImageView fragment4_image1;
	private RadioGroup rg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jfsc);
		DiglogUtil.setDiglog(JiFenShangCheng.this);
		btn2 = (RadioButton) findViewById(R.id.btn2);
		btn3 = (RadioButton) findViewById(R.id.btn3);
		rg = (RadioGroup) findViewById(R.id.rg);
		fragment4_image1 = (ImageView) findViewById(R.id.fragment4_image1);
		fragment4_image1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		list = new ArrayList<Fragment>();
		adapter = new Fragment4Adapter(getSupportFragmentManager());
		init();
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:
					btn2.setChecked(true);
					break;
				case 1:
					btn3.setChecked(true);
					break;

				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.btn2:
					if (viewPager.getCurrentItem() != 0) {
						viewPager.setCurrentItem(0);

					}
					break;
				case R.id.btn3:
					if (viewPager.getCurrentItem() != 1) {

						viewPager.setCurrentItem(1);
					}
					break;

				default:
					break;
				}

			}
		});

	}
	public void btn(View v){
		startActivity(new Intent(this,Login.class));
	}

	public void init() {
		list.add(new LeftFragment4());
		list.add(new RightFragment4());
	}

	public class Fragment4Adapter extends FragmentPagerAdapter {

		public Fragment4Adapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {
			return list.get(arg0);
		}

		@Override
		public int getCount() {
			return list.size();
		}

	}

}
