package ed;

public class Account 
{
   private int accountNumber; 
   private int pin;
   private double soDu;
   private double tongDu; 
   private String username;

   public Account(String Username, int accountNumber, int PIN, 
      double soDu, double tongDu)
   {
	  this.username = Username;
      this.accountNumber = accountNumber;
      this.pin = PIN;
      this.soDu = soDu;
      this.tongDu = tongDu;
   } 

   public double getSoDu() {
      return soDu;
   } 

   public double getTongDu() {
      return tongDu;
   } 
   public int getAccountNumber() {
      return accountNumber;  
   }   
   public int GetPin() {
	   return getPin();
   }

   public String getUsername() {
		return username;
   }

   public void setUsername(String username) {
		this.username = username;
   }

   public void setAccountNumber(int accountNumber) {
	   this.accountNumber = accountNumber;
   }

   public int getPin() {
	   return pin;
   }

   public void setPin(int pin) {
	   this.pin = pin;
   }

   public void setSoDu(double soDu) {
	   this.soDu = soDu;
   }

   public void setTongDu(double tongDu) {
	   this.tongDu = tongDu;
   }

   public boolean validatePIN(int userPIN)
   {
      if (userPIN == getPin())
         return true;
      else
         return false;
   }
   public void credit(double amount)
   {
      setTongDu(getTongDu() + amount); 
   } 

   public void debit(double amount)
   {
      setSoDu(getSoDu() - amount);
      setTongDu(getTongDu() - amount); 
   } 
     
} 