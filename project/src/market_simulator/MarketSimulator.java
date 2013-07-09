package market_simulator;

import java.util.Random;

import javax.swing.JTextField;

import managers.MarketManager;

import common.Account;
import common.Transaction;

public class MarketSimulator {
	
	private MarketSimulator(){}
	
	public static Account getAccount(String id) {
		return null;
	}

	public static double getCurrentExchangRateUSDToEuro() {
		// TODO Auto-generated method stub
		Random r=new Random();
		return MarketManager.getCurrentExchangRateUSDToEuro();
	}

	public static double getCurrentExchangRateEUROToUSD() {
		// TODO Auto-generated method stub
		return MarketManager.getCurrentExchangRateEUROToUSD();
	}
	
	public static void submitOrder(Account account, String type, String currency, double amount){
		
		
		double fee = .06 * amount;
		
		
		
		
		
		Transaction transaction = new Transaction();
	}

}
