package DAO;

import java.util.List;

import Entity.transaction;
import exception.SomethingWentWrong;

public interface transactions {
	public List<transaction> viewAllTransactionDayWise(String s,String e) throws SomethingWentWrong;
	
	public List<transaction> viewAllHighlyMagnitude() throws SomethingWentWrong;
}
