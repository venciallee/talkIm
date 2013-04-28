package com.talk.user;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.XMPPConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ven
 * @createTime 2013-1-18ÏÂÎç08:54:09
 * @lastEditTime 2013-1-18ÏÂÎç08:54:09
 * @copyright Design by vencial
 * @description ÀàÃèÊö
 */
public class UserManagerUtil {
	private static Logger log = LoggerFactory.getLogger(UserManagerUtil.class);
	
	/**
	 * 
	 * 
	 * @param xmppConn
	 * @return
	 */
	public Roster getRoster(XMPPConnection xmppConn){
		return xmppConn.getRoster();
	}
	
}
