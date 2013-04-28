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
	 * @explain 通过用户名搜索联系人.
	 * 
	 * @param userName
	 * @return
	 */
	public ReportedData getContactDataBySearch(String userName) {
		return mContactManager.getContactDataBySearch(mXMPPCon, userName);
	}

	/**
	 * @explain 增加联系人到指定组.
	 * 
	 * @param userName
	 * @param group
	 * @return
	 */
	public boolean addContact(String userName, String[] group) {
		return mContactManager.addContact(mXMPPCon, userName, group);
	}

	/**
	 * @explain 获取所有联系人.
	 * 
	 * @return
	 */
	public Collection<RosterEntry> getAllContacts() {
		return mContactManager.getAllContacts(mXMPPCon);
	}

	/**
	 * @explain 移除联系人.
	 * 
	 * @param rosterEntry
	 * @return
	 */
	public boolean removeContact(RosterEntry rosterEntry) {
		return mContactManager.removeContact(mXMPPCon, rosterEntry);
	}

	/**
	 * @explain 加载VCard.
	 * 
	 * @return
	 */
	public VCard loadVCard() {
		return mContactManager.loadVCard(mXMPPCon);
	}

	/**
	 * @explain 通过用户名加载VCard.
	 * 
	 * @param user
	 * @return
	 */
	public VCard loadVCardByUserName(String userName) {
		return mContactManager.loadVCardByUserName(mXMPPCon, userName);
	}

	/**
	 * @explain 保存VCard.
	 * 
	 * @param vCard
	 * @return
	 */
	public boolean saveVCard(VCard vCard) {
		return mContactManager.saveVCard(mXMPPCon, vCard);
	}
}
