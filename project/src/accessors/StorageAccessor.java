package accessors;

import java.util.ArrayList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import common.Transaction;

class StorageAccessor
{
	// Write transaction to disk
	public void StoreTransaction(Transaction t)
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
	protected ArrayList<Transaction> RetrieveAccountTransactions(int AccountID)
	{
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "Transactions.dat");
		try {
			ObjectSet<Transaction> objs = db.query(Transaction.class);
			ArrayList<Transaction> al = new ArrayList<Transaction>();
			al.addAll(objs);
			return al;
		} finally {
			db.close();
		}
	}
}