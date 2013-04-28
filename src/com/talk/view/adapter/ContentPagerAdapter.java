package com.talk.view.adapter;

import java.util.List;

import com.talk.R;

import android.app.Activity;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author ven
 * @createTime 2013-1-28œ¬ŒÁ11:39:22
 * @lastEditTime 2013-1-28œ¬ŒÁ11:39:22
 * @copyright Design by vencial
 * @description ¿‡√Ë ˆ
 */
public class ContentPagerAdapter extends PagerAdapter{
	private List<View> listView;
	
	public ContentPagerAdapter(List<View> listView) {
		this.listView = listView;
	}
	
	@Override
	public void destroyItem(View arg0, int arg1, Object arg2) {
		((ViewPager)arg0).removeView(listView.get(arg1));
	}

	@Override
	public void finishUpdate(View arg0) {
		
	}

	@Override
	public int getCount() {
		return listView.size();
	}

	@Override
	public Object instantiateItem(View arg0, int arg1) {
		((ViewPager)arg0).addView(listView.get(arg1),0);
		return listView.get(arg1);
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0==(arg1);
	}

	@Override
	public void restoreState(Parcelable arg0, ClassLoader arg1) {
		
	}

	@Override
	public Parcelable saveState() {
		return null;
	}

	@Override
	public void startUpdate(View arg0) {
		
	}
}
