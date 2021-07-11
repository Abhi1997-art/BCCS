package com.service.banking.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.service.banking.model.errorHandleModel.DataNotFoundException;
import com.service.banking.service.DashBoardService;
import com.service.banking.utils.DateFormater;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service
@RequestMapping("/service/dashboard")
public class DashBoardController {

	@Autowired
	DashBoardService dashService;

	// To get proper date format.........
	DateFormater dateformater = new DateFormater();

	//Get DDS daily due....................................................................................................
	@GetMapping("/dailydue/dds/{duedate}")
	List<DueDeatailsModel> getDDSDue(@PathVariable("duedate") String date) {
		Date dueDate = dateformater.getFromatDate(date);
		List<DueDeatailsModel> dailydue = dashService.getDdsDailyDue(dueDate); 
			return dailydue;
	}
	
	//Get Recurring daily due................................................................................................
	@GetMapping("/dailydue/recurring/{duedate}")
	List<DueDeatailsModel> getRecurringDue(@PathVariable("duedate") String date) {
		Date dueDate = dateformater.getFromatDate(date);
		List<DueDeatailsModel> dailydue = dashService.getRecurringDailyDue(dueDate);
			return dailydue;
	}
	
		//Get HL daily due................................................................................................
		@GetMapping("/dailydue/hl/{duedate}")
		List<DueDeatailsModel> getHLDue(@PathVariable("duedate") String date) {
			Date dueDate = dateformater.getFromatDate(date);
			List<DueDeatailsModel> dailydue = dashService.getHLDailyDue(dueDate);
				return dailydue;
		}
		
		//Get ML daily due................................................................................................
		@GetMapping("/dailydue/ml/{duedate}")
		List<DueDeatailsModel> getMLDue(@PathVariable("duedate") String date) {
			Date dueDate = dateformater.getFromatDate(date);
			List<DueDeatailsModel> dailydue = dashService.getMLDailyDue(dueDate);
				return dailydue;
		}
		
		//Get PL daily due................................................................................................
		@GetMapping("/dailydue/pl/{duedate}")
		List<DueDeatailsModel> getPLDue(@PathVariable("duedate") String date) {
			Date dueDate = dateformater.getFromatDate(date);
			List<DueDeatailsModel> dailydue = dashService.getPLDailyDue(dueDate);
				return dailydue;
		}
		
		//Get VL daily due................................................................................................
		@GetMapping("/dailydue/vl/{duedate}")
		List<DueDeatailsModel> getVLDue(@PathVariable("duedate") String date) {
			Date dueDate = dateformater.getFromatDate(date);
			List<DueDeatailsModel> dailydue = dashService.getVLDailyDue(dueDate);
				return dailydue;
		}
		
		//Get OTHER daily due................................................................................................
		@GetMapping("/dailydue/other/{duedate}")
		List<DueDeatailsModel> getOTHERDue(@PathVariable("duedate") String date) {
			Date dueDate = dateformater.getFromatDate(date);
			List<DueDeatailsModel> dailydue = dashService.getOTHERDailyDue(dueDate);
				return dailydue;
		}
		
		
		
		
	// FD AND MIS daily Due to give list..........................
	@GetMapping("daily/fd_mis/due_to_giveList/{duedate}")
	List<DueToGiveList> dailyDDS(@PathVariable("duedate") String date) {
		List<DueToGiveList> fdmis = dashService.FDMISToGiveLists(date, date);
			return fdmis;
	}

	// recurring daily Due to give list..........................
	@GetMapping("daily/recurring/due_to_giveList/{duedate}")
	List<DueToGiveList> dailyRecurring(@PathVariable("duedate") String date) {
		List<DueToGiveList> recurring = dashService.RecurringToGiveLists(date, date);
			return recurring;
	}

	// DDS daily Due to give list..........................
	@GetMapping("daily/dds/due_to_giveList/{duedate}")
	List<DueToGiveList> dailyDueDDS(@PathVariable("duedate") String date) {
		List<DueToGiveList> dds = dashService.DDSToGiveLists(date, date);
			return dds;
	}

	// Get DDS weekly due...........................................................................................................
	@GetMapping("/weeklydue/dds/{duedate}")
	List<DueDeatailsModel> getDdsWeeklyDue(@PathVariable("duedate") String duedate) {
		dateformater.getMotnYearDay(duedate); // to get month, year, day Separately.......
		Map<String, String> weekDay = dateformater.getweekDate(); // this will provide start-date,end-date...
		Date startDate = dateformater.getFromatDate(weekDay.get("startDate"));
		Date endDate = dateformater.getFromatDate(weekDay.get("endDate"));
		System.out.println("####3######## end  day week" + endDate);
		System.out.println("####3######## first day week" + startDate);
		List<DueDeatailsModel> weekDue = dashService.getDdsWeeklyDue(startDate, endDate); // null
		System.out.println("size of list*****************" + weekDue.size());
		return weekDue;
	}

