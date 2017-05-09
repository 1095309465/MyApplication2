package com.example.DownLoadUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadThread extends Thread {

	private String path; // 资源的地址
	private int start; // 资源的开始下标
	private int end; // 资源的结束下标
	private int threadId; // 线程id
	private String desPath; // 文件的保存路径
	
	public DownloadThread(String path, int start, int end, int threadId, String desPath) {
		this.path = path;
		this.start = start;
		this.end = end;
		this.threadId = threadId;
		this.desPath = desPath;
	}

	@Override
	public void run() {
		System.out.println("线程" + threadId + "下载 : " + start + " ~ " + end);
		RandomAccessFile raf = null;
		HttpURLConnection conn = null;
		try {
			URL url = new URL(path);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			// Range
			// bytes=56-89
			conn.setRequestProperty("Range", "bytes=" + start + "-" + end);
			int code = conn.getResponseCode();
			if(code == 206) {
				InputStream is = conn.getInputStream();
				// 随机流打开文件，如果文件不存在则创建，
				// 如果存在，不会清空文件，而是将指针放在开始位置进行读写
				raf = new RandomAccessFile(desPath, "rw");
				// 将随机流中的文件指针指向指定的位置
				raf.seek(start);
				byte[] buf = new byte[1024];
				int len = 0;
				while((len = is.read(buf))!=-1){
					raf.write(buf, 0, len);
				}
				System.out.println("线程"+threadId+"下载完成");
			} else {
				throw new RuntimeException("网络异常:"+code);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(raf!=null){
				try {
					raf.close();
					raf = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				conn.disconnect();
				conn = null;
			}
		}
	}

}











