package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.User;
import com.nt.repo.UserRepo;
import com.nt.utils.EmailUtils;

@Service
public class UserServiceIml implements UserService{

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Override
	public boolean saveUser(User user) {
		User savedUser=repo.save(user);
		if(savedUser.getUid()!=null) {
			String subject="your account created-AshokIT";
			String body="<h1>Congratulations,welcome to board..</h>";
			emailUtils.sendEmail(user.getEmail(),subject,body);
		}
		return true;
	}
	@Override
	public User getUser(String email,String pwd) {
		return repo.findByEmailAndPassword(email, pwd);
	}
	
}
