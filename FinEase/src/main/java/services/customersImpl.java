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

}
