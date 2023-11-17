package com.exampleSms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleSms.model.Test;

public interface TestDao extends JpaRepository <Test, Integer> {

}
