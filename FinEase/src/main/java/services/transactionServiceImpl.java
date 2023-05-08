package services;

import java.util.List;

import DAO.transactionImpl;
import DAO.transactions;
import Entity.transaction;
import exception.SomethingWentWrong;

public class transactionServiceImpl implements transactionServices{

	@Override
	public List<transaction> viewAllTransactionDayWiseService(String a,String e) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		
		transactions t = new transactionImpl();
		return t.viewAllTransactionDayWise(a, e);
		
	}

	@Override
	public List<transaction> viewAllHighlyMagnitudeService() {
		// TODO Auto-generated method stub
		return null;
	}

}
