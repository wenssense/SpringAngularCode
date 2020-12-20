package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDAO;

@Controller
public class HomeController {

	@Autowired
	UserDAO userDAO;

	@RequestMapping("/")
	public String welcomePage() {
		return "welcome.html";
	}

	@RequestMapping(value = "/signupURL", method = RequestMethod.POST)
	@ResponseBody
	public String signupURL(@RequestBody User user) {
		String ss ="";
		User us = userDAO.saveUser(user);
		if(us != null) {
			ss = "success";
		}else {
			ss = "failed";
		}
		return ss;
	}
	
	@RequestMapping(value = "/loginApp", method = RequestMethod.POST)
	@ResponseBody
	public String loginApp(@RequestBody User user) {
		String ss = "";
		if(user.getEmail() !=null && user.getPassword() != null && !user.getEmail().isEmpty() && !user.getPassword().isEmpty()) {
			ss = userDAO.checkLogin(user);
		}else {
			ss = "errorCode";
		}
		return ss;
	}
	
	@RequestMapping(value = "/wow", method = RequestMethod.GET)
	@ResponseBody
	public String wow(@RequestParam("id") int id) {
		String ss ="";
		
			ss = "failed";
		return ss;
	}

}
