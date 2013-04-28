package com.talk.view.main;

import org.jivesoftware.smack.packet.IQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import android.annotation.SuppressLint;
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
 * @createTime 2013-2-2下午08:07:01
 * @lastEditTime 2013-2-2下午08:07:01
 * @copyright Design by vencial
 * @description 类描述
 */
public class RegisterFormActivity extends Activity{
	
	private EditText username = null;
	private EditText name = null;
	private EditText password = null;
	private ImageButton registerButton = null;
	private Logger log = LoggerFactory.getLogger(RegisterFormActivity.class);
	private ImageViewPaddingService imgPaddingService = null;
	
	private UserServices mUserServices = null;
	
	private boolean userNameFlag = false;
	
	private boolean passwordFlag = false;
	
	private boolean nameFlag = false;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_form);
		
		
		mUserServices = new UserServices();
		registerButton = (ImageButton)findViewById(R.id.register_button);
		//loginButton = (ImageButton)findViewById(R.id.login_button);
		username = (EditText)findViewById(R.id.register_username_edit_text);
		password = (EditText)findViewById(R.id.register_password_edit_text);
		name = (EditText)findViewById(R.id.register_name_edit_text);
		
		imgPaddingService = new ImageViewPaddingService();
		
		imgPaddingService.setImageViewPadding((ImageView)findViewById(R.id.selected_bg_view), this);
		
		registerButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				//mUserServices.setXmppConnection(mXMPPCon);
				
				//提交用户注册信息，并返回IQ.
				IQ result = mUserServices.register(username.getText().toString(), password.getText().toString());
				
				/*mUserOpHandler = new UserOpHandler();
				
				Thread thread = new Thread(new Thread(new ConnectOpThread(UserOpType.REGISTER, mUserOpHandler)));
				
				thread.start();*/
				
				//根据IQ类型判断注册成功或失败.
				createAccoutResult(result);
			}
		});
		
		username.setOnTouchListener(new TextOnToughListener(username,userNameFlag));
		password.setOnTouchListener(new TextOnToughListener(password,passwordFlag));
		name.setOnTouchListener(new TextOnToughListener(name,nameFlag));
		
		
		/*loginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				userServices.login(username.getText().toString(), password.getText().toString());
			}
		});*/
		
		/*age_spinner = (Spinner)findViewById(R.id.age_spinner);
		ArrayAdapter spinnerAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, ages){
			@Override
			public View getDropDownView(int position, View convertView,
					ViewGroup parent) {
				View view = getLayoutInflater().inflate(R.layout.spinner, parent, false);
				TextView textView = (TextView)view.findViewById(R.id.text_label);
				textView.setText(this.getItem(position)+"");
				
				return view;
			}
			
		};
		
		//spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		
		
		age_spinner.setAdapter(spinnerAdapter);
		
		age_spinner.setOnItemSelectedListener(new SpinnerListener());*/
		
	}
	
	private void createAccoutResult(IQ result){
		if(null==result){
			log.error("createAccoutResult-server not respond.");
			Toast.makeText(this, "server not respond.", Toast.LENGTH_SHORT).show();
		}else if(IQ.Type.ERROR==result.getType()){
			if(result.getError().toString().equalsIgnoreCase("conflict(409)")){
				log.error("createAccoutResult-accout exist.");
				username.setText(null);
				password.setText(null);
				Toast.makeText(this, "accout exist.", Toast.LENGTH_SHORT).show();
			}else{
				log.error(result.getError().toString());
				Toast.makeText(this, "signin error.", Toast.LENGTH_SHORT).show();
			}
		}else if(IQ.Type.RESULT==result.getType()){
			Intent intent = new Intent();
			intent.setClass(RegisterFormActivity.this, LoginActivity.class);
			intent.putExtra("username", username.getText().toString());
			intent.putExtra("password", password.getText().toString());
			startActivity(intent);
			finish();
			//Toast.makeText(this, "congratulation.", Toast.LENGTH_SHORT).show();
			
		}
	}
	
	
	private class TextOnToughListener implements OnTouchListener{
		
		private boolean flag = false;
		private TextView textView = null;
		
		public TextOnToughListener(TextView textView,boolean flag) {
			this.textView = textView;
			this.flag = flag;
		}
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			
			if(!flag){
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
