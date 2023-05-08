package DAO;

import java.util.List;

import Entity.Customer;
import exception.SomethingWentWrong;

public interface customer{
	public List<Customer> viewAllCustomer() throws SomethingWentWrong;
	public Customer viewCustomerbyId(int id) throws SomethingWentWrong;
	public Customer loginCustomers(String username, String passwodrd) throws SomethingWentWrong;
	public String updateDetails(String name, String mobile, String city, String state, int zipcode, Customer c)
			throws SomethingWentWrong;
	
	public String changePassword(Customer c,String pass) throws SomethingWentWrong;
}