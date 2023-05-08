package services;
import java.util.List;

import Entity.*;
import exception.SomethingWentWrong;
public interface customers{
	public List<Customer> viewAllCustomerService() throws SomethingWentWrong;
	public Customer viewCustomerByIdService(int id) throws SomethingWentWrong;
	
	public Customer loginCustomer(String username,String passwodrd) throws SomethingWentWrong;
	
	public String updateDetails(String name,String mobile,String city,String state,int zipcode, Customer c) throws SomethingWentWrong;
	
	public String changePassword(Customer c, String pass) throws SomethingWentWrong;
}