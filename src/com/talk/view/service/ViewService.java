package com.talk.view.service;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

/**
 * @author ven
 * @createTime 2013-1-27����03:54:08
 * @lastEditTime 2013-1-27����03:54:08
 * @copyright Design by vencial
 * @description ������
 */
public class ViewService {
	
	/**
	 * @explain �Ƚ���ͼ�����id�Ƿ���ָ��id����.
	 * 
	 * @param view
	 * @param id
	 * @return
	 */
	public boolean compareViewId(View view ,int id){
		return view.getId()==id;
	}
	
	/**
	 * @explain ͨ��Drawable������ImageViewͼƬ.
	 * 
	 * @param imageView
	 * @param src
	 */
	public void setImg(ImageView imageView,Drawable src){
		imageView.setImageDrawable(src);
	}
	
	/**
	 * @explain ͨ��Resourse������ImageViewͼƬ.
	 * 
	 * @param imageView
	 * @param src
	 */
	public void setImg(ImageView imageView,int src){
		imageView.setImageResource(src);
	}
	
	/**
	 * @explain ͨ��Resourse������ImageView��ͼƬ,ͨ����ֵ���ñ�����ɫ.
	 * 
	 * @param imageView
	 * @param src
	 */
	public void setImgColor(ImageView imageView,int src){
		imageView.setImageResource(src);
	}
	
	/**
	 * @explain ����ѡ��imageView��ͼƬ�ͱ�����
	 * ûѡ��imageView����ͼƬΪδѡ��,bgColorΪ00000000.
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
	 * @explain ���滻ԭ��ѡ���е�imageView��ͼƬ
	 * ������ѡ�е�imageView��ͼƬ.
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
