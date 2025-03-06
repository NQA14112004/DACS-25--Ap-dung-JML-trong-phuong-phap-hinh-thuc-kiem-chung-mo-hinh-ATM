package ed;

import java.util.ArrayList;

public class BankDatabase
{
   static ArrayList<Account> accounts = new ArrayList<Account>() ; 
   
   
   
   public BankDatabase() {
      Account acc1 = new Account("acc1", 12345, 11111, 10000000.0, 1200.0, 0);
      Account acc2 = new Account("acc2", 98765, 22222, 20000000.0, 200.0, 0);
      Account acc3 = new Account("acc3", 19234, 33333, 20000000.0, 200.0, 0);
      Account acc4 = new Account("admin", 99999, 00000, 0, 0, 1);
      accounts.add(acc1);
      accounts.add(acc2);
      accounts.add(acc3);
      accounts.add(acc4);
   } 
   
   public Account getAccount(int accountnumber) {
      for (Account currentAccount : accounts)
      {
         if (currentAccount.getAccountNumber() == accountnumber)
            return currentAccount;
      } 
      return null; 
   } 
   
   private Account getAccountpin(int PIN) {
      for (Account currentAccount : accounts)
      {
         if (currentAccount.GetPin() == PIN)
            return currentAccount;
      }
      return null; 
   } 

   public boolean ktUser(int userPIN) {
      Account userAccount = getAccountpin(userPIN);

      if (userAccount != null)
         return userAccount.validatePIN(userPIN);
      else
         return false; 
   } 

   public double getSoDu(int userAccountNumber) {
      return getAccount(userAccountNumber).getSoDu();
   } 

   public double getTongDu(int userAccountNumber) {
      return getAccount(userAccountNumber).getTongDu();
   } 

   public void credit(int userAccountNumber, double amount) {
      getAccount(userAccountNumber).credit(amount);
   } 

   public void debit(int userAccountNumber, double amount) {
      getAccount(userAccountNumber).debit(amount);
   }
   public int getadmin(int userAccountNumber) {
	   return getAccountpin(userAccountNumber).getISadmin();  
   }
   
   public static Iterator createIterator() {
		return new AccountIterator(accounts);
	}
   
  public int getaccpin(int PIN){
	   for (Account currentAccount : accounts)
	      {
	         if (currentAccount.GetPin() == PIN)
	            return currentAccount.getAccountNumber();
	         else
	        	 return 1;
	      } 
	return PIN;
   }
   
  public static void Adduser(){
	  String name = ATMView.Inputfield1.getText();
	  int accountnumber = Integer.parseInt( ATMView.Inputfield2.getText() );
	  int pin = Integer.parseInt( ATMView.Inputfield4.getText() );
	  int balance = Integer.parseInt( ATMView.Inputfield3.getText() );
	  
	  Account newaccount = new Account(name, accountnumber, pin, balance, balance, 0);
	 accounts.add(newaccount);
	 
	 ATMView.Inputfield1.setText("");
	 ATMView.Inputfield2.setText("");
	 ATMView.Inputfield3.setText("");
	 ATMView.Inputfield4.setText("");
  }

public static void Deleteuser(int position) {
	accounts.remove(position);
	
}   
   
} 


