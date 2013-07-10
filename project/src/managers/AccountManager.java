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
		double usdTotal = 0.0;

		ArrayList<Transaction> transactions = getTransactionsByAccountID(accountId);
		
		for (Transaction transaction : transactions) {
		    if(transaction.getType().equals(MarketManager.BUY_ORDER)) usdTotal-=transaction.getUsd();
		    if(transaction.getType().equals(MarketManager.SELL_ORDER)) usdTotal+=transaction.getUsd();
		    if(transaction.getType().equals(MarketManager.INIT_ORDER)) usdTotal+=transaction.getUsd();
		}
		return usdTotal;
	}
	
	public static double getAccountEUROBalanceByAccountID(String accountId){
		
		if(accountId.equals("")) return 0.0;
		double eurTotal = 0.0;

		ArrayList<Transaction> transactions = getTransactionsByAccountID(accountId);
		for (Transaction transaction : transactions) {
		   if(transaction.getType().equals(MarketManager.BUY_ORDER)) eurTotal+=transaction.getEur();
		   if(transaction.getType().equals(MarketManager.SELL_ORDER)) eurTotal-=transaction.getEur();
		   if(transaction.getType().equals(MarketManager.INIT_ORDER)) eurTotal+=transaction.getEur();
		}
		return eurTotal;
		
	}
	
	public static Account getAccountById(String id){
		Account account = new Account();
		
		//account.setTransactions(StorageAccessor.RetrieveAccountTransactions(account.getId()));
		return null;
	}
}
