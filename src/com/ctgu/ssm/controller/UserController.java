package com.ctgu.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctgu.ssm.entity.User;
import com.ctgu.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@RequestMapping("/login")
	public String Login(HttpServletRequest request) {
		return "userlogin";
	}

	@RequestMapping(value = "logininfo")
	@ResponseBody
	public String LoginInfo(@RequestParam("username") String username, @RequestParam("password") String password) {
		User user = userService.findUserByUsername(username);
		System.out.println("LoginInfo run");
		if (password != null && user != null && password.equals(user.getPassword())) {
			return "success";
		} else {
			return "error";
		}
	}

}
