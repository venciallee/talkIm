package com.talk.handler;

import org.jivesoftware.smack.packet.IQ;

import com.talk.view.service.UserOpType;

import android.os.Handler;
import android.os.Message;

public class UserOpHandler extends Handler{
	
	private IQ mIQResult = null;
	
	private boolean mResult = false;
	
	@Override
	public void handleMessage(Message msg) {
		
		switch(msg.what){
			case UserOpType.REGISTER:
				mIQResult = (IQ) msg.obj;
				break;
			case UserOpType.LOGIN:
				mResult = (Boolean) msg.obj;
				break;
			case UserOpType.LOGOUT:
				mResult = (Boolean) msg.obj;
				break;
		}
		super.handleMessage(msg);
	}

	public IQ getmIQResult() {
		return mIQResult;
	}

	public void setmIQResult(IQ mIQResult) {
		this.mIQResult = mIQResult;
	}

	public boolean ismResult() {
		return mResult;
	}

	public void setmResult(boolean mResult) {
		this.mResult = mResult;
	}
}
