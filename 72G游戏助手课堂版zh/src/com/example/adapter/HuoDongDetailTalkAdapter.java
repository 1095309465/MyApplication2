package com.example.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.example.UtilsTools.DialogShowImage;
import com.example.UtilsTools.ImageTask;
import com.example.UtilsTools.ImageTask.CallBackImage;
import com.example.UtilsTools.JsonPostAsyncTask;
import com.example.UtilsTools.JsonPostAsyncTask.CallBack;
import com.example.UtilsTools.UrlConstantUtils;
import com.example.bean.HuoDongDetailBean;
import com.example.bean.HuoDongDetailTalkInfo;
import com.example.game_assistent.R;

public class HuoDongDetailTalkAdapter extends AppAdapter<HuoDongDetailTalkInfo> {
	private float left;
	private Map<Integer, Bitmap> buf;
	private Context context;
	private int _position;
	private String id;
	private Dialog dialog;
	private View view0;

	public HuoDongDetailTalkAdapter(String id, Context context,
			List<HuoDongDetailTalkInfo> mList) {
		super(context, mList);
		this.id = id;
		this.context = context;
		buf = new HashMap<Integer, Bitmap>();
		left = context.getResources().getDisplayMetrics().widthPixels;
	}

	@Override
	public int getCount() {

		return mList.size() + 1;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (position == 0) {
			if (view0 != null) {
				return view0;
			}
			view0 = mInflater.inflate(R.layout.huodongtalk_head, null);
			init(view0);
			return view0;
		}
		ViewHolder holder = null;
		if (convertView == null || convertView.getTag() == null) {

			convertView = mInflater.inflate(R.layout.acitvity_talk, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		_position = position;
		HuoDongDetailTalkInfo model = mList.get(position - 1);
		holder.getTv1().setText(model.getNickname());
		holder.getTv2().setText(model.getPubdate());
		holder.getTv3().setText(model.getFloor() + "楼");
		holder.getTv4().setText(model.getContent());
		DialogShowImage.showImage(model.getLitpic(), convertView,
				model.getImg(), context);
		final String website = model.getHpic();
		ImageView image = holder.getImage();
		image.setTag(_position);
		if (buf.get(_position) != null) {
			image.setImageBitmap(buf.get(_position));
		} else {
			image.setImageResource(R.drawable.ic_default_avatar);
			new ImageTask(image, _position, context, new CallBackImage() {

				@Override
				public void getData(ImageView iv, int position_, Bitmap result) {
					if (result != null && iv != null) {
						int num = (Integer) iv.getTag();
						if (num == position_) {
							buf.put(position_, result);
							iv.setImageBitmap(result);
						}
					}

				}
			}).execute(website);
		}

		ObjectAnimator oa1 = ObjectAnimator.ofFloat(convertView,
				View.TRANSLATION_X, left, 0);
		ObjectAnimator oa2 = ObjectAnimator.ofFloat(convertView,
				View.ROTATION_X, 180, 0);
		oa1.setDuration(1000);
		oa2.setDuration(1000);
		oa1.setInterpolator(new DecelerateInterpolator());
		oa2.setInterpolator(new DecelerateInterpolator());
		AnimatorSet set = new AnimatorSet();
		set.playTogether(oa1, oa2);
		set.start();

		return convertView;
	}

	public void init(View view) {
		Map<String, String> map = new HashMap<String, String>();
		final TextView tv1 = (TextView) view.findViewById(R.id.tv1);
		final TextView tv2 = (TextView) view.findViewById(R.id.tv2);
		final TextView tv3 = (TextView) view.findViewById(R.id.tv3);
		final TextView tv4 = (TextView) view.findViewById(R.id.tv4);
		final ImageView image1 = (ImageView) view.findViewById(R.id.image01);
		final ImageView image2 = (ImageView) view.findViewById(R.id.image02);
		image1.setVisibility(View.GONE);
		image2.setVisibility(View.GONE);
		ImageView lbxq_lin1_image1 = (ImageView) view
				.findViewById(R.id.lbxq_lin1_image1);
		ImageView lbxq_lin1_image2 = (ImageView) view
				.findViewById(R.id.lbxq_lin1_image2);
		lbxq_lin1_image1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				((Activity) context).finish();

			}
		});
		lbxq_lin1_image2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				View view = LayoutInflater.from(context).inflate(
						R.layout.diglog2, null);
				builder.setView(view);
				builder.create();
				builder.show();

			}
		});
		map.put("id", id);
		map.put("compare", "58282462d26da122b3e42330697e2a2f");
		new JsonPostAsyncTask<HuoDongDetailBean>(map, HuoDongDetailBean.class,
				new CallBack<HuoDongDetailBean>() {

					@Override
					public void getData(HuoDongDetailBean result) {
						if (result != null) {
							tv1.setText(result.getInfo().getAname());
							tv2.setText(result.getInfo().getWriter());
							tv3.setText(result.getInfo().getPubdate());
							tv4.setText(result.getInfo().getContent());
							final String url1 = result.getInfo().getExpimg();
							if (!TextUtils.isEmpty(url1)) {
								new ImageTask(context, new CallBackImage() {

									@Override
									public void getData(ImageView iv,
											int position_, Bitmap result) {
										if (result != null) {

											image1.setImageBitmap(result);
											image1.setVisibility(View.VISIBLE);
											image1.setTag(url1);
											DialogShowImage.showBigImage(
													image1, context);

										} else {
											image1.setVisibility(View.GONE);

										}

									}
								}).execute(url1);
							} else {
								image1.setVisibility(View.GONE);
							}
							final String url2 = result.getInfo().getHotpic();
							if (!TextUtils.isEmpty(url2)) {
								new ImageTask(context, new CallBackImage() {

									@Override
									public void getData(ImageView iv,
											int position_, Bitmap result) {
										if (result != null) {

											image2.setImageBitmap(result);
											image2.setVisibility(View.VISIBLE);
											image2.setTag(url2);
											DialogShowImage.showBigImage(
													image2, context);
										} else {
											image2.setVisibility(View.GONE);
										}

									}
								}).execute(url2);
							} else {
								image2.setVisibility(View.GONE);
							}
						}

					}
				}).execute(UrlConstantUtils.HuoDongDetail);

	}

	class ViewHolder {
		ImageView image;
		TextView tv1;
		TextView tv2;
		TextView tv3;
		TextView tv4;
		View root;

		public ViewHolder(View v) {
			root = v;
		}

		public ImageView getImage() {
			if (image == null) {
				image = (ImageView) root.findViewById(R.id.image1);
			}
			return image;
		}

		public TextView getTv1() {
			if (tv1 == null) {
				tv1 = (TextView) root.findViewById(R.id.tv1);
			}
			return tv1;
		}

		public TextView getTv2() {
			if (tv2 == null) {
				tv2 = (TextView) root.findViewById(R.id.tv2);
			}
			return tv2;
		}

		public TextView getTv3() {
			if (tv3 == null) {
				tv3 = (TextView) root.findViewById(R.id.tv3);
			}
			return tv3;
		}

		public TextView getTv4() {
			if (tv4 == null) {
				tv4 = (TextView) root.findViewById(R.id.tv4);
			}
			return tv4;
		}

	}

}
