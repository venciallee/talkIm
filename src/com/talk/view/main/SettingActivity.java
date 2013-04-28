package com.talk.view.main;

import com.talk.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SettingActivity extends Activity{
	
	
	private TextView mPhoto = null;
	private TextView mNickname =null;
	private TextView mPassword = null;
	private TextView mSex = null;
	private TextView mWhatsup = null;
	private TextView mCollege = null;
	private TextView mCity = null;
	
	private TextView [] mSetting_txtview = null;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		setContentView(R.layout.setting);
	}
}
