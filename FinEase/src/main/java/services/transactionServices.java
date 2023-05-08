package services;

import java.util.List;
import java.util.Scanner;

import Entity.Account;
import Entity.Customer;
import Entity.transaction;
import exception.SomethingWentWrong;

public interface transactionServices {
public List<transaction> viewAllTransactionDayWiseService(String s,String e) throws SomethingWentWrong;
	
	public List<transaction> viewAllHighlyMagnitudeService();

	public String deposit(Account a, double amount) throws SomethingWentWrong;

	public String withdraw(Account a, double amount) throws SomethingWentWrong;

	public String transaction(Account a, double amount, String accNum, Customer c) throws SomethingWentWrong;

	public void history(Account a, Scanner sc) throws SomethingWentWrong;
}
