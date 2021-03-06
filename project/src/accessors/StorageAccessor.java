package accessors;

import java.util.ArrayList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import common.Transaction;

public class StorageAccessor
{
	// Write transaction to disk
	public static void StoreTransaction(Transaction t)
	{
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "Transactions.dat");
		try {
			db.store(t);
		} finally {
			db.close();
		}
	}
	
	// Retrieve all transactions associated with a given account ID from disk
	// Returns null if no transactions exist
	public static ArrayList<Transaction> RetrieveAccountTransactions(String AccountID)
	{
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "Transactions.dat");
		try {
			Transaction ex = new Transaction(AccountID);
			ObjectSet<Transaction> objs = db.queryByExample(ex);
			ArrayList<Transaction> al = new ArrayList<Transaction>();
			al.addAll(objs);
			return al;
		} finally {
			db.close();
		}
	}
}