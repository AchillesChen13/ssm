package com.ssm.service.impl;

import javax.annotation.Resource;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.springframework.stereotype.Service;

import com.ssm.dao.IUserdao;
import com.ssm.entity.User;
import com.ssm.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Resource
	private IUserdao userdao;

	public IUserdao getUserdao() {
		return userdao;
	}

	public void setUserdao(IUserdao userdao) {
		this.userdao = userdao;
	}

	/**
	 * 根据编号查找用户
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id) {
		System.out.println("findUserById");
		return userdao.selectUserById(id);
	}

	/**
	 * 添加一个用户信息
	 * @param user
	 * @return
	 */
	public boolean addUser(User user) {
		if (userdao.insertUser(user)>0) {
			return true;
		}
		return false;
	}

	/**
	 * 根据用户编号删除用户
	 * @param id
	 * @return
	 */
	public boolean removeUserById(Integer id) {
		
		return userdao.deleteUserById(id);
	}

	/**
	 * 根据编号修改用户名字
	 * @param id
	 * @return
	 */
	public boolean modifyUserNameById(User user) {
		
		return userdao.updateUserNameById(user);
	}
	
	
	
}
