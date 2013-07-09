package managers;

import java.util.Random;

import accessors.MarketAccessor;



public class MarketManager {
	
	static final String SELL_ORDER = "Sell";
	static final String BUY_ORDER = "Buy";
	static final String INIT_ORDER = "Init";
	static final String USD = "USD";
	static final String EUR = "EUR";
	
	private MarketManager(){}
	
	public static double getCurrentExchangRateUSDToEuro() {
		
		return MarketAccessor.getCurrentExchangeRateUSDtoEUR();
	}

	public static double getCurrentExchangRateEUROToUSD() {
		// TODO Auto-generated method stub
		return MarketAccessor.getCurrentExchangeRateEURtoUSD();
	}


}
