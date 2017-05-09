package com.example.UtilsTools;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.LinearLayout.LayoutParams;

import com.example.UtilsTools.ImageTask.CallBackImage;
import com.example.game_assistent.R;

public class DialogShowImage {
	private static Dialog dialog;
	private static Context _context;
	public static void showImage(String key, View view, String tags,Context context) {
		if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(tags)) {
			_context=context;
			String[] str = key.split(",");
			String[] tag = tags.split(",");
			LinearLayout Lin = (LinearLayout) view.findViewById(R.id.talk_lin);
			Lin.removeAllViews();
			for (int i = 0; i < str.length; i++) {
				if (TextUtils.isEmpty(str[i])) {
					return;
				}
				final ImageView image = new ImageView(context);
				image.setLayoutParams(new LayoutParams(60, 60));
				image.setPadding(10, 0, 0, 0);
				Lin.addView(image);
				image.setTag(tag[i]);
				DialogShowImage.showBigImage(image,context);
				new ImageTask(context, new CallBackImage() {

					@Override
					public void getData(ImageView iv, int position_,
							Bitmap result) {
						if (result != null) {
							image.setImageBitmap(result);
						}

					}
				}).execute(str[i]);

			}
		}
	}

	public static void showBigImage(final ImageView iv, final Context context) {
		iv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (iv.getTag() == null)
					return;
				String website = (String) iv.getTag();
				dialog = new Dialog(context, R.style.processDialog);
				View view = LayoutInflater.from(context).inflate(
						R.layout.showbigimage, null);
				final ProgressBar progressBar1 = (ProgressBar) view
						.findViewById(R.id.progressBar1);
				final ImageView image = (ImageView) view
						.findViewById(R.id.bigimage);
				image.setVisibility(View.INVISIBLE);
				new ImageTask(context, new CallBackImage() {

					@Override
					public void getData(ImageView iv, int position_,
							Bitmap result) {
						image.setImageBitmap(result);
						image.setVisibility(View.VISIBLE);

						progressBar1.setVisibility(View.INVISIBLE);
						Animshow(progressBar1, 0);
						Animshow(image, 1);
						image.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View v) {
								dialog.dismiss();

							}
						});
					}
				}).execute(website);
				dialog.setContentView(view);
				dialog.show();

			}
		});
	}

	public static void Animshow(View v, int type) {
		AnimatorSet set = new AnimatorSet();
		switch (type) {
		case 0:// 消失
			ObjectAnimator oa = ObjectAnimator.ofFloat(v, View.ALPHA, 1.0f,
					0.0f);
			oa.setDuration(2000);

			set.play(oa);

			break;
		case 1:// 出现
			ObjectAnimator ob = ObjectAnimator.ofFloat(v, View.ALPHA, 0.5f,
					1.0f);
			ob.setDuration(1000);
			ObjectAnimator ob1 = ObjectAnimator.ofFloat(v, View.SCALE_X, 0.9f,
					1.0f);
			ob1.setDuration(500);
			ObjectAnimator ob2 = ObjectAnimator.ofFloat(v, View.SCALE_Y, 0.9f,
					1.0f);
			ob2.setDuration(500);
			set.playTogether(ob, ob1, ob2);

			break;

		default:
			break;
		}

		set.start();

	}
}
