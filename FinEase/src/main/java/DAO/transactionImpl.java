package DAO;

import java.time.LocalDate;
import java.util.List;

import Entity.transaction;
import exception.SomethingWentWrong;
import jakarta.persistence.*;

public class transactionImpl implements transactions{
	@Override
	public List<transaction> viewAllTransactionDayWise(String a,String e) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			
			em = utility.utility.getEm();
			
			Query q = em.createQuery("from transaction t where t.date >= :para and t.date <= :para2");
			
			q.setParameter("para", LocalDate.parse(a));
			q.setParameter("para2", LocalDate.parse(e));
			
			List<transaction> lt = q.getResultList();
			
			return lt;
	
		}catch(Exception ef) {
		
			throw new SomethingWentWrong("No Record Found");
			
			
		}finally {
		 em.close();
		}
		
		
	}

	@Override
	public List<transaction> viewAllHighlyMagnitude() {
		// TODO Auto-generated method stub
		return null;
	}
}
