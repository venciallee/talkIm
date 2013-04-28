package com.talk.user;

import java.util.Map;

import org.jivesoftware.smack.AccountManager;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketIDFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Registration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.talk.factory.XmppConnectionFactory;


/**
 * @author ven
 * @createTime 2013-2-5…œŒÁ12:23:09
 * @lastEditTime 2013-2-5…œŒÁ12:23:09
 * @copyright Design by vencial
 * @description ¿‡√Ë ˆ
 */
public class UserOperation implements IUserOperation{

	private AccountManager accountManager = null;
	private static final Logger log = LoggerFactory.getLogger(UserOperation.class);
	
	public UserOperation() {
		
	}

	/* (non-Javadoc)
	 * @see com.talk.user.IUserOperation#modifyPassword(org.jivesoftware.smack.XMPPConnection, java.lang.String)
	 */
	@Override
	public boolean modifyPassword(XMPPConnection xmppConnection, String password) {
		boolean flag = false;
		try{
			accountManager = xmppConnection.getAccountManager();
			accountManager.changePassword(password);
			flag = true;
		}catch(Exception e){
			log.error("modifyPassword error"+e.getMessage());
			e.printStackTrace();
		}
		
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.talk.user.IUserOperation#login(org.jivesoftware.smack.XMPPConnection, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean login(XMPPConnection xmppConnection, String userName,
			String password) {
		boolean flag = false;
		try{
			//SASLAuthentication.supportSASLMechanism("PLAIN", 0);
			xmppConnection.login(userName, password);
			flag = true;
		}catch(Exception e){
			log.error("login error."+e.getMessage());
			XmppConnectionFactory.getXmppConnection();
			e.printStackTrace();
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.talk.user.IUserOperation#logout(org.jivesoftware.smack.XMPPConnection)
	 */
	@Override
	public boolean logout(XMPPConnection xmppConnection) {
		boolean flag = false;
		try{
			xmppConnection.disconnect();
			flag = true;
		}catch (Exception e) {
			log.error("logout error."+e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.talk.user.IUserOperation#register(org.jivesoftware.smack.XMPPConnection, java.lang.String, java.lang.String)
	 */
	public IQ register(XMPPConnection xmppConnection, String userName,
			String password) {
		Registration register = new Registration();
		
		register.setType(IQ.Type.SET);
		register.setTo(xmppConnection.getServiceName());
		register.setUsername(userName);
		register.setPassword(password);
		
		PacketFilter filter = new AndFilter(new PacketIDFilter(register.getPacketID()),new PacketTypeFilter(IQ.class));
		PacketCollector collector = xmppConnection.createPacketCollector(filter);
		xmppConnection.sendPacket(register);
		
		IQ result = (IQ)collector.nextResult(SmackConfiguration.getPacketReplyTimeout());
		
		collector.cancel();
		/*try{
			accountManager = xmppConnection.getAccountManager();
			accountManager.createAccount(userName, password);
			flag = true;
		}catch (Exception e) {
			log.error("register error."+e.getMessage());
			e.printStackTrace();
		}*/
		return result;
	}

	/* (non-Javadoc)
	 * @see com.talk.user.IUserOperation#register(org.jivesoftware.smack.XMPPConnection, java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public IQ register(XMPPConnection xmppConnection, String userName,
			String password, Map<String, String> attributes) {
		Registration register = new Registration();
		
		register.setType(IQ.Type.SET);
		register.setTo(xmppConnection.getServiceName());
		register.setUsername(userName);
		register.setPassword(password);
		
		PacketFilter filter = new AndFilter(new PacketIDFilter(register.getPacketID()),new PacketTypeFilter(IQ.class));
		PacketCollector collector = xmppConnection.createPacketCollector(filter);
		xmppConnection.sendPacket(register);
		
		IQ result = (IQ)collector.nextResult(SmackConfiguration.getPacketReplyTimeout());
		
		collector.cancel();
		
		return result;
	}

}
