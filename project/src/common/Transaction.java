package common;

import java.util.Date;

public class Transaction 
{
	private String accountID;			// ID for account that made the transaction
	private String type;                //type of transaciton example buy, sell or init
	private Date date;					// date and time at which the transaction took place
	private double eur;
	private double usd;
	
	public Transaction(String ID) {
		accountID = ID;
	}
	
	public Transaction() {
	}
	
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getEur() {
		return eur;
	}
	public void setEur(double eur) {
		this.eur = eur;
	}
	public double getUsd() {
		return usd;
	}
	public void setUsd(double usd) {
		this.usd = usd;
	}


}
