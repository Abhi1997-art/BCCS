package com.service.banking.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.service.banking.hibernateEntity.Accounts;
import com.service.banking.hibernateEntity.Premiums;
import com.service.banking.hibernateEntity.Schemes;
import com.service.banking.model.accountsModel.DueToGiveList;
import com.service.banking.model.dashboardModel.AccountsDetails;
import com.service.banking.model.dashboardModel.AccountsOpenTodayDetails;
import com.service.banking.model.dashboardModel.CCSchemaDetails;
import com.service.banking.model.dashboardModel.DDSSchemaDetails;
import com.service.banking.model.dashboardModel.DailyDueResultModel;
import com.service.banking.model.dashboardModel.DefaultSchemaDetails;
import com.service.banking.model.dashboardModel.DueDeatailsModel;
import com.service.banking.model.dashboardModel.DueTotalSize;
import com.service.banking.model.dashboardModel.FixedSchemaDetails;
import com.service.banking.model.dashboardModel.InsurenceDueList;
import com.service.banking.model.dashboardModel.LoanSchemaDetails;
import com.service.banking.model.dashboardModel.MonthlyDao;
import com.service.banking.model.dashboardModel.PremiusDetails;
import com.service.banking.model.dashboardModel.RecurringSchemaDetails;
import com.service.banking.model.dashboardModel.SavingSchemaDetails;
import com.service.banking.model.dashboardModel.SchemaDetail;
import com.service.banking.model.dashboardModel.iAccountDetails;
import com.service.banking.model.dashboardModel.iCashBankReport;
import com.service.banking.model.dashboardModel.iDefaultScheme;
import com.service.banking.repository.AccountsRepo.AccountsRepo;
import com.service.banking.repository.dashBoardRepo.AccountsOpenTodayRepo;
import com.service.banking.repository.dashBoardRepo.DailyDueRepository;
import com.service.banking.repository.dashBoardRepo.DashBoardSchemeRepo;
import com.service.banking.repository.dashBoardRepo.InsuranceDueListRepo;
import com.service.banking.repository.transaction.TransactionRowRepo;
import com.service.banking.utils.DateFormater;

@Service
public class DashBoardService {

	// Due Repository for dailydue,monthlydue,weeklydue............
	@Autowired
	DailyDueRepository dailyduerepo;

	// Insurance Repository for insurance due List.................
	@Autowired
	InsuranceDueListRepo insurenceduerepo;

	// schema repository.............
	@Autowired
	DashBoardSchemeRepo schemeRepo;

	// accounts open today repository.................................

	@Autowired
	AccountsOpenTodayRepo accountsOpenTodayRepo;

	@Autowired
	AccountsRepo acountsRepo;
	
	@Autowired
	TransactionRowRepo transactionRowRepo;

	private SessionFactory hibernateFactory;

