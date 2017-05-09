package com.example.fragment;

import java.util.HashMap;
import java.util.Map;

import com.example.UtilsTools.ImageTask;
import com.example.UtilsTools.ImageTask.CallBackImage;
import com.example.UtilsTools.JsonPostAsyncTask;
import com.example.UtilsTools.JsonPostAsyncTask.CallBack;
import com.example.UtilsTools.UrlConstantUtils;
import com.example.bean.GameInfo;
import com.example.bean.GameInfoBean;
import com.example.game_assistent.Game_Detail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameDetailFragment1 extends Fragment {
	private TextView tv1;
	private LinearLayout lin;
	private Map<String, String> map;
	private String id;
	private String game_desc;

	public GameDetailFragment1(String id, String game_desc) {
		Bundle bundle = new Bundle();
		bundle.putString("id", id);
		bundle.putString("game_desc", game_desc);
		setArguments(bundle);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.game_detail01, null);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		tv1 = (TextView) view.findViewById(R.id.tv1);
		lin = (LinearLayout) view.findViewById(R.id.Lin);
		map = new HashMap<String, String>();
		id = getArguments().getString("id");
		game_desc = getArguments().getString("game_desc");
		tv1.setText(game_desc);
		init();

	}

	public void init() {
		map.put("id", id);
		new JsonPostAsyncTask<GameInfoBean>(map, GameInfoBean.class,
				new CallBack<GameInfoBean>() {

					@Override
					public void getData(GameInfoBean result) {
						if (result != null) {
							loadData(result);

						}
					}

				}).execute(UrlConstantUtils.GAME_DETAIL);

	}

	public void loadData(GameInfoBean result) {
		for (int i = 0; i < lin.getChildCount(); i++) {
			LinearLayout lin2 = (LinearLayout) lin.getChildAt(i);
			final GameInfo modle = result.getInfo().get(i);
			final ImageView image = (ImageView) lin2.getChildAt(0);
			image.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(getActivity(), Game_Detail.class);
					intent.putExtra("id", modle.getId() + "");
					startActivity(intent);

				}
			});
			TextView tv1 = (TextView) lin2.getChildAt(1);
			TextView tv2 = (TextView) lin2.getChildAt(2);
			tv1.setText(modle.getName());
			tv2.setText(modle.getCount_dl() + "次下载");
			String website = modle.getIcon();
			new ImageTask(getActivity(), new CallBackImage() {

				@Override
				public void getData(ImageView iv, int position_, Bitmap result) {
					if (result != null) {
						image.setImageBitmap(result);
					}
				}

			}).execute(website);

		}
	}

}
