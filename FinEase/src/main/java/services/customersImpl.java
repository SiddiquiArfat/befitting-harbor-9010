package services;

import java.util.List;

import DAO.customer;
import DAO.customerImpl;
import Entity.Customer;
import exception.SomethingWentWrong;

public class customersImpl implements customers{

	@Override
	public List<Customer> viewAllCustomerService() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
		customer c = new customerImpl();
		List<Customer> lc = c.viewAllCustomer();
		
		return lc;
	}

	@Override
	public Customer viewCustomerByIdService(int id) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		customer c1 = new customerImpl();
		return (Customer) c1.viewCustomerbyId(id);
	}

	@Override
	public Customer loginCustomer(String username, String passwodrd) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		customer c = new customerImpl();
		
		return c.loginCustomers(username, passwodrd);
		
	}

	@Override
	public String updateDetails(String name, String mobile, String city, String state, int zipcode,Customer c)
			throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
		customer f = new customerImpl();
		f.updateDetails(name, mobile, city, state, zipcode,c);
		
		return null;
	}

	@Override
	public String changePassword(Customer c, String pass) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
		customer c4 = new customerImpl();
		return c4.changePassword(c, pass);
		
		
	}

}
