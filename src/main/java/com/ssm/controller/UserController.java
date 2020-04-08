package com.ssm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.ssm.entity.User;
import com.ssm.service.IUserService;

@Controller
public class UserController {

	@Resource
	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/saveUser",method = RequestMethod.POST)
	@ResponseBody
	public boolean saveUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping(value = "/dropUserById",method = RequestMethod.GET)
	@ResponseBody
	public boolean dropUserById(@RequestParam("id")Integer id) {
		System.out.println(id);
		return userService.removeUserById(id);
	}
	
	@RequestMapping(value = "/queryUserById",method = RequestMethod.GET)
	@ResponseBody
	public User queryUserById(@RequestParam("id")Integer id) {
		System.out.println(id);
		return userService.findUserById(id);
	}
	
	@RequestMapping(value = "/alterUserNameById",method = RequestMethod.GET)
	@ResponseBody
	public boolean alterUserNameById(@RequestParam("id")Integer id,@RequestParam("username")String username) {
		System.out.println(id);
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		return userService.modifyUserNameById(user);
	}
}
