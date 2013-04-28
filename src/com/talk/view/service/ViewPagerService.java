package com.talk.view.service;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.talk.R;
import com.talk.view.adapter.ContentPagerAdapter;
import com.talk.view.listener.ContentPagerListener;

/**
 * @author ven
 * @createTime 2013-1-28下午11:39:45
 * @lastEditTime 2013-1-28下午11:39:45
 * @copyright Design by vencial
 * @description 类描述
 */
public class ViewPagerService {

	private int bitWidth;
	private int offset;
	private Handler mHandler = null;
	
	public ViewPagerService(Handler handler) {
		this.mHandler = handler;
	}

	/**
	 * @explain 初始化viewPager.
	 * 
	 * @param activity
	 * @param currIndex
	 * @param selected_bg_view
	 * @param imageBtns
	 * @param unselected_img_draws
	 * @param selected_img_draws
	 * @param viewService
	 * @return
	 */
	public ViewPager initViewPager(Activity activity, int currIndex,
			ImageView selected_bg_view, ImageButton[] imageBtns,
			int unselected_img_draws[], int selected_img_draws[],
			ViewService viewService) {
		ViewPager contentPager = (ViewPager) activity
				.findViewById(R.id.contentPager);
		List<View> listView = new ArrayList<View>();
		LayoutInflater inflater = activity.getLayoutInflater();
		
		listView.add(inflater.inflate(R.layout.chat_content_layout, null));
		listView.add(inflater.inflate(R.layout.friend_content_layout, null));
		listView.add(inflater.inflate(R.layout.search_content_layout, null));
		
		ContentPagerAdapter contentPagerAdapter = new ContentPagerAdapter(
				listView);
		contentPager.setAdapter(contentPagerAdapter);
		contentPager.setCurrentItem(0);
		contentPager.setOnPageChangeListener(new ContentPagerListener(offset,
				bitWidth, currIndex, selected_bg_view, imageBtns,
				unselected_img_draws, selected_img_draws, viewService,
				activity,(ArrayList<View>)listView,mHandler));
		return contentPager;
	}

	/**
	 * @explain 初始化视图的矩阵.
	 * 
	 * @param activity
	 * @return
	 */
	public ImageView initImageView(Activity activity) {
		ImageView selected_bg_view = (ImageView) activity
				.findViewById(R.id.selected_bg_view);

		DisplayMetrics dm = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		bitWidth = getBitMapWidth(activity, R.drawable.selecticon);
		int screenW = dm.widthPixels;
		offset = (screenW / 3 - bitWidth) / 2;
		Matrix mx = new Matrix();
		mx.postTranslate(offset, 0);
		selected_bg_view.setImageMatrix(mx);
		selected_bg_view.setPadding(offset, 0, 0, 0);

		return selected_bg_view;
	}

	/**
	 * @explain 获取指定位图的宽.
	 * 
	 * @param activity
	 * @param drawable
	 * @return
	 */
	public int getBitMapWidth(Activity activity, int drawable) {
		Bitmap bitMap = BitmapFactory.decodeResource(activity.getResources(),
				drawable);
		return bitMap.getWidth();
	}

	public int getBitWidth() {
		return bitWidth;
	}

	public void setBitWidth(int bitWidth) {
		this.bitWidth = bitWidth;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
}
