package common;

import java.util.Date;

public class Transaction 
{
	private int accountID;				// ID for account that made the transaction
	private Date transactionCompletion;	// date and time at which the transaction took place
	private Currency sold;				// currency paid in transaction
	private Currency purchased;			// currency purchased
	private double unitPrice;			// price paid for 1 unit of currency purchased denominated in currency sold

	// Need to implement ToString()
}
