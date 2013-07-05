package common;

import java.util.Map;

public class Account 
{
	private String username;						// username associated with user account
	private int accountID;							// ID associated with user account
	private Map<Currency, Double> currencyHoldings;	// list of all currency balances
}