	// Get Recurring weekly due......................................................................................................
	@GetMapping("/weeklydue/recurring/{duedate}")
	List<DueDeatailsModel> getRecurringWeeklyDue(@PathVariable("duedate") String duedate) {
		dateformater.getMotnYearDay(duedate); // to get month, year, day Separately.......
		Map<String, String> weekDay = dateformater.getweekDate(); // this will provide start-date,end-date...
		Date startDate = dateformater.getFromatDate(weekDay.get("startDate"));
		Date endDate = dateformater.getFromatDate(weekDay.get("endDate"));
		System.out.println("####3######## end  day week" + endDate);
		System.out.println("####3######## first day week" + startDate);
		List<DueDeatailsModel> weekDue = dashService.getRecurringWeeklyDue(startDate, endDate); // null
		System.out.println("size of list*****************" + weekDue.size());
		return weekDue;
	}
	
	// Get HL weekly due..........................................................................................................
	@GetMapping("/weeklydue/hl/{duedate}")
	List<DueDeatailsModel> getHLWeeklyDue(@PathVariable("duedate") String duedate) {
		dateformater.getMotnYearDay(duedate); // to get month, year, day Separately.......
		Map<String, String> weekDay = dateformater.getweekDate(); // this will provide start-date,end-date...
		Date startDate = dateformater.getFromatDate(weekDay.get("startDate"));
		Date endDate = dateformater.getFromatDate(weekDay.get("endDate"));
		List<DueDeatailsModel> weekDue = dashService.getHLWeeklyDue(startDate, endDate); // null
		return weekDue;
	}
	
	// Get ML weekly due..........................................................................................................
	@GetMapping("/weeklydue/ml/{duedate}")
	List<DueDeatailsModel> getMLWeeklyDue(@PathVariable("duedate") String duedate) {
		dateformater.getMotnYearDay(duedate); // to get month, year, day Separately.......
		Map<String, String> weekDay = dateformater.getweekDate(); // this will provide start-date,end-date...
		Date startDate = dateformater.getFromatDate(weekDay.get("startDate"));
		Date endDate = dateformater.getFromatDate(weekDay.get("endDate"));
		List<DueDeatailsModel> weekDue = dashService.getMLWeeklyDue(startDate, endDate); // null
		return weekDue;
	}
	
	// Get PL weekly due..........................................................................................................
	@GetMapping("/weeklydue/pl/{duedate}")
	List<DueDeatailsModel> getPLWeeklyDue(@PathVariable("duedate") String duedate) {
		dateformater.getMotnYearDay(duedate); // to get month, year, day Separately.......
		Map<String, String> weekDay = dateformater.getweekDate(); // this will provide start-date,end-date...
		Date startDate = dateformater.getFromatDate(weekDay.get("startDate"));
		Date endDate = dateformater.getFromatDate(weekDay.get("endDate"));
		List<DueDeatailsModel> weekDue = dashService.getPLWeeklyDue(startDate, endDate); // null
		return weekDue;
	}
	
	// Get VL weekly due..........................................................................................................
	@GetMapping("/weeklydue/vl/{duedate}")
	List<DueDeatailsModel> getVLWeeklyDue(@PathVariable("duedate") String duedate) {
		dateformater.getMotnYearDay(duedate); // to get month, year, day Separately.......
		Map<String, String> weekDay = dateformater.getweekDate(); // this will provide start-date,end-date...
		Date startDate = dateformater.getFromatDate(weekDay.get("startDate"));
		Date endDate = dateformater.getFromatDate(weekDay.get("endDate"));
		List<DueDeatailsModel> weekDue = dashService.getVLWeeklyDue(startDate, endDate); // null
		return weekDue;
	}
	
	// Get Other weekly due..........................................................................................................
	@GetMapping("/weeklydue/other/{duedate}")
	List<DueDeatailsModel> getOtherWeeklyDue(@PathVariable("duedate") String duedate) {
		dateformater.getMotnYearDay(duedate); // to get month, year, day Separately.......
		Map<String, String> weekDay = dateformater.getweekDate(); // this will provide start-date,end-date...
		Date startDate = dateformater.getFromatDate(weekDay.get("startDate"));
		Date endDate = dateformater.getFromatDate(weekDay.get("endDate"));
		List<DueDeatailsModel> weekDue = dashService.getOTHERWeeklyDue(startDate, endDate); // null
		return weekDue;
	}
	
	
	
	// FD AND MIS weekly Due to give list..........................
	@GetMapping("weekly/fd_mis/due_to_giveList/{duedate}")
	List<DueToGiveList> weeklydds(@PathVariable("duedate") String date) {
		dateformater.getMotnYearDay(date); // to get month, year, day seprately.......
		Map<String, String> weekDay = dateformater.getweekDate(); // this will provide stardate,enddate...
		String startDate = weekDay.get("startDate");
		String endDate = weekDay.get("endDate");
		System.out.println("####3######## end  day week" + endDate);
		System.out.println("####3######## first day week" + startDate);

		List<DueToGiveList> fdmis = dashService.FDMISToGiveLists(startDate, endDate);
			return fdmis;


	}

