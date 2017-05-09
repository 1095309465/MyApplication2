package com.example.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.UtilsTools.ImageTask;
import com.example.UtilsTools.ImageTask.CallBackImage;
import com.example.bean.ShouYouInfo;
import com.example.custom.XCRoundRectImageView;
import com.example.game_assistent.R;

/**
 * 根据不同的泛型T,获取不同的数据
 * 
 * @author Administrator
 * 
 */

public class ShouYouInfoAdapter extends AppAdapter<ShouYouInfo> {

	private float left;

	private Map<Integer, Bitmap> buf;
	private Context context;
	private int _position;

	public ShouYouInfoAdapter(Context context, List<ShouYouInfo> mList) {
		super(context, mList);
		this.context = context;
		buf = new HashMap<Integer, Bitmap>();
		left = context.getResources().getDisplayMetrics().widthPixels;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.fragment1_item, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		_position = position;
		ShouYouInfo info = mList.get(position);
		int remain = info.getRemain();
		holder.getTv1().setText(info.getName());
		holder.getTv2().setText(remain + "");
		holder.getTv3().setText(info.getContent());
		Button btn = holder.getBtn1();
		if (remain == 0) {
			btn.setText("淘号");
			btn.setBackgroundResource(R.drawable.fragment1_item_btn_02_sector);
			btn.setTextColor(context.getResources().getColorStateList(
					R.color.btntv_oring_color_sector));
		} else {
			btn.setText("免费领取");
			btn.setBackgroundResource(R.drawable.fragment1_item_btn_01_sector);
			btn.setTextColor(context.getResources().getColorStateList(
					R.color.btntv_bule_color_sector));

		}
		final String url = info.getIcon();
		ImageView image = holder.getImage();
		image.setTag(_position);
		if (buf.get(_position) != null) {
			image.setImageBitmap(buf.get(_position));
		} else {
			image.setImageResource(R.drawable.ic_launcher);
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
			}).execute(url);
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

	public class ViewHolder {
		XCRoundRectImageView image;
		TextView tv1;
		TextView tv2;
		TextView tv3;
		Button btn1;
		View foot;

		public ViewHolder(View v) {
			foot = v;
		}

		public ImageView getImage() {
			if (image == null) {
				image = (XCRoundRectImageView) foot.findViewById(R.id.image);
			}
			return image;
		}

		public TextView getTv1() {
			if (tv1 == null) {
				tv1 = (TextView) foot.findViewById(R.id.tv1);
			}
			return tv1;
		}

		public TextView getTv2() {
			if (tv2 == null) {
				tv2 = (TextView) foot.findViewById(R.id.tv2);
			}
			return tv2;
		}

		public TextView getTv3() {
			if (tv3 == null) {
				tv3 = (TextView) foot.findViewById(R.id.tv3);
			}
			return tv3;
		}

		public Button getBtn1() {
			if (btn1 == null) {
				btn1 = (Button) foot.findViewById(R.id.btn1);
			}
			return btn1;
		}

	}

}
