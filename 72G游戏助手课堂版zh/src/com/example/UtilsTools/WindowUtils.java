package com.example.UtilsTools;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;

public class WindowUtils {
	
	
	/**
	 * 获取当前屏幕的宽度
	 */
	public static int getScreenWidth(Activity a){
		Point outSize=new Point();
		a.getWindowManager().getDefaultDisplay().getSize(outSize);
		return outSize.x;
	}
	/**
	 * 获取当前屏幕的高度
	 */
	public static int getScreenHeight(Activity a){
		Point outSize=new Point();
		a.getWindowManager().getDefaultDisplay().getSize(outSize);
		return outSize.y;
	}
	
	/**
	 * 获取去除状态栏的屏幕的高度
	 *该方法有问题
	 */
	@Deprecated
	public static int getViewScreenHeight(Activity a){
		//矩形框的意思（记录了左上角和右下角的点）
		Rect outRect=new Rect();
//		outRect.set(left, top, right, bottom)
		a.getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
		//返回矩形框的高度
		return outRect.height();
	}
	
	

}
