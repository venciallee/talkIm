package com.talk.view.service;

import java.util.Map;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;

import com.talk.factory.UserOperationFacroty;
import com.talk.factory.XmppConnectionFactory;
import com.talk.user.IUserOperation;

/**
 * @author ven
 * @createTime 2013-2-5ÏÂÎç10:05:51
 * @lastEditTime 2013-2-5ÏÂÎç10:05:51
 * @copyright Design by vencial
 * @description ÀàÃèÊö
 */
public class UserServices {
	
	private static IUserOperation userOperation = null;
	
	private XMPPConnection xmppConnection = null;
	
	public UserServices() {
		userOperation = UserOperationFacroty.getUserOperation();
		xmppConnection = XmppConnectionFactory.getXmppConnection();
	}
	
	/**
	 * @explian ×¢²á.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public IQ register(String userName, String password){
		return userOperation.register(xmppConnection, userName, password);
	}
	
	/**
	 * @explian ×¢²á.
	 * 
	 * @param userName
	 * @param password
	 * @param attributes
	 * @return
	 */
	public IQ register(String userName, String password,Map<String,String> attributes){
		return userOperation.register(xmppConnection, userName, password, attributes);
	}
	
	/**
	 * @explain µÇÂ½.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean login(String userName,String password){
		return userOperation.login(xmppConnection, userName, password);
	}
	
	/**
	 * @explain ×¢Ïú.
	 * 
	 * @return
	 */
	public boolean logout(){
		return userOperation.logout(xmppConnection);
	}

	public XMPPConnection getXmppConnection() {
		return xmppConnection;
	}

	public void setXmppConnection(XMPPConnection xmppConnection) {
		this.xmppConnection = xmppConnection;
	}
}
