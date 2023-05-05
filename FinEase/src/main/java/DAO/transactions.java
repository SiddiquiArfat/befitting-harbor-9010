package DAO;

import java.util.List;

import Entity.transaction;

public interface transactions {
	public List<transaction> viewAllTransactionDayWise();
	
	public List<transaction> viewAllHighlyMagnitude();
}
