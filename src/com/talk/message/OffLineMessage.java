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
 * @createTime 2013-1-18下午02:20:42
 * @lastEditTime 2013-1-18下午02:20:42
 * @copyright Design by vencial
 * @description 类描述
 */
public class OffLineMessage {
	private static Logger log = LoggerFactory.getLogger(OffLineMessage.class);
	
	/**
	 * @explain 获取离线消息管理器.
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
	 * @explain 获取离线消息集合的迭代器.
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
