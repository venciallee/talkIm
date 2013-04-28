package com.talk.view.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.talk.R;
import com.talk.message.MsgEntity;
import com.talk.message.MsgEntityType;

public class MsgViewAdapter extends BaseAdapter {

	private List<MsgEntity> mMsgLists = null;

	private LayoutInflater mLayoutInflater = null;

	private Context mContext = null;

	private Bitmap mBitmap = null;

	private static final String TAG = MsgViewAdapter.class.getSimpleName();

	public MsgViewAdapter(Context context, List<MsgEntity> msgLists) {
		this.mMsgLists = msgLists;
		this.mContext = context;
		this.mLayoutInflater = LayoutInflater.from(mContext);
	}

	public MsgViewAdapter() {

	}

	@Override
	public int getCount() {
		return mMsgLists.size();
	}

	@Override
	public Object getItem(int location) {
		return mMsgLists.get(location).getMsgType();
	}

	@Override
	public int getItemViewType(int position) {
		MsgEntity entity = mMsgLists.get(position);

		if (entity.getMsgType() == 0) {
			return MsgEntityType.MSG_FROM;
		} else {
			return MsgEntityType.MSG_TO;
		}
	}

	@Override
	public long getItemId(int location) {
		return location;
	}
	
	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public View getView(int location, View convertView, ViewGroup parentView) {

		MsgEntity msg = mMsgLists.get(location);
		ViewHolder viewHolder = null;
		if (convertView == null) {
			if (msg.getMsgType() == MsgEntityType.MSG_FROM) {
				convertView = (View) mLayoutInflater.inflate(
						R.layout.chat_text_view_right, null);
			} else if (msg.getMsgType() == MsgEntityType.MSG_TO) {
				convertView = (View) mLayoutInflater.inflate(
						R.layout.chat_text_view_left, null);
			}
			viewHolder = new ViewHolder();

			viewHolder.mMsgTextView = (TextView) convertView
					.findViewById(R.id.chat_text_view);

			viewHolder.mProfileImgView = (ImageView) convertView
					.findViewById(R.id.profilePhote_imgView);

			convertView.setTag(viewHolder);
		} else {
			
			viewHolder = (ViewHolder) convertView.getTag();
		}

		if (null != mBitmap) {
			viewHolder.mProfileImgView.setImageBitmap(mBitmap);
		}

		viewHolder.mMsgTextView.setText(msg.getMsg());
		return convertView;
	}

	public Bitmap getmBitmap() {
		return mBitmap;
	}

	public void setmBitmap(Bitmap mBitmap) {
		this.mBitmap = mBitmap;
	}

	private final class ViewHolder {
		protected TextView mMsgTextView = null;
		protected ImageView mProfileImgView = null;

	}

}
