package com.service.banking.repository.hodAuthorityRepo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Xlog;
import com.service.banking.model.hodAuthorityModel.LogCheckDetails;
import com.service.banking.model.hodAuthorityModel.LogCheckModel;
import com.service.banking.model.hodAuthorityModel.PremiumDetails;

public interface LogCheckRepo extends JpaRepository<Xlog, Integer> {
	// get all loged user.............................
	// @Query("select x.id,s.name,x.modelClass ,x.pkId ,x.createdAt ,x.name
	// ,x.type,a.accountNumber ,m.name,m.fatherName from Xlog x ,Accounts a ,Staffs
	// s ,Members m where x.staffId =s.id and a.staffId = x.staffId and a.memberId
	// =m.id")
	// List<Object> alllogCheck();

	@Query("select new com.service.banking.model.hodAuthorityModel.LogCheckDetails(x.id,s.name as staffName,x.modelClass ,x.pkId ,x.createdAt ,x.name ,x.type,a.accountNumber ,m.name as memberName,m.fatherName) from Xlog x  "
			+"left join Staffs s on s.id=x.staffId "
			+"left join Accounts a on a.staffId =s.id "
			+"left join Members m on m.id =a.memberId "
			+ "where  x.createdAt >=?1 and x.createdAt <=?2 ")
	//List<LogCheckDetails> alllogCheck();
    List<LogCheckDetails> alllogCheck(Date fromdate,Date todate);
	
	
	// get all model for log check search.......................
	@Query("select DISTINCT new com.service.banking.model.hodAuthorityModel.LogCheckModel (x.modelClass) from Xlog x")
	List<LogCheckModel> logCheckModel();

}
