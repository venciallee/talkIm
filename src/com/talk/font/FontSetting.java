package com.talk.font;

import android.content.Context;
import android.graphics.Typeface;

/**
 * @author ven
 * @createTime 2013-1-19����02:11:38
 * @lastEditTime 2013-1-19����02:11:38
 * @copyright Design by vencial
 * @description ������
 */
public class FontSetting {
	public Typeface setTypeface(Context context,String fontStyle){
		return Typeface.createFromAsset(context.getAssets(), fontStyle);
	}
}
