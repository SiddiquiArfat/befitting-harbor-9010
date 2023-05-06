package services;
import java.util.List;

import Entity.*;
import exception.SomethingWentWrong;
public interface customers{
	public List<Customer> viewAllCustomerService() throws SomethingWentWrong;
	public Customer viewCustomerByIdService(int id) throws SomethingWentWrong;
	
}