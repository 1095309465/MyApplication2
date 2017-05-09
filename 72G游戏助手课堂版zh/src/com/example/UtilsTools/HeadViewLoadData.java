package com.example.UtilsTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.example.UtilsTools.ImageTask.CallBackImage;
import com.example.UtilsTools.JsonPostAsyncTask.CallBack;
import com.example.bean.XiaoGameRGameBean;
import com.example.bean.XiaoGameRGameInfo;
import com.example.bean.XiaoGameVPBean;
import com.example.bean.XiaoGameVPInfo;
import com.example.custom.XCRoundRectImageView;
import com.example.game_assistent.R;
import com.example.game_assistent.WebViewShow;

public class HeadViewLoadData {
	private static List<View> list;
	private static ViewPager viewpager;
	private static MyAdapter adapter;
	private static Map<String, String> map;
	private static List<XiaoGameVPInfo> infoList;
	private static TextView vp_tv;
	private static LinearLayout vp_re;
	private static LinearLayout smallgamelin;
	private static int[] imgs = new int[] { R.drawable.dot00, R.drawable.dot01 };
	private static Context _context;
	private static int count;
	private static HeadViewLoadData data;
	private static Handler handler = new Handler() {
		private boolean flag = true;

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			if (msg.what == 0 && flag) {
				viewpager.setCurrentItem(viewpager.getCurrentItem() + 1);
				if (flag) {
					handler.sendEmptyMessageDelayed(0, 2000);
				}
			}
		}

	};

	public static void setView(View view, Context context) {
		_context = context;
		viewpager = (ViewPager) view.findViewById(R.id.viewpager);
		vp_tv = (TextView) view.findViewById(R.id.vp_tv);
		vp_re = (LinearLayout) view.findViewById(R.id.vp_re);
		smallgamelin = (LinearLayout) view.findViewById(R.id.smallgamelin);
		map = new HashMap<String, String>();
		list = new ArrayList<View>();
		data = new HeadViewLoadData();
		adapter = data.new MyAdapter();
		init();

		init3();

		viewpager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				if (infoList != null) {
					vp_tv.setText(infoList.get(arg0 % list.size()).getName());

				}
				for (int i = 0; i < infoList.size(); i++) {
					ImageView image = (ImageView) vp_re.getChildAt(i);
					if (image == null) {
						return;
					}
					if (i == arg0 % list.size()) {
						image.setImageResource(imgs[1]);
					} else {
						image.setImageResource(imgs[0]);
					}
				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	public static void init() {
		map.clear();
		map.put("platform", "2");
		map.put("compare", "af9cd783af6a57e43edeb8bd54421d45");
		new JsonPostAsyncTask<XiaoGameVPBean>(map, XiaoGameVPBean.class,
				new CallBack<XiaoGameVPBean>() {

					@Override
					public void getData(XiaoGameVPBean result) {
						if (result != null) {
							infoList = result.getInfo();
							init2();
							list.clear();
							for (int i = 0; i < infoList.size(); i++) {
								final int j = i;
								ImageView image = new ImageView(_context);
								image.setLayoutParams(new LayoutParams(
										LayoutParams.MATCH_PARENT,
										LayoutParams.MATCH_PARENT));
								image.setScaleType(ScaleType.FIT_XY);
								setImage(infoList.get(i).getImage(), image);
								image.setOnClickListener(new OnClickListener() {

									@Override
									public void onClick(View v) {
										Intent intent = new Intent(_context,
												WebViewShow.class);
										intent.putExtra("url", infoList.get(j)
												.getLink());
										_context.startActivity(intent);

									}
								});

							}

						}

					}
				}).execute(UrlConstantUtils.XiaoGame_ViewPager);

	}

	public static void init2() {
		if (infoList == null) {
			return;
		}
		vp_re.removeAllViews();
		for (int i = 0; i < infoList.size(); i++) {

			ImageView image = new ImageView(_context);
			image.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			if (i == 0) {
				image.setImageResource(imgs[1]);
			} else {
				image.setImageResource(imgs[0]);
			}
			image.setPadding(0, 0, 10, 0);

			vp_re.addView(image);

		}

	}

	public static void init3() {
		// 下载热门推荐
		map.clear();
		map.put("platform", "2");
		map.put("compare", "4baf6f981db2e4e3ca54281ab4db5884");
		new JsonPostAsyncTask<XiaoGameRGameBean>(map, XiaoGameRGameBean.class,
				new CallBack<XiaoGameRGameBean>() {

					@Override
					public void getData(XiaoGameRGameBean result) {
						if (result != null) {
							List<XiaoGameRGameInfo> infoList = result.getInfo();
							for (int i = 0; i < infoList.size(); i++) {
								final XiaoGameRGameInfo model = infoList.get(i);
								LinearLayout lin = (LinearLayout) smallgamelin
										.getChildAt(i);
								final XCRoundRectImageView image = (XCRoundRectImageView) lin
										.getChildAt(0);
								TextView tv = (TextView) lin.getChildAt(1);
								tv.setText(model.getName());
								new ImageTask(_context, new CallBackImage() {

									@Override
									public void getData(ImageView iv,
											int position_, Bitmap result) {
										if (result != null) {
											image.setImageBitmap(result);
											image.setOnClickListener(new OnClickListener() {

												@Override
												public void onClick(View v) {
													Intent intent = new Intent(
															_context,
															WebViewShow.class);
													intent.putExtra("url",
															model.getH5src());
													_context.startActivity(intent);

												}
											});

										}
									}
								}).execute(model.getIcon());

							}

						}

					}
				}).execute(UrlConstantUtils.XiaoGame_ReMen);

	}

	public static void setImage(String key, final ImageView image) {

		new ImageTask(_context, new CallBackImage() {

			@Override
			public void getData(ImageView iv, int position_, Bitmap result) {
				if (result != null) {
					image.setImageBitmap(result);
					list.add(image);
					adapter.notifyDataSetChanged();
					count++;
					if (count == 3) {
						viewpager.setAdapter(adapter);
						viewpager.setCurrentItem(900);
						adapter.notifyDataSetChanged();
						handler.sendEmptyMessage(0);
					}
				}

			}
		}).execute(key);

	}

	

	public class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {

			if (list.size() == 0) {
				return 0;
			}
			return Integer.MAX_VALUE;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View v = list.get(position % list.size());
			if (v.getParent() != null) {
				container.removeView(v);
			}
			container.addView(list.get(position % list.size()));
			return list.get(position % list.size());
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// container.removeView(list.get(position%list.size()));
		}

	}

}
