package com.example.DownLoadUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.game_assistent.R;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class OneThreadDown {
	private ProgressDialog dialog;
	private Context context;
	private int count;
	private String url;
	
	///////////////////
	private NotificationCompat.Builder nb;
	private NotificationManager  nm;
	
	public OneThreadDown(Context context,String path) {
		this.context=context;
		url=path;
		nb=new NotificationCompat.Builder(context);
		nm=(NotificationManager) context.getSystemService(Service.NOTIFICATION_SERVICE);
		
	}
	public void Down(){
		dialog=new ProgressDialog(context);
		dialog.setMessage("正在下载...");
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.setCancelable(true);
		dialog.show();
		nb.setContentTitle("下载任务");
		nb.setContentText("正在下载...");
		nb.setSmallIcon(R.drawable.ic_launcher);
		
		new DownloadTask().execute(url);
		nm.notify(1, nb.build());
		
	};

	public class DownloadTask extends AsyncTask<String, Integer, Void> {
		
		@Override
		protected Void doInBackground(String... params) {
			

			String path = params[0];
			FileOutputStream fos = null;
			HttpURLConnection conn = null;
			try {
				URL url = new URL(path);
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setDoInput(true);
				conn.setDoOutput(false);
				conn.setReadTimeout(8000);
				int length=conn.getContentLength();
				nb.setProgress(length, 0, false);
				dialog.setMax(length);
				conn.setConnectTimeout(8000);
				Log.i("123", "code =" + conn.getResponseCode());
				int code = conn.getResponseCode();
				if (code == 200) {
					Log.i("123", "访问网络成功");
					InputStream is = conn.getInputStream();
					fos = new FileOutputStream(new File(getPathName(path)));
					Log.i("123", "File.path=" + getPathName(path));
					byte[] buf = new byte[1024 * 4];
					int len = 0;
					while ((len = is.read(buf)) != -1) {
						fos.write(buf, 0, buf.length);
						count+=len;
						nb.setProgress(length, len, false);
						dialog.setProgress(count);
						nm.notify(1,nb.build());
//						publishProgress(count);
						dialog.show();
					}
					dialog.dismiss();
					Log.i("123", "下载完成");

				} else {
					Log.i("123", "网络访问失败");
					throw new Exception("网络访问失败");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (fos != null) {
						fos.close();
						fos = null;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (conn != null) {
					conn.disconnect();
				}
			}
			return null;

		}

		@Override
		protected void onProgressUpdate(Integer... values) {
//			dialog.setProgress(count);
			super.onProgressUpdate(values);
		}

	}


	public static String getPathName(String path) {
		String[] str = path.split("/");
		String pathName = Environment.getExternalStorageDirectory()
				.getAbsolutePath()
				+ File.separator
				+ str[str.length - 1]
				+ ".apk";

		Log.i("123", "pathName=pathName" + pathName);

		return pathName;

	}

}
