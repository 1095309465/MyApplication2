package com.example.UtilsTools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HttpUtils {
	public static String getJSON(String website, Map<String, String> map) {
		HttpURLConnection conn = null;
		PrintWriter pw = null;
		StringBuilder sbs = new StringBuilder();
		Iterator<Entry<String, String>> itr = map.entrySet().iterator();
		StringBuilder sb = new StringBuilder();
		while (itr.hasNext()) {
			Entry<String, String> entry = itr.next();
			String key = entry.getKey();
			String value = entry.getValue();
			sb.append(key + "=" + value + "&");
		}
		if (sb.length() != 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		try {
			URL url = new URL(website);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(8000);
			conn.setReadTimeout(8000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Connection", "Keep-Alive");
			// 头文件填写表单的数据大小
			conn.setRequestProperty("Content-Length",
					String.valueOf(sb.length()));
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			pw = new PrintWriter(conn.getOutputStream());
			pw.write(sb.toString());
			pw.flush();
			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						conn.getInputStream(), "utf-8"));
				String str = "";
				while ((str = br.readLine()) != null) {
					sbs.append(str);
				}
				return sbs.toString();
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
			if (pw != null) {
				pw.close();
				pw = null;
			}
		}

		return null;
	}

}
