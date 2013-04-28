package com.talk.connect;

import java.util.Iterator;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.OfflineMessageManager;

public class SmarkConnect {

	private static ConnectionConfiguration connectConfig = null;
	private static XMPPConnection xmppCon = null;
	private Chat sendChat = null;
	private ChatManager chatManager = null;
	public XMPPConnection openConnection() {
		if (null == xmppCon) {
			config();
		}
		return xmppCon;
	}
	
	/**
	 * πÿ±’xmpp¡¨Ω”.
	 */
	public void closeXmppConnection(){
		xmppCon.disconnect();
		xmppCon = null;
	}
	
	private void config(){
		connectConfig = new ConnectionConfiguration("192.168.173.1", 5222);
		connectConfig.setSendPresence(false);
		xmppCon = new XMPPConnection(connectConfig);
		try{
			xmppCon.connect();
			try {
				xmppCon.login("white", "white");
			} catch (XMPPException e) {
				e.printStackTrace();
			}
			getOffLineMessage(xmppCon);
			chatManager = xmppCon.getChatManager();
			sendChat = chatManager.createChat("vencial@vencial",null);
		/*	
			xmppCon.addPacketListener(new PacketListener() {
				
				@Override
				public void processPacket(Packet packet) {
					System.out.println(packet.getFrom()+":"+packet.toXML());
				}
			}, null);
			
			sendChat.addMessageListener(new MessageListener() {
				@Override
				public void processMessage(Chat chat, Message message) {
					System.out.println("recieve:"+message.getBody());
				}
			});*/
		}catch (Exception e) {
			System.out.println("XMPP connect error.");
			e.printStackTrace();
		}
		
		Message message = new Message();
		message.setBody("goodnight");
		try {
			sendChat.sendMessage(message);
		} catch (XMPPException e) {
			e.printStackTrace();
		}
	}
	
	public void getOffLineMessage(XMPPConnection xmppCon){
		System.out.println(xmppCon);
		OfflineMessageManager offLineMsgManager = new OfflineMessageManager(xmppCon);
		try {
			Iterator<Message> itetator = offLineMsgManager.getMessages();
			while(itetator.hasNext()){
				Message msg = itetator.next();
				System.out.println("recieve from:"+msg.getFrom()+",content:"+msg.getBody());
			}
			offLineMsgManager.deleteMessages();
		} catch (XMPPException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		SmarkConnect s = new SmarkConnect();
		xmppCon = s.openConnection();
		System.out.println(xmppCon.isConnected()+" "+xmppCon.getUser());
	}

}
