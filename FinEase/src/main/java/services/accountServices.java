package services;

import java.util.List;

import Entity.Account;
import exception.SomethingWentWrong;

public interface accountServices {
	public List<Account> viewAllAccountService() throws SomethingWentWrong;
	public Account viewAccountByNumberService(String number) throws SomethingWentWrong;
	public List<Account> viewAllInoperativeAccountService() throws SomethingWentWrong;
	public List<Account> viewAllClosedAccountService() throws SomethingWentWrong;
	public String changeStatusService(String number) throws SomethingWentWrong;
}
