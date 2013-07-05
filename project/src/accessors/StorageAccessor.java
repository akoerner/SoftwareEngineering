package src.accessors;

import java.util.ArrayList;

import common.Account;
import common.Transaction;

class StorageAccessor
{
	// Write transaction to disk
	public void StoreTransaction(Transaction t)
	{}
	
	// Retrieve all transactions from disk
	public ArrayList<Transaction> RetrieveAccountTransactions(int AccountID)
	{
		return null;
	}
	
	public void StoreAccount()
	{}
	
	public Account RetrieveAccount(int ID)
	{
		return null;
	}
}