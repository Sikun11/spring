package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Contact;

public interface ContactRepo extends JpaRepository<Contact,Integer>{

}
