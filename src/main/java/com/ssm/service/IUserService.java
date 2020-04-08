package com.ssm.service;

import com.ssm.entity.User;

public interface IUserService {
	
	/**
	 * 添加一个用户信息
	 * @param user
	 * @return
	 */
	boolean addUser(User user);

	/**
	 * 根据编号查找用户
	 * @param id
	 * @return
	 */
	User findUserById(Integer id);
	
	/**
	 * 根据用户编号删除用户
	 * @param id
	 * @return
	 */
	boolean removeUserById(Integer id);
	
	/**
	 * 根据编号修改用户名字
	 * @param id
	 * @return
	 */
	boolean modifyUserNameById(User user);
	
}
