package com.example.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.UtilsTools.DiglogUtil;
import com.example.game_assistent.Gift_Cnxh;
import com.example.game_assistent.R;

public class GiftFragment extends Fragment {
	private ViewPager viewpager;
	private List<Fragment> list;
	private MyFragmentAdapter adapter;
	private RadioGroup rg_gift;
	private RadioButton rb1;
	private RadioButton rb2;
	private EditText fragment1_ed1;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_gift, null);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		fragment1_ed1 = (EditText) view.findViewById(R.id.fragment1_ed1);
		viewpager = (ViewPager) view.findViewById(R.id.viewpager);
		rg_gift = (RadioGroup) view.findViewById(R.id.rg_gift);
		rb1 = (RadioButton) view.findViewById(R.id.rbtn_shouyou_gift);
		rb2 = (RadioButton) view.findViewById(R.id.rbtn_yeyou_gift);
		list = new ArrayList<Fragment>();
		list.add(new GiftListFragment(0));
		list.add(new GiftListFragment(1));
		adapter = new MyFragmentAdapter(getActivity()
				.getSupportFragmentManager());
		viewpager.setAdapter(adapter);
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:
					rb1.setChecked(true);

					break;
				case 1:
					rb2.setChecked(true);
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
		rg_gift.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rbtn_shouyou_gift:
					if (viewpager.getCurrentItem() != 0) {

						viewpager.setCurrentItem(0);
					}

					break;
				case R.id.rbtn_yeyou_gift:
					if (viewpager.getCurrentItem() != 1) {

						viewpager.setCurrentItem(1);
					}
					break;

				default:
					break;
				}

			}
		});
		fragment1_ed1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(getActivity(), Gift_Cnxh.class));

			}
		});
	}

	public class MyFragmentAdapter extends FragmentPagerAdapter {

		public MyFragmentAdapter(FragmentManager fm) {
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
