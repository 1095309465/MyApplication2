package com.example.ChcheUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.util.Log;

public class SDcard {
	
	public static byte[] Read(String key,Context context){
		
		try {
			String path=context.getExternalCacheDir().getAbsolutePath()+File.separator+key;
			File file=new File(path);
			if(!file.exists()){
				return null;
			}
			FileInputStream fis=new FileInputStream(file);
			
			ByteArrayOutputStream bos=new ByteArrayOutputStream();
			
			byte[] buf=new byte[1024*4];
			int len=0;
			while((len=fis.read(buf))!=-1){
				bos.write(buf, 0, len);
			}
			byte[] date=bos.toByteArray();
			if(fis!=null){
				fis.close();
				fis=null;
			}
			if(bos!=null){
				bos.close();
				bos=null;
			}
			
			Log.i("123", "从sd卡读取");
			return date;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
	public static void write(String key,byte[] data,Context context){
		FileOutputStream fos=null;
		
		try {
			String path=context.getExternalCacheDir().getAbsolutePath()+File.separator+key;
			File file=new File(path);
			 fos=new FileOutputStream(file);
			
			fos.write(data);
			Log.i("123", "写入到sd卡");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fos=null;
			}
			
		}
		
	}

}