	// recurring weekly Due to give list..........................
	@GetMapping("weekly/recurring/due_to_giveList/{duedate}")
	List<DueToGiveList> weeklyRecurring(@PathVariable("duedate") String date) {
		dateformater.getMotnYearDay(date); // to get month, year, day seprately.......
		Map<String, String> weekDay = dateformater.getweekDate(); // this will provide stardate,enddate...
		String startDate = weekDay.get("startDate");
		String endDate = weekDay.get("endDate");
		System.out.println("####3######## end  day week" + endDate);
		System.out.println("####3######## first day week" + startDate);

		List<DueToGiveList> recuring = dashService.RecurringToGiveLists(startDate, endDate);
			return recuring;

	}

	// DDS weekly Due to give list..........................
	@GetMapping("weekly/dds/due_to_giveList/{duedate}")
	List<DueToGiveList> weeklyDDS(@PathVariable("duedate") String date) {
		dateformater.getMotnYearDay(date); // to get month, year, day separately.......
		Map<String, String> weekDay = dateformater.getweekDate(); // this will provide start-date,end-date...
		String startDate = weekDay.get("startDate");
		String endDate = weekDay.get("endDate");
		System.out.println("####3######## end  day week" + endDate);
		System.out.println("####3######## first day week" + startDate);

		List<DueToGiveList> dds = dashService.DDSToGiveLists(startDate, endDate);
			return dds;

	}
	
	// Get DDS monthly due..................................................................................................
	@GetMapping("/monthdue/dds/{duedate}/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> monthlyDdsDue(@PathVariable("duedate") String duedate,
			@PathVariable("setFirstResult") Integer setFirstResult,
			@PathVariable("setMaxResults") Integer setMaxResults) {
		dateformater.getMotnYearDay(duedate); // to get month, year, day separately.......

		Map<String, String> monthdate = dateformater.getmonthStartAndEndDate(duedate);// get first date and last of
		Date startDate = dateformater.getFromatDate(monthdate.get("startdatemonth"));
		Date endDate = dateformater.getFromatDate(monthdate.get("enddatemonth"));
		System.out.println("####3######## month last  day week" + endDate);

		Integer setPageNumber = DashBoardService.pageNumber(setFirstResult);
		System.out.println("####3######## month first day week" + startDate); // month
		
		Map<String, Object> monthdue = dashService.getMonthlyDdsDue(startDate, endDate, setPageNumber, setMaxResults);
		return monthdue;
	}
	
	// Get Recurring monthly due..................................................................................................
	@GetMapping("/monthdue/recurring/{duedate}/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> monthlyRecurringDue(@PathVariable("duedate") String duedate,
			@PathVariable("setFirstResult") Integer setFirstResult,
			@PathVariable("setMaxResults") Integer setMaxResults) {
		dateformater.getMotnYearDay(duedate); // to get month, year, day separately.......

		Map<String, String> monthdate = dateformater.getmonthStartAndEndDate(duedate);// get first date and last of
		Date startDate = dateformater.getFromatDate(monthdate.get("startdatemonth"));
		Date endDate = dateformater.getFromatDate(monthdate.get("enddatemonth"));
		System.out.println("####3######## month last  day week" + endDate);

		Integer setPageNumber = DashBoardService.pageNumber(setFirstResult);
		System.out.println("####3######## month first day week" + startDate); // month
		
		Map<String, Object> monthdue = dashService.getMonthlyRecurringDue(startDate, endDate, setPageNumber, setMaxResults);
		return monthdue;
	}
	
	// Get HL monthly due..................................................................................................
	@GetMapping("/monthdue/hl/{duedate}/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> monthlyHLDue(@PathVariable("duedate") String duedate,
			@PathVariable("setFirstResult") Integer setFirstResult,
			@PathVariable("setMaxResults") Integer setMaxResults) {
		dateformater.getMotnYearDay(duedate); // to get month, year, day separately.......

		Map<String, String> monthdate = dateformater.getmonthStartAndEndDate(duedate);// get first date and last of
		Date startDate = dateformater.getFromatDate(monthdate.get("startdatemonth"));
		Date endDate = dateformater.getFromatDate(monthdate.get("enddatemonth"));
		System.out.println("####3######## month last  day week" + endDate);

		Integer setPageNumber = DashBoardService.pageNumber(setFirstResult);
		System.out.println("####3######## month first day week" + startDate); // month
		
		Map<String, Object> monthdue = dashService.getMonthlyHLDue(startDate, endDate, setPageNumber, setMaxResults);
		return monthdue;
	}
	
