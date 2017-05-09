package com.example.ChcheUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class BitmapUtils {
	/**
	 * 获取二次采样后的图片(图片的压缩处理)
	 * @param fileName 图片文件的名字
	 * @param targetWidth 设定的宽度 (根据实际情况设置)
	 * @param targetHeight 设定的高度
	 * @return bm 二次处理过的图片,可以方式OOM(OutOfMemory)
	 */
	public static Bitmap getBitmapFile(String fileName,int targetWidth, int targetHeight){
		//带有Options的方式去处理图片
		/**
		 * 第一个参数:图片所以完整的路径
		 * 第二个参数:Options
		 */
		BitmapFactory.Options opts = new BitmapFactory.Options();
		//设置opts参数
		//该参数表示:不加载内容到内存,只获取属性信息(图片的宽度和高度)
		opts.inJustDecodeBounds = true;
		//这时候加载返回的bm是null
		Bitmap bm = BitmapFactory.decodeFile(fileName, opts);
		Log.i("BitmapUtils", "图片内容-->"+bm);
		
		//从opts中获取图片的宽度和高度
		int srcWidth = opts.outWidth; //图片原始宽度
		int srcHeight = opts.outHeight; //图片原始的高度
		Log.i("BitmapUtils", "图片原始宽度-->"+srcWidth);
		Log.i("BitmapUtils", "图片原始高度-->"+srcHeight);
		
		//通过原始宽度和高度进行重新处理,压缩原图的比例，以节省内存
		//>1才是有意义的，比如设置4代表，获取的图片大小是原始图片的1/4
		//1000*1000
		//3000*3000 
		//由于不同图片大小不一样，所有自定义算法，使inSampleSize的值合理化，通用性更强
		//直接写死效果比较差
		opts.inSampleSize = calculateSampleSize(srcWidth, srcHeight, targetWidth, targetHeight);
		//开始加载内容到内存中
		opts.inJustDecodeBounds = false;
		//图像的类型设置
		//常用的是ARGB_8888(质量高，消耗内存高)和RGB_565(质量稍微较低，但是内存和ARGB_8888相比减少一半)
		//防止OOM的一种选择
		opts.inPreferredConfig = Bitmap.Config.RGB_565;
		//再去重新执行BitmapFactory.decodeFile(fileName, opts)方法,获取压缩后的图片
		return BitmapFactory.decodeFile(fileName, opts);
	}
	
	/**
	 * 获取二次采样后的图片(图片的压缩处理)
	 * @param byte[] 图片数组
	 * @param targetWidth 设定的宽度 (根据实际情况设置)
	 * @param targetHeight 设定的高度
	 * @return bm 二次处理过的图片,可以方式OOM(OutOfMemory)
	 */
	public static Bitmap getBitmapByteData(byte[] data,int targetWidth, int targetHeight){
		//带有Options的方式去处理图片
		/**
		 * 第一个参数:图片所以完整的路径
		 * 第二个参数:Options
		 */
		BitmapFactory.Options opts = new BitmapFactory.Options();
		//设置opts参数
		//该参数表示:不加载内容到内存,只获取属性信息(图片的宽度和高度)
		opts.inJustDecodeBounds = true;
		//这时候加载返回的bm是null
		Bitmap bm = BitmapFactory.decodeByteArray(data, 0, data.length, opts);
		Log.i("BitmapUtils", "图片内容-->"+bm);
		
		//从opts中获取图片的宽度和高度
		int srcWidth = opts.outWidth; //图片原始宽度
		int srcHeight = opts.outHeight; //图片原始的高度
		Log.i("BitmapUtils", "图片原始宽度-->"+srcWidth);
		Log.i("BitmapUtils", "图片原始高度-->"+srcHeight);
		
		//通过原始宽度和高度进行重新处理,压缩原图的比例，以节省内存
		//>1才是有意义的，比如设置4代表，获取的图片大小是原始图片的1/4
		//1000*1000
		//3000*3000 
		//由于不同图片大小不一样，所有自定义算法，使inSampleSize的值合理化，通用性更强
		//直接写死效果比较差
		opts.inSampleSize = calculateSampleSize(srcWidth, srcHeight, targetWidth, targetHeight);
		//开始加载内容到内存中
		opts.inJustDecodeBounds = false;
		//图像的类型设置
		//常用的是ARGB_8888(质量高，消耗内存高)和RGB_565(质量稍微较低，但是内存和ARGB_8888相比减少一半)
		//防止OOM的一种选择
		opts.inPreferredConfig = Bitmap.Config.RGB_565;
		//再去重新执行BitmapFactory.decodeFile(fileName, opts)方法,获取压缩后的图片
		return BitmapFactory.decodeByteArray(data, 0, data.length, opts);
	}
	
	
	
	
	/**
	 * 计算inSampleSize的算法
	 * @param srcWidth 原始图片宽度
	 * @param srcHeight 原始图片高度 
	 * @param targetWidth 目标图片宽度
	 * @param targetWidth 目标图片高度
	 * 比如从 1000*1000 到 500*500 或者从2000*2000 到 500*500  (500*500就是目标的宽度和高度)
	 */
	public static int calculateSampleSize(int srcWidth , int srcHeight, int targetWidth, int targetHeight){
		//初始化sample为1 (采用2的倍数，处理速度更快)
		int sample = 1;
		/**
		 * 比如: 900*600 到 400*400
		 * while(900/2  >= 400 && 600 /2 >= 400){
		 * 		srcWidth = 500;
		 * 	    srcHeight = 500; 
		 *      sample = 2
		 * } 
		 */
		while (srcWidth / 2 >= targetWidth && srcHeight / 2 >= targetHeight) { //以小的作为判断依据
			srcWidth /= 2;
			srcHeight /= 2;
			sample *= 2;   
		}
		return sample;
	}
	
}
