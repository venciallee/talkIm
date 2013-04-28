package com.talk.message;

import java.util.Collection;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.packet.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ven
 * @createTime 2013-1-18下午01:38:25
 * @lastEditTime 2013-1-18下午01:38:25
 * @copyright Design by vencial
 * @description 类描述
 */
public class TextMessage extends AbsMessage {
	private static Logger log = LoggerFactory.getLogger(TextMessage.class);

	private Message mMsg = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.talk.message.IMessage#receiveMessage()
	 */
	@Override
	public Message receiveMessage(Chat chat) {
		Collection<MessageListener> msg_ltn_list = chat.getListeners();
		if (msg_ltn_list.size() == 0) {
			chat.addMessageListener(new MessageListener() {
				@Override
				public void processMessage(Chat c, Message msg) {
					mMsg = msg;
				}
			});
		}
		return mMsg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.talk.message.IMessage#sendMessage(org.jivesoftware.smack.Chat,
	 * java.lang.String)
	 */
	@Override
	public boolean sendMessage(Chat chat, String message) {
		boolean flag = false;
		try {
			chat.sendMessage(message);
			flag = true;
		} catch (Exception e) {
			log.error("Sending message error." + e.getMessage());
		}
		return flag;
	}

	/**
	 * @explain 发送消息.
	 * 
	 * @param chat
	 * @param message
	 * @return
	 */
	public boolean sendMessage(Chat chat, Message message) {
		boolean flag = false;
		try {
			chat.sendMessage(message);
			flag = true;
		} catch (Exception e) {
			log.error("Sending message error." + e.getMessage());
		}
		return flag;
	}
}
