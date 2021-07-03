package com.service.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.banking.model.LoginUserDeails;
import com.service.banking.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginrepository;
	
	public LoginUserDeails getuser(String username,String password)
	{
		
		LoginUserDeails loginUserDeails=loginrepository.findUserbyNameandPass(username, password);
		//System.out.println("####333*****"+loginUserDeails+"####");
		//System.out.println("***************"+loginUserDeails+"####");
		System.out.println("******name*********"+loginUserDeails.getName());
		return loginUserDeails;
		
	}


}
