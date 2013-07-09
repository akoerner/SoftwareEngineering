package market_simulator;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import managers.AccountManager;
import managers.MarketManager;

import common.Account;
import common.lib.GUITools.GUITools;
import common.lib.GUITools.JFrameDragger;


public class MarketSimulatorJFrame extends JFrame implements ActionListener{

	private JButton buyButton;
	private JButton sellButton;
	
	private JLabel pair, marketFee, amountToTrade, perTrade;
	private JTextField euro, usd, buyTrade, sellTrade, fee, accountIDJTextField;
	private JPanel rootPanel, topPanel, bottomPanel;
	private JButton fetchAccountInfoButton;
	
	private JScrollPane transactionPane;
	
	private GridLayout gbl;
	
	
	private MarketHeartbeat mhb;

	private MarketSimulator marketSimulator;
	private JTextField exchangeRate;
	private double excRate;
	public JTable transactionTable;
	
	Account account;
	
	public MarketSimulatorJFrame(){
		
		this.account = new Account();
		this.account.setId("");
		
		this.rootPanel = new JPanel();
		
		this.topPanel = new JPanel();
		this.bottomPanel = new JPanel();
		
		//this.setLayout(new GridLayout(2,0));
		this.rootPanel.setLayout(new GridLayout(2,0));
		
		this.rootPanel.add(this.topPanel);
		this.rootPanel.add(this.bottomPanel);
		
		this.gbl = new GridLayout(6,3);
		
		
		
		
		this.topPanel.setLayout(this.gbl);
		this.bottomPanel.setLayout(new BorderLayout());
		
		JPanel component = new JPanel();
		component.setLayout(new FlowLayout());
		component.add(new JLabel("Account Transaction History"));
		this.bottomPanel.add(component, BorderLayout.NORTH);
		
		this.transactionPane = new JScrollPane();
		
		this.bottomPanel.add(this.transactionPane);
		
		JPanel transactionPanel = new JPanel(new GridBagLayout());
		//transactionPanel.setSize(11, 40);
		//this.transactionPane.getViewport().add(transactionPanel);
		//transactionPanel.setPreferredSize(this.getSize());
		transactionPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		//for(int i = 0; i < 100; i++)transactionPanel.add(new JLabel("i="+i));
		
		this.transactionTable = new JTable();
		this.transactionTable.setName("Account Transaction History");
		
		
		
		
		
		
		
		
		this.transactionPane.getViewport().add(this.transactionTable);
		
		this.setName("Simple FOREX Simulator");
		
		//this.setLayout(new FlowLayout());
		
		this.add(this.rootPanel);
		//this.add(this.bottomPanel);
		
		euro = new JTextField("N/A");
		usd = new JTextField("N/A");
		
		euro.setEditable(false);
		usd.setEditable(false);
		
		buyTrade = new JTextField("0.00");
		sellTrade = new JTextField("0.00");
		
		buyTrade.addCaretListener(new CaretListener() {

	        @Override
	        public void caretUpdate(CaretEvent e) {
	           usd.setText(AccountManager.getAccountUSDBalanceByAccountID(account.getId()) + "");
	           euro.setText(AccountManager.getAccountEUROBalanceByAccountID(account.getId()) + "");
	        }
	    });
		
		sellTrade.addCaretListener(new CaretListener() {
	        @Override
	        public void caretUpdate(CaretEvent e) {
	           usd.setText(AccountManager.getAccountUSDBalanceByAccountID(account.getId()) + "");
	           euro.setText(AccountManager.getAccountEUROBalanceByAccountID(account.getId()) + "");
	        }
	    });
		
		
		fee  = new JTextField(".06%");
		fee.setEditable(false);
		buyButton = new JButton("Buy Euros");
		sellButton = new JButton("Sell Euros");
		
		this.buyButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	double rate =  MarketManager.getCurrentExchangRateUSDToEuro();
            	int n = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to buy " + buyTrade.getText() + " at a rate of " + rate + "?",
                        "Sell Order Confirmation",
                        JOptionPane.YES_NO_OPTION);
            	
