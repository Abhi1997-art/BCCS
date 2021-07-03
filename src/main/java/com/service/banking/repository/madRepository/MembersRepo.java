package com.service.banking.repository.madRepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Members;
import com.service.banking.model.GstModel.AccountDetail;
import com.service.banking.model.MadModel.MemberDetails;
import com.service.banking.model.printingModel.MemberDetail;
import com.service.banking.model.printingModel.PrintMemberDetail;
import com.service.banking.model.report.iMemberReport;
import com.service.banking.model.superAdminModel.MeberDetail;

public interface MembersRepo extends JpaRepository<Members,Integer>  {
	
	
	   
	// @Query("Select new com.service.banking.model.MadModel.MemberDetails() from Members m ,Branches b where  m.isActive =1 and m.branchId =b.id")
	@Query(value="Select new com.service.banking.model.MadModel.MemberDetails(m.id, m.memberNo, b.id, b.name as branchName ,m.title,m.name,m.cast ,m.phoneNos ,m.fatherName ,m.landmark ,m.tehsil ,m.district ,m.city, \r\n" + 
			"m.state ,m.pinCode ,m.currentAddress ,\r\n" + 
			"m.username ,m.password ,m.relationWithParent ,m.occupation ,m.dob ,m.witness1name ,m.witness1fatherName ,m.witness1address \r\n" + 
			",m.witness2name ,m.witness2fatherName ,\r\n" + 
			"m.witness2address ,m.createdAt ,m.isActive ,m.isDefaulter , m.defaulterOn, m.panNo ,m.adharNumber ,m.gstin ,m.bankbranchAId \r\n" + 
			",m.bankAccountNumber1 ,\r\n" + 
			"m.bankbranchBId ,m.bankAccountNumber2 ,m.memebrType ,m.isAgent ,a.nominee,a.nomineeAge,a.relationWithNominee \r\n" + 
			",m.relationWithFatherField, a.minorNomineeDob ,m.parentName,a.accountNumber, m.filledForm60, a.sigImageId \r\n" + 
			")from Members m,Branches b, Accounts a where  m.isActive =1 and m.branchId =b.id and m.id = a.memberId and a.accountType='SM' order by m.memberNo DESC",
			countQuery = "SELECT count(*) from Members m,Branches b where  m.isActive =1 and m.branchId =b.id")	
	public Page<MemberDetails> getAllMembers(Pageable pageable);
	    

	     // get all member for printing 
		 @Query("select new com.service.banking.model.printingModel.MemberDetail(m.id,m.name ,m.permanentAddress,m.memberNo ,m.landmark,m.isDefaulter) from  Members m where m.name LIKE %?1% ")
		 public List<MemberDetail> getPrintMember(String accountName);

		 
		       // get  member by id for printing ...................
				@Query("select new com.service.banking.model.printingModel.PrintMemberDetail(m.id,m.name ,m.permanentAddress,m.memberNo ,m.phoneNos,m.email) from  Members m where m.id=?1 ")
				public PrintMemberDetail printMember(Integer memberId);

				// get all memeber for share add and update dropdown...................................
				@Query("select new com.service.banking.model.superAdminModel.MeberDetail(m.id, m.name , CASE WHEN (m.memberNo is null) THEN 0 ELSE m.memberNo END, m.currentAddress , CASE WHEN (m.isDefaulter is null) THEN false ELSE m.isDefaulter END,m.landmark, m.name, m.id) from Members m " +  
						"where m.name LIKE %?1% or m.memberNo LIKE %?1%")
				List<MeberDetail> getMember(String memberName);

				//Search for sponsor name for MAD - Agent..............................................................................
				@Query("select new com.service.banking.model.superAdminModel.MeberDetail(m.id, m.name , CASE WHEN (m.memberNo is null) THEN 0 ELSE m.memberNo END, m.currentAddress , CASE WHEN (m.isDefaulter is null) THEN false ELSE m.isDefaulter END,m.landmark, ag.codeNo) from Members m " +  
						" left join Agents ag on ag.memberId=m.id where m.isAgent = 1 and m.name LIKE %?1% ")
				public List<MeberDetail> getSponsor(String name);


				@Query(value = "select m.member_no , b.name as branchName, m.title , m.name, m.FatherName , m.RelationWithNominee ,m.CurrentAddress , m.landmark , m.tehsil , m.city , m.PhoneNos, m.created_at ,m.is_active ,m.is_defaulter from members m\r\n"
						+ "left join branches b on m.branch_id = b.id\r\n"
						+ "order by m.member_no DESC",
						countQuery = "SELECT count(*) from members m",
						nativeQuery = true)
				public Page<iMemberReport> getMemberReport(Pageable pageable);


				@Query(value = "select a.AccountNumber , s.name as SchemeName, a.created_at, m.title , m.name , m.FatherName ,m.CurrentAddress ,m.PhoneNos ,m.DOB , m.Nominee ,m.RelationWithNominee , a.Amount from accounts a\r\n"
						+ "left join members m on m.id = a.member_id \r\n"
						+ "left join schemes s on s.id = a.scheme_id \r\n"
						+ "where (a.account_type = ?1)\r\n"
						+ "and a.created_at >= ?2 and a.created_at <= ?3 \r\n"
						+ "order by a.branch_id",
						countQuery = "SELECT count(*) from accounts a where a.account_type = ?1 and a.created_at >= ?2 and a.created_at <= ?3",
						nativeQuery = true)
				public Page<iMemberReport> getDepositeMemberInsurance1(String type, String fromDate, String toDate, Pageable pageable);
				
				@Query(value = "select a.AccountNumber , s.name as SchemeName, a.created_at, m.title , m.name , m.FatherName ,m.CurrentAddress ,m.PhoneNos ,m.DOB , m.Nominee ,m.RelationWithNominee , a.Amount from accounts a\r\n"
						+ "left join members m on m.id = a.member_id \r\n"
						+ "left join schemes s on s.id = a.scheme_id  \r\n"
						+ "where (a.account_type = \"MIS\" or a.account_type = \"FD\" or a.account_type = \"Recurring\" or a.account_type = \"DDS\")\r\n"
						+ "and a.created_at >= ?1 and a.created_at <= ?2 \r\n"
						+ "order by a.branch_id",
						countQuery = "SELECT count(*) from accounts a where (a.account_type = 'MIS' or a.account_type = 'FD' or a.account_type = 'Recurring' or a.account_type = 'DDS') and a.created_at >= ?1 and a.created_at <= ?2",
						nativeQuery = true)
				public Page<iMemberReport> getDepositeMemberInsurance2(String fromDate, String toDate, Pageable pageable);


				@Query(value = "select m.member_no , b.name as branchName, m.name, m.FatherName , m.AdharNumber ,m.CurrentAddress , m.tehsil , m.city , m.PhoneNos, m.created_at ,m.is_active ,m.defaulter_on from members m\r\n"
						+ "left join branches b on b.id = m.branch_id \r\n"
						+ "where m.is_defaulter = 1\r\n"
						+ "and m.defaulter_on >= ?1 and m.defaulter_on <= ?2 \r\n"
						+ "order by m.member_no desc",
						countQuery = "SELECT count(*) from members m where m.is_defaulter = 1 and  m.defaulter_on >= ?1 and m.defaulter_on <= ?2",
						nativeQuery = true)
				public Page<iMemberReport> getDefaulterList(String fromDate, String toDate, Pageable pageable);
}
