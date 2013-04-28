package com.talk.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smackx.packet.VCard;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.talk.enumeration.ePagerSelected;
import com.talk.enumeration.eUserField;
import com.talk.message.db.MsgSharedPrefenrence;
import com.talk.user.Constant;
import com.talk.user.ContactService;
import com.talk.util.Util;

public class PagerSwitcherRunnable implements Runnable {

	private Activity mActivity = null;

	private ContactService mContactService = null;

	private MsgSharedPrefenrence mMsgPrefs = null;

	// ÁªÏµÈËresourse.
	private Collection<RosterEntry> mRosterLists = null;

	private int mSelectedPage = 0;

	private Handler mHandler = null;

	private Message msg = null;

	private ePagerSelected mContentInterface;

	private static final HashMap<String, VCard> mContactsMap = new HashMap<String, VCard>();

	private static final ArrayList<String> mChatList = new ArrayList<String>();

	public PagerSwitcherRunnable(ContactService contactService,
			Activity activity, int selectedPage, Handler handler,
			ePagerSelected _eContentInterface) {
		this.mContactService = contactService;
		this.mActivity = activity;
		this.mSelectedPage = selectedPage;
		this.mHandler = handler;
		this.mContentInterface = _eContentInterface;
		mMsgPrefs = new MsgSharedPrefenrence(mActivity);
	}

	@Override
	public void run() {

		mRosterLists = mContactService.getAllContacts();

		loadView(mRosterLists, mContentInterface);
	}

	private void loadView(Collection<RosterEntry> rosterLists,
			ePagerSelected _eContentInterface) {
		if (null != rosterLists) {
			Iterator<RosterEntry> rosterItor = rosterLists.iterator();
			while (rosterItor.hasNext()) {
				RosterEntry rosterEntry = rosterItor.next();
				String userName = rosterEntry.getName();

				// send msg including user data to UI thread.
				msg = new Message();

				Bundle bundle = new Bundle();

				int resImg = 0;

				String whatUp = null;

				VCard vcard = mContactService.loadVCardByUserName(userName);
				try {
					resImg = Util.toInt(vcard.getField(eUserField.PHOTO
							.getValue()));
					whatUp = vcard.getField(eUserField.WHATUP.getValue());
				} catch (Exception e) {
					resImg = 0;
					e.printStackTrace();
				}

				switch (_eContentInterface) {
				case CONTACT:

					synchronized (mContactsMap) {

						if (mContactsMap.containsKey(userName)) {

							break;
						}

						mContactsMap.put(userName, vcard);
					}

					bundle.putInt(Constant.CONTENTVIEWKEY,
							ePagerSelected.CONTACT.contentLayoutID());

					bundle.putString(
							eUserField.NICKNAME.getValue(),
							vcard.getNickName() == null ? userName : vcard
									.getNickName());

					bundle.putInt(eUserField.PHOTO.getValue(), resImg);

					bundle.putString(eUserField.WHATUP.getValue(),
							whatUp == null ? "" : whatUp);

					bundle.putString(Constant.USERNAME, userName);

					bundle.putInt(Constant.PAGESELECTKEY, mSelectedPage);

					msg.setData(bundle);

					msg.obj = _eContentInterface;

					mHandler.sendMessage(msg);

					break;
				case CHAT:

					synchronized (mChatList) {

						if (mChatList.contains(userName.toString())) {

							break;
						}

						mChatList.add(userName);
					}

					HashMap<String, String> lastMsgInfo = mMsgPrefs
							.getLastMsgInfo(userName);

					bundle.putInt(Constant.CONTENTVIEWKEY,
							ePagerSelected.CHAT.contentLayoutID());

					bundle.putInt(eUserField.PHOTO.getValue(), resImg);

					bundle.putInt(Constant.PAGESELECTKEY, mSelectedPage);

					bundle.putString(
							eUserField.NICKNAME.getValue(),
							vcard.getNickName() == null ? userName : vcard
									.getNickName());

					bundle.putString(Constant.USERNAME, userName);

					bundle.putSerializable(Constant.MSGINFO, lastMsgInfo);

					msg.setData(bundle);

					msg.obj = _eContentInterface;

					mHandler.sendMessage(msg);

				}

			}
		}
	}

}
