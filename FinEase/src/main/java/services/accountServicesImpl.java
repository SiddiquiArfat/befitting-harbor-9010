package services;

import java.util.List;

import DAO.account;
import DAO.accountImpl;
import Entity.Account;
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
	public List<Account> viewAllInoperativeAccountService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> viewAllClosedAccountService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeStatusService() {
		// TODO Auto-generated method stub
		return null;
	}

}