	// Get PL monthly due..................................................................................................
	@GetMapping("/monthdue/pl/{duedate}/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> monthlyPLDue(@PathVariable("duedate") String duedate,
			@PathVariable("setFirstResult") Integer setFirstResult,
			@PathVariable("setMaxResults") Integer setMaxResults) {
		dateformater.getMotnYearDay(duedate); // to get month, year, day separately.......

		Map<String, String> monthdate = dateformater.getmonthStartAndEndDate(duedate);// get first date and last of
		Date startDate = dateformater.getFromatDate(monthdate.get("startdatemonth"));
		Date endDate = dateformater.getFromatDate(monthdate.get("enddatemonth"));
		System.out.println("####3######## month last  day week" + endDate);

		Integer setPageNumber = DashBoardService.pageNumber(setFirstResult);
		System.out.println("####3######## month first day week" + startDate); // month
		
		Map<String, Object> monthdue = dashService.getMonthlyPLDue(startDate, endDate, setPageNumber, setMaxResults);
		return monthdue;
	}
	
	// Get ML monthly due..................................................................................................
	@GetMapping("/monthdue/ml/{duedate}/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> monthlyMLDue(@PathVariable("duedate") String duedate,
			@PathVariable("setFirstResult") Integer setFirstResult,
			@PathVariable("setMaxResults") Integer setMaxResults) {
		dateformater.getMotnYearDay(duedate); // to get month, year, day separately.......

		Map<String, String> monthdate = dateformater.getmonthStartAndEndDate(duedate);// get first date and last of
		Date startDate = dateformater.getFromatDate(monthdate.get("startdatemonth"));
		Date endDate = dateformater.getFromatDate(monthdate.get("enddatemonth"));
		System.out.println("####3######## month last  day week" + endDate);

		Integer setPageNumber = DashBoardService.pageNumber(setFirstResult);
		System.out.println("####3######## month first day week" + startDate); // month
		
		Map<String, Object> monthdue = dashService.getMonthlyMLDue(startDate, endDate, setPageNumber, setMaxResults);
		return monthdue;
	}
	
	// Get VL monthly due..................................................................................................
	@GetMapping("/monthdue/vl/{duedate}/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> monthlyVLDue(@PathVariable("duedate") String duedate,
			@PathVariable("setFirstResult") Integer setFirstResult,
			@PathVariable("setMaxResults") Integer setMaxResults) {
		dateformater.getMotnYearDay(duedate); // to get month, year, day separately.......

		Map<String, String> monthdate = dateformater.getmonthStartAndEndDate(duedate);// get first date and last of
		Date startDate = dateformater.getFromatDate(monthdate.get("startdatemonth"));
		Date endDate = dateformater.getFromatDate(monthdate.get("enddatemonth"));
		System.out.println("####3######## month last  day week" + endDate);

		Integer setPageNumber = DashBoardService.pageNumber(setFirstResult);
		System.out.println("####3######## month first day week" + startDate); // month
		
		Map<String, Object> monthdue = dashService.getMonthlyVLDue(startDate, endDate, setPageNumber, setMaxResults);
		return monthdue;
	}
	
	// Get OTHER monthly due..................................................................................................
	@GetMapping("/monthdue/other/{duedate}/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> monthlyOTHERDue(@PathVariable("duedate") String duedate,
			@PathVariable("setFirstResult") Integer setFirstResult,
			@PathVariable("setMaxResults") Integer setMaxResults) {
		dateformater.getMotnYearDay(duedate); // to get month, year, day separately.......

		Map<String, String> monthdate = dateformater.getmonthStartAndEndDate(duedate);// get first date and last of
		Date startDate = dateformater.getFromatDate(monthdate.get("startdatemonth"));
		Date endDate = dateformater.getFromatDate(monthdate.get("enddatemonth"));
		System.out.println("####3######## month last  day week" + endDate);

		Integer setPageNumber = DashBoardService.pageNumber(setFirstResult);
		System.out.println("####3######## month first day week" + startDate); // month
		
		Map<String, Object> monthdue = dashService.getMonthlyOTHERDue(startDate, endDate, setPageNumber, setMaxResults);
		return monthdue;
	}
	
	// get total size of monthly due.................

	@GetMapping("/total_monthdue/{duedate}")
	DueTotalSize totalMonthlyDue(@PathVariable("duedate") String duedate) {
		dateformater.getMotnYearDay(duedate); // to get month, year, day seprately.................................

		Map<String, String> monthdate = dateformater.getmonthStartAndEndDate(duedate);// get first date and last of
		Date startDate = dateformater.getFromatDate(monthdate.get("startdatemonth"));
		Date endDate = dateformater.getFromatDate(monthdate.get("enddatemonth"));
		System.out.println("####3######## month last  day week" + endDate);

		System.out.println("####3######## month first day week" + startDate); // month
		DueTotalSize monthdue = dashService.totalMonthlyDue(startDate, endDate); // null check already in service....
		System.out.println("size of list***************** " + monthdue.getTotalsize());

		return monthdue;

	}

