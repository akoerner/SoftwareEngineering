package managers;

import java.util.ArrayList;

import common.Account;
import common.Transaction;
import accessors.StorageAccessor;

public class AccountManager{

	private AccountManager(){}
	
	public static ArrayList<Transaction> getTransactionsByAccountID(String accountID){
		return StorageAccessor.RetrieveAccountTransactions(accountID);
	}
	
	
	public static double getAccountUSDBalanceByAccountID(String accountId){
		if(accountId.equals("")) return 0.0;

		
		
		return 0.0;
	}
	
	public static double getAccountEUROBalanceByAccountID(String accountId){
		if(accountId.equals("")) return 0.0;
		return 0.0;
		
	}
	
	public static Account getAccountById(String id){
		Account account = new Account();
		
		//account.setTransactions(StorageAccessor.RetrieveAccountTransactions(account.getId()));
		return null;
	}
}