	@Autowired
	public DashBoardService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.hibernateFactory = factory.unwrap(SessionFactory.class);
		// System.out.println("********"+hibernateFactory);
	}

	// recurring due to give list....................
	@SuppressWarnings("deprecation")
	public List<DueToGiveList> RecurringToGiveLists(String startDATE, String lastDATE) {

		List<DueToGiveList> newArrDueToGiveLists = new ArrayList<DueToGiveList>();
		String startDate = startDATE;
		String lastDate = lastDATE;
		Session s = hibernateFactory.openSession();

		@SuppressWarnings("rawtypes")
		SQLQuery sq = s.createSQLQuery(
				"SELECT DISTINCT a.id as accountId,a.AccountNumber ,m.name as membername, m.FatherName ,m.PermanentAddress as permanentaddress ,m.PhoneNos,a.CurrentBalanceCr,a.CurrentInterest ,\r\n"
						+ "DATE_ADD(DATE(a.created_at) , INTERVAL sch.MaturityPeriod MONTH),\r\n"
						+ "agnt.code_no ,mg.name,mg.member_no ,mg.PermanentAddress as agentaddress,mg.landmark ,mg.is_defaulter, a.member_id \r\n"
						+ "FROM accounts a \r\n" + "left join schemes sch on sch.id=a.scheme_id \r\n"
						+ "left join members m on m.id=a.member_id \r\n"
						+ "left  join agents agnt on agnt.id=a.agent_id \r\n"
						+ "left join members mg on agnt.member_id =mg.id \r\n"
						+ "WHERE  a.account_type ='Recurring' and  a.ActiveStatus = 1 and a.DefaultAC =0  and sch.SchemeType ='Recurring' \r\n"
						+ "and DATE_ADD(DATE(a.created_at) , INTERVAL sch.MaturityPeriod MONTH) <='" + lastDate
						+ "'  \r\n" + "and DATE_ADD(DATE(a.created_at) , INTERVAL sch.MaturityPeriod MONTH) >='"
						+ startDate + "' ");
		List<Object[]> result = sq.list();
		for (Object[] row : result) {

			DueToGiveList dataobj = new DueToGiveList();

			try {
				dataobj.setId((Integer) (row[0]));
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setId(0);
			}
			try {
				dataobj.setAccountNumber(row[1].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setAccountNumber("");
			}
			try {
				dataobj.setMemberName(row[2].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setMemberName("");
			}
			try {
				dataobj.setFatherName(row[3].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setFatherName("");
			}

			try {
				dataobj.setPermanentAddress(row[4].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setPermanentAddress("");
			}
			try {
				dataobj.setPhoneNos(row[5].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setPhoneNos("");
			}
			try {
				dataobj.setCurrentBalanceCr((BigDecimal) row[6]);
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setCurrentBalanceCr(new BigDecimal("0.000000000"));
			}
			try {
				dataobj.setCurrentInterest(row[7].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setCurrentInterest("");
			}

			try {
				dataobj.setDueDate(DateFormater.getformatDate((Date) row[8]));

			} catch (NullPointerException e) {
				// TODO: handle exception
				// dataobj.setMaturityDate((Date)row[8]);
			}
			try {
				dataobj.setCodeNo((Integer) row[9]);
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setCodeNo(0);
			}
			try {
				dataobj.setAgentName(row[10].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setAgentName("");
			}
			try {
				dataobj.setMember_no((Integer) row[11]);
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setMember_no(0);
			}
			try {
				dataobj.setAgentAddress(row[12].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setCurrentInterest("");
			}
			try {
				dataobj.setLandmark(row[13].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setLandmark("");
			}
			try {
				dataobj.setIsDefaulter((Boolean) row[14]);  //setMemberId
			} catch (NullPointerException e) {
				// TODO: handle exception
				// dataobj.setIsDefaulter((Boolean)row[14]);
			}
				
				try {
					dataobj.setMemberId((Integer) (row[15]));
				} catch (NullPointerException e) {
					// TODO: handle exception
					dataobj.setMemberId(0);
				}
				
			newArrDueToGiveLists.add(dataobj);
			// System.out.println(dataobj);
		}

		System.out.print("***" + newArrDueToGiveLists.size());
		s.close();
		return newArrDueToGiveLists;
	}

	// FD AND MIS due to give list....................
	@SuppressWarnings("deprecation")
	public List<DueToGiveList> FDMISToGiveLists(String startDATE, String lastDATE) {

		List<DueToGiveList> newArrDueToGiveLists = new ArrayList<DueToGiveList>();
		String startDate = startDATE;
		String lastDate = lastDATE;
		Session s = hibernateFactory.openSession();

		@SuppressWarnings("rawtypes")
		SQLQuery sq = s.createSQLQuery(
				"SELECT  a.id as accountId,a.AccountNumber ,m.name as membername, m.FatherName ,m.PermanentAddress as permanentaddress ,m.PhoneNos,a.CurrentBalanceCr,a.CurrentInterest ,\r\n"
						+ "DATE_ADD(DATE(a.created_at) , INTERVAL sch.MaturityPeriod DAY),\r\n"
						+ "agnt.code_no ,mg.name,mg.member_no ,mg.PermanentAddress as agentaddress,mg.landmark ,mg.is_defaulter, m.id \r\n"
						+ "FROM accounts a \r\n" + "left join schemes sch on sch.id=a.scheme_id \r\n"
						+ "left join members m on m.id=a.member_id \r\n"
						+ "left  join agents agnt on agnt.id=a.agent_id \r\n"
						+ "left join members mg on agnt.member_id =mg.id \r\n"
						+ "WHERE  a.account_type in ('FD', 'MIS') and  a.ActiveStatus = 1 and a.DefaultAC =0  and sch.SchemeType ='FixedAndMis' \r\n"
						+ "and DATE_ADD(DATE(a.created_at) , INTERVAL sch.MaturityPeriod DAY) <='" + lastDate
						+ "'  \r\n" + "and DATE_ADD(DATE(a.created_at) , INTERVAL sch.MaturityPeriod DAY) >='"
						+ startDate + "' ");
		List<Object[]> result = sq.list();
		for (Object[] row : result) {

			DueToGiveList dataobj = new DueToGiveList();
			try {
				dataobj.setId((Integer) (row[0]));
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setId(0);
			}
			try {
				dataobj.setAccountNumber(row[1].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setAccountNumber("");
			}
			try {
				dataobj.setMemberName(row[2].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setMemberName("");
			}
			try {
				dataobj.setFatherName(row[3].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setFatherName("");
			}

			try {
				dataobj.setPermanentAddress(row[4].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setPermanentAddress("");
			}
			try {
				dataobj.setPhoneNos(row[5].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setPhoneNos("");
			}
			try {
				dataobj.setCurrentBalanceCr((BigDecimal) row[6]);
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setCurrentBalanceCr(new BigDecimal("0.000000000"));
			}
			try {
				dataobj.setCurrentInterest(row[7].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setCurrentInterest("");
			}

			try {
				dataobj.setDueDate(DateFormater.getformatDate((Date) row[8]));
			} catch (NullPointerException e) {
				// TODO: handle exception
				// dataobj.setMaturityDate((Date)row[8]);
			}
			try {
				dataobj.setCodeNo((Integer) row[9]);
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setCodeNo(0);
			}
			try {
				dataobj.setAgentName(row[10].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setAgentName("");
			}
			try {
				dataobj.setMember_no((Integer) row[11]);
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setMember_no(0);
			}
			try {
				dataobj.setAgentAddress(row[12].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setCurrentInterest("");
			}
			try {
				dataobj.setLandmark(row[13].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setLandmark("");
			}
			try {
				dataobj.setIsDefaulter((Boolean) row[14]);
			} catch (NullPointerException e) {
				// TODO: handle exception
				// dataobj.setIsDefaulter((Boolean)row[14]);

			}
			try {
				dataobj.setMemberId((Integer) row[15]);
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setMemberId(0);
			}
			newArrDueToGiveLists.add(dataobj);
			// System.out.println(dataobj);
		}

		System.out.print("***" + newArrDueToGiveLists.size());
		s.close();
		return newArrDueToGiveLists;
	}

	// DDS due to give list....................
	@SuppressWarnings("deprecation")
	public List<DueToGiveList> DDSToGiveLists(String startDATE, String lastDATE) {

		List<DueToGiveList> newArrDueToGiveLists = new ArrayList<DueToGiveList>();
		String startDate = startDATE;
		String lastDate = lastDATE;
		Session s = hibernateFactory.openSession();

		@SuppressWarnings("rawtypes")
		SQLQuery sq = s.createSQLQuery(
				"SELECT DISTINCT a.id as accountId,a.AccountNumber , m.name as membername, m.FatherName ,m.PermanentAddress as permanentaddress ,m.PhoneNos,a.CurrentBalanceCr,a.CurrentInterest ,\r\n"
						+ "DATE_ADD(DATE(a.created_at) , INTERVAL sch.MaturityPeriod MONTH),\r\n"
						+ "agnt.code_no ,mg.name,mg.member_no ,mg.PermanentAddress as agentaddress, mg.landmark ,mg.is_defaulter, m.id \r\n"
						+ "FROM accounts a \r\n" + "left join schemes sch on sch.id=a.scheme_id \r\n"
						+ "left join members m on m.id=a.member_id \r\n"
						+ "left  join agents agnt on agnt.id=a.agent_id \r\n"
						+ "left join members mg on agnt.member_id =mg.id \r\n"
						+ "WHERE  a.account_type ='DDS' and  a.ActiveStatus = 1 and a.DefaultAC =0  and sch.SchemeType ='DDS' \r\n"
						+ "and DATE_ADD(DATE(a.created_at) , INTERVAL sch.MaturityPeriod MONTH) <='" + lastDate
						+ "'  \r\n" + "and DATE_ADD(DATE(a.created_at) , INTERVAL sch.MaturityPeriod MONTH) >='"
						+ startDate + "' ");
		List<Object[]> result = sq.list();
		for (Object[] row : result) {

			DueToGiveList dataobj = new DueToGiveList();
			try {
				dataobj.setId((Integer) (row[0]));
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setId(0);
			}
			try {
				dataobj.setAccountNumber(row[1].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setAccountNumber("");
			}
			try {
				dataobj.setMemberName(row[2].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setMemberName("");
			}
			try {
				dataobj.setFatherName(row[3].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setFatherName("");
			}

			try {
				dataobj.setPermanentAddress(row[4].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setPermanentAddress("");
			}
			try {
				dataobj.setPhoneNos(row[5].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setPhoneNos("");
			}
			try {
				dataobj.setCurrentBalanceCr((BigDecimal) row[6]);
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setCurrentBalanceCr(new BigDecimal("0.000000000"));
			}
			try {
				dataobj.setCurrentInterest(row[7].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setCurrentInterest("");
			}

			try {
				dataobj.setDueDate(DateFormater.getformatDate((Date) row[8]));
			} catch (NullPointerException e) {
				// TODO: handle exception
				// dataobj.setMaturityDate((Date)row[8]);
			}
			try {
				dataobj.setCodeNo((Integer) row[9]);
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setCodeNo(0);
			}
			try {
				dataobj.setAgentName(row[10].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setAgentName("");
			}
			try {
				dataobj.setMember_no((Integer) row[11]);
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setMember_no(0);
			}
			try {
				dataobj.setAgentAddress(row[12].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setCurrentInterest("");
			}
			try {
				dataobj.setLandmark(row[13].toString());
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setLandmark("");
			}
			try {
				dataobj.setIsDefaulter((Boolean) row[14]);
			} catch (NullPointerException e) {
				// TODO: handle exception
				// dataobj.setIsDefaulter((Boolean)row[14]);

			}
			try {
				dataobj.setMemberId((Integer) row[15]);
			} catch (NullPointerException e) {
				// TODO: handle exception
				dataobj.setMemberId(0);
			}
			newArrDueToGiveLists.add(dataobj);
			// System.out.println(dataobj);
		}

		System.out.print("***" + newArrDueToGiveLists.size());
		s.close();
		return newArrDueToGiveLists;
	}

	// get new dds.........................................................
	public List<Accounts> dsss() {
		List<Accounts> dueList = acountsRepo.getDDSAcccccccccount();
		if (dueList.size() != 0) {
			return dueList;
		} else {
			return new ArrayList<Accounts>();

		}
	}

	//Get DDS daily due ...........................................................................................
	public List<DueDeatailsModel> getDdsDailyDue(Date dueDate) {
		List<DueDeatailsModel> dueList = dailyduerepo.getDdsDailyDue(dueDate);
		if (dueList.size() != 0) {
			return dueList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}

	//Get Recurring daily due .......................................................................................
	public List<DueDeatailsModel> getRecurringDailyDue(Date dueDate) {
		List<DueDeatailsModel> dueList = dailyduerepo.getRecurringDailyDue(dueDate);
		if (dueList.size() != 0) {
			return dueList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}
	
	
	//Get HL daily due .......................................................................................
	public List<DueDeatailsModel> getHLDailyDue(Date dueDate) {
		List<DueDeatailsModel> dueList = dailyduerepo.getHLDailyDue(dueDate);
		if (dueList.size() != 0) {
			return dueList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}
	
	//Get ML daily due .......................................................................................
	public List<DueDeatailsModel> getMLDailyDue(Date dueDate) {
		List<DueDeatailsModel> dueList = dailyduerepo.getMLDailyDue(dueDate);
		if (dueList.size() != 0) {
			return dueList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}
	
	//Get VL daily due .......................................................................................
	public List<DueDeatailsModel> getVLDailyDue(Date dueDate) {
		List<DueDeatailsModel> dueList = dailyduerepo.getVLDailyDue(dueDate);
		if (dueList.size() != 0) {
			return dueList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}
	
	//Get FVL daily due .......................................................................................
	public List<DueDeatailsModel> getFVLDailyDue(Date dueDate) {
		List<DueDeatailsModel> dueList = dailyduerepo.getFVLDailyDue(dueDate);
		if (dueList.size() != 0) {
			return dueList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}
	
	//Get PL daily due .......................................................................................
	public List<DueDeatailsModel> getPLDailyDue(Date dueDate) {
		List<DueDeatailsModel> dueList = dailyduerepo.getPLDailyDue(dueDate);
		if (dueList.size() != 0) {
			return dueList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}
	
	//Get OTHER daily due .......................................................................................
	public List<DueDeatailsModel> getOTHERDailyDue(Date dueDate) {
		List<DueDeatailsModel> dueList = dailyduerepo.getOTHERDailyDue(dueDate);
		if (dueList.size() != 0) {
			return dueList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}
	
	// Get DDS weekly due..........................................................................................................
	public List<DueDeatailsModel> getDdsWeeklyDue(Date firstdate, Date lastdate) {
		List<DueDeatailsModel> weekList = dailyduerepo.getDdsWeeklyDue(firstdate, lastdate);
		if (weekList.size() != 0) {
			return weekList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}
	
	// Get Recurring weekly due.....................................................................................................
	public List<DueDeatailsModel> getRecurringWeeklyDue(Date firstdate, Date lastdate) {
		List<DueDeatailsModel> weekList = dailyduerepo.getRecurringWeeklyDue(firstdate, lastdate);
		if (weekList.size() != 0) {
			return weekList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}
	
	// Get HL weekly due..........................................................................................................
	public List<DueDeatailsModel> getHLWeeklyDue(Date firstdate, Date lastdate) {
		List<DueDeatailsModel> weekList = dailyduerepo.getHLWeeklyDue(firstdate, lastdate);
		if (weekList.size() != 0) {
			return weekList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}
	
	// Get ML weekly due..........................................................................................................
	public List<DueDeatailsModel> getMLWeeklyDue(Date firstdate, Date lastdate) {
		List<DueDeatailsModel> weekList = dailyduerepo.getMLWeeklyDue(firstdate, lastdate);
		if (weekList.size() != 0) {
			return weekList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}
	
	// Get VL weekly due..........................................................................................................
	public List<DueDeatailsModel> getVLWeeklyDue(Date firstdate, Date lastdate) {
		List<DueDeatailsModel> weekList = dailyduerepo.getVLWeeklyDue(firstdate, lastdate);
		if (weekList.size() != 0) {
			return weekList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}
	
	// Get FVL weekly due..........................................................................................................
	public List<DueDeatailsModel> getFVLWeeklyDue(Date firstdate, Date lastdate) {
		List<DueDeatailsModel> weekList = dailyduerepo.getFVLWeeklyDue(firstdate, lastdate);
		if (weekList.size() != 0) {
			return weekList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}
	
	// Get PL weekly due..........................................................................................................
	public List<DueDeatailsModel> getPLWeeklyDue(Date firstdate, Date lastdate) {
		List<DueDeatailsModel> weekList = dailyduerepo.getPLWeeklyDue(firstdate, lastdate);
		if (weekList.size() != 0) {
			return weekList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}
	
	// Get OTHER weekly due..........................................................................................................
	public List<DueDeatailsModel> getOTHERWeeklyDue(Date firstdate, Date lastdate) {
		List<DueDeatailsModel> weekList = dailyduerepo.getOTHERWeeklyDue(firstdate, lastdate);
		if (weekList.size() != 0) {
			return weekList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}
	
	// Get DDS monthly due............................................................................................................
	public Map<String, Object> getMonthlyDdsDue(Date month_firstDay, Date month_lastday, Integer setFirstResults,
			Integer setMaxResults) {
		Pageable paging = PageRequest.of(setFirstResults, setMaxResults);
		Page<DueDeatailsModel> monthList = dailyduerepo.getMonthlyDdsDue(month_firstDay, month_lastday, paging);
		Map<String, Object> monthDDSMap = new HashMap<String, Object>(); 
		
		if (monthList.hasContent()) {
			monthDDSMap.put("pageSize", monthList.getSize());
			monthDDSMap.put("totalElement", monthList.getTotalElements());
			monthDDSMap.put("totalPage", monthList.getTotalPages());
			monthDDSMap.put("ShareDetail", monthList.getContent());
			return monthDDSMap;
		} else {
			return monthDDSMap;
		}
	}
	
	// Get Recurring monthly due.....................................................................................................
	public Map<String, Object> getMonthlyRecurringDue(Date month_firstDay, Date month_lastday, Integer setFirstResults,
			Integer setMaxResults) {
		Pageable paging = PageRequest.of(setFirstResults, setMaxResults);
		Page<DueDeatailsModel> monthList = dailyduerepo.getMonthlyRecurringDue(month_firstDay, month_lastday, paging);
		Map<String, Object> monthMap = new HashMap<String, Object>(); 
		
		if (monthList.hasContent()) {
			monthMap.put("pageSize", monthList.getSize());
			monthMap.put("totalElement", monthList.getTotalElements());
			monthMap.put("totalPage", monthList.getTotalPages());
			monthMap.put("ShareDetail", monthList.getContent());
			return monthMap;
		} else {
			return monthMap;
		}
	}
	
	
	// Get HL monthly due............................................................................................................
	public Map<String, Object> getMonthlyHLDue(Date month_firstDay, Date month_lastday, Integer setFirstResults,
			Integer setMaxResults) {
		Pageable paging = PageRequest.of(setFirstResults, setMaxResults);
		Page<DueDeatailsModel> monthList = dailyduerepo.getMonthlyHLDue(month_firstDay, month_lastday, paging);
		Map<String, Object> monthMap = new HashMap<String, Object>(); 
		
		if (monthList.hasContent()) {
			monthMap.put("pageSize", monthList.getSize());
			monthMap.put("totalElement", monthList.getTotalElements());
			monthMap.put("totalPage", monthList.getTotalPages());
			monthMap.put("ShareDetail", monthList.getContent());
			return monthMap;
		} else {
			return monthMap;
		}
	}
	
	// Get ML monthly due............................................................................................................
	public Map<String, Object> getMonthlyMLDue(Date month_firstDay, Date month_lastday, Integer setFirstResults,
			Integer setMaxResults) {
		Pageable paging = PageRequest.of(setFirstResults, setMaxResults);
		Page<DueDeatailsModel> monthList = dailyduerepo.getMonthlyMLDue(month_firstDay, month_lastday, paging);
		Map<String, Object> monthMap = new HashMap<String, Object>(); 
		
		if (monthList.hasContent()) {
			monthMap.put("pageSize", monthList.getSize());
			monthMap.put("totalElement", monthList.getTotalElements());
			monthMap.put("totalPage", monthList.getTotalPages());
			monthMap.put("ShareDetail", monthList.getContent());
			return monthMap;
		} else {
			return monthMap;
		}
	}
	
	// Get VL monthly due............................................................................................................
	public Map<String, Object> getMonthlyVLDue(Date month_firstDay, Date month_lastday, Integer setFirstResults,
			Integer setMaxResults) {
		Pageable paging = PageRequest.of(setFirstResults, setMaxResults);
		Page<DueDeatailsModel> monthList = dailyduerepo.getMonthlyVLDue(month_firstDay, month_lastday, paging);
		Map<String, Object> monthMap = new HashMap<String, Object>(); 
		
		if (monthList.hasContent()) {
			monthMap.put("pageSize", monthList.getSize());
			monthMap.put("totalElement", monthList.getTotalElements());
			monthMap.put("totalPage", monthList.getTotalPages());
			monthMap.put("ShareDetail", monthList.getContent());
			return monthMap;
		} else {
			return monthMap;
		}
	}
	
	// Get FVL monthly due............................................................................................................
	public Map<String, Object> getMonthlyFVLDue(Date month_firstDay, Date month_lastday, Integer setFirstResults,
			Integer setMaxResults) {
		Pageable paging = PageRequest.of(setFirstResults, setMaxResults);
		Page<DueDeatailsModel> monthList = dailyduerepo.getMonthlyFVLDue(month_firstDay, month_lastday, paging);
		Map<String, Object> monthMap = new HashMap<String, Object>(); 
		
		if (monthList.hasContent()) {
			monthMap.put("pageSize", monthList.getSize());
			monthMap.put("totalElement", monthList.getTotalElements());
			monthMap.put("totalPage", monthList.getTotalPages());
			monthMap.put("ShareDetail", monthList.getContent());
			return monthMap;
		} else {
			return monthMap;
		}
	}
	
	// Get PL monthly due............................................................................................................
	public Map<String, Object> getMonthlyPLDue(Date month_firstDay, Date month_lastday, Integer setFirstResults,
			Integer setMaxResults) {
		Pageable paging = PageRequest.of(setFirstResults, setMaxResults);
		Page<DueDeatailsModel> monthList = dailyduerepo.getMonthlyPLDue(month_firstDay, month_lastday, paging);
		Map<String, Object> monthMap = new HashMap<String, Object>(); 
		
		if (monthList.hasContent()) {
			monthMap.put("pageSize", monthList.getSize());
			monthMap.put("totalElement", monthList.getTotalElements());
			monthMap.put("totalPage", monthList.getTotalPages());
			monthMap.put("ShareDetail", monthList.getContent());
			return monthMap;
		} else {
			return monthMap;
		}
	}
	
	// Get OTHER monthly due............................................................................................................
	public Map<String, Object> getMonthlyOTHERDue(Date month_firstDay, Date month_lastday, Integer setFirstResults,
			Integer setMaxResults) {
		Pageable paging = PageRequest.of(setFirstResults, setMaxResults);
		Page<DueDeatailsModel> monthList = dailyduerepo.getMonthlyOTHERDue(month_firstDay, month_lastday, paging);
		Map<String, Object> monthMap = new HashMap<String, Object>(); 
		
		if (monthList.hasContent()) {
			monthMap.put("pageSize", monthList.getSize());
			monthMap.put("totalElement", monthList.getTotalElements());
			monthMap.put("totalPage", monthList.getTotalPages());
			monthMap.put("ShareDetail", monthList.getContent());
			return monthMap;
		} else {
			return monthMap;
		}
	}
	

	// get total with data monthly due..........

	public MonthlyDao getMonthlyDataAndSize(Date month_firstDay, Date month_lastday, Integer setFirstResults,
			Integer setMaxResults) {
		Pageable paging = PageRequest.of(setFirstResults, setMaxResults);
		Page<DueDeatailsModel> monthList = dailyduerepo.getMonthlyDue(month_firstDay, month_lastday, paging);
		MonthlyDao monthlyDao = new MonthlyDao();

		if (monthList.hasContent()) {
			monthlyDao.setSize(monthList.getSize());
			monthlyDao.setTotalElements(monthList.getTotalElements());
			monthlyDao.setTotalPages(monthList.getTotalPages());
			monthlyDao.setDueDeatailsModels(monthList.getContent());
			return monthlyDao;
		} else {
			return new MonthlyDao();
		}
	}

	// get total size monthly due.................................

	public DueTotalSize totalMonthlyDue(Date month_firstDay, Date month_lastday) {

		DueTotalSize monthList = dailyduerepo.MonthlyDueForPagination(month_firstDay, month_lastday);
		if (monthList != null) {
			return monthList;
		} else {
			DueTotalSize totalSize = new DueTotalSize();
			return monthList;
		}
	}

//  get DDS view for daily due..........................

	public List<DueDeatailsModel> getDssAc(Date dueDate) {
		List<DueDeatailsModel> acList = dailyduerepo.getDDSView(dueDate);
		if (acList.size() != 0) {
			return acList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}

	// get recurring view for daily due..........................................

	public List<DueDeatailsModel> getRecurringAc(Date dueDate) {
		List<DueDeatailsModel> acList = dailyduerepo.getRecurringView(dueDate);
		if (acList.size() != 0) {
			return acList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}

	// get FD and MIS view for daily due..........................

	public List<DueDeatailsModel> getFDMISAc(Date dueDate) {
		List<DueDeatailsModel> acList = dailyduerepo.getFDMISView(dueDate);
		if (acList.size() != 0) {
			return acList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}

//  get DDS view for weekly due..........................

	public List<DueDeatailsModel> getWeeklyDDS(Date firstdate, Date lastdate) {
		List<DueDeatailsModel> acList = dailyduerepo.DdsWeeklyView(firstdate, lastdate);
		if (acList.size() != 0) {
			return acList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}

	// get recurring view for weekly due..........................

	public List<DueDeatailsModel> getWeeklyRecurring(Date firstdate, Date lastdate) {
		List<DueDeatailsModel> acList = dailyduerepo.RecurringWeeklyView(firstdate, lastdate);
		if (acList.size() != 0) {
			return acList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}

	// get FD and MIS view for weekly due..........................

	public List<DueDeatailsModel> getWeeklyFDMIS(Date firstdate, Date lastdate) {
		List<DueDeatailsModel> acList = dailyduerepo.FDMISWeeklyView(firstdate, lastdate);
		if (acList.size() != 0) {
			return acList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}

//  get DDS view for monthly due..........................

	public List<DueDeatailsModel> getMonthlyDss(Date month_firstDay, Date month_lastday) {
		List<DueDeatailsModel> acList = dailyduerepo.DdsMonthlyView(month_firstDay, month_lastday);
		if (acList.size() != 0) {
			return acList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}

	// get recurring view for monthly due..........................

	public List<DueDeatailsModel> getRecurringMonthly(Date month_firstDay, Date month_lastday) {
		List<DueDeatailsModel> acList = dailyduerepo.RecurringMonthlyView(month_firstDay, month_lastday);
		if (acList.size() != 0) {
			return acList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}

	// get FD and MIS view for monthly due..........................

	public List<DueDeatailsModel> getFDMISMonthly(Date month_firstDay, Date month_lastday) {
		List<DueDeatailsModel> acList = dailyduerepo.FDMISMonthlyView(month_firstDay, month_lastday);
		if (acList.size() != 0) {
			return acList;
		} else {
			return new ArrayList<DueDeatailsModel>();
		}
	}

	// Get SM ACCOUNTS - Accounts open today.....................................
	public List<AccountsOpenTodayDetails> getSMAccount(Date date) {
		List<AccountsOpenTodayDetails> accountsOpenTodayDetails = accountsOpenTodayRepo.accountsOpenToday(date);
		if (accountsOpenTodayDetails.size() != 0) {
			return accountsOpenTodayDetails;
		} else {
			return new ArrayList<AccountsOpenTodayDetails>();
		}
	}

	// Saving and Current ,DDS ,CC ,RD , FixedAndMis accounts...........
	public List<AccountsOpenTodayDetails> getAccountsOpenToday(Date date, String schemeaType) {
		List<AccountsOpenTodayDetails> accountsOpenTodayDetails = accountsOpenTodayRepo.acntOpenToday(date,
				schemeaType);
		if (accountsOpenTodayDetails.size() != 0) {
			return accountsOpenTodayDetails;
		} else {
			return new ArrayList<AccountsOpenTodayDetails>();
		}
	}

	// LOAN TYPE PL, SL, VL, ACCOUNTS OPEN TODAY accounts.........................
	public List<AccountsOpenTodayDetails> loanAccountsOpenToday(Date date, String accountType) {
		List<AccountsOpenTodayDetails> accountsOpenTodayDetails = accountsOpenTodayRepo.loanAccountsOpenToday(date,
				accountType);
		if (accountsOpenTodayDetails.size() != 0) {
			return accountsOpenTodayDetails;
		} else {
			return new ArrayList<AccountsOpenTodayDetails>();
		}
	}

	// Other loan accounts.........................................................
	public List<AccountsOpenTodayDetails> otherLoanAccounts(Date date) {
		List<AccountsOpenTodayDetails> accountsOpenTodayDetails = accountsOpenTodayRepo.otherAccountsOpenToday(date);
		if (accountsOpenTodayDetails.size() != 0) {
			return accountsOpenTodayDetails;
		} else {
			return new ArrayList<AccountsOpenTodayDetails>();
		}
	}

	// All other loan accounts................................................
	public List<AccountsOpenTodayDetails> AllotherAccounts(Date date) {
		List<AccountsOpenTodayDetails> accountsOpenTodayDetails = accountsOpenTodayRepo.AllotherAccountsOpenToday(date);
		if (accountsOpenTodayDetails.size() != 0) {
			return accountsOpenTodayDetails;

		} else {
			return new ArrayList<AccountsOpenTodayDetails>();
		}
	}

	// get insurance due.........................

	public List<InsurenceDueList> getInsurnceDue(int year, int month, Integer pageNumber, Integer setMaxResults) {
		Pageable paging = PageRequest.of(pageNumber, setMaxResults);
		if(month == 12) {
			month = 0;
		}
		Page<InsurenceDueList> insurancedue = insurenceduerepo.getInsuranceDue(year, month + 1, paging);
		if (insurancedue.hasContent()) {
			return insurancedue.getContent();
		} else {
			return new ArrayList<InsurenceDueList>();
		}

	}

	// ******************** SCHEME ***************************

	// Get CC type - scheme....................................
	public List<CCSchemaDetails> getCCScheme(String schemeType) {
		List<CCSchemaDetails> ccScheme = schemeRepo.getccScheme(schemeType);
		if (ccScheme.size() != 0) {
			return ccScheme;
		} else {
			return new ArrayList<CCSchemaDetails>();
		}
	}

	// Get DDS type - scheme....................................
	public List<DDSSchemaDetails> getDDScheme(String schemeType) {
		List<DDSSchemaDetails> ddsScheme = schemeRepo.getDdsScheme(schemeType);
		if (ddsScheme.size() != 0) {
			return ddsScheme;
		} else {
			return new ArrayList<DDSSchemaDetails>();
		}
	}

	// Get Default type - scheme........................................
	public List<iDefaultScheme> getDefaultScheme(String schemeType) {
		List<iDefaultScheme> defaultScheme = schemeRepo.getDefaultScheme(schemeType);
		if (defaultScheme.size() != 0) {
			return defaultScheme;
		} else {
			return new ArrayList<iDefaultScheme>();
		}
	}

	// Get Loan type - scheme...........................
	public List<LoanSchemaDetails> getLoanScheme(String schemeType) {
		List<LoanSchemaDetails> loanScheme = schemeRepo.getloanScheme(schemeType);
		if (loanScheme.size() != 0) {
			return loanScheme;
		} else {
			return new ArrayList<LoanSchemaDetails>();
		}
	}

	// Get Recurring type - scheme...........................
	public List<RecurringSchemaDetails> getRecurringScheme(String schemeType) {
		List<RecurringSchemaDetails> recuuringScheme = schemeRepo.getRecurringScheme(schemeType);
		if (recuuringScheme.size() != 0) {
			return recuuringScheme;
		} else {
			return new ArrayList<RecurringSchemaDetails>();
		}
	}

	// Get Mis and fix type scheme................................
	public List<FixedSchemaDetails> getMisAndFixScheme(String schemeType) {
		List<FixedSchemaDetails> misfixScheme = schemeRepo.getcfixAndMisScheme(schemeType);
		if (misfixScheme.size() != 0) {
			return misfixScheme;
		} else {
			return new ArrayList<FixedSchemaDetails>();
		}
	}

	// Get Saving and Current type scheme...........................
	public List<SavingSchemaDetails> getSavingAndcurrentScheme(String schemeType) {
		List<SavingSchemaDetails> savingAndcurrentScheme = schemeRepo.getsavingAndCurrentScheme(schemeType);
		if (savingAndcurrentScheme.size() != 0) {
			return savingAndcurrentScheme;
		} else {
			return new ArrayList<SavingSchemaDetails>();
		}
	}

	// Get DDS2 type - scheme..........................................
	public List<SchemaDetail> getDds2Schema(String schemeType) {
		List<SchemaDetail> dds2List = schemeRepo.getDds2Schema(schemeType);
		if (dds2List.size() != 0) {
			return dds2List;
		} else {
			return new ArrayList<SchemaDetail>();
		}
	}

	// Get accounts details...........................
	public AccountsDetails getAccountDetails1(Integer memberId) {
		AccountsDetails ac_Details = accountsOpenTodayRepo.getAccountsDetails1(memberId);
		if (ac_Details.getAccountNumber() != null) {
			return ac_Details;
		} else {
			return new AccountsDetails();
		}
	}
	
	
	public List<AccountsDetails>  getAccountDetails(Integer id) {
		List<AccountsDetails>  ac_Details = accountsOpenTodayRepo.getAccountsDetails(id);
		if (ac_Details.size() != 0) {
			return ac_Details ;
		} else {
			return new ArrayList<>();
		}
	}

	
	// get premium details...........................

	public List<PremiusDetails> getPremiumDetails(Integer acId) {
		List<PremiusDetails> prmList = dailyduerepo.getPremiusDetails(acId);
		if (prmList.size() != 0) {
			return prmList;
		} else {
			return new ArrayList<PremiusDetails>();
		}

	}

	public static Integer pageNumber(Integer pageNmber) {
		if (pageNmber > 0) {
			return pageNmber - 1;
		} else {
			return pageNmber;
		}

	}

	@SuppressWarnings("deprecation")
	public List<LoanSchemaDetails> getCC() {

		List<LoanSchemaDetails> newArrDueToGiveLists = new ArrayList<LoanSchemaDetails>();

		Session s = hibernateFactory.openSession();

		@SuppressWarnings("rawtypes")
		SQLQuery sq = s.createSQLQuery(
				"SELECT count(distinct  a.id) as totalAccounts,count(distinct  an.id) as activeAccounts,s.id ,s.name,s.interest ,s.ProcessingFees \r\n"
						+ ",s.valid_till ,s.MaxLimit ,s.MinLimit from schemes s\r\n"
						+ "			 left join accounts a on a.scheme_id =s.id \r\n"
						+ "		 left join accounts an on an.scheme_id =s.id and an.ActiveStatus =1  \r\n"
						+ "			 WHERE  s.SchemeType ='cc' \r\n" + "			group by(s.name)  ");
		List<Object[]> result = sq.list();
		for (Object[] row : result) {

		}
		return newArrDueToGiveLists;
	}

	//--------------------------------------------------------------------------------------------------
	public List<iCashBankReport> getCashBankReport1(String date) {
		List<iCashBankReport> list = transactionRowRepo.getCashBankReport1(date);
		return list;
	}
	
	public List<iCashBankReport> getCashBankReport2(String date) {
		List<iCashBankReport> list = transactionRowRepo.getCashBankReport2(date);
		return list;
	}
	
	public List<iCashBankReport> getCashBankReport3(String date) {
		List<iCashBankReport> list = transactionRowRepo.getCashBankReport3(date);
		return list;
	}

	public List<iAccountDetails> getAccountDocuments(Integer id) {
		List<iAccountDetails> list = acountsRepo.getAccountDocuments(id);
		return list;
	}

	public List<iAccountDetails> getAccountInsurance(Integer id) {
		List<iAccountDetails> list = acountsRepo.getAccountInsurance(id);
		return list;
	}

	public List<iAccountDetails> getAccountGaurantors(Integer id) {
		List<iAccountDetails> list = acountsRepo.getAccountGaurantors(id);
		return list;
	}

	public iAccountDetails getMaturityDate(Integer id) {
		String accountType = acountsRepo.getAccountType(id);
		
		if(accountType.equals("FD") || accountType.equals("MIS")) {
			iAccountDetails result = acountsRepo.getMaturityDateFDMIS(id);
			return result;
		}
		else {
			iAccountDetails result = acountsRepo.getMaturityDate(id);
			return result;
		}
	}


}
