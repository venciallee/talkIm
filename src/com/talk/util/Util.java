package com.talk.util;

import com.talk.R;

public class Util {

	/**
	 * @explain String to Integer.
	 * 
	 * @param s
	 * @return
	 */
	public static Integer toInt(String s) {
		return (s == null || s == "") ? R.drawable.default_profile_photo
				: Integer.valueOf(s);
	}
}
