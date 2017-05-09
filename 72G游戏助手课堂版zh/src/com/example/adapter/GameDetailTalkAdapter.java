package com.example.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bean.GameDetailTalkInfo;
import com.example.game_assistent.R;

public class GameDetailTalkAdapter extends AppAdapter<GameDetailTalkInfo> {

	public GameDetailTalkAdapter(Context context, List<GameDetailTalkInfo> mList) {
		super(context, mList);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.game_info_viewpager3, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		GameDetailTalkInfo model=mList.get(position);
		holder.getTv1().setText(model.getNickname());
		holder.getTv2().setText(model.getPubdate());
		holder.getTv3().setText(model.getContent());
		return convertView;
	}

	class ViewHolder {
		private TextView tv1;
		private TextView tv2;
		private TextView tv3;
		private View root;

		public ViewHolder(View v) {
			root = v;
		}

		public TextView getTv1() {
			if (tv1 == null) {
				tv1 = (TextView) root.findViewById(R.id.tv1);
			}
			return tv1;
		}

		public TextView getTv2() {
			if (tv2 == null) {
				tv2 = (TextView) root.findViewById(R.id.tv2);
			}
			return tv2;
		}

		public TextView getTv3() {
			if (tv3 == null) {
				tv3 = (TextView) root.findViewById(R.id.tv3);
			}
			return tv3;
		}

	}

}