				if (n == JOptionPane.NO_OPTION) return;
				if (n == JOptionPane.YES_OPTION) {
					MarketSimulator.submitOrder(account, MarketManager.BUY_ORDER, new Double(buyTrade.getText()));
				}
            }
        });
		
		this.sellButton.addActionListener(new ActionListener () {
			
			public void actionPerformed (ActionEvent e)
			{
				double rate = MarketManager.getCurrentExchangRateEUROToUSD();
				int n = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to sell " + sellTrade.getText() + " at a rate of " + rate + "?",
                        "Sell Order Confirmation",
                        JOptionPane.YES_NO_OPTION);
				
				if (n == JOptionPane.NO_OPTION) return;
				if (n == JOptionPane.YES_OPTION) {
					MarketSimulator.submitOrder(account, MarketManager.SELL_ORDER, new Double(sellTrade.getText()));
				}
			}
		});
		
		//this.add(new JLabel("Pair"));
		//this.add(usd);
		//this.add(new JLabel("Amount to trade"));
		//this.add(buyButton);
		
		this.topPanel.add(new JLabel("Currency Pair"));
		JTextField pairTextField = new JTextField("USD - EUR");
		pairTextField.setEditable(false);
		this.topPanel.add(pairTextField);
		
		
		this.accountIDJTextField = new JTextField("Account ID");
		this.accountIDJTextField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	accountIDJTextField.setText("");
            }
        });
		
		
		
		this.topPanel.add(this.accountIDJTextField);
		this.topPanel.add(new JLabel("USD Account Balance"));
		this.topPanel.add(new JLabel("Market Fee"));
		this.topPanel.add(new JLabel("EURO Account Balance"));
		this.topPanel.add(usd);
		this.topPanel.add(fee);
		this.topPanel.add(euro);
		this.topPanel.add(new JLabel("Amount to Trade"));		
		this.topPanel.add(new JLabel("Current Exchange Rate(USD/EUR)"));
		this.topPanel.add(new JLabel("Amount to Trade"));
		this.topPanel.add(buyTrade);
		this.exchangeRate = new JTextField(".00");
		this.exchangeRate.setEditable(false);
		this.exchangeRate.setText(marketSimulator.getCurrentExchangRateUSDToEuro() + "");
		this.topPanel.add(exchangeRate);
		this.topPanel.add(sellTrade);
		this.topPanel.add(buyButton);
		this.fetchAccountInfoButton = new JButton("Fetch Market Account");
		
		this.fetchAccountInfoButton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                
            }
        });      
		
		this.mhb = new MarketHeartbeat(exchangeRate, excRate, this);
		 new Thread(this.mhb).start();
		//this.mhb.start();
		
		this.topPanel.add(this.fetchAccountInfoButton);
		this.topPanel.add(sellButton);
		
		
		//GUITools.makeSwingComponentTransparent(.5f, this);
		
		this.setDefaultLookAndFeelDecorated(true);
		
		//this.setUndecorated(true);
		JFrameDragger jfd = new JFrameDragger(this);
		
		transactionPane.setPreferredSize(new Dimension(350,150));
		transactionPane.setMaximumSize(getPreferredSize());
		transactionPanel.setAutoscrolls(true);
		this.pack();
		this.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
	
		
	}
	
	public class MarketHeartbeat  implements Runnable {

		private double er;
		private JTextField jtfer;
		private JFrame jf;
		
		public MarketHeartbeat(JTextField jtfer, double er, JFrame jf){
			//super();
			this.jf = jf;
			this.er = er;
			this.jtfer = jtfer;
			
		}
	    public void run() {
	    	while(true){
	    	this.er = MarketSimulator.getCurrentExchangRateUSDToEuro();
	    	
	    	this.jtfer.setText(er+"");
	    	//this.jf.repaint();
	    	try {
	    		this.jtfer.repaint();
				Thread.sleep(1000*60);
				System.out.println(this.er);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	}
	    }

	    

	}

}
