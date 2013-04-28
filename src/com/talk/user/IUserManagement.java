package com.talk.user;


/**
 * @author ven
 * @createTime 2013-1-17下午09:38:51
 * @lastEditTime 2013-1-17下午09:38:51
 * @copyright Design by vencial
 * @description 类描述
 */
public interface IUserManagement {
	/**
	 * @explain 通过账号获取用户.
	 * 
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName);
	/**
	 * @explain 通过用户名称获取用户.
	 * 
	 * @param name
	 * @return
	 */
	public User getUserByName(String name);
	/**
	 * @explain 删除好友.
	 * 
	 * @param userName
	 * @return
	 */
	public boolean deleteUser(String userName);
	/**
	 * @explain 通过账号添加好友.
	 * 
	 * @param userName
	 * @return
	 */
	public boolean addUserByUserName(String userName);
	/**
	 * @explain 通过用户名称添加好友.
	 * 
	 * @param name
	 * @return
	 */
	public boolean addUserByName(String name);
}
