package com.talk.message;

import java.util.List;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.talk.view.adapter.MsgViewAdapter;

public class InflateLayoutUtil {

	/**
	 * @explain �����ض�ID��ȡָ����XML�ļ��ĸ������ļ�.
	 * 
	 * @param activity
	 * @param layoutID
	 * @return
	 */
	public RelativeLayout getSpecifiedXMLLayout(Activity activity,
			int layoutID, int profileImgViewID, int profileImgID,
			int chatContentViewID, String msg) {
		RelativeLayout rltLayout = (RelativeLayout) activity
				.getLayoutInflater().inflate(layoutID, null);
		
		ImageView profileImg = (ImageView) rltLayout
				.findViewById(profileImgViewID);

		profileImg.setBackgroundResource(profileImgID);

		TextView chatContentView = (TextView) rltLayout
				.findViewById(chatContentViewID);

		chatContentView.setText(msg);

		return rltLayout;
	}

	/**
	 * @explain ����ָ��layoutid��ȡָ�������Բ����ļ�.
	 * 
	 * @param activity
	 * @param layoutID
	 * @return
	 */
	public LinearLayout getSpecifiedLinearLayout(Activity activity, int layoutID) {
		// LayoutInflater inflater = LayoutInflater.from(activity);

		// LinearLayout ly = (LinearLayout)inflater.inflate(layoutID, null);
		LinearLayout ly = (LinearLayout) activity.findViewById(layoutID);
		return ly;
	}

	/**
	 * @explain ��̬����������ӵ�ָ����LinearLayout��.
	 * 
	 * @param relativeLayout
	 * @param linearLayout
	 * 
	 *            true is right,it mean u recieve a message.
	 * @param direction
	 * @param msg
	 */
	public void addTextFromSpecifiedLinear(LinearLayout linearLayout,
			RelativeLayout addedLayout) {
		if (null != linearLayout) {
			linearLayout.addView(addedLayout);
			// linearLayout.addView(relativeLayout,addedLayout,
			// linearLayout.getChildCount()+1);
		}
	}
	
	
	/**
	 * @explain ��message���ӵ�ListView.
	 * 
	 * @param msgLists
	 * @param msgAdapter
	 * @param msg
	 */
	public void addTextToListView(List<MsgEntity> msgLists,ListView msgListView,MsgViewAdapter msgAdapter,String msg,int msgFrom){
		
		if(null!=msgLists){
			msgLists.add(new MsgEntity(msg,msgFrom));
			msgAdapter.notifyDataSetChanged();
			
			msgListView.setSelection(msgListView.getCount() - 1);
		}
	}
}
