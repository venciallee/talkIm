package com.talk.thread;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.packet.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.talk.handler.RcvMsgHandler;
import com.talk.message.IMessage;
import com.talk.message.MsgEntityType;

public class RcvMsgThread implements Runnable{
	
	private static final Logger log = LoggerFactory.getLogger(RcvMsgThread.class);
	private IMessage mMessage = null;
	private Chat mChat = null;
	private RcvMsgHandler mMsgHandler = null;
	private Message mMsg = null;
	
	
	public RcvMsgThread(IMessage message,Chat chat,RcvMsgHandler msgHandler) {
		this.mMessage = message;
		this.mChat = chat;
		this.mMsgHandler = msgHandler;
	}
	
	@Override
	public void run() {
		try{
			mMsg = this.mMessage.receiveMessage(mChat);
			android.os.Message msg = new android.os.Message();
			msg.what = MsgEntityType.UPDATE;
			msg.obj = mMsg.getBody();
			mMsgHandler.sendMessage(msg);
		}catch (Exception e) {
			log.error("RcvMsgThread error."+e.getMessage());
			e.printStackTrace();
		}
	}
}
