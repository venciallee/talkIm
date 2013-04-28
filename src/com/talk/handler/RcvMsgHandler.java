package com.talk.handler;

import java.util.List;

import com.talk.message.InflateLayoutUtil;
import com.talk.message.MsgEntity;
import com.talk.message.MsgEntityType;
import com.talk.view.adapter.MsgViewAdapter;

import android.os.Handler;
import android.os.Message;

public class RcvMsgHandler extends Handler {

	private InflateLayoutUtil mProMsgService = null;
	private List<MsgEntity> mMsgLists = null;
	private MsgViewAdapter mMsgAdapter = null;

	public RcvMsgHandler(InflateLayoutUtil proMsgService) {
		mProMsgService = proMsgService;
	}

	/**
	 * @explain 从消息队列中取出消息，并处理消息.
	 */
	@Override
	public void handleMessage(Message msg) {
		super.handleMessage(msg);
		// LayoutInflater layoutInflater =
		// mActivity.findViewById(R.id.chatingContent);
		if (msg.what == MsgEntityType.UPDATE) {
			/*mProMsgService.addEditText(mProMsgService.getSpecifiedXMLLayout(
					mActivity, Constant.CHATXMLID), mProMsgService
					.getSpecifiedLinearLayout(mActivity,
							Constant.CHATCONTENTLAYOUTID));*/
			//mProMsgService.addTextToListView(mMsgLists, mMsgAdapter, msg.obj.toString());
		}
	}
}
