package com.exampleSms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleSms.model.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer>{

}
