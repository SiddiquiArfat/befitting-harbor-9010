package services;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


import DAO.transactionImpl;
import DAO.transactions;
import Entity.Account;
import Entity.Customer;
import Entity.transaction;
import exception.SomethingWentWrong;
import jakarta.persistence.*;

public class transactionServiceImpl implements transactionServices{

	@Override
	public List<transaction> viewAllTransactionDayWiseService(String a,String e) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
		transactions t = new transactionImpl();
		return t.viewAllTransactionDayWise(a, e);
		
	}

	@Override
	public List<transaction> viewAllHighlyMagnitudeService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deposit(Account a, double amount) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
		transactions t = new transactionImpl();
		return t.deposit(a,amount);
		
	}

	@Override
	public String withdraw(Account a, double amount) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		transactions t = new transactionImpl();
		return t.withdraw(a,amount);
		
	}

	@Override
	public String transaction(Account a, double amount, String accNum, Customer c) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		transactions t = new transactionImpl();
		return t.trans(a,amount,accNum,c);
		
	}

	@Override
	public void history(Account a, Scanner sc) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		transactions t = new transactionImpl();
		List<transaction> t1 = t.hist(a);
		
		System.out.println("Enter Starting Date(YYYY-MM-DD)");
		LocalDate start = LocalDate.parse(sc.next());
		System.out.println("Enter Ending Date(YYYY-MM-DD)");
		LocalDate end = LocalDate.parse(sc.next());
		
		
		for(transaction t3: t1) {
			if(t3.getDate().compareTo(start)>=0 && t3.getDate().compareTo(end)<=0) {
				System.out.println(t3);
			}
		}
		
	}

}
