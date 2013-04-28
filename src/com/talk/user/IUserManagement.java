package com.talk.user;


/**
 * @author ven
 * @createTime 2013-1-17����09:38:51
 * @lastEditTime 2013-1-17����09:38:51
 * @copyright Design by vencial
 * @description ������
 */
public interface IUserManagement {
	/**
	 * @explain ͨ���˺Ż�ȡ�û�.
	 * 
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName);
	/**
	 * @explain ͨ���û����ƻ�ȡ�û�.
	 * 
	 * @param name
	 * @return
	 */
	public User getUserByName(String name);
	/**
	 * @explain ɾ������.
	 * 
	 * @param userName
	 * @return
	 */
	public boolean deleteUser(String userName);
	/**
	 * @explain ͨ���˺���Ӻ���.
	 * 
	 * @param userName
	 * @return
	 */
	public boolean addUserByUserName(String userName);
	/**
	 * @explain ͨ���û�������Ӻ���.
	 * 
	 * @param name
	 * @return
	 */
	public boolean addUserByName(String name);
}
