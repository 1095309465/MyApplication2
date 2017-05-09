package com.example.DownLoadUtil;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

public class DownApkMoreThread {
	private static Context _context;

	public static void DownStart(String path,Context context ) {
		if (TextUtils.isEmpty(path))
			return;
		// 多线程下载
		_context=context;
		RandomAccessFile raf = null;
		HttpURLConnection conn = null;
		// 线程的个数
		int threadCount = 5;
		try {
			URL url = new URL(path);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			conn.setDoOutput(false);
			conn.setReadTimeout(8000);
			conn.setConnectTimeout(8000);
			int code = conn.getResponseCode();
			String desPath = getPathName(path);
			Log.i("123", "询问网络" );
			Log.i("123", "desPath="+desPath );
			if (code == 200) {
				// 获取文件的大小
				int length = conn.getContentLength();
				Log.i("123", "下载文件的大小：" + length);
				// 在本地创建一个一样大小的文件
				raf = new RandomAccessFile(desPath, "rw");
				raf.setLength(length);
				int blockSize = length / threadCount;
				// 开启多个线程下载数据
				for (int i = 0; i < threadCount; i++) {
					// 计算每个线程需要下载数据的区间
					int start = i * blockSize;
					int end = (i + 1) * blockSize - 1;
					if (i == threadCount - 1) {
						end = length - 1;
					}
					// 开启线程下载指定部分的数据
					new DownloadThread(path, start, end, i, desPath).start();
				}
			} else {
				throw new RuntimeException("网络连接异常：" + code);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.i("123", "网络访问失败...");
		} finally {
			if (raf != null) {
				try {
					raf.close();
					raf = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				conn.disconnect();
				conn = null;
			}
		}
	}
	public static String getPathName(String path){
		String[] str=path.split("/");
		String pathName=_context.getExternalCacheDir().getAbsolutePath()+File.separator
				+str[str.length-1]+".apk";
		
		Log.i("123", "pathName=pathName"+pathName);
		
		return pathName;
		
	}

}
