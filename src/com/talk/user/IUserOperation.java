package com.talk.user;

import java.util.Map;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;

/**
 * @author ven
 * @createTime 2013-1-17ÏÂÎç09:20:06
 * @lastEditTime 2013-1-17ÏÂÎç09:20:06
 * @copyright Design by vencial
 * @description ÀàÃèÊö
 */

public interface IUserOperation {
	/**
	 * @explain ×¢²á.
	 * 
	 * @param xmppConnection
	 * @param userName
	 * @param password
	 * @return
	 */
	public IQ register(XMPPConnection xmppConnection,String userName, String password);
	/**
	 * @explian ×¢²á.
	 * 
	 * @param xmppConnection
	 * @param userName
	 * @param password
	 * @param attributes
	 * @return
	 */
	public IQ register(XMPPConnection xmppConnection,String userName, String password,Map<String,String> attributes);
	/**
	 * @explain µÇÂ½.
	 * 
	 * @param xmppConnection
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean login(XMPPConnection xmppConnection,String userName,String password);
	/**
	 * @explain ×¢Ïú.
	 * 
	 * @param xmppConnection
	 * @return
	 */
	public boolean logout(XMPPConnection xmppConnection);
	/**
	 * @explian ÐÞ¸ÄÃÜÂë.
	 * 
	 * @param xmppConnection
	 * @param password
	 * @return
	 */
	public boolean modifyPassword(XMPPConnection xmppConnection,String password);
}
