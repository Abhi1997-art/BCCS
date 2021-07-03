package com.service.banking.repository.AccountsRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.banking.hibernateEntity.Jointmembers;

public interface JointMemberRepo extends JpaRepository<Jointmembers, Integer>{

}
