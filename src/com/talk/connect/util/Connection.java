package com.talk.connect.util;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ven
 * @createTime 2013-1-18…œŒÁ12:28:24
 * @lastEditTime 2013-1-18…œŒÁ12:28:24
 * @copyright Design by vencial
 * @description ¿‡√Ë ˆ
 */
public class Connection extends AbsConnection{
	
	private static ConnectionConfiguration connConfig = null;
	private static Logger log = LoggerFactory.getLogger(Connection.class);
	
	/* (non-Javadoc)
	 * @see com.talk.connect.util.IConnection#connectionConfig(java.lang.String, int)
	 */
	@Override
	public ConnectionConfiguration connectionConfig(String domain, int port) {
		if(null==connConfig){
			connConfig = new ConnectionConfiguration(domain, port);
			connConfig.setSASLAuthenticationEnabled(false); 
		}
		return connConfig;
	}
	
}
