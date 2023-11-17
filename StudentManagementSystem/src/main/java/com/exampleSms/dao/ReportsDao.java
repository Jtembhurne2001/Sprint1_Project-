package com.exampleSms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleSms.model.Reports;

public interface ReportsDao extends JpaRepository<Reports, Integer> {

}
