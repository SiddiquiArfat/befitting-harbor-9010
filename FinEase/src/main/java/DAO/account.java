package DAO;

import java.util.List;
import java.util.Set;

import Entity.Account;
import Entity.Customer;
import exception.SomethingWentWrong;

public interface account {
	public List<Account> viewAllAccount() throws SomethingWentWrong;
	public Account viewAccountByNumber(String number) throws SomethingWentWrong;
	public List<Account> viewAllInoperativeAccount() throws SomethingWentWrong;
	public List<Account> viewAllClosedAccount() throws SomethingWentWrong;
	public String changeStatus(String number) throws SomethingWentWrong;
	public Account signInAcc(Set<Account> t, String number, int pin) throws SomethingWentWrong;
	public String addAccount(String name, String status, String type, String acc, int pin, Customer c) throws SomethingWentWrong;
}
