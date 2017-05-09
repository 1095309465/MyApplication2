package com.example.UtilsTools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.example.ChcheUtils.BitmapUtils;
import com.example.ChcheUtils.SDcard;

public class ImageTask extends AsyncTask<String, Void, Bitmap> {
	private MyLruCache myLruCache;
	private static int maxSize;
	private CallBackImage callback;
	private ImageView iv;
	private Context context;
	private boolean flag = true;// 是否压缩图片
	private Bitmap bm2;
	private int position_;

	public ImageTask(Context context, CallBackImage callback) {
		this.callback = callback;
		this.context = context;
		long maxMemory = Runtime.getRuntime().maxMemory();
		maxSize = (int) (maxMemory / 8);
		myLruCache = MyLruCache.getInstance();

	}

	public ImageTask(ImageView iv, int position, Context context,
			CallBackImage callback) {
		this.callback = callback;
		this.iv = iv;
		this.context = context;
		long maxMemory = Runtime.getRuntime().maxMemory();
		maxSize = (int) (maxMemory / 8);
		myLruCache = MyLruCache.getInstance();
		position_ = position;

	}

	public ImageTask(ImageView iv, Context context, boolean flag,
			CallBackImage callback) {
		this.callback = callback;
		this.iv = iv;
		this.context = context;
		long maxMemory = Runtime.getRuntime().maxMemory();
		maxSize = (int) (maxMemory / 8);
		myLruCache = MyLruCache.getInstance();

	}

	@Override
	protected Bitmap doInBackground(String... params) {
		String url = getImageName(params[0]);
		Bitmap bm = getBitmapByLruCache(url, context);
		if (bm != null) {
			return bm;
		}
		byte[] bit = SDcard.Read(url, context);
		if (bit != null) {
			return BitmapFactory.decodeByteArray(bit, 0, bit.length);
		}
		byte[] data = HttpUtil.getImage(params[0]);
		if (data == null) {
			return null;
		}
		if (flag) {
			bm2 = BitmapUtils.getBitmapByteData(data, 80, 80);
		} else {
			bm2 = BitmapFactory.decodeByteArray(data, 0, data.length);

		}
		if (bm2 == null) {
			return null;
		}

		SDcard.write(url, data, context);
		myLruCache.put(url, bm2);
		return bm2;
	}

	@Override
	protected void onPostExecute(Bitmap result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if (callback != null) {
			callback.getData(iv, position_, result);
		}
	}

	public interface CallBackImage {
		void getData(ImageView iv, int position_, Bitmap result);
	}

	/**
	 * 读取内存图片
	 * 
	 * @return
	 */
	private Bitmap getBitmapByLruCache(String key, Context context) {
		// 1.先从缓存A(LRUCache的缓存,该缓存存放的是强引用对象)读取数据
		if (myLruCache != null && key != null) {
			Bitmap bm = myLruCache.get(key);
			if (bm != null) { // 读取到图片确实存在，直接返回
				return bm;
			}
		}
		byte[] data = SDcard.Read(key, context);
		if (data != null) {
			myLruCache.put(key,
					BitmapFactory.decodeByteArray(data, 0, data.length));// 将他移入到缓存A中
			return BitmapFactory.decodeByteArray(data, 0, data.length);

		}

		return null;
	}

	public String getImageName(String key) {
		if (TextUtils.isEmpty(key)) {
			return null;
		}
		return key.split("/")[key.split("/").length - 1];
	}

	/**
	 * 自定义LruCache缓存，继承系统提供的LruCache LruCache定义泛型:<K,V> key:图片URL(String)，保证位移性
	 * Value:实际存储的图片(Bitmap)
	 */
	public static class MyLruCache extends LruCache<String, Bitmap> {
		private static MyLruCache myLruCache = null;

		// maxSize分配LruCache缓存的大小
		// maxSize太大浪费，太小放不了多少数据
		private MyLruCache(int maxSize) {
			super(maxSize);
			// TODO Auto-generated constructor stub
		}

		public static MyLruCache getInstance() {
			if (myLruCache == null) {
				myLruCache = new MyLruCache(maxSize);
			}
			return myLruCache;
		}

		/**
		 * 可以计算图片的大小 默认的图片大小计算宽度*高度*4
		 */
		@Override
		protected int sizeOf(String key, Bitmap value) {
			// TODO Auto-generated method stub
			// 第二个参数直接提供了图片（1.宽度*高度*4）
			// return value.getWidth() * value.getHeight() * 4;
			// 2.调用bitmap提供的方法
			return value.getByteCount();
		}

		// 可以进行置换的逻辑
		// 内部对命中率低的图片进行栓选，作为oldValue提供
		@Override
		protected void entryRemoved(boolean evicted, // true表示oldValue已经过期,false表示没有过期
				String key, // oldValue的key (LruCache内部缓存移除的)
				Bitmap oldValue, // 需要移除的老图片
				Bitmap newValue // 新加入的图片
		) {
			// TODO Auto-generated method stub
			super.entryRemoved(evicted, key, oldValue, newValue);
		}
	}

}
