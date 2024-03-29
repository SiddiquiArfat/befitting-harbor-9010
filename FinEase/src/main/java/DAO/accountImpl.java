package DAO;


import java.util.*;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.mapping.Set;

import Entity.Account;
import Entity.Customer;
import Entity.transaction;
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
			Query q = em.createQuery("FROM Account a where a.accountNo = :para");
			
			q.setParameter("para", number);
			
			
			Account acc = (Account) q.getSingleResult();
			return acc;
			
		}catch(Exception e) {
			throw new SomethingWentWrong("Account Number Not Available in database");
		}finally {
			em.close();
		}
		
	}

	@Override
	public List<Account> viewAllInoperativeAccount() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
		EntityManager em = utility.utility.getEm();
		try {
			Query q = em.createQuery("from Account a where a.status = :para");
			q.setParameter("para", "Non-Operative");
			
			List<Account> la = q.getResultList();
			return la;
		}
		catch(Exception e) {
			throw new SomethingWentWrong("No Record Found");
		}finally {
			em.close();
		}
		
		
	}

	@Override
	public List<Account> viewAllClosedAccount() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
		EntityManager em = utility.utility.getEm();
		try {
			Query q = em.createQuery("from Account a where a.status = :para");
			q.setParameter("para", "Closed");			
			List<Account> la = q.getResultList();
			return la;
		}
		catch(Exception e) {
			throw new SomethingWentWrong("No Record Found");
		}finally {
			em.close();
		}
		
	}

	@Override
	public String changeStatus(String number) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			
			em = utility.utility.getEm();
			Query q = em.createQuery("FROM Account a where a.accountNo = :para");
			
			q.setParameter("para", number);
			
			
			Account acc = (Account) q.getSingleResult();
			
			LocalDate ld = LocalDate.now();
			LocalDate j = ld.minusMonths(24);
			
			List<transaction> lt = acc.getT();
			
			 
			
			for(transaction t2: lt) {
				if(t2.getDate().compareTo(j)<0 && !acc.getStatus().equals("Non-Operative")) {
					acc.setStatus("Non-Operative");
					System.out.println(acc.getStatus());
					em.getTransaction().begin();
					em.merge(acc);
					em.getTransaction().commit();
					return "Status changed to Non-Operative Account";
				}
			}
			
			
			
			return "Status remain same";
			
		}catch(Exception e) {
			throw new SomethingWentWrong("Account Number is not available in database");
		}finally {
			em.close();
		}
	}

	@Override
	public Account signInAcc(java.util.Set<Account> acc, String number, int pin) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
		try {
			for(Account g: acc) {
				if(g.getAccountNo().equals(number) && g.getPin() == pin){
					Account h = g;
					return h;
				}
			}
		}
		catch(Exception e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}
		
		return null;
	}

	@Override
	public String addAccount(String name, String status, String type, String acc, int pin, Customer c) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		java.util.Set<Account> d = c.getAcc();
		for(Account g: d) {
			if(g.getType().equals(type) && g.getStatus().equals("active")) {
				throw new SomethingWentWrong("You Already have one "+type+" account");
			}
		}
		Account a = new Account(name,type,status,pin,acc,c);
		EntityManager em = null;
		if(d == null) {
			java.util.Set<Account> n = new HashSet<>();
			n.add(a);
			c.setAcc(n);
		}else {
			d.add(a);
			c.setAcc(d);
		}
		try {
			
			em = utility.utility.getEm();
			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();
		}catch(Exception e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}finally {
			em.close();
		}
		return "Your Account Add "+pin+" is your Account pin Please kept it save";
	}
	
}
