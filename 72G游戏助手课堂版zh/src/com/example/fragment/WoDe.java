package com.example.fragment;

import java.util.HashMap;
import java.util.Map;

import com.example.UtilsTools.ImageTask;
import com.example.UtilsTools.ImageTask.CallBackImage;
import com.example.UtilsTools.JsonPostAsyncTask;
import com.example.UtilsTools.JsonPostAsyncTask.CallBack;
import com.example.UtilsTools.UrlConstantUtils;
import com.example.bean.WoDeBean;
import com.example.game_assistent.Login;
import com.example.game_assistent.R;

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

public class WoDe extends Fragment implements OnClickListener {
	private ImageView image;
	private TextView tv1;
	private ImageView image1;
	private Map<String, String> map;
	private LinearLayout lin1;
	private LinearLayout lin2;
	private LinearLayout lin3;
	private LinearLayout lin4;
	private LinearLayout lin5;
	private LinearLayout lin6;
	private LinearLayout lin7;
	private LinearLayout lin8;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.detail_fragment5, null);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		image = (ImageView) view.findViewById(R.id.image);
		image1 = (ImageView) view.findViewById(R.id.image1);
		image1.setOnClickListener(this);
		lin1 = (LinearLayout) view.findViewById(R.id.lin1);
		lin2 = (LinearLayout) view.findViewById(R.id.lin2);
		lin3 = (LinearLayout) view.findViewById(R.id.lin3);
		lin4 = (LinearLayout) view.findViewById(R.id.lin4);
		lin5 = (LinearLayout) view.findViewById(R.id.lin5);
		lin6 = (LinearLayout) view.findViewById(R.id.lin6);
		lin7 = (LinearLayout) view.findViewById(R.id.lin7);
		lin8 = (LinearLayout) view.findViewById(R.id.lin8);
		lin1.setOnClickListener(this);
		lin2.setOnClickListener(this);
		lin3.setOnClickListener(this);
		lin4.setOnClickListener(this);
		lin5.setOnClickListener(this);
		lin6.setOnClickListener(this);
		lin7.setOnClickListener(this);
		lin8.setOnClickListener(this);

		tv1 = (TextView) view.findViewById(R.id.tv1);
		init();
	}

	private void init() {
		map = new HashMap<String, String>();
		map.put("platform", "2");
		map.put("pos", "4");
		map.put("compare", "1518b20993dd7dac56e52d88eb72edd8");
		new JsonPostAsyncTask<WoDeBean>(map, WoDeBean.class,
				new CallBack<WoDeBean>() {

					@Override
					public void getData(WoDeBean result) {
						if (result != null) {
							tv1.setText(result.getInfo().get(0).getBname());
							new ImageTask(getActivity(), new CallBackImage() {

								@Override
								public void getData(ImageView iv,
										int position_, Bitmap result) {
									if (result != null) {
										image.setImageBitmap(result);
									}

								}
							}).execute(result.getInfo().get(0).getBimg());
						}

					}
				}).execute(UrlConstantUtils.URL_WODE);

	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(getActivity(), Login.class);
		startActivity(intent);

	}

}
