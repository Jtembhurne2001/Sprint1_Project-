package com.exampleSms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleSms.model.PersonalDetail;

public interface PersonalDetailDao extends JpaRepository<PersonalDetail, Integer> {

}
