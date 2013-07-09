package common;

public class Account 
{
	private String username;	// username associated with user account
	private int accountID;		// ID associated with user account
	
	public Account(String Username, String ID) {
		this.username = Username;
		this.accountID = new Integer(ID);
	}

	public String getUsername() {
		return username;
	}

	public int getID() {
		return accountID;
	}
}
