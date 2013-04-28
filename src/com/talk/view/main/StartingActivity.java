package com.talk.view.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.talk.R;
import com.talk.thread.ConnectOpThread;
import com.talk.view.service.ImageViewPaddingService;

/**
 * @author ven
 * @createTime 2013-2-14œ¬ŒÁ08:21:39
 * @lastEditTime 2013-2-14œ¬ŒÁ08:21:39
 * @copyright Design by vencial
 * @description ¿‡√Ë ˆ
 */
public class StartingActivity extends Activity {

	private ImageButton loginButton = null;
	private ImageButton registerButton = null;
	private ImageViewPaddingService imgPaddingService = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starting);

		loginButton = (ImageButton) findViewById(R.id.login_button);
		registerButton = (ImageButton) findViewById(R.id.register_button);
		
		imgPaddingService = new ImageViewPaddingService();

		imgPaddingService.setImageViewPadding(
				(ImageView) findViewById(R.id.selected_bg_view), this);

		new Thread(new ConnectOpThread()).start();

		loginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(StartingActivity.this, LoginActivity.class);
				startActivity(intent);
			}
		});

		registerButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(StartingActivity.this,
						RegisterFormActivity.class);
				startActivity(intent);
			}
		});
	}
}
