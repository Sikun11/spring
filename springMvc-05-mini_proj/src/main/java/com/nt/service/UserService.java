package com.nt.service;

import com.nt.entity.User;

public interface UserService {

	public boolean saveUser(User user);
	
	public User getUser(String email,String pwd);
	
}
