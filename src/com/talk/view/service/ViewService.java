package com.talk.view.service;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

/**
 * @author ven
 * @createTime 2013-1-27下午03:54:08
 * @lastEditTime 2013-1-27下午03:54:08
 * @copyright Design by vencial
 * @description 类描述
 */
public class ViewService {
	
	/**
	 * @explain 比较视图组件的id是否与指定id符合.
	 * 
	 * @param view
	 * @param id
	 * @return
	 */
	public boolean compareViewId(View view ,int id){
		return view.getId()==id;
	}
	
	/**
	 * @explain 通过Drawable来设置ImageView图片.
	 * 
	 * @param imageView
	 * @param src
	 */
	public void setImg(ImageView imageView,Drawable src){
		imageView.setImageDrawable(src);
	}
	
	/**
	 * @explain 通过Resourse来设置ImageView图片.
	 * 
	 * @param imageView
	 * @param src
	 */
	public void setImg(ImageView imageView,int src){
		imageView.setImageResource(src);
	}
	
	/**
	 * @explain 通过Resourse来设置ImageView的图片,通过数值设置背景颜色.
	 * 
	 * @param imageView
	 * @param src
	 */
	public void setImgColor(ImageView imageView,int src){
		imageView.setImageResource(src);
	}
	
	/**
	 * @explain 设置选中imageView的图片和背景，
	 * 没选中imageView设置图片为未选中,bgColor为00000000.
	 * 
	 * @param imageView
	 * @param src
	 * @param bg
	 * @param imageView1
	 * @param src1
	 * @param imageView2
	 * @param src2
	 */
	public void reverse(ImageView imageView,int src,ImageView imageView1,int src1,ImageView imageView2,int src2){
		this.setImg(imageView,src);
		this.setImgColor(imageView1, src1);
		this.setImgColor(imageView2, src2);
	}
	
	/**
	 * @explain 把替换原来选择中的imageView的图片
	 * 和现已选中的imageView的图片.
	 * 
	 * @param orgImgView
	 * @param src
	 * @param selectedImgView
	 * @param src1
	 */
	public void reverse(ImageView orgImgView,int src,ImageView selectedImgView ,int src1){
		this.setImg(orgImgView, src);
		this.setImg(selectedImgView, src1);
	}
}
