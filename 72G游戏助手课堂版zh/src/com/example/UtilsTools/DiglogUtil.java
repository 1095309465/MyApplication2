package com.example.UtilsTools;

import com.example.game_assistent.R;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class DiglogUtil {
	private static Dialog dialog;
	private static AnimatorSet set;

	public static void setDiglog(Context context) {
		stopDiglog();
		dialog = new Dialog(context, R.style.processDialog);
		View view = LayoutInflater.from(context).inflate(R.layout.diglog, null);
		ImageView dot1 = (ImageView) view.findViewById(R.id.dot1);
		ImageView dot2 = (ImageView) view.findViewById(R.id.dot2);
		ImageView dot3 = (ImageView) view.findViewById(R.id.dot3);
		dialog.setContentView(view);

		ObjectAnimator oa1 = ObjectAnimator.ofFloat(dot1, View.SCALE_X, 1.0f,
				0.0f, 1.0f);
		ObjectAnimator oa2 = ObjectAnimator.ofFloat(dot1, View.SCALE_Y, 1.0f,
				0.0f, 1.0f);
		ObjectAnimator oa3 = ObjectAnimator.ofFloat(dot2, View.SCALE_X, 0.8f,
				0.0f, 1.0f, 0.8f);
		ObjectAnimator oa4 = ObjectAnimator.ofFloat(dot2, View.SCALE_Y, 0.8f,
				0.0f, 1.0f, 0.8f);
		ObjectAnimator oa5 = ObjectAnimator.ofFloat(dot3, View.SCALE_X, 0.0f,
				1.0f, 0.0f);
		ObjectAnimator oa6 = ObjectAnimator.ofFloat(dot3, View.SCALE_Y, 0.0f,
				1.0f, 0.0f);
		oa1.setDuration(800);
		oa1.setRepeatCount(-1);
		oa2.setDuration(800);
		oa2.setRepeatCount(-1);
		oa3.setDuration(800);
		oa3.setRepeatCount(-1);
		oa4.setDuration(800);
		oa4.setRepeatCount(-1);
		oa5.setDuration(800);
		oa5.setRepeatCount(-1);
		oa6.setDuration(800);
		oa6.setRepeatCount(-1);
		set = new AnimatorSet();
		set.playTogether(oa1, oa2, oa3, oa4, oa5, oa6);
		set.start();
		dialog.show();
	}
	
	public static void stopDiglog(){
		if(dialog!=null&&set!=null){
			dialog.dismiss();
			set.cancel();
			dialog=null;
			set=null;
			
		}
	}

}
