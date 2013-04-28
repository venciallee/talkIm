package com.talk.user;

import java.util.Collection;

import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.Form;
import org.jivesoftware.smackx.ReportedData;
import org.jivesoftware.smackx.packet.VCard;
import org.jivesoftware.smackx.search.UserSearchManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.talk.connect.util.Constant;

public class ContactManager implements IContactManager {

	private static Logger log = LoggerFactory.getLogger(ContactManager.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.talk.user.IContactManager#getContactDataBySearch(org.jivesoftware
	 * .smack.XMPPConnection, java.lang.String)
	 */
	@Override
	public ReportedData getContactDataBySearch(XMPPConnection xmppCon,
			String userName) {
		ReportedData reData = null;
		UserSearchManager userSearch = new UserSearchManager(xmppCon);
		try {
			Form searchForm = userSearch.getSearchForm("search."
					+ Constant.DOMAIN);
			Form answerForm = searchForm.createAnswerForm();
			answerForm.setAnswer("Username", true);
			answerForm.setAnswer("search", userName);
			reData = userSearch.getSearchResults(answerForm, "search."
					+ Constant.DOMAIN);
		} catch (XMPPException e) {
			e.printStackTrace();
			log.error("getContactDataBySearch error.");
		}
		return reData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.talk.user.IContactManager#addContact(org.jivesoftware.smack.
	 * XMPPConnection, java.lang.String, java.lang.String[])
	 */
	@Override
	public boolean addContact(XMPPConnection xmppCon, String userName,
			String[] group) {
		boolean flag = false;
		try {
			Roster roster = xmppCon.getRoster();
			roster.createEntry(userName, null, group);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("addContact error");
		}
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.talk.user.IContactManager#getAllContacts(org.jivesoftware.smack.
	 * XMPPConnection)
	 */
	@Override
	public Collection<RosterEntry> getAllContacts(XMPPConnection xmppCon) {
		Collection<RosterEntry> rosterLists = null;
		Roster roster = xmppCon.getRoster();
		rosterLists = roster.getEntries();
		return rosterLists;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.talk.user.IContactManager#removeContact(org.jivesoftware.smack.
	 * XMPPConnection, org.jivesoftware.smack.RosterEntry)
	 */
	@Override
	public boolean removeContact(XMPPConnection xmppCon, RosterEntry rosterEntry) {
		boolean flag = false;
		try {
			Roster roster = xmppCon.getRoster();
			roster.removeEntry(rosterEntry);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("removeConta");
		}
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.talk.user.IContactManager#loadVCard(org.jivesoftware.smack.Connection
	 * )
	 */
	@Override
	public VCard loadVCard(Connection con) {
		VCard vCard = new VCard();
		try {
			vCard.load(con);
		} catch (XMPPException e) {
			e.printStackTrace();
		}
		return vCard;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.talk.user.IContactManager#loadVCardByUserName(org.jivesoftware.smack
	 * .Connection, java.lang.String)
	 */
	@Override
	public VCard loadVCardByUserName(Connection con, String user) {
		VCard vCard = new VCard();
		try {
			vCard.load(con, user + "@vencial");
		} catch (XMPPException e) {
			e.printStackTrace();
		}
		return vCard;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.talk.user.IContactManager#saveVCard(org.jivesoftware.smack.Connection
	 * )
	 */
	@Override
	public boolean saveVCard(Connection con, VCard vCard) {
		boolean flag = false;
		try {
			vCard.save(con);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
