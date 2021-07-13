package com.service.banking.repository.dashBoardRepo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Schemes;
import com.service.banking.model.dashboardModel.CCSchemaDetails;
import com.service.banking.model.dashboardModel.DDSSchemaDetails;
import com.service.banking.model.dashboardModel.DefaultSchemaDetails;
import com.service.banking.model.dashboardModel.FixedSchemaDetails;
import com.service.banking.model.dashboardModel.LoanSchemaDetails;
import com.service.banking.model.dashboardModel.RecurringSchemaDetails;
import com.service.banking.model.dashboardModel.SavingSchemaDetails;
import com.service.banking.model.dashboardModel.SchemaDetail;
import com.service.banking.model.superAdminModel.SchemeDetails;

public interface DashBoardSchemeRepo extends JpaRepository<Schemes, Integer> {

	// Get CC type - scheme..........................
	@Query("select new  com.service.banking.model.dashboardModel.CCSchemaDetails(count(distinct  a.id) as totalAccounts,count(distinct  an.id) as activeAccounts,s.id,s.name,s.interest,s.processingFees ,CASE WHEN (s.validTill is null or s.validTill='00:00:0000')  THEN '0001-11-30' ELSE s.validTill END,s.activeStatus, s.maxLimit, s.minLimit, blnc.name, s.createdAt) from Schemes s "
			+ "left join Accounts a on a.schemeId =s.id " + "left join BalanceSheet blnc on blnc.id=s.balanceSheetId "
			+ "left join Accounts an on an.schemeId =s.id and an.activeStatus =1  "
			+ " WHERE s.schemeType = 'cc' group by(s.name) ")
	List<CCSchemaDetails> getccScheme(String schemeType);

	// Get DDS type - scheme..........................
	@Query("select new  com.service.banking.model.dashboardModel.DDSSchemaDetails(s.id,s.name,s.interest,s.maturityPeriod ,s.crpb,s.accountOpenningCommission,s.collectorCommissionRate,s.percentLoanOnDeposit,s.noLoanOnDepositTill, "
			+ "s.preMatureInterests,CASE WHEN (s.validTill is null or s.validTill='00:00:0000')  THEN '0001-11-30' ELSE s.validTill END,s.activeStatus,s.maxLimit ,s.minLimit, s.createdAt) from Schemes s "
			+ " WHERE s.schemeType = 'dds' ")
	List<DDSSchemaDetails> getDdsScheme(String schemeType);

	// Get Default type - scheme..........................
	@Query("select new  com.service.banking.model.dashboardModel.DefaultSchemaDetails(count(distinct  a.id) as totalAccounts, s.id , s.name, s.isDepriciable ,s.depriciationPercentBeforeSep ,s.depriciationPercentAfterSep, s.validTill,s.activeStatus,s.minLimit ,s.maxLimit,blnc.name, s.createdAt) from Schemes s \r\n"
			+ " left join Accounts a on a.schemeId =s.id \r\n"
			+ "left join BalanceSheet blnc on blnc.id=s.balanceSheetId "
			+ " WHERE s.schemeType = 'Default' \r\n" + " group by(s.id) ")
	List<DefaultSchemaDetails> getDefaultScheme(String schemeType);

	// Get fixandMis type schema ..................................
	@Query("select new  com.service.banking.model.dashboardModel.FixedSchemaDetails(count(distinct  a.id) as totalAccounts,count(distinct  an.id) as activeAccounts,s.type,s.id ,s.name,s.interest, s.accountOpenningCommission ,s.crpb ,s.maturityPeriod ,s.percentLoanOnDeposit ,s.noLoanOnDepositTill ,s.preMatureInterests,CASE WHEN (s.validTill is null or s.validTill='00:00:0000')  THEN '0001-11-30' ELSE s.validTill END,s.activeStatus,s.maxLimit ,s.minLimit,blnc.name, s.createdAt) from Schemes s \r\n"
			+ " left join Accounts a on a.schemeId =s.id \r\n"
			+ "left join BalanceSheet blnc on blnc.id=s.balanceSheetId "
			+ " left join Accounts an on an.schemeId =s.id and an.activeStatus =1  \r\n"
			+ " where s.schemeType='FixedAndMis' \r\n" + " group by(s.name) ")
	List<FixedSchemaDetails> getcfixAndMisScheme(String schemeType);

