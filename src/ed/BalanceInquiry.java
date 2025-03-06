package ed;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class BalanceInquiry extends Transaction
{
   public BalanceInquiry(int userAccountNumber, ATMView atmScreen, 
      BankDatabase atmBankDatabase)
   {
      super(userAccountNumber, atmScreen, atmBankDatabase);
   } 

   @Override
   public void execute()
   {
      BankDatabase bankDatabase = getBankDatabase();
      ATMView screen = getScreen();

      double soDu = 
         bankDatabase.getSoDu(getAccountNumber());

      double tongDu = 
         bankDatabase.getTongDu(getAccountNumber());
      
      
      
      screen.creatBalanceGUI();
      screen.messageJLabel2.setText("Avaliable Balance: " + soDu);
      screen.messageJLabel3.setText("Total Balance: " + tongDu);
      screen.GDChinh.revalidate();
      
   } 
   
  
} 