	@GetMapping("/total_pageData_monthdue/{duedate}/{setFirstResult}/{setMaxResults}")
	MonthlyDao totalMonthlyDue(@PathVariable("duedate") String duedate,
			@PathVariable("setFirstResult") Integer setFirstResult,
			@PathVariable("setMaxResults") Integer setMaxResults) {
		dateformater.getMotnYearDay(duedate); // to get month, year, day seprately.......

		Map<String, String> monthdate = dateformater.getmonthStartAndEndDate(duedate);// get first date and last of
		Date startDate = dateformater.getFromatDate(monthdate.get("startdatemonth"));
		Date endDate = dateformater.getFromatDate(monthdate.get("enddatemonth"));
		System.out.println("####3######## month last  day " + endDate);

		Integer setPageNumber = DashBoardService.pageNumber(setFirstResult);
		System.out.println("####3######## month first day week" + startDate); // month
		MonthlyDao monthdue = dashService.getMonthlyDataAndSize(startDate, endDate, setPageNumber, setMaxResults); // null
																													// check
																													// already
																													// in
																													// service....

		return monthdue;

	}

	// FD AND MIS monthly Due to give list..........................
	@GetMapping("/monthly/fd_mis/due_to_giveList/{duedate}")
	List<DueToGiveList> monthlyDds(@PathVariable("duedate") String date) {
		dateformater.getMotnYearDay(date); // to get month, year, day seprately.......
		Map<String, String> monthdate = dateformater.getmonthStartAndEndDate(date);// get first date and last of
		String startDate = monthdate.get("startdatemonth");
		String endDate = monthdate.get("enddatemonth");
		System.out.println("####3######## month last  day week" + endDate);
		System.out.println("####3######## month first day week" + startDate);
		List<DueToGiveList> fdmis = dashService.FDMISToGiveLists(startDate, endDate);
			return fdmis;

	}

	// recurring monthly Due to give list..........................
	@GetMapping("/monthly/recurring/due_to_giveList/{duedate}")
	List<DueToGiveList> monthlyRecurring(@PathVariable("duedate") String date) {
		dateformater.getMotnYearDay(date); // to get month, year, day seprately.......
		Map<String, String> monthdate = dateformater.getmonthStartAndEndDate(date);// get first date and last of
		String startDate = monthdate.get("startdatemonth");
		String endDate = monthdate.get("enddatemonth");
		System.out.println("####3######## month last  day week" + endDate);
		System.out.println("####3######## month first day week" + startDate);
		List<DueToGiveList> recuring = dashService.RecurringToGiveLists(startDate, endDate);
			return recuring;


	}

	// dds monthly Due to give list..........................
	@GetMapping("monthly/dds/due_to_giveList/{duedate}")
	List<DueToGiveList> monthlyDDS(@PathVariable("duedate") String date) {
		dateformater.getMotnYearDay(date); // to get month, year, day seprately.......
		Map<String, String> monthdate = dateformater.getmonthStartAndEndDate(date);// get first date and last of
		String startDate = monthdate.get("startdatemonth");
		String endDate = monthdate.get("enddatemonth");
		System.out.println("####3######## month last  day week" + endDate);
		System.out.println("####3######## month first day week" + startDate);
		List<DueToGiveList> dds = dashService.DDSToGiveLists(startDate, endDate);
			return dds;

	}

	// ******************** ACCOUNTS OPENED TODAY ***************************

	// Get SM ACCOUNTS - Accounts open today.....................................
	@GetMapping("/accountopentoday/sm/{todayDate}")
	List<AccountsOpenTodayDetails> getSmAccounts(@PathVariable("todayDate") String todayDate) {
		Date dueDate = dateformater.getFromatDate(todayDate);
		List<AccountsOpenTodayDetails> accountsOpen = dashService.getSMAccount(dueDate);
		return accountsOpen;
	}

	// SAVING AND CURRENT ACCOUNTS OPEN TODAY...............................
	@GetMapping("/accountopentoday/saving_current/{todayDate}")
	List<AccountsOpenTodayDetails> savingAccount(@PathVariable("todayDate") String todayDate) {
		String accountType = "SavingAndCurrent";
		Date dueDate = dateformater.getFromatDate(todayDate);
		List<AccountsOpenTodayDetails> accountsOpen = dashService.getAccountsOpenToday(dueDate, accountType);
		return accountsOpen;
	}

	// DDS ACCOUNTS open TOIDAY ...........................................
	@GetMapping("/accountopentoday/dds/{todayDate}")
	List<AccountsOpenTodayDetails> DDSAccount(@PathVariable("todayDate") String todayDate) {
		String accountType = "DDS";
		Date dueDate = dateformater.getFromatDate(todayDate);
		List<AccountsOpenTodayDetails> accountsOpen = dashService.getAccountsOpenToday(dueDate, accountType);
		return accountsOpen;
	}

