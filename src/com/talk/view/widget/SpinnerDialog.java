package com.talk.view.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

/**
 * @author ven
 * @createTime 2013-2-2����11:39:41
 * @lastEditTime 2013-2-2����11:39:41
 * @copyright Design by vencial
 * @description ������
 */
public class SpinnerDialog extends AlertDialog{

	public SpinnerDialog(Context context) {
		super(context);
	}
	
	public SpinnerDialog(Context context,int theme) {
		super(context,theme);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
}
