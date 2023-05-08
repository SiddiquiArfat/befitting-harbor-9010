package services;

import java.util.List;

import Entity.transaction;
import exception.SomethingWentWrong;

public interface transactionServices {
public List<transaction> viewAllTransactionDayWiseService(String s,String e) throws SomethingWentWrong;
	
	public List<transaction> viewAllHighlyMagnitudeService();
}
