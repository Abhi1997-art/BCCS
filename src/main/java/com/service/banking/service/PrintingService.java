package com.service.banking.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.service.banking.model.printingModel.*;
import com.service.banking.repository.transaction.TransactionRowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.banking.hibernateEntity.ContentFiles;
import com.service.banking.repository.AccountsRepo.AccountsRepo;
import com.service.banking.repository.PrintRepo.ContentFileRepo;
import com.service.banking.repository.madRepository.MembersRepo;
import com.service.banking.utils.DateFormater;

@Service
public class PrintingService {

    @Autowired
    AccountsRepo accountsRepo;

    @Autowired
    MembersRepo memRepo;

    @Autowired
    ContentFileRepo contFile;

    @Autowired
    TransactionRowRepo transactionRowRepo;

    DateFormater dateformater = new DateFormater();

    // get all fd accounts..................
    public List<FDAccountDetails> getFDAccounts(String accountName) {
        List<FDAccountDetails> fdAccounts = accountsRepo.FDAccounts(accountName);
        if (fdAccounts.size() != 0) {
            return fdAccounts;
        } else {
            return new ArrayList<FDAccountDetails>();
        }


    }

    public AcountDetails getAccountsDetails(Integer id) {
        AcountDetails accounts = accountsRepo.getAccountById(id);

        //Amount × Roi ÷ 365 × Days
        Double interestRate = Double.parseDouble(accounts.getInterest());
        Double amount = accounts.getAmount();
        Integer years = accounts.getMaturityPeriod()/365;
        Integer RemainingDays= accounts.getMaturityPeriod() % 365;
        Double tempAmount = 0.0;
        Double remainingAmount=0.0;
        Double interestAmount = 0.0;

        if(accounts.getMaturityPeriod() > 365) {
            for (int i = 0; i < years; i++) {
                tempAmount = amount * (interestRate / 100);
                System.out.println(amount);
                amount += tempAmount;
                interestAmount += tempAmount;
                System.out.println(interestAmount);
            }
        }
        if(RemainingDays > 0) {
            remainingAmount = amount * (interestRate / 100) / 365 * RemainingDays;
            System.out.println("remainingAmount " + remainingAmount);
            interestAmount += remainingAmount;
        }

        if(RemainingDays == 0 && years == 1) {
            remainingAmount = amount * (interestRate / 100) / 365 * 365;
            System.out.println("remainingAmount " + remainingAmount);
            interestAmount += remainingAmount;
        }

        System.out.println("Final Amount " + (interestAmount + accounts.getAmount()));
        accounts.setMaturityAmount(Math.round(interestAmount+accounts.getAmount()));

        Date date = accounts.getCreatedAt();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, accounts.getMaturityPeriod());
        Date maturityDate = cal.getTime();
        accounts.setMaturityDate(maturityDate);

        accounts.setDepositeAmountWords(numberToWord((int)Math.round(accounts.getAmount())));
        accounts.setMaturityAmountWords(numberToWord((int)Math.round(interestAmount+accounts.getAmount())));

        if(accounts.getAccountType().equals("MIS")){
            accounts.setMaturityAmount(Math.round(accounts.getAmount()));
            accounts.setMaturityAmountWords(numberToWord((int)Math.round(accounts.getAmount())));
        }

        if (accounts != null) {
            return accounts;
        } else {
            return new AcountDetails();
        }
    }

    // get all share certificate accounts..................
    public List<ShareCertificateAccount> getShareCertificate(String accountName) {
        List<ShareCertificateAccount> shareAcnt = accountsRepo.ShareCertificateAccount(accountName);
        if (shareAcnt.size() != 0) {
            return shareAcnt;
        } else {
            return new ArrayList<ShareCertificateAccount>();
        }


    }

    // get accounts details  for share certificate.............

    public ShareAccountDetail getShareDetails(Integer id) {
        ShareAccountDetail accounts = accountsRepo.getShareAccountById(id);
        Integer certificateNo = Integer.parseInt(accounts.getAccountNumber().replaceAll("[\\D]", ""));
        accounts.setCertificateNo(certificateNo);
        if (accounts != null) {
            return accounts;
        } else {
            return new ShareAccountDetail();
        }
    }

    // get member accounts  for interest certificate.............

    public List<MemberDetail> getMember(String accountName) {
        List<MemberDetail> shareAcnt = memRepo.getPrintMember(accountName);
        if (shareAcnt.size() != 0) {
            return shareAcnt;
        } else {
            return new ArrayList<MemberDetail>();
        }
    }

    // get member accounts details  for interest certificate.............

    public PrintMemberDetail getMemberAccount(Integer memberId) {
        PrintMemberDetail printMember = memRepo.printMember(memberId);
        return printMember;
    }


    // get content file for print content  4 .............

    public List<ContentFiles> ContentFile() {
        List<ContentFiles> contentFiles = contFile.getContentFile();
        if (contentFiles.size() != 0) {
            return contentFiles;
        } else {
            return new ArrayList<ContentFiles>();
        }
    }

    // get Account details for print content 4 ..................
    public List<iPrintContent> printContentAcntDetails(PrintFileContentReq printFileContentReq) {

        String request = printFileContentReq.getAccountNumbers();
        String acNumbers = request.replaceAll("\\s", "");
        String[] accounts = acNumbers.split(",");

        List<iPrintContent> result = new ArrayList<>();

        for(String ac : accounts){
            iPrintContent content = accountsRepo.printContentAcntDetails(ac);
            result.add(content);
        }
        return result;

    }


    public List<iInterestCertificate> getIntCertificate(Integer memberId, String dateFrom, String dateTo) {
        List<iInterestCertificate> list = transactionRowRepo.getIntCertificate(memberId, dateFrom, dateTo);
        return list;
    }




    public static String numberToWord(int number) {
        // variable to hold string representation of number
        String words = "";
        String unitsArray[] = { "zero", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen" };
        String tensArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty",
                "sixty", "seventy", "eighty", "ninety" };

        if (number == 0) {
            return "zero";
        }
        // add minus before conversion if the number is less than 0
        if (number < 0) {
            // convert the number to a string
            String numberStr = "" + number;
            // remove minus before the number
            numberStr = numberStr.substring(1);
            // add minus before the number and convert the rest of number
            return "minus " + numberToWord(Integer.parseInt(numberStr));
        }

        // check if number is divisible by 1 crore
        if ((number / 10000000) > 0) {
            words += numberToWord(number / 10000000) + " crore ";
            number %= 10000000;
        }

        // check if number is divisible by 1 lakh
        if ((number / 100000) > 0) {
            words += numberToWord(number / 100000) + " lakh ";
            number %= 100000;
        }
        // check if number is divisible by 1 thousand
        if ((number / 1000) > 0) {
            words += numberToWord(number / 1000) + " thousand ";
            number %= 1000;
        }
        // check if number is divisible by 1 hundred
        if ((number / 100) > 0) {
            words += numberToWord(number / 100) + " hundred ";
            number %= 100;
        }

        if (number > 0) {
            // check if number is within teens
            if (number < 20) {
                // fetch the appropriate value from unit array
                words += unitsArray[number];
            } else {
                // fetch the appropriate value from tens array
                words += tensArray[number / 10];
                if ((number % 10) > 0) {
                    words += "-" + unitsArray[number % 10];
                }
            }
        }
        return words;
    }

}
