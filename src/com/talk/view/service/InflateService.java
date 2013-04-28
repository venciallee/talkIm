package com.talk.view.service;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InflateService {
	
	private LayoutInflater mLayoutInflater;
	
	private View mView = null;
	
	public InflateService() {
		
	}
	
	public InflateService(LayoutInflater layoutInflater) {
		this.mLayoutInflater = layoutInflater;
	}
	
	
	public View getLayoutFromId(int layoutId){
		View view = mLayoutInflater.inflate(layoutId, null);
		return view;
	}
	
	public boolean addToLayout(int originLayoutId,ViewGroup viewGroup){
		boolean flag = false;
		try{
			mView = getLayoutFromId(originLayoutId);
			viewGroup.addView(mView);
			flag = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	public View getmView() {
		return mView;
	}

	public void setmView(View mView) {
		this.mView = mView;
	}
}
