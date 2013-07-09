
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

//need to include StorageAccessor.javam to get its methods, so will import

import StorageAccessor.java;

public class Account_Manager {
	
	//need to start with number of transactions to know when ends
	int noOfTrans = 0;
	//retrieve all transactions associated with account 
		//first we retrieve the account using the Storage Accessor RetrieveAccount class
	public int[] Account = RetrieveAccountTransactions(t);
		for each(RetrieveAccountTransactions){
			noOfTrans++;  //this loop gets the proper number of transactions
		}
	
		//for each transaction, print the transactions as stored in the StorageAccessor account
	for (i = 0; i < noOfTrans; i++){
		//t is acquired from the Storage Accessor class.  Println ensures a new line each time.
		System.out.println(t);
	}
	
}
