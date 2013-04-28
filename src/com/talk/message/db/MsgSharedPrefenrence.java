package com.talk.message.db;

import java.util.HashMap;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

public class MsgSharedPrefenrence {

	private static final String MSG_PREFS = "LastMsgPref";

	private SharedPreferences lastMsgPrefs = null;

	public static final String LASTMSGKEY = "LASTMSG";

	public static final String LASTTIMEKEY = "LASTTIME";

	private static OnSharedPreferenceChangeListener onSharePrefListener = null;

	private static boolean isUpdate = false;

	private static HashMap<String, String> hashMap = null;

	public MsgSharedPrefenrence(Context context) {
		init(context);
	}

	public void init(Context context) {
		if (null == lastMsgPrefs) {
			lastMsgPrefs = context.getSharedPreferences(MSG_PREFS, 0);
		}

		if (null == hashMap) {
			hashMap = new HashMap<String, String>();
		}

		onSharePrefListener = new OnSharedPreferenceChangeListener() {

			@Override
			public void onSharedPreferenceChanged(
					SharedPreferences sharedPreferences, String key) {
				isUpdate = true;
			}
		};
	}

	public HashMap<String, String> getLastMsgInfo(String username) {
		if (null != lastMsgPrefs || isUpdate) {
			String msg = getMsg(username);
			String time = getTime(username);
			if(null != msg && null!=time){
				hashMap.put(LASTMSGKEY + username, msg);
				hashMap.put(LASTTIMEKEY + username, time);
				isUpdate = false;
				return hashMap;
			}
		}
		return null;
	}

	public void setLastMsgInfo(String username, String msg, String time) {
		if (null != lastMsgPrefs) {
			SharedPreferences.Editor editor = lastMsgPrefs.edit();
			editor.putString(LASTMSGKEY + username, msg);
			editor.putString(LASTTIMEKEY + username, time);

			editor.commit();
			System.out.println("ok.......");
		}
	}

	private String getMsg(String username) {
		return lastMsgPrefs.getString(LASTMSGKEY+username, null);
	}

	private String getTime(String username) {
		return lastMsgPrefs.getString(LASTTIMEKEY+username, null);
	}
}
