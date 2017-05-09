package com.example.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.UtilsTools.ImageTask;
import com.example.UtilsTools.ImageTask.CallBackImage;
import com.example.bean.HuoDongInfo;
import com.example.custom.XCRoundRectImageView;
import com.example.game_assistent.R;

public class HuoDongAdapter extends AppAdapter<HuoDongInfo> {
	private Map<Integer, Bitmap> buf;
	private float left;
	private Context context;
	private int _position;

	public HuoDongAdapter(Context context, List<HuoDongInfo> mList) {
		super(context, mList);
		this.context = context;
		left = context.getResources().getDisplayMetrics().widthPixels;
		buf = new HashMap<Integer, Bitmap>();

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.fragment2_item, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		_position = position;
		HuoDongInfo model = mList.get(position);
		holder.getTv1().setText(model.getShortname());
		holder.getTv2().setText(model.getAname());
		holder.getTv3().setText(model.getTotal_join_user() + "人参加");
		TextView tv = holder.getTv4();
		if ("进行中".equals(model.getStatus())) {
			tv.setBackgroundResource(R.drawable.fragment2_tv_shape_01);
			tv.setText("进行中");
		}
		final String website = model.getHotpic();
		ImageView image = holder.getImage();
		image.setImageResource(R.drawable.ic_launcher);
		image.setTag(_position);
		if (buf.get(_position) != null) {
			image.setImageBitmap(buf.get(_position));
		} else {
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

	class ViewHolder {
		private XCRoundRectImageView image;
		private TextView tv1;
		private TextView tv2;
		private TextView tv3;
		private TextView tv4;
		private View root;

		public ViewHolder(View v) {
			root = v;
		}

		public ImageView getImage() {
			if (image == null) {
				image = (XCRoundRectImageView) root.findViewById(R.id.imageView1);
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
