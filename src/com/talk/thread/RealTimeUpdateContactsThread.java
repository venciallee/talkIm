package com.talk.thread;

import java.util.Collection;

import org.jivesoftware.smack.RosterEntry;

import com.talk.user.ContactService;

public class RealTimeUpdateContactsThread implements Runnable{
	
	private ContactService mContactService = null;
	
	private Collection<RosterEntry> rostersArrList =null;
	
	private boolean mContactUpdateFlag = false;
	
	public RealTimeUpdateContactsThread() {
		mContactService = new ContactService();
	}
	
	@Override
	public void run() {
		if(!mContactUpdateFlag){
			rostersArrList = mContactService.getAllContacts();
			mContactUpdateFlag = true;
		}
	}

	public Collection<RosterEntry> getRostersArrList() {
		return rostersArrList;
	}

	public void setRostersArrList(Collection<RosterEntry> rostersArrList) {
		this.rostersArrList = rostersArrList;
	}

	public boolean ismContactUpdateFlag() {
		return mContactUpdateFlag;
	}

	public void setmContactUpdateFlag(boolean mContactUpdateFlag) {
		this.mContactUpdateFlag = mContactUpdateFlag;
	}
	
}
