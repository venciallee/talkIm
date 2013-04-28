package com.talk.connect;

import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketIDFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Registration;

import com.talk.factory.XmppConnectionFactory;

public class RegisterTest {
	
	public static void main(String args[]){
		XMPPConnection con = XmppConnectionFactory.getXmppConnection();
		Registration register = new Registration();
		register.setType(IQ.Type.SET);
		register.setTo(con.getServiceName());
		System.out.println(con.isConnected());
		
		register.setUsername("gogoo");
		register.setPassword("gogogo");
		register.addAttribute("android", "test_android");
		
		PacketFilter filter = new AndFilter(new PacketIDFilter(register.getPacketID()),new PacketTypeFilter(IQ.class));
		PacketCollector collector = con.createPacketCollector(filter);
		con.sendPacket(register);
		
		IQ result = (IQ)collector.nextResult(SmackConfiguration.getPacketReplyTimeout());
		
		collector.cancel();
		
	}
}
