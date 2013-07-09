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
	
	public static void submitOrder(Account account, String type, double amount){
		
		
		double fee = .06 * amount;
		
		Transaction transaciton = new Transaction();
		
		if(type.equals(MarketManager.INIT_ORDER)){
			transaciton.setAccountID(account.getId());
			transaciton.setUsd(10000.00);
			transaciton.setType(MarketManager.INIT_ORDER);
			return;
		}
		
		if(type.equals(MarketManager.BUY_ORDER)){
			
			return;
		}
		
		if(type.equals(MarketManager.SELL_ORDER)){
			
			
			return;
		}
	}

}