	// FixedAndMis ACCOUNTS open TOIDAY ....................................
	@GetMapping("/accountopentoday/fix_mis/{todayDate}")
	List<AccountsOpenTodayDetails> FixedAndMisAccount(@PathVariable("todayDate") String todayDate) {
		String accountType = "FixedAndMis";
		Date dueDate = dateformater.getFromatDate(todayDate);
		List<AccountsOpenTodayDetails> accountsOpen = dashService.getAccountsOpenToday(dueDate, accountType);
		return accountsOpen;
	}

	// Recurring ACCOUNTS open TODAY ......................................
	@GetMapping("/accountopentoday/recurring/{todayDate}")
	List<AccountsOpenTodayDetails> RecurringAccount(@PathVariable("todayDate") String todayDate) {
		String accountType = "Recurring";
		Date dueDate = dateformater.getFromatDate(todayDate);
		List<AccountsOpenTodayDetails> accountsOpen = dashService.getAccountsOpenToday(dueDate, accountType);
		return accountsOpen;
	}

	// CC ACCOUNTS open TODAY ..............................................
	@GetMapping("/accountopentoday/cc/{todayDate}")
	List<AccountsOpenTodayDetails> CCAccounts(@PathVariable("todayDate") String todayDate) {
		String accountType = "CC";
		Date dueDate = dateformater.getFromatDate(todayDate);
		List<AccountsOpenTodayDetails> accountsOpen = dashService.getAccountsOpenToday(dueDate, accountType); // null
		return accountsOpen;
	}

	// PL ACCOUNTS open TODAY ...............................................
	@GetMapping("/accountopentoday/pl/{todayDate}")
	List<AccountsOpenTodayDetails> PLAccounts(@PathVariable("todayDate") String todayDate) {
		String accountType = "Personal Loan";
		Date dueDate = dateformater.getFromatDate(todayDate);
		List<AccountsOpenTodayDetails> accountsOpen = dashService.loanAccountsOpenToday(dueDate, accountType);
		return accountsOpen;
	}

	// SL ACCOUNTS open TODAY ................................................
	@GetMapping("/accountopentoday/sl/{todayDate}")
	List<AccountsOpenTodayDetails> SLAccounts(@PathVariable("todayDate") String todayDate) {
		String accountType = "Loan Against Deposit";
		Date dueDate = dateformater.getFromatDate(todayDate);
		List<AccountsOpenTodayDetails> accountsOpen = dashService.loanAccountsOpenToday(dueDate, accountType);
		return accountsOpen;
	}

	// VL two wheelers ACCOUNTS open TODAY .................................
	@GetMapping("/accountopentoday/vl_two_wheelers/{todayDate}")
	List<AccountsOpenTodayDetails> VLTwoWheelersAccounts(@PathVariable("todayDate") String todayDate) {
		String accountType = "Two Wheeler Loan";
		Date dueDate = dateformater.getFromatDate(todayDate);
		List<AccountsOpenTodayDetails> accountsOpen = dashService.loanAccountsOpenToday(dueDate, accountType);
		return accountsOpen;
	}

	// VL Auto four wheelers ACCOUNTS open TODAY .............................
	@GetMapping("/accountopentoday/vl_auto_accounts/{todayDate}")
	List<AccountsOpenTodayDetails> VLFourWheelersAccounts(@PathVariable("todayDate") String todayDate) {
		String accountType = "Auto Loan";
		Date dueDate = dateformater.getFromatDate(todayDate);
		List<AccountsOpenTodayDetails> accountsOpen = dashService.getAccountsOpenToday(dueDate, accountType);
		return accountsOpen;
	}

	// Other loan accounts...................................................
	@GetMapping("/accountopentoday/other_accounts/{todayDate}")
	List<AccountsOpenTodayDetails> otherLoanAccounts(@PathVariable("todayDate") String todayDate) {
		Date dueDate = dateformater.getFromatDate(todayDate);
		List<AccountsOpenTodayDetails> accountsOpen = dashService.otherLoanAccounts(dueDate);
		return accountsOpen;
	}

	// All other loan accounts.....................
	@GetMapping("/accountopentoday/all_other_accounts/{todayDate}")
	List<AccountsOpenTodayDetails> AllotherLoanAccounts(@PathVariable("todayDate") String todayDate) {
		Date dueDate = dateformater.getFromatDate(todayDate);
		List<AccountsOpenTodayDetails> accountsOpen = dashService.AllotherAccounts(dueDate);
		return accountsOpen;
	}

