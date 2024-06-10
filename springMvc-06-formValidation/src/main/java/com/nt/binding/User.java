package com.nt.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {

	@NotEmpty(message="name is mandatory")
	@Size(min=3,max=8,message="min 3 and max 8 chars allowed")
	private String name;
	
	@NotEmpty(message="email is mandatory")
	@Email(message="enter a valid email")
	private String email;
	
	@NotNull(message="phno is mandatory")
	private Long phno;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", phno=" + phno + "]";
	}
	
	
}
