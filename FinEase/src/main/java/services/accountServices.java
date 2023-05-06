package services;

import java.util.List;

import Entity.Account;
import exception.SomethingWentWrong;

public interface accountServices {
	public List<Account> viewAllAccountService() throws SomethingWentWrong;
	public Account viewAccountByNumberService(String number);
	public List<Account> viewAllInoperativeAccountService();
	public List<Account> viewAllClosedAccountService();
	public String changeStatusService();
}
