package ed;

public class AccountFactory extends Account {

	public AccountFactory(String Username, int AccountNumber, int PIN, double soDU,
			double tongDu) {
		super(Username, AccountNumber, PIN, soDU, tongDu);
		setUsername(Username);
		setAccountNumber(AccountNumber);
		setPin(PIN);
		setSoDu(soDU);
	    setTongDu(tongDu);
	}
}

