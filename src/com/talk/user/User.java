package com.talk.user;

/**
 * @author ven
 * @createTime 2013-1-17ÏÂÎç09:39:28
 * @lastEditTime 2013-1-17ÏÂÎç09:39:28
 * @copyright Design by vencial
 * @description ÀàÃèÊö
 */
public class User {
	private String userName;
	private String password;
	private String name;
	private char sex;
	private int age;
	private String address;
	
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
