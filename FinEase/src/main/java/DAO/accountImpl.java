package DAO;

import java.util.List;

import Entity.Account;
import exception.SomethingWentWrong;
import jakarta.persistence.*;

public class accountImpl implements account{

	@Override
	public List<Account> viewAllAccount() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;
		
		try {
			em = utility.utility.getEm();
			Query q = em.createQuery("FROM Account a");
			List<Account> la = q.getResultList();
			
			return la;
		}
		catch(Exception e) {
			throw new SomethingWentWrong("No Record Found");
		}
		finally {
			em.close();
		}
		
		
	}

	@Override
	public Account viewAccountByNumber(String number) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			
			em = utility.utility.getEm();
			Query q = em.createQuery("FROM Account a where e.accountNo");
			
			Account a = (Account) q.getSingleResult();
			return a;
			
		}catch(Exception e) {
			throw new SomethingWentWrong("Account Number did'nt in database");
		}finally {
			em.close();
		}
		
	}

	@Override
	public List<Account> viewAllInoperativeAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> viewAllClosedAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
