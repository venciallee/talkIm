package com.talk.thread;

import org.jivesoftware.smack.XMPPConnection;

import com.talk.factory.XmppConnectionFactory;

public class ConnectOpThread implements Runnable{
	
	private XMPPConnection mXMPPCon = null;
	
	/*private UserServices mUserServices = null;
	
	private UserOpHandler mUserOpHandler = null;
	
	private Integer mOperation;
	
	private String userName = null;
	private String password = null;
	
	private String key = null;
	
	public ConnectOpThread(final int operation,final UserOpHandler userOpHandler) {
		mUserServices = new UserServices();
		this.mUserOpHandler = userOpHandler;
		this.mOperation = operation;
	}
	
	@Override
	public void run() {
		synchronized(mOperation){
			Message msg = new Message();
			switch (this.mOperation) {
			case UserOpType.REGISTER:
				IQ result = mUserServices.register(userName, password);
				msg.what = UserOpType.REGISTER;
				msg.obj = result;
				break;
			case UserOpType.LOGIN:
				boolean flag = mUserServices.login(userName, password);
				msg.what = UserOpType.LOGIN;
				msg.obj = flag;
			case UserOpType.LOGOUT:
				mUserServices.logout();
				break;
			default:
				//do nothing.
				break;
			}
		}
	}

	public int getmOperation() {
		return mOperation;
	}

	public void setmOperation(int mOperation) {
		this.mOperation = mOperation;
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
	}*/
	
	
	@Override
	public void run() {
		
		mXMPPCon = XmppConnectionFactory.getXmppConnection();
	}
	
}
