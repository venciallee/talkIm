package com.talk.connect.util;

import org.jivesoftware.smack.ConnectionConfiguration;

/**
 * @author ven
 * @createTime 2013-1-18œ¬ŒÁ02:00:21
 * @lastEditTime 2013-1-18œ¬ŒÁ02:00:21
 * @copyright Design by vencial
 * @description ¿‡√Ë ˆ
 */
public class OfflineConnection extends AbsConnection{
	private static ConnectionConfiguration connConfig = null;
	/* (non-Javadoc)
	 * @see com.talk.connect.util.IConnection#connectionConfig(java.lang.String, int)
	 */
	@Override
	public ConnectionConfiguration connectionConfig(String domain, int port) {
		if(null!=connConfig){
			connConfig = new ConnectionConfiguration(domain, port);
		}
		connConfig.setSendPresence(false);
		return connConfig;
	}
}
