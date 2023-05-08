package DAO;

import java.util.List;

import Entity.Address;
import Entity.Customer;
import exception.SomethingWentWrong;
import jakarta.persistence.*;

public class customerImpl implements customer{

	@Override
	public List<Customer> viewAllCustomer() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			
			em = utility.utility.getEm();
			Query q = em.createQuery("FROM Customer c");
			
			List<Customer> li = q.getResultList();
			return li;
		}
		catch(Exception e) {
			throw new SomethingWentWrong("No Record Found");
		}
		finally {
			em.close();
		}
		
	}

	@Override
	public Customer viewCustomerbyId(int id) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			
			em = utility.utility.getEm();
			Query q = em.createQuery("FROM Customer c where c.Id = :para");
			
			q.setParameter("para", id);
			Customer li = (Customer) q.getSingleResult();
			return li;
		}
		catch(Exception e) {
			throw new SomethingWentWrong("No Record Found");
		}
		finally {
			em.close();
		}
	
	}
	
	public Customer loginCustomers(String username, String password) throws SomethingWentWrong{
		EntityManager em = null;
		try {
			
			em = utility.utility.getEm();
			Query q = em.createQuery("select c FROM Customer c where c.userName = :para1 and c.password = :para2");
			q.setParameter("para1", username);
			q.setParameter("para2", password);
			
			Customer li = (Customer) q.getSingleResult();
			
			if(li == null) {
				throw new IllegalArgumentException("Wrong Credentials!!!! try again with right credentials");
			}
			
			return li;
			
			
		}
		catch(Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		finally {
			em.close();
		}
		
		
		
	}

	@Override
	public String updateDetails(String name, String mobile, String city, String state, int zipcode,Customer c)
			throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
		c.setName(name);
		c.setMobile(mobile);
		List<Address> li = c.getLi();
		Address add = new Address(city,state,zipcode);
		add.setCustomer(c);
		li.add(add);
		
		c.setLi(li);
		
		EntityManager em = null;
		
		
		try {
			
			em = utility.utility.getEm();
			
			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();
			
			return "Details Updated successgully";
			
		}catch(Exception e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}finally {
			em.close();
		}
		
	}

	@Override
	public String changePassword(Customer c, String pass) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		c.setPassword(pass);
		
		EntityManager em = null;
		
		
		try {
			
			em = utility.utility.getEm();
			
			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();
			
			return "Password Change successfully";
			
		}catch(Exception e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}finally {
			em.close();
		}
		
	}

}
