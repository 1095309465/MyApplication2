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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.UtilsTools.HeadViewLoadData;
import com.example.UtilsTools.ImageTask;
import com.example.UtilsTools.ImageTask.CallBackImage;
import com.example.bean.XiaoGameZuiXinInfo;
import com.example.game_assistent.R;

public class XiaoGameAdapter extends AppAdapter<XiaoGameZuiXinInfo> {
	private float left;
	private Map<Integer, Bitmap> buf;
	private Context context;
	private int _position;
	private View view0;

	public XiaoGameAdapter(Context context, List<XiaoGameZuiXinInfo> mList) {
		super(context, mList);
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
		if(view0!=null){
			return view0;
		}
			view0 = mInflater.inflate(R.layout.xiaogamefragment, null);
			HeadViewLoadData.setView(view0, context);
			return view0;
		}
		ViewHolder holder = null;
		if (convertView == null || convertView.getTag() == null) {
			convertView = mInflater.inflate(R.layout.xiaogamezuixin, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		_position = position;
		XiaoGameZuiXinInfo info = mList.get(position - 1);
		holder.getTv1().setText(info.getName());
		holder.getTv2().setText(info.getClick());
		holder.getTv3().setText(info.getGame_desc());
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

	public void position0(View v) {

	}

	public class ViewHolder {
		ImageView image;
		TextView tv1;
		TextView tv2;
		TextView tv3;
		View foot;

		public ViewHolder(View v) {
			foot = v;
		}

		public ImageView getImage() {
			if (image == null) {
				image = (ImageView) foot.findViewById(R.id.image);
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

	}

}
