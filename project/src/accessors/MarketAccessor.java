import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import com.google.gson.Gson;

public class MarketAccessor {

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
	public static double getExchange() throws Exception {
		
		//strings to format url
		String google = "http://www.google.com/ig/calculator?hl=en&q=";
	    String baseCurrency = "USD";
	    String termCurrency = "EUR";
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
