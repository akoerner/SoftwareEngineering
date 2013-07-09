package managers;

import java.util.Random;

import accessors.MarketAccessor;



public class MarketManager {
	
	public static final String SELL_ORDER = "Sell";
	public static final String BUY_ORDER = "Buy";
	public static final String INIT_ORDER = "Init";
	public static final String USD = "USD";
	public static final String EUR = "EUR";
	
	private MarketManager(){}
	
	public static double getCurrentExchangRateUSDToEuro() {
		
		return MarketAccessor.getCurrentExchangeRateUSDtoEUR();
	}

	public static double getCurrentExchangRateEUROToUSD() {
		// TODO Auto-generated method stub
		return MarketAccessor.getCurrentExchangeRateEURtoUSD();
	}


}
