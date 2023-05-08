package services;

import java.util.List;
import java.util.Set;

import Entity.Account;
import Entity.Customer;
import exception.SomethingWentWrong;

public interface accountServices {
	public List<Account> viewAllAccountService() throws SomethingWentWrong;
	public Account viewAccountByNumberService(String number) throws SomethingWentWrong;
	public List<Account> viewAllInoperativeAccountService() throws SomethingWentWrong;
	public List<Account> viewAllClosedAccountService() throws SomethingWentWrong;
	public String changeStatusService(String number) throws SomethingWentWrong;
	public Account signIn(Set<Account> t, String number, int pin) throws SomethingWentWrong;
	public String addAccountService(String name, String status, String type, String acc, int pin, Customer c) throws SomethingWentWrong;
	
}
