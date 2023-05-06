package DAO;

import java.util.List;

import Entity.Customer;
import exception.SomethingWentWrong;

public interface customer{
	public List<Customer> viewAllCustomer() throws SomethingWentWrong;
	public Customer viewCustomerbyId(int id) throws SomethingWentWrong;
}