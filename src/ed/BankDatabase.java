package ed;

import java.util.ArrayList;

public class BankDatabase
{
   static ArrayList<Account> accounts = new ArrayList<Account>(); 
   
   public BankDatabase() {
      Account acc1 = new Account("acc1", 12345, 111111, 10000000.0, 120000000.0);
      Account acc2 = new Account("acc2", 98765, 222222, 20000000.0, 200000000.0);
      Account acc3 = new Account("acc3", 19234, 333333, 20000000.0, 20000000.0);
      accounts.add(acc1);
      accounts.add(acc2);
      accounts.add(acc3);
   } 
   
   public Account getAccount(int accountnumber) {
      for (Account currentAccount : accounts) {
         if (currentAccount.getAccountNumber() == accountnumber) {
            return currentAccount;
         }
      } 
      return null; 
   } 
   
   private Account getAccountpin(int PIN) {
      for (Account currentAccount : accounts) {
         if (currentAccount.GetPin() == PIN) {
            return currentAccount;
         }
      }
      return null; 
   } 

   public boolean ktUser(int userPIN) {
      Account userAccount = getAccountpin(userPIN);
      if (userAccount != null) {
         return userAccount.validatePIN(userPIN);
      } else {
         return false; 
      }
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
   public static Iterator createIterator() {
      return new AccountIterator(accounts);
   }
   
   public int getaccpin(int PIN) {
      for (Account currentAccount : accounts) {
         if (currentAccount.GetPin() == PIN) {
            return currentAccount.getAccountNumber();
         }
      } 
      return -1; 
   }
   
}