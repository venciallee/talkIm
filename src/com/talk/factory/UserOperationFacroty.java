package com.talk.factory;

import com.talk.user.IUserOperation;
import com.talk.user.UserOperation;

/**
 * @author ven
 * @createTime 2013-2-5����10:12:04
 * @lastEditTime 2013-2-5����10:12:04
 * @copyright Design by vencial
 * @description ������
 */
public class UserOperationFacroty {
	
	private static IUserOperation userOperation = null;
	
	/**
	 * @explain ����IUserOperationʵ��.
	 * 
	 * @return
	 */
	public static IUserOperation getUserOperation(){
		if(null==userOperation){
			userOperation = new UserOperation();
		}
		return userOperation;
	}
}
