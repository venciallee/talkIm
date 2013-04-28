package com.talk.factory;

import com.talk.view.service.UserServices;

/**
 * @author ven
 * @createTime 2013-2-5ÏÂÎç11:55:21
 * @lastEditTime 2013-2-5ÏÂÎç11:55:21
 * @copyright Design by vencial
 * @description ÀàÃèÊö
 */
public class UserServicesFactory {
	private static UserServices userServices = null;
	
	/**
	 * 
	 * @return
	 */
	public static UserServices getUserServices(){
		if(null==userServices){
			userServices = new UserServices();
		}
		return userServices;
	}
}
