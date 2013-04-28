package com.talk.message;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;

/**
 * @author ven
 * @createTime 2013-1-17下午11:19:16
 * @lastEditTime 2013-1-17下午11:19:16
 * @copyright Design by vencial
 * @description 类描述
 */
public interface IMessage {
	/**
	 * @explain 获取聊天管理器.
	 * 
	 * @param xmppConneaction
	 * @return
	 */
	public ChatManager getChatManager(XMPPConnection xmppConneaction);
	/**
	 * @explain 聊天连接.
	 * 
	 * @param userJID
	 * @param messageListener
	 * @param xmppConneaction
	 * @return
	 */
	public Chat chatConnection(String userJID,MessageListener messageListener,XMPPConnection xmppConneaction);
	/**
	 * @explain 发送即时信息.
	 * 
	 * @param chat
	 * @param message
	 * @return
	 */
	public boolean sendMessage(Chat chat,String message);
	/**
	 * @explain 接受即时消息.
	 * 
	 * @param chat
	 * @return
	 */
	public Message receiveMessage(Chat chat);
}
