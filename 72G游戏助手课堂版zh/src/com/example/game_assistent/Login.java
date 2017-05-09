package com.example.game_assistent;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Login extends Activity {
	private ImageView lbxq_lin1_image1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		lbxq_lin1_image1=(ImageView) findViewById(R.id.lbxq_lin1_image1);
		lbxq_lin1_image1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
	}

	

}
