package accessors;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import common.Account;
import common.Transaction;

class StorageAccessor
{
	// Write transaction to disk
	public void StoreTransaction(Transaction t)
	{
		try {
		File tFile = new File("Transactions.dat");
		if (!tFile.exists()) tFile.createNewFile();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(tFile)));
		out.append(t.toString()+"\n");
		out.flush();
		out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// Retrieve all transactions associated with a given account ID from disk
	// Returns null if no transactions exist
	public ArrayList<Transaction> RetrieveAccountTransactions(int AccountID)
	{
		File tFile = new File("Transactions.dat");
		if (!tFile.exists()) return null;
		// Unimplemented
		return null;
	}
	
	public void StoreAccount(Account acct)
	{
		try {
		// Make sure file works
		File acctFile = new File(acct.getUserName()+".dat");
		if (!acctFile.exists()) acctFile.createNewFile();
		// Make FileWriter and write to it
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(acctFile)));
		out.append(new Integer(acct.getId()).toString());
		// Flush and close FileWriter
		out.flush();
		out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Returns null if account doesn't exist
	public Account RetrieveAccount(String Username)
	{
		try {
			File acctFile = new File(Username+".dat");
			if (!acctFile.exists()) return null;
			
			 BufferedReader in = new BufferedReader(new FileReader(Username));
			 Account ret = new Account(Username, in.readLine());
			 
			 in.close();
			 
			 return ret;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}