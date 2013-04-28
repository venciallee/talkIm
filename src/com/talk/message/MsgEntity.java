package com.talk.message;

public class MsgEntity {
	
	private String msg = null;
	
	//message is recieved if the value it's true,
	private int msgType = 0;
	
	public MsgEntity() {
		
	}
	
	public MsgEntity(final String msg,final int msgType) {
		this.msg = msg;
		this.msgType = msgType;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getMsgType() {
		return this.msgType;
	}

	public void setMsgType(final int msgType) {
		this.msgType = msgType;
	}
}
