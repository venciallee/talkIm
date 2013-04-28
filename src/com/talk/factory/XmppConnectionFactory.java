package com.talk.factory;

import org.jivesoftware.smack.XMPPConnection;

import com.talk.connect.util.Constant;
import com.talk.connect.util.IConnection;

/**
 * @author ven
 * @createTime 2013-2-5����10:16:26
 * @lastEditTime 2013-2-5����10:16:26
 * @copyright Design by vencial
 * @description ������
 */
public class XmppConnectionFactory {
	
	private static XMPPConnection connection = null;
	
	private static IConnection connectionUtil = null;
	
	/**
	 * @explain ��ȡxmppConnection.
	 * 
	 * @param domain
	 * @param port
	 * @return
	 */
	public static XMPPConnection getXmppConnection(){
		if(null==connection){
			connectionUtil = new com.talk.connect.util.Connection();
			connection = connectionUtil.getXMPPConnection(connectionUtil.connectionConfig(Constant.DOMAIN, Constant.PORT));
		}
		return connection;
	}
}
