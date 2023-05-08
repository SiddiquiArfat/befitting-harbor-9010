package DAO;

import java.util.List;

import Entity.Account;
import exception.SomethingWentWrong;

public interface account {
	public List<Account> viewAllAccount() throws SomethingWentWrong;
	public Account viewAccountByNumber(String number) throws SomethingWentWrong;
	public List<Account> viewAllInoperativeAccount() throws SomethingWentWrong;
	public List<Account> viewAllClosedAccount() throws SomethingWentWrong;
	public String changeStatus(String number) throws SomethingWentWrong;
	
}
