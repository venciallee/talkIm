package com.talk.view.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.talk.R;
import com.talk.view.service.ImageViewPaddingService;
import com.talk.view.service.UserServices;

/**
 * @author ven
 * @createTime 2013-2-12œ¬ŒÁ07:05:39
 * @lastEditTime 2013-2-12œ¬ŒÁ07:05:39
 * @copyright Design by vencial
 * @description ¿‡√Ë ˆ
 */
public class LoginActivity extends Activity {

	private EditText username = null;
	private EditText password = null;
	private ImageButton loginButton = null;
	private UserServices userServices = null;
	private boolean userNameFlag = false;
	private boolean passwordFlag = false;

	private ImageViewPaddingService imgPaddingService = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		username = (EditText) findViewById(R.id.username_edit_text);
		password = (EditText) findViewById(R.id.password_edit_text);
		loginButton = (ImageButton) findViewById(R.id.login_button);

		userServices = new UserServices();

		imgPaddingService = new ImageViewPaddingService();

		imgPaddingService.setImageViewPadding(
				(ImageView) findViewById(R.id.selected_bg_view), this);

		Intent intent = getIntent();

		if (null != intent) {
			if (null != intent.getStringExtra("username")
					&& null != intent.getStringExtra("password")) {
				username.setText(intent.getStringExtra("username"));
				password.setText(intent.getStringExtra("password"));
			}
		}

		loginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				boolean result = userServices.login(username.getText()
						.toString(), password.getText().toString());
				isLogin(result);
			}
		});

		username.setOnTouchListener(new TextOnToughListener(username,
				userNameFlag));
	}

	/**
	 * 
	 * @param result
	 */
	private void isLogin(boolean result) {
		if (result) {
			Intent intent = new Intent(LoginActivity.this, MainActivity.class);
			this.startActivity(intent);
		} else {
			Toast.makeText(this, "invalid username or password",
					Toast.LENGTH_SHORT).show();
		}
	}

	private class TextOnToughListener implements OnTouchListener {

		private boolean flag = false;
		private TextView textView = null;

		public TextOnToughListener(TextView textView, boolean flag) {
			this.textView = textView;
			this.flag = flag;
		}

		@Override
		public boolean onTouch(View v, MotionEvent event) {

			if (!flag) {
				textView.setText(null);
				flag = true;
			}
			return false;
		}

		public boolean isFlag() {
			return flag;
		}

		public void setFlag(boolean flag) {
			this.flag = flag;
		}
	}
}
