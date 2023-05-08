package DAO;

import java.time.LocalDate;

import Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.Session;

import Entity.Account;
import Entity.Customer;
import Entity.transaction;
import exception.SomethingWentWrong;
import jakarta.persistence.*;
import jakarta.transaction.Transaction;

public class transactionImpl implements transactions{
	@Override
	public List<transaction> viewAllTransactionDayWise(String a,String e) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			
			em = utility.utility.getEm();
			
			Query q = em.createQuery("from transaction t where t.date >= :para and t.date <= :para2");
			
			q.setParameter("para", LocalDate.parse(a));
			q.setParameter("para2", LocalDate.parse(e));
			
			List<transaction> lt = q.getResultList();
			
			return lt;
	
		}catch(Exception ef) {
		
			throw new SomethingWentWrong("No Record Found");
			
			
		}finally {
		 em.close();
		}
		
		
	}

	@Override
	public List<transaction> viewAllHighlyMagnitude() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deposit(Account a, double amount) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
		List<transaction> t = a.getT();
		LocalDate ld = LocalDate.now();
		
		transaction t1 = new transaction(amount,ld,a.getAccountNo(),a.getAccountNo(),false,true,a);
		
		if(t == null) {
			List<transaction> h = new ArrayList<>();
			
			h.add(t1);
			a.setT(h);
		}
		else {
			t.add(t1);
			a.setT(t);
		}
		
		EntityManager em = null;
		try {
			em = utility.utility.getEm();
				double am = a.getAmount();
				a.setAmount(amount+am);
			em.getTransaction().begin();
			em.merge(a);
			em.getTransaction().commit();
			return "Amount Deposite Rupee "+amount;
		}catch(Exception e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}finally {
			em.close();
		}
		
		
	}

	@Override
	public String withdraw(Account a, double amount) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		List<transaction> t = a.getT();
		LocalDate ld = LocalDate.now();
		double am = a.getAmount();
		
		if(am<amount) {
			throw new SomethingWentWrong("You Don't Have Enough Balance");
		}
		
		if(t == null) {
			List<transaction> h = new ArrayList<>();
			transaction t1 = new transaction(amount,ld,a.getAccountNo(),a.getAccountNo(),true,false,a);
			h.add(t1);
			a.setT(h);
		}
		else {
			transaction t1 = new transaction(amount,ld,a.getAccountNo(),a.getAccountNo(),true,false,a);
			t.add(t1);
			a.setT(t);
		}
		
		EntityManager em = null;
		try {
			em = utility.utility.getEm();

			a.setAmount(am-amount);
			
			em.getTransaction().begin();
			em.merge(a);
			em.getTransaction().commit();
			
			return "Amount Withdraw Rupee "+amount;
		}catch(Exception e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}finally {
			em.close();
		}
	}

	@Override
	public String trans(Account a, double amount, String accNum, Customer c) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			
			em = utility.utility.getEm();
			Query q = em.createQuery("from Account t where t.accountNo = :para ");
			q.setParameter("para", accNum);
			
			
			Account h = (Account) q.getSingleResult();
			
			double am = h.getAmount();
			h.setAmount(amount+am);
			
			double n = a.getAmount();
			a.setAmount(n-amount);
			
			LocalDate ld = LocalDate.now();
			transaction l = new transaction(amount,ld,h.getAccountNo(),a.getAccountNo(),true,a);
			l.setWithdraw(false);
			transaction l1 = new transaction(amount,ld,a.getAccountNo(),h.getAccountNo(),true,false,a);
			
			List<transaction> t = a.getT();
			
			if(t == null) {
				List<transaction> h1 = new ArrayList<>();
				h1.add(l1);
				a.setT(h1);
			}
			else {
				t.add(l1);
				a.setT(t);
			}
			
			List<transaction> t1 = h.getT();
			
			if(t1 == null) {
				List<transaction> h1 = new ArrayList<>();
				h1.add(l);
				h.setT(h1);
			}
			else {
				t1.add(l);
				h.setT(t1);
			}
//			Customer custo = h.getCustomer();
			
			em.getTransaction().begin();
			em.merge(h);
			em.merge(a);
			em.getTransaction().commit();
			
		}catch(Exception ef) {
		
			throw new SomethingWentWrong(ef.getMessage());
			
			
		}finally {
		 em.close();
		}
		return accNum;
		
		
	}

	@Override
	public List<transaction> hist(Account a) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			
			em = utility.utility.getEm();
			
			List<transaction> t = a.getT();
			
			
			
			if(t == null) {
				throw new SomethingWentWrong("No transaction History");
			}
			
			return t;
			
			
		}catch(Exception e) {
			throw new SomethingWentWrong("Something went Wrong");
		}finally {
			em.close();
		}
	
	}
}
