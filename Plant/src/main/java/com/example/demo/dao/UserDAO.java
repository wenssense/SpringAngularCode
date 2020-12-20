package com.example.demo.dao;

import com.example.demo.bean.User;

public interface UserDAO {
	
	public User saveUser(User user);
	
	public String checkLogin(User user);

}
