package com.example.adapter;

import java.util.List;
import java.util.Map;

import com.example.bean.ShouYouInfo;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class AppAdapter<T> extends BaseAdapter {
	/**
	 * 只要继承与它的类，就可以获得成员变量
	 */
	protected List<T> mList;
	protected LayoutInflater mInflater;
	public AppAdapter(Context context, List<T> mList
			) {
		// TODO Auto-generated constructor stub
		this.mList = mList;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList == null ? 0 : mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	/**
	 * 不实现该方法，外部进行实现，因为单行布局不能确定
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
