package com.service.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Staffs;
import com.service.banking.model.LoginUserDeails;

public interface LoginRepository extends JpaRepository<Staffs, Integer> {

	// login  user deatils...........
	@Query("select new com.service.banking.model.LoginUserDeails(s.id,s.username ,s.branchId ,s.accessLevel ,s.name ,s.fatherName ,s.createdAt ,s.mobileNo ,s.isActive ,s.role,s.accountNo)from Staffs s where username=?1 and password=?2")
	LoginUserDeails findUserbyNameandPass(String username,String password);
}
