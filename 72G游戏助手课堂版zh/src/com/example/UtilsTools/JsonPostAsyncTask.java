package com.example.UtilsTools;

import java.util.Map;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

import com.example.game_assistent.R;

public class JsonPostAsyncTask<T> extends AsyncTask<String, Void, T> {

	/**
	 * 定义泛型 T 提高扩展性
	 * 
	 * @author Administrator
	 */
	private Map<String, String> map;
	private Class clazz;
	private CallBack<T> callBack;
	private MyOpenHelper moh;

	public JsonPostAsyncTask(Map<String, String> map, Class clazz,
			CallBack<T> callBack) {
		this.callBack = callBack;
		this.clazz = clazz;
		this.map = map;

	}

	public JsonPostAsyncTask(Map<String, String> map, Class clazz,
			Context context, CallBack<T> callBack) {
		this.callBack = callBack;
		this.clazz = clazz;
		this.map = map;
		moh = new MyOpenHelper(context);

	}

	@Override
	protected T doInBackground(String... params) {
		String jsonString = HttpUtils.getJSON(params[0], map);
		Log.i("123", "jsonString" + jsonString);
		if (moh != null) {
			String sql = "select detail from test where model=?";
			Log.i("123", "clazz.toString()=" + clazz.toString());
			String str = moh.queryGetString(sql,
					new String[] { clazz.toString() + "" });
			Log.i("123", "从数据库读取的str=" + str);

			if (jsonString != null) {
				String sqlInsert = "insert into test (model,detail) values (?,?)";
				boolean flag = moh.oprateTable(sqlInsert,
						new String[] { clazz.toString(), jsonString });
				Log.i("123", "flag=" + flag);

			}
		}
		JsonUtils<T> jsonUtils = new JsonUtils<T>();

		return jsonUtils.parserShouYou(jsonString, clazz);
	}

	@Override
	protected void onPostExecute(T result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if (callBack != null) {
			callBack.getData(result);
		}
	}

	public interface CallBack<T> {

		void getData(T result);
	}

}
