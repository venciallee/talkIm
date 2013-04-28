package com.talk.user;

import java.util.Collection;

import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smackx.ReportedData;
import org.jivesoftware.smackx.packet.VCard;

public interface IContactManager {

	/**
	 * @explain ������ϵ��.
	 * 
	 * @param xmppCon
	 * @param userName
	 * @return
	 */
	public ReportedData getContactDataBySearch(XMPPConnection xmppCon,
			String userName);

	/**
	 * @explain �����ϵ��.
	 * 
	 * @param xmppCon
	 * @param userName
	 * @param group
	 * @return
	 */
	public boolean addContact(XMPPConnection xmppCon, String userName,
			String[] group);

	/**
	 * @explain ��ȡ������ϵ��.
	 * 
	 * @param xmppCon
	 * @return
	 */
	public Collection<RosterEntry> getAllContacts(XMPPConnection xmppCon);

	/**
	 * @explain ɾ����ϵ��.
	 * 
	 * @param xmppCon
	 * @param rosterEntry
	 * @return
	 */
	public boolean removeContact(XMPPConnection xmppCon, RosterEntry rosterEntry);

	/**
	 * @explain ����VCard.
	 * 
	 * @param con
	 * @return
	 */
	public VCard loadVCard(Connection con);

	/**
	 * @explain ͨ���û�������VCard.
	 * 
	 * @param con
	 * @param user
	 * @return
	 */
	public VCard loadVCardByUserName(Connection con, String user);

	/**
	 * @explain ����VCard.
	 * 
	 * @param con
	 * @param vCard
	 * @return
	 */
	public boolean saveVCard(Connection con, VCard vCard);
}
