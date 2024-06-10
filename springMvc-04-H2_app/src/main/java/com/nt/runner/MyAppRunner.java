package com.nt.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Contact;
import com.nt.repo.ContactRepo;
@Component
public class MyAppRunner implements ApplicationRunner{

	@Autowired
	private ContactRepo repo;
	
	@Override
	public void run(ApplicationArguments args)throws Exception{
		Contact c1= new Contact();
		c1.setName("john");
		c1.setPhno(123456);
		
		Contact c2=new Contact();
		c2.setName("smith");
		c2.setPhno(22333444);
		
		repo.saveAll(Arrays.asList(c1,c2));
	}
}
