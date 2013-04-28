package com.talk.user;

import java.util.Collection;

import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smackx.ReportedData;
import org.jivesoftware.smackx.packet.VCard;

public interface IContactManager {

	/**
	 * @explain 查找联系人.
	 * 
	 * @param xmppCon
	 * @param userName
	 * @return
	 */
	public ReportedData getContactDataBySearch(XMPPConnection xmppCon,
			String userName);

	/**
	 * @explain 添加联系人.
	 * 
	 * @param xmppCon
	 * @param userName
	 * @param group
	 * @return
	 */
	public boolean addContact(XMPPConnection xmppCon, String userName,
			String[] group);

	/**
	 * @explain 获取所有联系人.
	 * 
	 * @param xmppCon
	 * @return
	 */
	public Collection<RosterEntry> getAllContacts(XMPPConnection xmppCon);

	/**
	 * @explain 删除联系人.
	 * 
	 * @param xmppCon
	 * @param rosterEntry
	 * @return
	 */
	public boolean removeContact(XMPPConnection xmppCon, RosterEntry rosterEntry);

	/**
	 * @explain 加载VCard.
	 * 
	 * @param con
	 * @return
	 */
	public VCard loadVCard(Connection con);

	/**
	 * @explain 通过用户名加载VCard.
	 * 
	 * @param con
	 * @param user
	 * @return
	 */
	public VCard loadVCardByUserName(Connection con, String user);

	/**
	 * @explain 保存VCard.
	 * 
	 * @param con
	 * @param vCard
	 * @return
	 */
	public boolean saveVCard(Connection con, VCard vCard);
}
