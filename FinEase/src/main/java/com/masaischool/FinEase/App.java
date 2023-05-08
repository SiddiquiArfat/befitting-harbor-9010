package com.masaischool.FinEase;
import Entity.*;
import exception.SomethingWentWrong;
import jakarta.persistence.*;
import services.accountServices;
import services.accountServicesImpl;
import services.customers;
import services.customersImpl;
import services.transactionServiceImpl;
import services.transactionServices;

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
			if(lc == null) {
				throw new SomethingWentWrong("No Record Found");
			}
			lc.forEach(q -> System.out.println("Name : "+q.getName()+"/ Id : "+q.getId()+"/ Email : "+ q.getEmail()+"/ Mobile No. : "+ q.getMobile()));
			break;
			
			case 2: customers c1 = new customersImpl();
			System.out.println("Enter Customer ID");
			int id = sc.nextInt();
			Customer q = c1.viewCustomerByIdService(id);
			if(q == null) {
				throw new SomethingWentWrong("No Record Found");
			}
			System.out.println("Name : "+q.getName()+"/ Id : "+q.getId()+"/ Email : "+ q.getEmail()+"/ Mobile No. : "+ q.getMobile());
			break;
			
			case 3: accountServices as = new accountServicesImpl();
			List<Account> la = as.viewAllAccountService();
			if(la == null) {
				throw new SomethingWentWrong("No Record Found");
			}
			Consumer<List<Account>> con = (list)-> list.stream().forEach(s-> System.out.println("Account Number:"+s.getAccountNo()+"/ Account Holder:"+s.getName()+"/ Account Type:"+s.getType()+"/ Account Status:"+s.getStatus()));
			con.accept(la);
			break;
			
			case 4: accountServices as1 = new accountServicesImpl();
					System.out.println("Enter Account Number");
					String number = sc.next();
					Account s = as1.viewAccountByNumberService(number);
					System.out.println("Account Number:"+s.getAccountNo()+"/ Account Holder:"+s.getName()+"/ Account Type:"+s.getType()+"/ Account Status:"+s.getStatus());
					int f = 0;
					
					do {
					
						System.out.println("---------------------------------------------------------------------------------------------------------------------------");
						System.out.println("Enter 1 to view transaction History ");
						System.out.println("Else Enter 0");
						System.out.println("---------------------------------------------------------------------------------------------------------------------------");
						f = sc.nextInt();
						if(f == 1) {
						List<transaction> t1 = s.getT();
						if(t1 == null) {
							throw new SomethingWentWrong("No Record Found");
						}
							t1.forEach(d1->System.out.println("Account No. "+d1.getAcountNum()+" / transaction ID: "+d1.getId()+" / To Account Number: "+d1.getToAccountNum()+" / Transaction Date: "+d1.getDate()));
						}
					}while(f!=0 || f>1);
					break;
					
			case 5: accountServices as2 = new accountServicesImpl();
					System.out.println("---------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Enter Account Number");
					System.out.println("---------------------------------------------------------------------------------------------------------------------------");
					String accNumber = sc.next();
					System.out.println(as2.changeStatusService(accNumber));  
					System.out.println("---------------------------------------------------------------------------------------------------------------------------");
					break;
			case 7: accountServices as3 = new accountServicesImpl();
				List<Account> la2 = as3.viewAllClosedAccountService();
				System.out.println("---------------------------------------------------------------------------------------------------------------------------");
				
				if(la2 == null) {
					throw new SomethingWentWrong("No Record Found");
				}
				Consumer<List<Account>> con1 = (list)-> list.stream().forEach(s1-> System.out.println("Account Number:"+s1.getAccountNo()+"/ Account Holder:"+s1.getName()+"/ Account Type:"+s1.getType()+"/ Account Status:"+s1.getStatus()));
				con1.accept(la2);
				System.out.println("---------------------------------------------------------------------------------------------------------------------------");
				break;
			case 6: accountServices as4 = new accountServicesImpl();
				List<Account> la3 = as4.viewAllInoperativeAccountService();
				System.out.println("---------------------------------------------------------------------------------------------------------------------------");
				if(la3 == null) {
					throw new SomethingWentWrong("No Record Found");
				}
				Consumer<List<Account>> con2 = (list)-> list.stream().forEach(s2-> System.out.println("Account Number:"+s2.getAccountNo()+"/ Account Holder:"+s2.getName()+"/ Account Type:"+s2.getType()+"/ Account Status:"+s2.getStatus()));
				con2.accept(la3);
				System.out.println("---------------------------------------------------------------------------------------------------------------------------");
				break;
			case 8: transactionServices t = new  transactionServiceImpl();
					System.out.println("Enter Starting Date (YYYY/MM/DD)");
					
					String startDate = sc.next();
					
					System.out.println("Enter Ending Date (YYYY/MM/DD)");
					String endDate = sc.next();
					List<transaction> lt = t.viewAllTransactionDayWiseService(startDate,endDate);
					if(lt == null) {
						throw new SomethingWentWrong("No Record Found");
					}
					Consumer<List<transaction>> con5 = (list)-> list.stream().forEach(s6-> System.out.println("Account Number:"+s6.getAcountNum()+"/ Amount :"+s6.getAmount()+"/ transaction:"+s6.getId()+"/ paid to:"+s6.getToAccountNum()));
					con5.accept(lt);
					System.out.println("---------------------------------------------------------------------------------------------------------------------------");
					
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
		
		
		
		Account a = new Account("asas","asass","asssaa","asass","sdf",c);
		
		transaction t = new transaction(234324,LocalDate.parse("2020-09-09"),"asdasd","asdad",a);
		
		List<transaction> lt = a.getT();
		
		if(lt == null) {
			List<transaction> lt1 = new ArrayList<>();
			lt1.add(t);
			a.setT(lt1);
		}
		else {
			lt.add(t);
			a.setT(lt);
		}
	
		Set<Account> sa = c.getAcc();
		
		if(sa == null) {
			Set<Account> ad = new HashSet<>();
			ad.add(a);
			c.setAcc(ad);
		}
		else {
			sa.add(a);
			c.setAcc(sa);
		}
		
		
	
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
