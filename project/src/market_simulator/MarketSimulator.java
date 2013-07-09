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
		return MarketManager.getCurrentExchangRateUSDToEuro();
	}

	public static double getCurrentExchangRateEUROToUSD() {
		// TODO Auto-generated method stub
		return MarketManager.getCurrentExchangRateEUROToUSD();
	}
	
	public static void submitOrder(String ID, String type, double usdAmount, double euroAmount){
		
		
		double usdFee = .06 * usdAmount;
		double euroFee = .06 * usdAmount;
		
		Transaction transaciton = new Transaction();
		transaciton.setAccountID(ID);
		transaciton.setUsd(usdAmount);
		
		if(type.equals(MarketManager.INIT_ORDER)) {
			transaciton.setType(MarketManager.INIT_ORDER);
			StorageAccessor.StoreTransaction(transaciton);
			return;
		}
		
		if(type.equals(MarketManager.BUY_ORDER)){
			transaciton.setType(MarketManager.BUY_ORDER);
			transaciton.setUsd(usdAmount);
			transaciton.setEur((usdAmount-usdFee)*MarketManager.getCurrentExchangRateUSDToEuro());
			StorageAccessor.StoreTransaction(transaciton);
			return;
		}
		
		if(type.equals(MarketManager.SELL_ORDER)){
			transaciton.setType(MarketManager.SELL_ORDER);
			transaciton.setUsd(usdAmount);
			transaciton.setEur((euroAmount-euroFee)*MarketManager.getCurrentExchangRateEUROToUSD());
			StorageAccessor.StoreTransaction(transaciton);
			return;
		}
	}

}
