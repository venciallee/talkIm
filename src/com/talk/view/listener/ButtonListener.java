package com.talk.view.listener;

import java.util.Map;

import org.jivesoftware.smack.packet.IQ;

import android.view.View;
import android.view.View.OnClickListener;

import com.talk.connect.util.Constant;
import com.talk.view.service.UserServices;

/**
 * @author ven
 * @createTime 2013-2-5œ¬ŒÁ09:46:13
 * @lastEditTime 2013-2-5œ¬ŒÁ09:46:13
 * @copyright Design by vencial
 * @description ¿‡√Ë ˆ
 */
public class ButtonListener implements OnClickListener{

	private UserServices userServices  = null;
	private int commond;
	private String userName;
	private String password;
	private Map<String,String> attributes = null;
	private IQ result = null;
	
	public ButtonListener() {
		userServices = new UserServices();
	}
	
	public ButtonListener(int commond) {
		this.commond = commond;
		userServices = new UserServices();
	}
	
	@Override
	public void onClick(View view) {
		switch(commond){
			case Constant.REGISTERCOM:
				if(null==attributes){
					result = userServices.register(userName, password);
				}else{
					result = userServices.register(userName, password, attributes);
				}
				break;
			case Constant.LOGINCOM:
				userServices.login(userName, password);
				break;
			case Constant.LOGOUTCOM:
				userServices.logout();
				break;
		}
	}

	public int getCommond() {
		return commond;
	}

	public void setCommond(int commond) {
		this.commond = commond;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public IQ isResult() {
		return result;
	}

	public void setResult(IQ result) {
		this.result = result;
	}

}
