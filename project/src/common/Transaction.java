package common;

import java.util.Date;

public class Transaction 
{
	public Transaction(String ID) {
		accountID = ID;
	}
	
	private String accountID;			// ID for account that made the transaction
	private String type;                //type of transaciton example buy, sell or init
	private Date date;					// date and time at which the transaction took place
	private double eur;
	private double usd;
}
