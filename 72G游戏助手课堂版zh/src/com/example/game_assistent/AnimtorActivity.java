package com.example.game_assistent;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.example.UtilsTools.WindowUtils;

public class AnimtorActivity extends Activity {
	private FrameLayout LinearLayout1;
	private int centerX;
	private int centerY;
	private ImageView ivPic;
	private ImageView ivPic2;
	private AnimtorView view;
	private static int DURAYION=600;
	private Handler handler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			if(msg.what==0){
				startActivity(new Intent(AnimtorActivity.this,MainActivity.class));
				finish();
			}
		}
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("123", "开始加载布局");
		setContentView(R.layout.activity_animtor);
		LinearLayout1 = (FrameLayout) findViewById(R.id.LinearLayout1);
		// 初始化自定义视图
		view = new AnimtorView(this, LinearLayout1);
		view.playAnimtor();
		
		handler.sendEmptyMessageDelayed(0,DURAYION*3);
	
	} 


	/**
	 * 自定义view,使用比较多，难度比较高
	 */
	public class AnimtorView extends View {
		private AnimatorSet set;
		private ViewGroup vp;
		// 动态代码调用的
		public AnimtorView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
		// 在xml文件中当标签使用的时候会调用
		// xml填写的属性需要第二个参数的解析
		public AnimtorView(Context context, AttributeSet attrs) {
			super(context, attrs);
			// TODO Auto-generated constructor stub
		}
		// 在xml文件中当标签使用的时候会调用 ，可以定义样式
		public AnimtorView(Context context, AttributeSet attrs, int defStyleAttr) {
			super(context, attrs, defStyleAttr);
			// TODO Auto-generated constructor stub
		}
		// 动态代码调用的
		// 提供ViewGroup可以将视图添加到ViewGroup中（xml中的布局容器）
		public AnimtorView(Context context, ViewGroup viewGroup) {
			super(context);
			// TODO Auto-generated constructor stub
			vp = viewGroup;
			initView(context);
		}
		/**
		 * 初始化视图（动态设置2个ImageView的位置）
		 */
		private void initView(Context context) {
			// 获取屏幕的中点(直接强转activity)
			centerX = WindowUtils.getScreenWidth((Activity) context) / 2;
			centerY = WindowUtils.getScreenHeight((Activity) context) / 2;
			ivPic = new ImageView(context);
			// 设置属性
			ivPic.setLayoutParams(new LayoutParams(500, 250));
			ivPic.setImageResource(R.drawable.ic_about_app);
			ivPic.setScaleType(ScaleType.FIT_CENTER);
			// 直接设置坐标点
			ivPic.setX(centerX - 250);// 到中心位置
			ivPic.setY(-300);// 默认设置
			ivPic2 = new ImageView(context);
			// 设置属性
			ivPic2.setLayoutParams(new LayoutParams(200,
					LayoutParams.WRAP_CONTENT));
			ivPic2.setImageResource(R.drawable.bg_logo_font);
			ivPic2.setScaleType(ScaleType.FIT_CENTER);
			ivPic2.setY(centerY - 250);
			ivPic2.setX(-300);// 补上偏移值，会让两张图片重叠，所以不设置，暂时

			// 添加到容器里
			vp.addView(ivPic);
			vp.addView(ivPic2);

		}

		/**
		 * 加入属性动画
		 */
		private void createAnimtor() {
			if (set == null) {
				ObjectAnimator oaText = ObjectAnimator.ofFloat(ivPic2,
						View.TRANSLATION_X, -300, centerX +200);
				ObjectAnimator oaText2 = ObjectAnimator.ofFloat(ivPic2,
						View.TRANSLATION_X, centerX +200, centerX - 100);
				oaText.setDuration(DURAYION);
				oaText2.setDuration(DURAYION/2);
				
				ObjectAnimator oaPic = ObjectAnimator.ofFloat(ivPic,
						View.TRANSLATION_Y, -300, centerY - 550);
				oaPic.setDuration(DURAYION);
				// 设置差值器，掉落的时候产生重力效果
				// LinearInterpolator
				// cycleInterpolator
				// AccelerateInterpolator 匀加速
				AccelerateInterpolator ai=new AccelerateInterpolator();
				oaText.setInterpolator(ai);
				oaPic.setInterpolator(new BounceInterpolator());
				set = new AnimatorSet();
				set.playSequentially(oaText,oaText2, oaPic);
			}

		}

		/**
		 * 播放动画的方法
		 */
		public void playAnimtor() {
			createAnimtor();
			set.start();
		}

	}

}
