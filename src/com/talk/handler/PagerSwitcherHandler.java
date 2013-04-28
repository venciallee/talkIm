package com.talk.handler;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.talk.R;
import com.talk.enumeration.ePagerSelected;
import com.talk.enumeration.eUserField;
import com.talk.message.db.MsgSharedPrefenrence;
import com.talk.user.Constant;
import com.talk.view.main.ChattingActivity;

public class PagerSwitcherHandler extends Handler {
	private MsgSharedPrefenrence mMsgSharedPrefs = null;
	private Activity mActivity = null;
	// 聊天resourse.
	private static final int LASTMSGVIEW = R.id.last_text_view;

	private static final int LASTTIMEVIEW = R.id.time_text_view;

	private ArrayList<View> mViewGroupLists = null;
	

	public PagerSwitcherHandler(Activity activity) {
		mMsgSharedPrefs = new MsgSharedPrefenrence(activity);
		this.mActivity = activity;
	}

	@Override
	public void handleMessage(Message msg) {

		/**
		 * 初始化。
		 */
		ePagerSelected pagerSelected = (ePagerSelected) msg.obj;

		Bundle bundle = msg.getData();

		int selectedPage = bundle.getInt(Constant.PAGESELECTKEY);

		boolean hasMsg = true;

		int desLayout = 0;

		int parentLayout = 0;

		View view = null;

		ViewGroup viewGroup = null;

		LayoutInflater inflate = null;

		String userName = null;

		int contentLayoutID = 0;

		int resImg = bundle.getInt(eUserField.PHOTO.getValue());

		HashMap<String, String> msgInfo = null;

		String nickName = bundle.getString(eUserField.NICKNAME.getValue());

		viewGroup = (ViewGroup) mViewGroupLists.get(selectedPage);

		/**
		 * 
		 */
		switch (pagerSelected) {
		case CHAT:

			desLayout = ePagerSelected.CHAT.desScrollViewID();
			parentLayout = ePagerSelected.CHAT.desParentLayouID();

			contentLayoutID = bundle.getInt(Constant.CONTENTVIEWKEY);

			userName = bundle.getString(Constant.USERNAME);

			inflate = LayoutInflater.from(mActivity);
			view = inflate.inflate(contentLayoutID, null);

			msgInfo = (HashMap<String, String>) bundle
					.getSerializable(Constant.MSGINFO);

			//System.out.println(msgInfo.get(MsgSharedPrefenrence.LASTMSGKEY + userName));
			
			if (null != msgInfo) {
				setChatLayout(
						view,
						resImg,
						eUserField.PHOTO.getKey(),
						eUserField.NICKNAME.getKey(),
						nickName,
						LASTMSGVIEW,
						msgInfo.get(MsgSharedPrefenrence.LASTMSGKEY + userName),
						LASTTIMEVIEW, msgInfo
								.get(MsgSharedPrefenrence.LASTTIMEKEY
										+ userName));
			} else {
				hasMsg = false;
			}

			break;
		case CONTACT:
			
			contentLayoutID = bundle.getInt(Constant.CONTENTVIEWKEY,
					ePagerSelected.CONTACT.contentLayoutID());

			String whatUp = bundle.getString(eUserField.WHATUP.getValue());

			inflate = LayoutInflater.from(mActivity);
			view = inflate.inflate(contentLayoutID, null);

			setContactLayout(view, resImg, eUserField.PHOTO.getKey(),
					eUserField.NICKNAME.getKey(), nickName,
					eUserField.WHATUP.getKey(), whatUp);

			desLayout = ePagerSelected.CONTACT.desScrollViewID();
			parentLayout = ePagerSelected.CONTACT.desParentLayouID();
			
			userName = bundle.getString(Constant.USERNAME);

			view.setTag(userName);

			bindListener(view);

			break;
		case SEARCH:

			break;

		default:
			break;
		}

		if (hasMsg) {
			ScrollView scv = (ScrollView) viewGroup.findViewById(desLayout);

			LinearLayout linearLayout = (LinearLayout) scv
					.findViewById(parentLayout);
			if (null != linearLayout) {
				linearLayout.addView(view, linearLayout.getChildCount());
			}
		}
	}

	/**
	 * @explain 设置聊天内容视图,profile通过Bitmap来设置。
	 * 
	 * @param view
	 * @param bitmap
	 * @param profilePhotoId
	 * @param userNameViewID
	 * @param userName
	 * @param lastMsgViewID
	 * @param msg
	 * @param timeViewID
	 * @param time
	 */
	private void setChatLayout(View view, Bitmap bitmap, int profilePhotoId,
			int userNameViewID, String userName, int lastMsgViewID, String msg,
			int timeViewID, String time) {
		/*
		 * ImageView imgView = (ImageView)view.findViewById(userNameViewID);
		 * imgView.setBackgroundResource(R.drawable.default_profile_photo);
		 */
		ImageView imgView = (ImageView) view.findViewById(profilePhotoId);
		imgView.setImageBitmap(bitmap);
		setChatLayout(view, userNameViewID, userName, lastMsgViewID, msg,
				timeViewID, time);

	}

