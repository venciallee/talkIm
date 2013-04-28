package com.talk.connect.util;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;

/**
 * @author ven
 * @createTime 2013-1-17����09:20:25
 * @lastEditTime 2013-1-17����09:20:25
 * @copyright Design by vencial
 * @description ������
 */
public interface IConnection {
	/**
	 * @explain ��openfire����������,��ȡXMPPConnection.
	 * 
	 * @param connConfig
	 * @return
	 */
	public XMPPConnection getXMPPConnection(ConnectionConfiguration connConfig);
	/**
	 * @explain �Ͽ�����.
	 * 
	 * @param xmppConn
	 * @return
	 */
	public boolean disconnect(XMPPConnection xmppConn);
	/**
	 * @explain XMPPConnection����ǰ����.
	 * 
	 * @param domain
	 * @param port
	 * @return
	 */
	public ConnectionConfiguration connectionConfig(String domain,int port);
}
