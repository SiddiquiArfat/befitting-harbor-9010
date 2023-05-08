package DAO;

import java.util.List;
import java.util.Scanner;

import Entity.Account;
import Entity.Customer;
import Entity.transaction;
import exception.SomethingWentWrong;

public interface transactions {
	public List<transaction> viewAllTransactionDayWise(String s,String e) throws SomethingWentWrong;
	
	public List<transaction> viewAllHighlyMagnitude() throws SomethingWentWrong;

	public String deposit(Account a, double amount) throws SomethingWentWrong;

	public String withdraw(Account a, double amount) throws SomethingWentWrong;

	public String trans(Account a, double amount, String accNum, Customer c) throws SomethingWentWrong;

	public List<transaction> hist(Account a) throws SomethingWentWrong;
}
