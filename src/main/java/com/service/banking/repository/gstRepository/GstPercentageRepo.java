package com.service.banking.repository.gstRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.banking.hibernateEntity.GstPercentage;

public interface GstPercentageRepo extends JpaRepository<GstPercentage, Integer>{

}