	// All other loan accounts.....................
	@GetMapping("/accountopentoday/{todayDate}")
	Map<String, List<?>> allaccounts(@PathVariable("todayDate") String todayDate) {
		Date dueDate = dateformater.getFromatDate(todayDate);

		List<AccountsOpenTodayDetails> smaccounts = dashService.getSMAccount(dueDate); // sm accounts

		List<AccountsOpenTodayDetails> allotherAccounts = dashService.AllotherAccounts(dueDate); // all other accounts

		String fdType = "FixedAndMis";
		List<AccountsOpenTodayDetails> fdms = dashService.getAccountsOpenToday(dueDate, fdType); // all fdmis

		String savingType = "SavingAndCurrent";
		List<AccountsOpenTodayDetails> savingCurrent = dashService.getAccountsOpenToday(dueDate, savingType); // savingandCurrent

		String ddsType = "DDS";
		List<AccountsOpenTodayDetails> ddsAccount = dashService.getAccountsOpenToday(dueDate, ddsType); // dds

		String reccType = "Recurring";
		List<AccountsOpenTodayDetails> reccuringAccnt = dashService.getAccountsOpenToday(dueDate, reccType); // recurring....

		String ccType = "CC";
		List<AccountsOpenTodayDetails> CCaccount = dashService.getAccountsOpenToday(dueDate, ccType); // cc check

		String personalType = "Personal Loan";
		List<AccountsOpenTodayDetails> personalLoan = dashService.loanAccountsOpenToday(dueDate, personalType); // personbal

		String loanAgainst = "Loan Against Deposit";
		List<AccountsOpenTodayDetails> slloangainst = dashService.loanAccountsOpenToday(dueDate, loanAgainst); // sl
																												// loanAgainst

		String twoWheeler = "Two Wheeler Loan";
		List<AccountsOpenTodayDetails> twoWheelerAccounts = dashService.loanAccountsOpenToday(dueDate, twoWheeler); // twoWheeler
																													// check

		String autoLoan = "Auto Loan";
		List<AccountsOpenTodayDetails> fourWheelers = dashService.loanAccountsOpenToday(dueDate, autoLoan); // four
																											// wheelre
																											// Auto laon
																											// check

		List<AccountsOpenTodayDetails> otherAccounts = dashService.otherLoanAccounts(dueDate); // other accounts check

		Map<String, List<?>> data = new HashMap<String, List<?>>();
		data.put("smaccounts", smaccounts);
		data.put("fdms", fdms);
		data.put("VLfourWheelers", fourWheelers);
		data.put("allotherAccounts", allotherAccounts);
		data.put("savingCurrent", savingCurrent);
		data.put("ddsAccount", ddsAccount);
		data.put("rd", reccuringAccnt);
		data.put("CCaccount", CCaccount);
		data.put("pl", personalLoan);
		data.put("sl", slloangainst);
		data.put("VLtwoWheelerAccounts", twoWheelerAccounts);
		data.put("otherAccounts", otherAccounts);
		return data;
	}

	// get all insurance due...............................

	@GetMapping("/insurancedue/{date}/{pageNumber}/{setMaxResults}")
	List<InsurenceDueList> insuranceDue(@PathVariable("date") String date,
			@PathVariable("pageNumber") Integer pageNumber, @PathVariable("setMaxResults") Integer setMaxResults) {
		Map<String, Integer> mh = dateformater.getMotnYearDay(date); // get year ,month
		int year = mh.get("year");
		System.out.print("******" + year);
		int month = mh.get("month");
		System.out.print("******" + month);
		Integer setPageNumber = DashBoardService.pageNumber(pageNumber);
		List<InsurenceDueList> insurance = dashService.getInsurnceDue(year, month, setPageNumber, setMaxResults); // null
																													// check
																													// already
																													// in
																													// service....
		System.out.print("******" + insurance.size());
		return insurance;
	}

	// custom api for Table column names......................
	@GetMapping("/customtable")
	ResponseEntity<Map<String, String>> getEmployeeById() {
		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("accountNumber", "AccountNumber");
		myMap.put("memberName", "Member Name");
		myMap.put("fatherName", "FatherName");
		myMap.put("permanentAddress", "PermanentAddress");
		myMap.put("phoneNos", "PhoneNos");
		myMap.put("amount", "Amount");
		myMap.put("dueDate", "DueDate");
		myMap.put("agent", "Agent");
		myMap.put("dealer", "Dealer");
		myMap.put("scheme", "Scheme");
		myMap.put("balance_On_Date", "Balance On Date");
		myMap.put("opening_Balance", "Opening Balance");
		myMap.put("todays_Received", "Todays Received");
		myMap.put("todays_Payment", "Todays Payment");
		myMap.put("loanInsurranceDate", "LoanInsurranceDate");
		myMap.put("scheme_Name", "Scheme Name");
		myMap.put("interest", "Interest (In %)");
		myMap.put("head", "Head");
		myMap.put("processing_Fees", "Processing Fees");
		myMap.put("accounts", "Accounts");
		myMap.put("active_Accounts", "Active Accounts");
		myMap.put("valid_Till", "Valid Till");
		myMap.put("Limits", "Limits");
		return new ResponseEntity<Map<String, String>>(myMap, new HttpHeaders(), HttpStatus.OK);
	}

	// ******************** SCHEME ***************************

