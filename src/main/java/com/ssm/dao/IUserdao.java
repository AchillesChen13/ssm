package com.ssm.dao;

import org.springframework.stereotype.Repository;

import com.ssm.entity.User;

/**
 * 这里我采用的是Mapper映射接口方式实现，如果需要在dao接口实现类中做少许逻辑处理，那么采用原始dao方式实现dao接口类
 * 采用Mapper映射一定要注意，Mapper文件里面sql语句标签的id,参数类型,结果类型都要与接口一致
 * @author chen
 *
 */
@Repository
public interface IUserdao {

	/**
	 * 添加一个用户信息
	 * @param user
	 * @return
	 */
	int insertUser(User user);

	/**
	 * 根据编号查找用户
	 * @param id
	 * @return
	 */
	User selectUserById(Integer id);
	
	/**
	 * 根据用户编号删除用户
	 * @param id
	 * @return
	 */
	boolean deleteUserById(Integer id);
	
	/**
	 * 根据编号修改用户名字
	 * @param id
	 * @return
	 */
	boolean updateUserNameById(User user);

}
