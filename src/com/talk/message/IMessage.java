package com.talk.message;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;

/**
 * @author ven
 * @createTime 2013-1-17����11:19:16
 * @lastEditTime 2013-1-17����11:19:16
 * @copyright Design by vencial
 * @description ������
 */
public interface IMessage {
	/**
	 * @explain ��ȡ���������.
	 * 
	 * @param xmppConneaction
	 * @return
	 */
	public ChatManager getChatManager(XMPPConnection xmppConneaction);
	/**
	 * @explain ��������.
	 * 
	 * @param userJID
	 * @param messageListener
	 * @param xmppConneaction
	 * @return
	 */
	public Chat chatConnection(String userJID,MessageListener messageListener,XMPPConnection xmppConneaction);
	/**
	 * @explain ���ͼ�ʱ��Ϣ.
	 * 
	 * @param chat
	 * @param message
	 * @return
	 */
	public boolean sendMessage(Chat chat,String message);
	/**
	 * @explain ���ܼ�ʱ��Ϣ.
	 * 
	 * @param chat
	 * @return
	 */
	public Message receiveMessage(Chat chat);
}
