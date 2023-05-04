package com.masaischool.FinEase;
import Entity.*;
import jakarta.persistence.*;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
	
	static EntityManagerFactory emf = null;
	
	static {
		emf = Persistence.createEntityManagerFactory("finease-connect");
	}
	
	
    public static void main( String[] args )
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

	

	private static void adminFunctions(Scanner sc) {
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
	
	
	
	private static void addCustomer(Scanner sc) {
		// TODO Auto-generated method stub
//		Customer c = new Customer();
//		
//		c.setName("arfat");
//		c.setEmail("easdds");
//		c.setAge(12);
//		c.setMobile("2323234324");
//		c.setPassword("sadsaddsa");
//		Address address = new Address("asd","asd",324324);
//		List<Address> add = c.getLi();
//		address.setCustomer(c);
//		if(add == null) {
//			List<Address> ad = new ArrayList<>();
//			ad.add(address);
//			c.setLi(ad);
//		}
//		else {
//			add.add(address);
//			c.setLi(add);
//		}
//		
//		
//	
//		EntityManager em = emf.createEntityManager();
//		
//		EntityTransaction et = em.getTransaction();
//		et.begin();
//		em.persist(c);
//		et.commit();
//		em.close();
		
	}

	private static void customerFuntions(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	
    
}
