package com.service.banking.repository.madRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Dealers;
import com.service.banking.model.MadModel.DealerDeatails;
import com.service.banking.model.accountsModel.LoanAccountDetails;
import com.service.banking.model.report.iDealerReport;
import com.service.banking.model.report.iLoanReport;

public interface DealerRepository extends JpaRepository<Dealers,Integer> {
	 
	
	@Query("select new com.service.banking.model.MadModel.DealerDeatails(d.id,d.name,d.address,d.loanPaneltyPerDay,d.timeOverCharge,d.dealerMonthlyDate,d.properitorName,d.properitorPhoneNo1,d.properitorPhoneNo2,d.emailId1,"
			+ "d.emailId2,d.product,d.activeStatus,d.username,d.password,ds.name as dsName,ds.id as dsId) from Dealers d \r\n" + 
			"left join Dsa ds on d.dsa.id=ds.id order by d.id DESC")
	List<DealerDeatails> getAllDealers();

	@Query("Select new com.service.banking.model.accountsModel.LoanAccountDetails(d.id, "
			+ " d.name) from Dealers d "
			+ "where CONCAT(d.id , REPLACE(d.name, ' ', '') ) like %?1% or CONCAT( REPLACE(d.name, ' ', ''), d.id ) like %?1% ")
	public List<LoanAccountDetails> getDealerList(String name);

	
	@Query(value = "select d.id, d.name , d.Address , d.loan_panelty_per_day ,\r\n"
			+ "d.time_over_charge , d.dealer_monthly_date ,\r\n"
			+ "d.properitor_name ,d.properitor_phone_no_1 ,d.properitor_phone_no_2,\r\n"
			+ "d.email_id_1 ,d.email_id_2 ,\r\n"
			+ "d.product , d.dsa_id ,d.ActiveStatus ,\r\n"
			+ "d.username, d.password from dealers d  \r\n"
			+ "where d.id = ?1",
			nativeQuery = true)
	public List<iDealerReport> getDealerReport(Integer dealerId);

	@Query(value="select  a.AccountNumber, m.name , m.FatherName ,m.PermanentAddress ,m.PhoneNos , a.LoanInsurranceDate , a.insurance_tenure, d.name as dealerName,\r\n"
			+ "DATE_ADD(a.created_at , INTERVAL  s.NumberOfPremiums MONTH) as MaturityDate from dealers d \r\n"
			+ "left join accounts a on a.dealer_id =d.id \r\n"
			+ "left join members m on m.id= a.member_id \r\n"
			+ "left join schemes s on s.id=a.scheme_id \r\n"
			+ "where d.id = ?1 and a.ActiveStatus = 1\r\n"
			+ "order by a.id DESC",nativeQuery=true)
	List<iLoanReport> getInsuranceDueListReport(Integer dealerId);

	@Query(value="select  a.AccountNumber,a.created_at ,m.name , m.FatherName ,m.CurrentAddress ,\r\n"
			+ "s.name as schemeName,m.PhoneNos , a.Nominee , a.MinorNomineeParentName , a.Amount , s.NumberOfPremiums , a.LoanInsurranceDate , a.insurance_tenure\r\n"
			+ "from dealers d \r\n"
			+ "left join accounts a on a.dealer_id =d.id \r\n"
			+ "left join members m on m.id= a.member_id \r\n"
			+ "left join schemes s on s.id=a.scheme_id \r\n"
			+ "where d.id = ?1",nativeQuery=true)
	List<iLoanReport> getLoanDispatchReport(Integer dealerId);

	@Query(value="select  a.AccountNumber,a.created_at ,m.name , m.FatherName ,m.CurrentAddress , d.name as dealerName,\r\n"
			+ "s.name as schemeName ,m.PhoneNos  ,DATE_ADD(a.created_at , INTERVAL  s.NumberOfPremiums MONTH) as MaturityDate from dealers d \r\n"
			+ "left join accounts a on a.dealer_id =d.id \r\n"
			+ "left join members m on m.id= a.member_id \r\n"
			+ "left join schemes s on s.id=a.scheme_id \r\n"
			+ "where d.id = ?1 and a.ActiveStatus =1\r\n"
			+ "order by a.id desc",nativeQuery=true)
	List<iLoanReport> getDueListReport(Integer dealerId);

	@Query(value="select  a.AccountNumber,a.created_at ,m.name , m.FatherName ,m.CurrentAddress , d.id as dealerId,a.ActiveStatus,a.Amount ,\r\n"
			+ "s.name as schemeName,m.PhoneNos  from dealers d \r\n"
			+ "left join accounts a on a.dealer_id =d.id \r\n"
			+ "left join members m on m.id= a.member_id \r\n"
			+ "left join schemes s on s.id=a.scheme_id \r\n"
			+ "where d.id = ?1 and a.ActiveStatus = ?2",nativeQuery=true)
	List<iLoanReport> getDealerStatementReport(Integer dealerId, Boolean activeStatus);

	@Query(value="select d.name, count(a.id) as countAccounts, sum(a.Amount) as sumAmount from dealers d \r\n"
			+ "left join dsa d2 on d2.id=d.dsa_id \r\n"
			+ "left join accounts a on a.dealer_id =d.id \r\n"
			+ "group by d.id",nativeQuery=true)
	List<iLoanReport> getDealerWiseLoanReport();

}
