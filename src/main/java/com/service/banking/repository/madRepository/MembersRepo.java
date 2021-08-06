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
	@Query("select new com.service.banking.model.MadModel.MemberDetails(m.id, m.memberNo, b.id, b.name as branchName ,m.title,m.name,m.cast ,m.phoneNos ,m.fatherName ,m.landmark ,m.tehsil ,m.district ,m.city, \r\n" + 
			"m.state ,m.pinCode ,m.currentAddress ,\r\n" + 
			"m.username ,m.password ,m.relationWithParent ,m.occupation ,m.dob ,m.witness1name ,m.witness1fatherName ,m.witness1address \r\n" + 
			",m.witness2name ,m.witness2fatherName ,\r\n" + 
			"m.witness2address ,m.createdAt ,m.isActive ,m.isDefaulter , m.defaulterOn, m.panNo ,m.adharNumber ,m.gstin ,m.bankbranchAId \r\n" + 
			",m.bankAccountNumber1 ,\r\n" + 
			"m.bankbranchBId ,m.bankAccountNumber2 ,m.memebrType ,m.isAgent ,a.nominee,a.nomineeAge,a.relationWithNominee \r\n" + 
			",m.relationWithFatherField, a.minorNomineeDob ,m.parentName,a.accountNumber, m.filledForm60, a.sigImageId, count(s.id), bb.name, bb2.name, bb.ifsc, bb2.ifsc \r\n" + 
			") from Members m "
			+ "left join Branches b on m.branchId = b.id "
			+ "left join Accounts a on m.id = a.memberId "
			+ "left join Share s on s.currentMemberId = m.id "
			+ "left join BankBranches bb on bb.id = m.bankbranchAId "
			+ "left join BankBranches bb2 on bb2.id = m.bankbranchBId "
			+ "where m.name like ?1% or m.memberNo  like ?1% "
			+ "group by m.id order by m.id DESC")	
	public Page<MemberDetails> getAllMembers(Pageable pageable, String search);	    

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
				@Query("select new com.service.banking.model.superAdminModel.MeberDetail(ag.id, m.name , CASE WHEN (m.memberNo is null) THEN 0 ELSE m.memberNo END, m.currentAddress , CASE WHEN (m.isDefaulter is null) THEN false ELSE m.isDefaulter END,m.landmark, ag.codeNo, m.name) from Members m " +  
						" left join Agents ag on ag.memberId=m.id where m.isAgent = 1 and m.name LIKE %?1% ")
				public List<MeberDetail> getSponsor(String name);


				@Query(value = "select  m.member_no , b.name as branchName, m.title , m.name, m.FatherName , m.RelationWithFatherField ,m.CurrentAddress , m.landmark , m.tehsil , m.city , m.PhoneNos, m.created_at ,m.is_active ,m.is_defaulter,\r\n"
						+ "m.PanNo , m.AdharNumber, m.memebr_type from members m\r\n"
						+ "left join branches b on m.branch_id = b.id\r\n"
						+ "left join accounts a on a.member_id =m.id \r\n"
						+ "where concat(m.AdharNumber, m.PhoneNos, m.PanNo, m.name) like %?1% "
						+ "order by m.member_no desc",
						countQuery = "SELECT count(*) from members m where concat(m.AdharNumber, m.PhoneNos, m.PanNo, m.name) like ?1%",
						nativeQuery = true)
				public Page<iMemberReport> getMemberReport(String search, Pageable pageable);


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


				@Query(value = "select m.member_no , m.name , count(case when a.account_type = 'SM' then 1 else null end ) as counts from members m \r\n"
						+ "left join accounts a on a.member_id = m.id\r\n"
						+ "group by m.id ",
						nativeQuery = true)
				public List<iMemberReport> getMemberWithoutSM();


				@Query(value = "select m.id , m.member_no , m.name , count(a.id) as counts from members m \r\n"
						+ "left join accounts a on a.member_id = m.id\r\n"
						+ "where a.account_type = 'SM'\r\n"
						+ "group by m.id\r\n"
						+ "having count(a.id) > 1",
						nativeQuery = true)
				public List<iMemberReport> getMemberWithMultipleSM();


				@Query(value = "select m.id from members m \r\n"
						+ "left join branches b on b.id = m.branch_id \r\n"
						+ "where m.name like '%Default' and b.id = ?1",
						nativeQuery = true)
				public Integer getDefaultBranchMember(Integer id);

				@Query(value = "select m.member_no from members m \r\n"
						+ "order by m.id DESC\r\n"
						+ "limit 1 ",
						nativeQuery = true)
				public Integer getLastMemberNo();




				
}
