package market_simulator;

import java.util.Random;

import javax.swing.JTextField;

import accessors.StorageAccessor;

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
	
	public static void submitOrder(String ID, String type, double amount){
		
		
		double fee = .06 * amount;
		
		Transaction transaciton = new Transaction();
		transaciton.setAccountID(ID);
		transaciton.setUsd(amount);
		
		if(type.equals(MarketManager.INIT_ORDER)) {
			transaciton.setType(MarketManager.INIT_ORDER);
			StorageAccessor.StoreTransaction(transaciton);
			return;
		}
		
		if(type.equals(MarketManager.BUY_ORDER)){
			transaciton.setType(MarketManager.BUY_ORDER);
			StorageAccessor.StoreTransaction(transaciton);
			return;
		}
		
		if(type.equals(MarketManager.SELL_ORDER)){
			transaciton.setType(MarketManager.SELL_ORDER);
			StorageAccessor.StoreTransaction(transaciton);
			return;
		}
	}

}