	// Get CC type - scheme...........................................
	@GetMapping("/scheme/cc/{schemetype}")
	List<CCSchemaDetails> getCCScheme(@PathVariable("schemetype") String schemeType) {
		List<CCSchemaDetails> ccScheme = dashService.getCCScheme(schemeType); // null check already in service....
		return ccScheme;
	}

	// Get DDS type - scheme...........................................
	@GetMapping("/scheme/dds/{schemetype}")
	List<DDSSchemaDetails> getDDSScheme(@PathVariable("schemetype") String schemeType) {
		List<DDSSchemaDetails> ddsScheme = dashService.getDDScheme(schemeType); // null check already in service....
		return ddsScheme;
	}

	// Get Default type - scheme........................................
	@GetMapping("/scheme/default/{schemetype}")
	List<DefaultSchemaDetails> getDefaultScheme(@PathVariable("schemetype") String schemeType) {
		List<DefaultSchemaDetails> defaultScheme = dashService.getDefaultScheme(schemeType);
		return defaultScheme;
	}

	// Get Loan type - scheme..............................................
	@GetMapping("/scheme/loan/{schemetype}")
	List<LoanSchemaDetails> getLoanScheme(@PathVariable("schemetype") String schemeType) {
		List<LoanSchemaDetails> loanScheme = dashService.getLoanScheme(schemeType); // null check already in service....
		return loanScheme;
	}

	// Get Recurring type - scheme..............................................
	@GetMapping("/scheme/recurring/{schemetype}")
	List<RecurringSchemaDetails> getRecurringScheme(@PathVariable("schemetype") String schemeType) {
		List<RecurringSchemaDetails> reccScheme = dashService.getRecurringScheme(schemeType);
		return reccScheme;
	}

	// Get Saving and Current type - scheme.....................................
	@GetMapping("/scheme/saveandcurrent/{schemetype}")
	List<SavingSchemaDetails> getSavingAndCurrentScheme(@PathVariable("schemetype") String schemeType) {
		List<SavingSchemaDetails> savAndCurrScheme = dashService.getSavingAndcurrentScheme(schemeType);
		return savAndCurrScheme;
	}

	// Get Mis and fix type - scheme.............................................
	@GetMapping("/scheme/misandfix/{schemetype}")
	List<FixedSchemaDetails> getMisandfixScheme(@PathVariable("schemetype") String schemeType) {
		List<FixedSchemaDetails> misAndfisScheme = dashService.getMisAndFixScheme(schemeType);
		return misAndfisScheme;
	}

	// Get DDS2 type - scheme....................................................
	@GetMapping("/scheme/dds2/{schemetype}")
	List<SchemaDetail> getDds2Scheme(@PathVariable("schemetype") String schemeType) {
		List<SchemaDetail> dds2List = dashService.getDds2Schema(schemeType);
		return dds2List;
	}
	
	
	//Cash bank report..............................................................................
	@GetMapping("/cash_bank_report/bank")
	List<iCashBankReport> getCashBankReport1(@RequestParam String date) {
		List<iCashBankReport> report = dashService.getCashBankReport1(date);
		return report;
	}
	
	@GetMapping("/cash_bank_report/bankOD")
	List<iCashBankReport> getCashBankReport2(@RequestParam String date) {
		List<iCashBankReport> report = dashService.getCashBankReport2(date);
		return report;
	}
	
	@GetMapping("/cash_bank_report/cash")
	List<iCashBankReport> getCashBankReport3(@RequestParam String date) {
		List<iCashBankReport> report = dashService.getCashBankReport3(date);
		return report;
	}
	
	
	
	
	
	
	
	

	// get account details..............................................................
	@GetMapping("/account_details/{id}")
	List<AccountsDetails> getAcntDetails(@PathVariable("id") Integer id) {
		List<AccountsDetails>  acDetails = dashService.getAccountDetails(id);
		return acDetails;
	}
	
	// get account details..............................................................
	@GetMapping("/account_details1/{memberId}")
	AccountsDetails getAcntDetails1(@PathVariable("memberId") Integer memberId) {
		AccountsDetails  acDetails = dashService.getAccountDetails1(memberId);
		return acDetails;
	}
	
	@GetMapping("/account_details/documents/{id}")
	List<iAccountDetails> getAccountDocuments(@PathVariable("id") Integer id) {
		List<iAccountDetails>  acDetails = dashService.getAccountDocuments(id);
		return acDetails;
	}
	
	@GetMapping("/account_details/insurance/{id}")
	List<iAccountDetails> getAccountInsurance(@PathVariable("id") Integer id) {
		List<iAccountDetails>  acDetails = dashService.getAccountInsurance(id);
		return acDetails;
	}
	
	
	// get premium details...........................
	@GetMapping("/premiums_deatils/{acId}")
	public List<PremiusDetails> getPremiumDetails(@PathVariable("acId") Integer acId) {
		List<PremiusDetails> prmList = dashService.getPremiumDetails(acId);
		return prmList;
	}

}
