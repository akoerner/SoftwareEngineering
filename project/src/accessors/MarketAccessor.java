package accessors;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import com.google.gson.Gson;

public class MarketAccessor {

	
	private MarketAccessor(){}
	
	static class Result
    {
		private String lhs;
        private String rhs;

        public String getLhs()
        {
        	return lhs;
        }
        public String getRhs()
        {
        	return rhs;
        }
    }
	
	//Gets the current exchange rate of USD to EUR
	public static double getCurrentExchangeRateUSDtoEUR(){
		try {
			return getCurrentExchangeRate("USD","EUR");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0.0;
	}
	
	//Gets the current exchange rate of EUR to USD
	public static double getCurrentExchangeRateEURtoUSD() {
		try {
			return getCurrentExchangeRate("EUR","USD");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0.0;
	}
	
	private static double getCurrentExchangeRate(String currency1, String currency2) throws Exception {
		
		//strings to format url
		String google = "http://www.google.com/ig/calculator?hl=en&q=";
	    String baseCurrency = currency1;
	    String termCurrency = currency2;
		String charset = "UTF-8";
		
	    URL url = new URL(google + baseCurrency + "%3D%3F" + termCurrency);

	    Reader reader = new InputStreamReader(url.openStream(), charset);
	    Result result = new Gson().fromJson(reader, Result.class);

	    // Get the value without the term currency.
	    String strAmount = result.getRhs().split("\\s+")[0];
	    Double amount = Double.parseDouble(strAmount);
		return amount;
		
	}
}
