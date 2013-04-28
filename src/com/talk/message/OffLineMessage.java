package com.talk.message;

import java.util.Iterator;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.OfflineMessageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ven
 * @createTime 2013-1-18����02:20:42
 * @lastEditTime 2013-1-18����02:20:42
 * @copyright Design by vencial
 * @description ������
 */
public class OffLineMessage {
	private static Logger log = LoggerFactory.getLogger(OffLineMessage.class);
	
	/**
	 * @explain ��ȡ������Ϣ������.
	 * 
	 * @param xmppConn
	 * @return
	 */
	public OfflineMessageManager getOffLineMsgManager(XMPPConnection xmppConn){
		OfflineMessageManager offLineMsgManager = null;
		offLineMsgManager = new OfflineMessageManager(xmppConn);
		return offLineMsgManager;
	}
	
	/**
	 * @explain ��ȡ������Ϣ���ϵĵ�����.
	 * 
	 * @param offLineManager
	 * @return
	 */
	public Iterator<Message> getMsgIterator(OfflineMessageManager offLineManager){
		Iterator<Message> msgIt = null;
		try {
			msgIt = offLineManager.getMessages();
		} catch (XMPPException e) {
			log.error("Getting offLine message error."+e.getMessage());
		}
		return msgIt;
	}
	
	
}
