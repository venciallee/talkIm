package com.talk.view.service;

import com.talk.R;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.widget.ImageView;

/**
 * @author ven
 * @createTime 2013-2-12下午07:16:13
 * @lastEditTime 2013-2-12下午07:16:13
 * @copyright Design by vencial
 * @description 类描述
 */
public class ImageViewPaddingService {
	
	/**
	 * @explain 设置ImageView的边距.
	 * 
	 * @param imageView
	 * @param activity
	 */
	public void setImageViewPadding(ImageView imageView,Activity activity){
		
		DisplayMetrics dm = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		int bitWidth = BitmapFactory.decodeResource(activity.getResources(), R.drawable.selecticon).getWidth();
		
		int screenW = dm.widthPixels;
		int offset = (screenW / 3 - bitWidth) / 2;
		Matrix mx = new Matrix();
		mx.postTranslate(offset, 0);
		imageView.setImageMatrix(mx);
		imageView.setPadding(offset, 0, 0, 0);
	}
}
