import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class MarketSimulator extends JFrame implements ActionListener{

	private JButton buyButton;
	private JButton sellButton;
	
	private JLabel pair, marketFee, amountToTrade, perTrade;
	private JTextField euro, usd, usdTrade, euroTrade, fee;
	
	private GridLayout gbl; 
	public MarketSimulator(){
		this.gbl = new GridLayout(6,3);
		this.setLayout(this.gbl);
		
		euro = new JTextField("0.00");
		usd = new JTextField("0.00");
		usdTrade = new JTextField("0.00");
		euroTrade = new JTextField("0.00");
		fee  = new JTextField(".06%");
		buyButton = new JButton("Buy");
		sellButton = new JButton("Sell");
		
		//this.add(new JLabel("Pair"));
		//this.add(usd);
		//this.add(new JLabel("Amount to trade"));
		//this.add(buyButton);
		
		this.add(new JLabel("Currency Pair"));
		this.add(new JTextField("USD - EUR"));
		this.add(new JLabel(""));
		this.add(new JLabel("USD Account Balance"));
		this.add(new JLabel("Market Fee"));
		this.add(new JLabel("EURO Account Balance"));
		this.add(usd);
		this.add(fee);
		this.add(euro);
		this.add(new JLabel("Amount to Trade"));
		this.add(new JLabel(""));
		this.add(new JLabel("Amount to Trade"));
		this.add(usdTrade);
		this.add(new JLabel(""));
		this.add(euroTrade);
		this.add(buyButton);
		this.add(new JLabel(""));
		this.add(sellButton);
		
		this.pack();
		this.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		
		MarketSimulator ms = new MarketSimulator();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
