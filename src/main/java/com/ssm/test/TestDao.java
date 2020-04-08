package com.ssm.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.dao.IUserdao;
import com.ssm.entity.User;
import com.ssm.service.impl.UserServiceImpl;

public class TestDao {

	@Test
	public void testDao() throws IOException {
		UserServiceImpl serviceImpl = new UserServiceImpl();
		User user = new User();
		user.setUsername("Áº³¯Î°55");
		user.setBirthday(new Date());
		user.setSex("ÄÐ");
		user.setAddress("Ïã¸Û");
		
		String resours = "spring-mybatis.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resours);
		IUserdao mapper = ac.getBean(IUserdao.class);
		System.out.println(mapper.selectUserById(520));
	}
}
