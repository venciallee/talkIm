package com.talk.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Spinner;

/**
 * @author ven
 * @createTime 2013-2-4ÏÂÎç06:07:43
 * @lastEditTime 2013-2-4ÏÂÎç06:07:43
 * @copyright Design by vencial
 * @description ÀàÃèÊö
 */
public class SpinnerWidget extends Spinner{

	public SpinnerWidget(Context context) {
		super(context);
	}
	
	public SpinnerWidget(Context context,AttributeSet attrs) {
		super(context,attrs);
	}
	
	@Override
	public boolean performClick() {
		Context context = getContext();
		final LayoutInflater layoutInflater = LayoutInflater.from(context);
		return super.performClick();
	}

}
