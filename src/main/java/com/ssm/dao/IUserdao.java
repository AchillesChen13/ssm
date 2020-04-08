package com.ssm.dao;

import org.springframework.stereotype.Repository;

import com.ssm.entity.User;

/**
 * �����Ҳ��õ���Mapperӳ��ӿڷ�ʽʵ�֣������Ҫ��dao�ӿ�ʵ�������������߼�������ô����ԭʼdao��ʽʵ��dao�ӿ���
 * ����Mapperӳ��һ��Ҫע�⣬Mapper�ļ�����sql����ǩ��id,��������,������Ͷ�Ҫ��ӿ�һ��
 * @author chen
 *
 */
@Repository
public interface IUserdao {

	/**
	 * ���һ���û���Ϣ
	 * @param user
	 * @return
	 */
	int insertUser(User user);

	/**
	 * ���ݱ�Ų����û�
	 * @param id
	 * @return
	 */
	User selectUserById(Integer id);
	
	/**
	 * �����û����ɾ���û�
	 * @param id
	 * @return
	 */
	boolean deleteUserById(Integer id);
	
	/**
	 * ���ݱ���޸��û�����
	 * @param id
	 * @return
	 */
	boolean updateUserNameById(User user);

}
