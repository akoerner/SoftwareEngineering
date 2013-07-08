package accessors;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	
	public void StoreAccount(Account acct)
	{
		try {
		// Make sure file works
		File acctFile = new File(acct.getUsername() + acct.getID());
		if (!acctFile.exists()) acctFile.createNewFile();
		// Make FileWriter and write to it
		FileWriter writer = new FileWriter(acctFile);
		writer.append(acct.getUsername() + "," + acct.getID());
		// Flush and close FileWriter
		writer.flush();
		writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Account RetrieveAccount(String Username)
	{
		return null;
	}
}