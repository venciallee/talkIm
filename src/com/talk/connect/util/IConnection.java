package com.talk.connect.util;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;

/**
 * @author ven
 * @createTime 2013-1-17下午09:20:25
 * @lastEditTime 2013-1-17下午09:20:25
 * @copyright Design by vencial
 * @description 类描述
 */
public interface IConnection {
	/**
	 * @explain 与openfire服务器连接,获取XMPPConnection.
	 * 
	 * @param connConfig
	 * @return
	 */
	public XMPPConnection getXMPPConnection(ConnectionConfiguration connConfig);
	/**
	 * @explain 断开连接.
	 * 
	 * @param xmppConn
	 * @return
	 */
	public boolean disconnect(XMPPConnection xmppConn);
	/**
	 * @explain XMPPConnection连接前配置.
	 * 
	 * @param domain
	 * @param port
	 * @return
	 */
	public ConnectionConfiguration connectionConfig(String domain,int port);
}
