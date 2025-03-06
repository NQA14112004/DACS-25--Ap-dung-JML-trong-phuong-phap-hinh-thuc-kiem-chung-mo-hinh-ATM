package ed;

public abstract class Transaction
{
   private int accountNumber; 
   protected ATMView screen; 
   private BankDatabase bankDatabase; 

   public Transaction(int userAccountNumber, ATMView atmScreen, 
      BankDatabase atmBankDatabase) {
      accountNumber = userAccountNumber;
      screen = atmScreen;
      bankDatabase = atmBankDatabase;
   } 
   public int getAccountNumber() {
      return accountNumber; 
   } 

   public ATMView getScreen() {
      return screen;
   } 
   public BankDatabase getBankDatabase() {
      return bankDatabase;
   } 

   abstract public void execute();
}

