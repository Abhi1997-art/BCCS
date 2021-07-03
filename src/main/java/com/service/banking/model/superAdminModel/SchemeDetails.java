package com.service.banking.model.superAdminModel;

import java.math.BigDecimal;
import java.util.Date;

public class SchemeDetails {
	
	private Integer id;
	private String name;
	private Boolean activeStatus;
	private String interest;
	private Integer maturityPeriod;
	private String schemeGroup;
	private Double minLimit;
	private Double maxLimit;
	private Integer crpb;
	private Double commission;
	private String interestMode;
	private String interestRateMode;
	private String accountOpenningCommission;
	private String collectorCommissionRate;
	private Integer percentLoanOnDeposit;
	private Integer noLoanOnDepositTill;
	private String preMatureInterests;
	private Date validTill;
	private BigDecimal matureInterestsForUncompleteProduct;
	private Integer headId;
	
	private Date createdAt;
	private Date updatedAt;
	private Double processingFees;
	private int balanceSheetId;
	private String postingMode;
	private String premiumMode;
	private Boolean createDefaultAccount;
	private String schemeType;
	private Boolean interestToAnotherAccount;
	private Integer numberOfPremiums;
	private String interestToAnotherAccountPercent;
	private Byte isDepriciable;
	private String depriciationPercentBeforeSep;
	private String depriciationPercentAfterSep;
	private Boolean processingFeesinPercent;
	private Boolean published;
	private Float schemePoints;
	private String agentSponsorCommission;

	private String reducingOrFlatRate;
	private String type;



	private Integer panelty;
	private Integer paneltyGrace;
	
	
	
	public SchemeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}



	public SchemeDetails(Integer id, String interest, String preMatureInterests,
			BigDecimal matureInterestsForUncompleteProduct) {
		super();
		this.id = id;
		this.interest = interest;
		this.preMatureInterests = preMatureInterests;
		this.matureInterestsForUncompleteProduct = matureInterestsForUncompleteProduct;
	}



	public SchemeDetails(Integer id, String name, Boolean activeStatus, String interest, Integer maturityPeriod,
			String schemeGroup, Double minLimit, Double maxLimit, Integer crpb, Double commission, String interestMode,
			String interestRateMode, String accountOpenningCommission, String collectorCommissionRate,
			Integer percentLoanOnDeposit, Integer noLoanOnDepositTill, String preMatureInterests, Date validTill,
			BigDecimal matureInterestsForUncompleteProduct, Integer headId, Date createdAt, Date updatedAt,
			Double processingFees, int balanceSheetId, String postingMode, String premiumMode,
			Boolean createDefaultAccount, String schemeType, Boolean interestToAnotherAccount, Integer numberOfPremiums,
			String interestToAnotherAccountPercent, Byte isDepriciable, String depriciationPercentBeforeSep,
			String depriciationPercentAfterSep, Boolean processingFeesinPercent, Boolean published, Float schemePoints,
			String agentSponsorCommission, String reducingOrFlatRate, String type, Integer panelty,
			Integer paneltyGrace) {
		super();
		this.id = id;
		this.name = name;
		this.activeStatus = activeStatus;
		this.interest = interest;
		this.maturityPeriod = maturityPeriod;
		this.schemeGroup = schemeGroup;
		this.minLimit = minLimit;
		this.maxLimit = maxLimit;
		this.crpb = crpb;
		this.commission = commission;
		this.interestMode = interestMode;
		this.interestRateMode = interestRateMode;
		this.accountOpenningCommission = accountOpenningCommission;
		this.collectorCommissionRate = collectorCommissionRate;
		this.percentLoanOnDeposit = percentLoanOnDeposit;
		this.noLoanOnDepositTill = noLoanOnDepositTill;
		this.preMatureInterests = preMatureInterests;
		this.validTill = validTill;
		this.matureInterestsForUncompleteProduct = matureInterestsForUncompleteProduct;
		this.headId = headId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.processingFees = processingFees;
		this.balanceSheetId = balanceSheetId;
		this.postingMode = postingMode;
		this.premiumMode = premiumMode;
		this.createDefaultAccount = createDefaultAccount;
		this.schemeType = schemeType;
		this.interestToAnotherAccount = interestToAnotherAccount;
		this.numberOfPremiums = numberOfPremiums;
		this.interestToAnotherAccountPercent = interestToAnotherAccountPercent;
		this.isDepriciable = isDepriciable;
		this.depriciationPercentBeforeSep = depriciationPercentBeforeSep;
		this.depriciationPercentAfterSep = depriciationPercentAfterSep;
		this.processingFeesinPercent = processingFeesinPercent;
		this.published = published;
		this.schemePoints = schemePoints;
		this.agentSponsorCommission = agentSponsorCommission;
		this.reducingOrFlatRate = reducingOrFlatRate;
		this.type = type;
		this.panelty = panelty;
		this.paneltyGrace = paneltyGrace;
	}
	
	
	


}
