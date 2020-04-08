package com.ssm.service;

import com.ssm.entity.User;

public interface IUserService {
	
	/**
	 * ���һ���û���Ϣ
	 * @param user
	 * @return
	 */
	boolean addUser(User user);

	/**
	 * ���ݱ�Ų����û�
	 * @param id
	 * @return
	 */
	User findUserById(Integer id);
	
	/**
	 * �����û����ɾ���û�
	 * @param id
	 * @return
	 */
	boolean removeUserById(Integer id);
	
	/**
	 * ���ݱ���޸��û�����
	 * @param id
	 * @return
	 */
	boolean modifyUserNameById(User user);
	
}
