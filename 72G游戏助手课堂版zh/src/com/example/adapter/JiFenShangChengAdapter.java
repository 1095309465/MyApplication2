package com.example.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.UtilsTools.ImageTask;
import com.example.UtilsTools.ImageTask.CallBackImage;
import com.example.bean.ZuiXinJiangPinInfo;
import com.example.game_assistent.R;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class JiFenShangChengAdapter extends AppAdapter<ZuiXinJiangPinInfo> {
	private Map<Integer, Bitmap> buf;
	private float left;
	private Context context;
	private int _position;

	public JiFenShangChengAdapter(Context context,
			List<ZuiXinJiangPinInfo> mList) {
		super(context, mList);
		this.context = context;
		buf = new HashMap<Integer, Bitmap>();
		left = context.getResources().getDisplayMetrics().widthPixels;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.activity_jfsc_item, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		_position = position;
		ZuiXinJiangPinInfo model = mList.get(position);
		holder.getTv1().setText(model.getName());
		holder.getTv2().setText(model.getRemain());
		if (TextUtils.isEmpty(model.getConsume())) {

			holder.getBtn().setText("0Q币");
		} else {
			holder.getBtn().setText(model.getConsume() + "Q币");
		}
		final String website = model.getIcon();
		final ImageView image = holder.getImage1();
		image.setTag(_position);
		if (buf.get(_position) != null) {
			image.setImageBitmap(buf.get(_position));
		} else {
			image.setImageResource(R.drawable.ic_launcher);
			new ImageTask(image,_position, context, new CallBackImage() {

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
		private ImageView image1;
		private TextView tv1;
		private TextView tv2;
		private Button btn;
		private View root;

		public ViewHolder(View v) {
			root = v;
		}

		public Button getBtn() {
			if (btn == null) {
				btn = (Button) root.findViewById(R.id.btn);
			}
			return btn;
		}

		public ImageView getImage1() {
			if (image1 == null) {
				image1 = (ImageView) root.findViewById(R.id.imageView1);
			}
			return image1;
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

	}

}
