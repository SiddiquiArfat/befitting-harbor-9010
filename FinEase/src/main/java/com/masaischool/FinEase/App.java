package com.masaischool.FinEase;
import Entity.*;
import exception.SomethingWentWrong;
import jakarta.persistence.*;
import services.accountServices;
import services.accountServicesImpl;
import services.customers;
import services.customersImpl;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;

import org.hibernate.internal.build.AllowSysOut;

import DAO.*;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
	
	
    public static void main( String[] args ) throws SomethingWentWrong
    {
    	
    	Scanner sc = new Scanner(System.in);

    	System.out.println("Welcome to FinEase");
		

			int preference = 0;
			do {
				System.out.println("---------------------------------------------------------------------------------------------------------------------------");
				System.out.println("Please enter your preference, " + " '1' --> Admin login , '2' --> Customer login , "
				+ "'3' for Customer signup, '0' for exit");
				System.out.println("---------------------------------------------------------------------------------------------------------------------------");
				preference = sc.nextInt();
				switch (preference) {
				case 1:
					adminFunctions(sc);
					break;
				case 2:
					customerFuntions(sc);
					break;

				case 3:
					addCustomer(sc);
					break;

				case 0:
					System.out.println("successfully existed from the system");
					break;

				default:
					throw new IllegalArgumentException("Invalid Selection");
				}

			}while (preference != 0);

    }

	
//    Admin UI
	private static void adminFunctions(Scanner sc) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		int session_id = adminLogin(sc);
		if(session_id == 1) {
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Successfully Loged In");
		}
		int choice = 0;
		do {
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Enter (1) -------> View information about all customers");
			System.out.println("Enter (2) -------> Viewing particular customer details by customer_id");
			System.out.println("Enter (3) -------> View information about all accounts");
			System.out.println("Enter (4) -------> Viewing particular account details by account_number");
			System.out.println("Enter (5) -------> Change the status of account from active to inoperative if no trsnaction for last 24\r\n"
					+ "months");
			System.out.println("Enter (6) -------> view all inoperative accounts");
			System.out.println("Enter (7) -------> view all closed accounts");
			System.out.println("Enter (8) -------> view the transaction report for a day range for all accounts.");
			System.out.println("Enter (9) -------> See all high magnitude transaction for a day i.e. only those transaction in which\r\n"
					+ "more than 49999 is transferred");
			
			System.out.println("Enter (0) -------> Logout from account");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1: customers c = new customersImpl();
			List<Customer> lc = c.viewAllCustomerService();
			lc.forEach(q -> System.out.println("Name : "+q.getName()+"/ Id : "+q.getId()+"/ Email : "+ q.getEmail()+"/ Mobile No. : "+ q.getMobile()));
			break;
			
			case 2: customers c1 = new customersImpl();
			System.out.println("Enter Customer ID");
			int id = sc.nextInt();
			Customer q = c1.viewCustomerByIdService(id);
			System.out.println("Name : "+q.getName()+"/ Id : "+q.getId()+"/ Email : "+ q.getEmail()+"/ Mobile No. : "+ q.getMobile());
			break;
			
			case 3: accountServices as = new accountServicesImpl();
			List<Account> la = as.viewAllAccountService();
			Consumer<List<Account>> con = (list)-> list.stream().forEach(s-> System.out.println("Account Number:"+s.getAccountNo()+"/ Account Holder:"+s.getName()+"/ Account Type:"+s.getType()+"/ Account Status:"+s.getStatus()));
			con.accept(la);
			break;
			
			case 4: accountServices as1 = new accountServicesImpl();
					System.out.println("Enter Account Number");
					String number = sc.next();
					as1.viewAccountByNumberService(number);
				break;
			}
			
		}while(choice!=0);
		
	}

	private static int adminLogin(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter UserName : ");
		String userName = sc.next();
		System.out.println("Enter Password : ");
		String password = sc.next();
		
		
		if(userName.equals("") || password.equals("")) {
			System.out.println("Please Enter Credentals First! ");
		}
		
		if(userName.equals("admin") && password.equals("admin")) {
			return 1;
		}
		
		else {
			throw new IllegalArgumentException("Wrong Credentials!!!! try again with right credentials");
		}

	}
	
	
	static EntityManagerFactory emf = null;
	static {
		emf = Persistence.createEntityManagerFactory("finease-connect");
	}
	
	
	
	
	private static void addCustomer(Scanner sc) {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		
		c.setName("arfafdt");
		c.setEmail("easddfds");
		c.setAge(13242);
		c.setMobile("2323sdf234324");
		c.setPassword("sadsdfsaddsa");
		Address address = new Address("assdfd","asdfsd",324324);
		List<Address> add = c.getLi();
		address.setCustomer(c);
		if(add == null) {
			List<Address> ad = new ArrayList<>();
			ad.add(address);
			c.setLi(ad);
		}
		else {
			add.add(address);
			c.setLi(add);
		}
		
		
		
//		Account a = new Account("asas","asass","asssaa","asass","sdf",c);
//		
//		transaction t = new transaction(234324,LocalDate.parse("2020-09-09"),"asdasd","asdad",a);
//		
//		List<transaction> lt = a.getT();
//		
//		if(lt == null) {
//			List<transaction> lt1 = new ArrayList<>();
//			lt1.add(t);
//			a.setT(lt1);
//		}
//		else {
//			lt.add(t);
//			a.setT(lt);
//		}
//	
//		Set<Account> sa = c.getAcc();
//		
//		if(sa == null) {
//			Set<Account> ad = new HashSet<>();
//			ad.add(a);
//			c.setAcc(ad);
//		}
//		else {
//			sa.add(a);
//			c.setAcc(sa);
//		}
		
		
	
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
		em.close();
		
	}

	private static void customerFuntions(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	
    
}
