package com.talk.view.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.packet.Message;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.talk.R;
import com.talk.enumeration.eUserField;
import com.talk.factory.XmppConnectionFactory;
import com.talk.message.IMessage;
import com.talk.message.InflateLayoutUtil;
import com.talk.message.MsgEntity;
import com.talk.message.MsgEntityType;
import com.talk.message.TextMessage;
import com.talk.message.db.MsgSharedPrefenrence;
import com.talk.view.adapter.MsgViewAdapter;

/**
 * @author ven
 * @createTime 2013-2-14下午09:29:26
 * @lastEditTime 2013-2-14下午09:29:26
 * @copyright Design by vencial
 * @description 类描述
 */
public class ChattingActivity extends Activity {

	private EditText mChat_content_text = null;
	private ImageButton mSend_msg_btn = null;
	private String mMsg = null;

	private ListView mMsgListView = null;

	private MsgViewAdapter mMsgAdapter = null;

	private List<MsgEntity> mMsgLists = null;

	private InflateLayoutUtil mProMsgService = null;

	private IMessage mIMsgOparation = null;

	private String mUserJID = null;

	private Chat mChat = null;

	private String mUID = null;

	private MsgSharedPrefenrence mMsgPrefs = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chatting);
		Intent intent = this.getIntent();
		mUID = intent.getStringExtra(eUserField.USERNAME.getValue());
		init();
		bindListener();
	}

	@Override
	protected void onResume() {

		super.onResume();
	}

	/**
	 * @explain 初始化组件.
	 */
	public void init() {
		mChat_content_text = (EditText) findViewById(R.id.chat_edit_text);
		mSend_msg_btn = (ImageButton) findViewById(R.id.send_button);
		mMsgListView = (ListView) findViewById(R.id.chatingContent);
		mMsgLists = new ArrayList<MsgEntity>();
		mMsgAdapter = new MsgViewAdapter(this, mMsgLists);
		mMsgListView.setAdapter(mMsgAdapter);
		mProMsgService = new InflateLayoutUtil();
		// rcvMsgHandler = new RcvMsgHandler(mProMsgService);
		mMsgPrefs = new MsgSharedPrefenrence(this);

		mIMsgOparation = new TextMessage();

		mChat = mIMsgOparation.chatConnection(mUID, new MessageListener() {

			@Override
			public void processMessage(Chat chat, Message msg) {

				mProMsgService.addTextToListView(mMsgLists, mMsgListView,
						mMsgAdapter, msg.getBody(), MsgEntityType.MSG_FROM);
				{
					Date date = new Date();
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append(date.getDate());
					stringBuilder.append(".");
					stringBuilder.append(date.getMonth());
					mMsgPrefs.setLastMsgInfo(mUID, msg.getBody(),
							stringBuilder.toString());
				}
			}
		}, XmppConnectionFactory.getXmppConnection());

	}

	public void bindListener() {
		mSend_msg_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				try {
					if (null != (mMsg = mChat_content_text.getText().toString())) {
						mProMsgService.addTextToListView(mMsgLists,
								mMsgListView, mMsgAdapter, mMsg,
								MsgEntityType.MSG_TO);
						mIMsgOparation.sendMessage(mChat, mMsg);
						{
							Date date = new Date();
							StringBuilder stringBuilder = new StringBuilder();
							stringBuilder.append(date.getDate());
							stringBuilder.append(".");
							stringBuilder.append(date.getMonth());
							mMsgPrefs.setLastMsgInfo(mUID, mMsg,
									stringBuilder.toString());
						}
					}
				} finally {
					mChat_content_text.setText(null);
				}
			}
		});
	}

	public String getmUserJID() {
		return mUserJID;
	}

	public void setmUserJID(String mUserJID) {
		this.mUserJID = mUserJID;
	}
}
