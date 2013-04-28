package com.talk.setting;

import java.util.HashMap;

import android.os.Bundle;

public interface ISetting {
	
	public void setUserField(HashMap<Object,Object> userMap);
	
	public Bundle getUserField(String userName);
}
