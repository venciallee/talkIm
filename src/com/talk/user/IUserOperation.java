package com.talk.user;

import java.util.Map;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;

/**
 * @author ven
 * @createTime 2013-1-17����09:20:06
 * @lastEditTime 2013-1-17����09:20:06
 * @copyright Design by vencial
 * @description ������
 */

public interface IUserOperation {
	/**
	 * @explain ע��.
	 * 
	 * @param xmppConnection
	 * @param userName
	 * @param password
	 * @return
	 */
	public IQ register(XMPPConnection xmppConnection,String userName, String password);
	/**
	 * @explian ע��.
	 * 
	 * @param xmppConnection
	 * @param userName
	 * @param password
	 * @param attributes
	 * @return
	 */
	public IQ register(XMPPConnection xmppConnection,String userName, String password,Map<String,String> attributes);
	/**
	 * @explain ��½.
	 * 
	 * @param xmppConnection
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean login(XMPPConnection xmppConnection,String userName,String password);
	/**
	 * @explain ע��.
	 * 
	 * @param xmppConnection
	 * @return
	 */
	public boolean logout(XMPPConnection xmppConnection);
	/**
	 * @explian �޸�����.
	 * 
	 * @param xmppConnection
	 * @param password
	 * @return
	 */
	public boolean modifyPassword(XMPPConnection xmppConnection,String password);
}