	/**
	 * @explain 设置聊天内容视图,profile通过ResourceID来设置.
	 * 
	 * @param view
	 * @param resImg
	 * @param profilePhotoId
	 * @param userNameViewID
	 * @param userName
	 * @param lastMsgViewID
	 * @param msg
	 * @param timeViewID
	 * @param time
	 */
	private void setChatLayout(View view, int resImg, int profilePhotoId,
			int userNameViewID, String userName, int lastMsgViewID, String msg,
			int timeViewID, String time) {
		
		ImageView imgView = (ImageView) view.findViewById(profilePhotoId);
		imgView.setImageResource(resImg);
		setChatLayout(view, userNameViewID, userName, lastMsgViewID, msg,
				timeViewID, time);
	}

	/**
	 * @explain 设置聊天内容视图,profile通过Drawable来设置.
	 * 
	 * @param view
	 * @param drawable
	 * @param profilePhotoId
	 * @param userNameViewID
	 * @param userName
	 * @param lastMsgViewID
	 * @param msg
	 * @param timeViewID
	 * @param time
	 */
	private void setChatLayout(View view, Drawable drawable,
			int profilePhotoId, int userNameViewID, String userName,
			int lastMsgViewID, String msg, int timeViewID, String time) {
		/*
		 * ImageView imgView = (ImageView)view.findViewById(userNameViewID);
		 * imgView.setBackgroundResource(R.drawable.default_profile_photo);
		 */
		ImageView imgView = (ImageView) view.findViewById(profilePhotoId);
		imgView.setImageDrawable(drawable);
		setChatLayout(view, userNameViewID, userName, lastMsgViewID, msg,
				timeViewID, time);
	}

	/**
	 * @explain 设置聊天内容视图.
	 * 
	 * @param view
	 * @param userNameViewID
	 * @param userName
	 * @param lastMsgViewID
	 * @param msg
	 * @param timeViewID
	 * @param time
	 */
	private void setChatLayout(View view, int userNameViewID, String userName,
			int lastMsgViewID, String msg, int timeViewID, String time) {
		TextView userNameView = (TextView) view.findViewById(userNameViewID);
		userNameView.setText(userName);
		TextView msgView = (TextView) view.findViewById(lastMsgViewID);
		msgView.setText(msg);
		TextView timeView = (TextView) view.findViewById(timeViewID);
		timeView.setText(time);
	}

	/**
	 * @explain 设置联系人视图,profile通过Bitmap来设置.
	 * 
	 * @param view
	 * @param bitmap
	 * @param profilePhotoId
	 * @param userNameViewID
	 * @param userName
	 * @param whatUpViewID
	 * @param whatUp
	 */
	private void setContactLayout(View view, Bitmap bitmap, int profilePhotoId,
			int userNameViewID, String userName, int whatUpViewID, String whatUp) {
		ImageView imgView = (ImageView) view.findViewById(profilePhotoId);
		imgView.setImageBitmap(bitmap);
		setContactLayout(view, userNameViewID, userName, whatUpViewID, whatUp);
	}

	/**
	 * @explain 设置联系人视图,profile通过ResouceID来设置.
	 * 
	 * @param view
	 * @param resImg
	 * @param profilePhotoId
	 * @param userNameViewID
	 * @param userName
	 * @param whatUpViewID
	 * @param whatUp
	 */
	private void setContactLayout(View view, int resImg, int profilePhotoId,
			int userNameViewID, String userName, int whatUpViewID, String whatUp) {
		ImageView imgView = (ImageView) view.findViewById(profilePhotoId);
		imgView.setImageResource(resImg);
		setContactLayout(view, userNameViewID, userName, whatUpViewID, whatUp);
	}

	/**
	 * @explain 设置联系人视图,profile通过Drawable来设置.
	 * 
	 * @param view
	 * @param userNameViewID
	 * @param userName
	 * @param whatUpViewID
	 * @param whatUp
	 */
	private void setContactLayout(View view, Drawable drawable,
			int profilePhotoId, int userNameViewID, String userName,
			int whatUpViewID, String whatUp) {
		ImageView imgView = (ImageView) view.findViewById(profilePhotoId);
		imgView.setImageDrawable(drawable);
		setContactLayout(view, userNameViewID, userName, whatUpViewID, whatUp);
	}

	/**
	 * @explain 设置联系人视图.
	 * 
	 * @param view
	 * @param userNameViewID
	 * @param userName
	 * @param whatUpViewID
	 * @param whatUp
	 */
	private void setContactLayout(View view, int userNameViewID,
			String userName, int whatUpViewID, String whatUp) {
		TextView userNameView = (TextView) view.findViewById(userNameViewID);
		userNameView.setText(userName);
		TextView timeView = (TextView) view.findViewById(whatUpViewID);
		timeView.setText(whatUp);

	}

	private void bindListener(View view) {
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent intent = new Intent();
				intent.putExtra(eUserField.USERNAME.getValue(), view.getTag().toString());
				intent.setClass(mActivity, ChattingActivity.class);
				mActivity.startActivity(intent);
			}
		});
	}

	public ArrayList<View> getmViewGroupLists() {
		return mViewGroupLists;
	}

	public void setmViewGroupLists(ArrayList<View> mViewGroupLists) {
		this.mViewGroupLists = mViewGroupLists;
	}

}
