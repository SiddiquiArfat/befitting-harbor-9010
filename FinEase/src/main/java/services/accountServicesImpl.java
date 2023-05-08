package services;

import java.util.List;

import DAO.account;
import DAO.accountImpl;
import Entity.Account;
import Entity.Customer;
import exception.SomethingWentWrong;

public class accountServicesImpl implements  accountServices{

	@Override
	public List<Account> viewAllAccountService() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		account a = new accountImpl();
		List<Account> la = a.viewAllAccount();
		return la;
	}

	@Override
	public Account viewAccountByNumberService(String number) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		account a = new accountImpl();
		Account la = a.viewAccountByNumber(number);
		return la;
		
	}

	@Override
	public List<Account> viewAllInoperativeAccountService() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
		account a = new accountImpl();
		List<Account> la = a.viewAllInoperativeAccount();
		return la;
		
		
	}

	@Override
	public List<Account> viewAllClosedAccountService() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
		account a = new accountImpl();
		List<Account> la = a.viewAllClosedAccount();
		return la;
	}

	@Override
	public String changeStatusService(String number) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		account df = new accountImpl();
		return df.changeStatus(number);
		
	}

	@Override
	public Account signIn(java.util.Set<Account> t, String number, int pin) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		account a = new accountImpl();
		return a.signInAcc(t, number, pin);
		
	}

	@Override
	public String addAccountService(String name, String status, String type, String acc, int pin, Customer c) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		account a = new accountImpl();
		return a.addAccount(name,status,type,acc,pin,c);
		 
	}

}
