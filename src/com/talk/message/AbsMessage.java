package com.talk.message;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ven
 * @createTime 2013-1-18œ¬ŒÁ01:17:47
 * @lastEditTime 2013-1-18œ¬ŒÁ01:17:47
 * @copyright Design by vencial
 * @description ¿‡√Ë ˆ
 */
public abstract class AbsMessage implements IMessage {
	private static ChatManager chatManager = null;
	private Chat chat = null;
	private static Logger log = LoggerFactory.getLogger(AbsMessage.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.talk.message.IMessage#chatConnection(java.lang.String,
	 * org.jivesoftware.smack.MessageListener,
	 * org.jivesoftware.smack.XMPPConnection)
	 */
	@Override
	public Chat chatConnection(String userJID, MessageListener messageListener,
			XMPPConnection xmppConneaction) {
		try {
			chat = this.getChatManager(xmppConneaction).createChat(
					userJID + "@vencial", messageListener);
		} catch (Exception e) {
			log.error("Getting Chat error." + e.getMessage());
		}
		return this.chat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.talk.message.IMessage#getChatManager(org.jivesoftware.smack.
	 * XMPPConnection)
	 */
	@Override
	public ChatManager getChatManager(XMPPConnection xmppConneaction) {
		try {
			chatManager = xmppConneaction.getChatManager();
		} catch (Exception e) {
			log.error("Getting ChatManager error." + e.getMessage());
		}
		return chatManager;
	}
}
