package com.ssm.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ssm.controller.UserController;
import com.ssm.entity.User;
import com.ssm.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml","classpath:spring-mvc.xml"}) 
@WebAppConfiguration
public class UserControllerTest {

	private MockMvc mockMvc;
	
	@Autowired  
	private WebApplicationContext webApplicationContext;
	
	@Resource
	private IUserService userService;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testSaveUser() {
		try {
			User user = new User();
			user.setUsername("梁朝伟");
			user.setBirthday(new Date());
			user.setSex("男");
			user.setAddress("香港");
			String sUser = new Gson().toJson(user);
			String response = mockMvc.perform(
					MockMvcRequestBuilders
					.post("/saveUser")
					.contentType(MediaType.APPLICATION_JSON)
					.content(sUser)
			).andExpect(status().isOk())
					.andDo(print())
					.andReturn()
					.getResponse()
					.getContentAsString();
			System.out.println("结果："+response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryUserById() {
		try {
			String response = mockMvc.perform(
					get("/queryUserById")
					.contentType(MediaType.APPLICATION_FORM_URLENCODED)
					.param("id", "10")
			).andExpect(status().isOk())
					.andDo(print())
					.andReturn()
					.getResponse()
					.getContentAsString();
			System.out.println("结果："+response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAlterUserNameById() {
		try {
			String response = mockMvc.perform(
					get("/alterUserNameById")
					.contentType(MediaType.APPLICATION_FORM_URLENCODED)
					.param("id", "520")
					.param("username", "这是测试")
			).andExpect(status().isOk())
					.andDo(print())
					.andReturn()
					.getResponse()
					.getContentAsString();
			System.out.println("结果："+response);
			testQueryUserById();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDropUserById() {
		try {
			String response = mockMvc.perform(
					get("/dropUserById")
					.contentType(MediaType.APPLICATION_FORM_URLENCODED)
					.param("id", "520")
			).andExpect(status().isOk())
					.andDo(print())
					.andReturn()
					.getResponse()
					.getContentAsString();
			System.out.println("结果："+response);
			testQueryUserById();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
