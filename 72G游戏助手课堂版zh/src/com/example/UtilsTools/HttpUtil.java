package com.example.UtilsTools;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class HttpUtil {
	
	
	public  static byte[] getImage(String website){
		if(website==null||website.length()==0||website.equals("null")){
			return null;
		}
		ByteArrayOutputStream bos=null;
		HttpURLConnection conn=null;
			try {
				URL url=new URL(website);
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setReadTimeout(8000);
				conn.setConnectTimeout(8000);
				conn.setDoInput(true);
				conn.setDoOutput(false);
				int code=conn.getResponseCode();
				if(code==200){
					InputStream is=conn.getInputStream();
					 bos=new ByteArrayOutputStream();
					byte[] buf=new byte[1024*4];
					int len=0;
					while((len=is.read(buf))!=-1){
						bos.write(buf, 0, len);
					}
					byte[] data=bos.toByteArray();
					return data;
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(bos!=null){
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bos=null;
			}
			if(conn!=null){
				conn.disconnect();
			}
			return null;
			
		
	}


}
