package market_simulator;

import java.util.Random;

import javax.swing.JTextField;

import common.Account;

public class MarketSimulator {
	
	private Account account;
	
	public MarketSimulator(){}

	public Account getAccount() {
		return account;
	}
	
	public static Account getAccount(String id) {
		return null;
	}

	public static double getCurrentExchangRateUSDToEuro() {
		// TODO Auto-generated method stub
		Random r=new Random();
		return r.nextDouble();
	}

	public static double getCurrentExchangRateEUROToUSD() {
		// TODO Auto-generated method stub
		return 0.0;
	}

}
