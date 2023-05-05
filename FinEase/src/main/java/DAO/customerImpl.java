package DAO;

import java.util.List;

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

}
