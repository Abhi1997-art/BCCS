package com.service.banking.repository.madRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.banking.hibernateEntity.AgentGuarantors;

public interface AgentGuarantorRepo extends JpaRepository<AgentGuarantors, Integer>{

}