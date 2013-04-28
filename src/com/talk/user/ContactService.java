package com.talk.user;

import java.util.Collection;

import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smackx.ReportedData;
import org.jivesoftware.smackx.packet.VCard;

import com.talk.factory.XmppConnectionFactory;

public class ContactService {

	private ContactManager mContactManager = null;
	private XMPPConnection mXMPPCon = null;


	public ContactService() {
		mContactManager = new ContactManager();
		mXMPPCon = XmppConnectionFactory.getXmppConnection();
	}

	/**
	 * @explain ͨ���û���������ϵ��.
	 * 
	 * @param userName
	 * @return
	 */
	public ReportedData getContactDataBySearch(String userName) {
		return mContactManager.getContactDataBySearch(mXMPPCon, userName);
	}

	/**
	 * @explain ������ϵ�˵�ָ����.
	 * 
	 * @param userName
	 * @param group
	 * @return
	 */
	public boolean addContact(String userName, String[] group) {
		return mContactManager.addContact(mXMPPCon, userName, group);
	}

	/**
	 * @explain ��ȡ������ϵ��.
	 * 
	 * @return
	 */
	public Collection<RosterEntry> getAllContacts() {
		return mContactManager.getAllContacts(mXMPPCon);
	}

	/**
	 * @explain �Ƴ���ϵ��.
	 * 
	 * @param rosterEntry
	 * @return
	 */
	public boolean removeContact(RosterEntry rosterEntry) {
		return mContactManager.removeContact(mXMPPCon, rosterEntry);
	}

	/**
	 * @explain ����VCard.
	 * 
	 * @return
	 */
	public VCard loadVCard() {
		return mContactManager.loadVCard(mXMPPCon);
	}

	/**
	 * @explain ͨ���û�������VCard.
	 * 
	 * @param user
	 * @return
	 */
	public VCard loadVCardByUserName(String userName) {
		return mContactManager.loadVCardByUserName(mXMPPCon, userName);
	}

	/**
	 * @explain ����VCard.
	 * 
	 * @param vCard
	 * @return
	 */
	public boolean saveVCard(VCard vCard) {
		return mContactManager.saveVCard(mXMPPCon, vCard);
	}
}
