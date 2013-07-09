package common;

import java.util.ArrayList;

public class Account 
{
	private String id;		// ID associated with user account
	private ArrayList<Transaction> transactions;
	private double usdBalance;
	private double euroBalance;
	private String userName;
	

	public Account(String userName, String id) {
		this.id = id;
		this.userName = userName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public double getUsdBalance() {
		return usdBalance;
	}

	public void setUsdBalance(double usdBalance) {
		this.usdBalance = usdBalance;
	}

	public double getEuroBalance() {
		return euroBalance;
	}

	public void setEuroBalance(double euroBalance) {
		this.euroBalance = euroBalance;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
