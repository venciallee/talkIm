package com.talk.setting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.jivesoftware.smackx.packet.VCard;

import android.os.Bundle;

import com.talk.enumeration.eUserField;
import com.talk.user.ContactService;

public class UserFieldSetting implements ISetting {

	private ContactService mContactService;

	public UserFieldSetting(final ContactService contactService) {
		this.mContactService = contactService;
	}

	@Override
	public void setUserField(HashMap<Object, Object> userMap) {
		VCard vCard = new VCard();
		Set<Object> userKeySet = userMap.keySet();
		Iterator<Object> itetator = userKeySet.iterator();
		while (itetator.hasNext()) {
			Object key = itetator.next();

			vCard.setField(key.toString(), userMap.get(key).toString());
		}

		mContactService.saveVCard(vCard);
	}

	@Override
	public Bundle getUserField(String userName) {
		Bundle bundle = new Bundle();
		VCard vCard = mContactService.loadVCardByUserName(userName);
		eUserField[] userFields = eUserField.values();
		for (int i = 0; i < userFields.length; i++) {
			String val = userFields[i].getValue();
			bundle.putString(val, vCard.getField(val));
		}

		return bundle;
	}

}
