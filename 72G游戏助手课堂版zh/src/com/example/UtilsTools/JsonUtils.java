package com.example.UtilsTools;

import com.alibaba.fastjson.JSONObject;

public class JsonUtils<T> {
	/**具体的Class不知道，定义泛型T，外部传递什么，解析出来的就是什么
	 * 使用FastJson解析Json数据
	 */
	public T parserShouYou(String jsonString,Class<T> clazz){
		if(jsonString!=null){//可能网络下载失败
			//填写的是Class
		T t=JSONObject.parseObject(jsonString,clazz);
		return t;
			
		}
		return null;
	}

}