	// Get Loan type schema ..................................
	@Query("select new  com.service.banking.model.dashboardModel.LoanSchemaDetails(count(distinct  a.id) as totalAccounts,count(distinct  an.id) as activeAccounts,s.id ,s.type,s.name,s.interest,s.premiumMode,s.numberOfPremiums,s.processingFees , s.activeStatus,CASE WHEN (s.validTill is null or s.validTill='00:00:0000')  THEN '0001-11-30' ELSE s.validTill END,s.maxLimit ,s.minLimit,blnc.name,s.createdAt, s.panelty,s.paneltyGrace, s.processingFeesinPercent) from Schemes s \r\n"
			+ " left join Accounts a on a.schemeId =s.id \r\n"
			+ "left join BalanceSheet blnc on blnc.id=s.balanceSheetId "
			+ " left join Accounts an on an.schemeId =s.id and an.activeStatus =1  \r\n"
			+ " WHERE s.schemeType = 'loan' \r\n" + " group by(s.name) ")
	List<LoanSchemaDetails> getloanScheme(String schemeType);

	// Get Recurring type - schema .......................................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.RecurringSchemaDetails(count(distinct  a.id) as totalAccounts,count(distinct  an.id) as activeAccounts,s.id ,s.name,s.interest,s.maturityPeriod ,s.premiumMode ,s.numberOfPremiums,s.crpb ,s.accountOpenningCommission ,s.collectorCommissionRate ,s.percentLoanOnDeposit ,"
			+ "s.noLoanOnDepositTill ,s.preMatureInterests,CASE WHEN (s.validTill is null or s.validTill='00:00:0000')  THEN '0001-11-30' ELSE s.validTill END,s.maxLimit ,s.minLimit,blnc.name, s.createdAt, s.matureInterestsForUncompleteProduct) from Schemes s "
			+ " left join Accounts a on a.schemeId =s.id " + "left join BalanceSheet blnc on blnc.id=s.balanceSheetId "
			+ " left join Accounts an on an.schemeId =s.id and an.activeStatus =1  "
			+ " where s.schemeType = 'Recurring' group by(s.name) ")
	List<RecurringSchemaDetails> getRecurringScheme(String schemeType);

	// Get Saving and Current type - schema ...............................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.SavingSchemaDetails(count(distinct  a.id) as totalAccounts,count(distinct  an.id) as activeAccounts,s.id,s.name,s.interest ,s.type ,CASE WHEN (s.validTill is null or s.validTill='00:00:0000')  THEN '0001-11-30' ELSE s.validTill END,s.maxLimit ,s.minLimit, s.createdAt) from Schemes s \r\n"
			+ " left join Accounts a on a.schemeId =s.id \r\n"
			+ " left join Accounts an on an.schemeId =s.id and an.activeStatus =1  \r\n"
			+ " WHERE  s.schemeType='SavingAndCurrent' \r\n" + " group by(s.name) ")
	List<SavingSchemaDetails> getsavingAndCurrentScheme(String schemeType);

	// Get DDS2 type - schema ..............................................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.SchemaDetail(count(distinct  a.id) as totalAccounts,count(distinct  an.id) as activeAccounts,s.id, s.name,s.interest ,s.processingFees ,CASE WHEN (s.validTill is null or s.validTill='00:00:0000')  THEN '0001-11-30' ELSE s.validTill END,s.maxLimit ,s.minLimit,blnc.name, s.createdAt, s.crpb, s.percentLoanOnDeposit, s.noLoanOnDepositTill, s.preMatureInterests, s.matureInterestsForUncompleteProduct, s.maturityPeriod, s.commission, s.collectorCommissionRate, s.accountOpenningCommission, s.premiumMode) from Schemes s \r\n"
			+ " left join Accounts a on a.schemeId =s.id \r\n"
			+ " left join BalanceSheet blnc on blnc.id=s.balanceSheetId "
			+ " left join Accounts an on an.schemeId =s.id and an.activeStatus =1  \r\n" + " WHERE  s.type='dds2'  \r\n"
			+ " group by(s.name) ")
	List<SchemaDetail> getDds2Schema(String schemeType);

	@Query("from Schemes")
	List<Schemes> schemes();

	@Query("Select new com.service.banking.model.dashboardModel.SchemaDetail(s.id,s.name) from Schemes s where s.name like %?1%")
	List<SchemaDetail> getSchemesSM(String name);

	@Query("Select new com.service.banking.model.dashboardModel.SchemaDetail(s.id, s.interest, s.preMatureInterests, s.matureInterestsForUncompleteProduct, s.maturityPeriod) from Schemes s left join Accounts a on a.schemeId=s.id where a.id=?1 ")
	SchemaDetail getSchemeByAccountId(Integer id);

	@Query("Select new com.service.banking.model.dashboardModel.SchemaDetail(s.id, s.interest, s.preMatureInterests, s.matureInterestsForUncompleteProduct, s.maturityPeriod, s.balanceSheetId) from Schemes s left join Accounts a on a.schemeId=s.id where a.id=?1 ")
	SchemaDetail getSchemeById(Integer scheme);




}
