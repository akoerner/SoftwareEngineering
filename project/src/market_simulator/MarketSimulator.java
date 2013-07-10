package market_simulator;

import java.util.Date;
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
		return MarketManager.getCurrentExchangRateUSDToEuro();
	}

	public static double getCurrentExchangRateEUROToUSD() {
		// TODO Auto-generated method stub
		return MarketManager.getCurrentExchangRateEUROToUSD();
	}
	
	public static void submitOrder(String ID, String type, double usdAmount, double euroAmount){
		
		
		double usdFee = .06 * usdAmount;
		double euroFee = .06 * euroAmount;
		
		Transaction transaction = new Transaction();
		transaction.setAccountID(ID);
		transaction.setUsd(usdAmount);
		transaction.setDate(new Date());
		
		
		if(type.equals(MarketManager.INIT_ORDER)) {
			transaction.setType(MarketManager.INIT_ORDER);
			StorageAccessor.StoreTransaction(transaction);
			return;
		}
		
		if(type.equals(MarketManager.BUY_ORDER)){
			transaction.setType(MarketManager.BUY_ORDER);
			transaction.setUsd(usdAmount);
			transaction.setEur((usdAmount-usdFee)*MarketManager.getCurrentExchangRateUSDToEuro());
			StorageAccessor.StoreTransaction(transaction);
			return;
		}
		
		if(type.equals(MarketManager.SELL_ORDER)){
			transaction.setType(MarketManager.SELL_ORDER);
			transaction.setUsd((euroAmount-euroFee)*MarketManager.getCurrentExchangRateEUROToUSD());
			transaction.setEur(euroAmount);
			StorageAccessor.StoreTransaction(transaction);
			return;
		}
	}

}
