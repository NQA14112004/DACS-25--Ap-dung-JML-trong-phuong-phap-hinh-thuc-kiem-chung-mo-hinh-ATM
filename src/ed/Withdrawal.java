package ed;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Withdrawal extends Transaction
{
   private int amount; // amount to withdraw
   private Keypad keypad; // reference to keypad
   private CashDispenser cashDispenser; // reference to cash dispenser

   private final static int HUYGD = 6;

   public Withdrawal(int userAccountNumber, ATMView atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      CashDispenser atmCashDispenser) {
      super(userAccountNumber, atmScreen, atmBankDatabase);
      keypad = atmKeypad;
      cashDispenser = atmCashDispenser;
   } 
   @Override
   public void execute() {
      GDRutTien();
   }
     public void transaction(int amount){
    	 BankDatabase bankDatabase = getBankDatabase();
         ATMView screen = getScreen();
    	 boolean cashDispensed = false;
         double soDu;
         soDu = bankDatabase.getSoDu(getAccountNumber());
            if (amount <= soDu) {   
               if (cashDispenser.ktSoDuATM(amount))  {
                  bankDatabase.debit(getAccountNumber(), amount);
                  
                  cashDispenser.dispenseCash(amount); 
                  cashDispensed = true; 
                  screen.messageJLabel7.setText("\nTien cua ban da duoc rut" +
                     " Vui long nhan tien!");
               }
               else 
            	   screen.messageJLabel7.setText(
                     "\nXin loi! So tien trong ATM khong du." +
                     "\n\nVui long nhap so tien nho hon.");
            } 
            else 
            {
               screen.messageJLabel7.setText(
                  "\nSo du trong tai khoan khong du." +
                  "\n\nHay chon so nho hon."); 
            }
         } 

   private void GDRutTien()
   {
	   
      int userChoice = 0;

      ATMView screen = getScreen(); 
      screen.createWithdrawGUI();
      screen.GDChinh.add( keypad.addkeypad(), BorderLayout.CENTER);
      withdraw1 check1 = new withdraw1();
      withdraw2 check2 = new withdraw2();
      withdraw3 check3 = new withdraw3();
      withdraw4 check4 = new withdraw4();
      withdraw5 check5 = new withdraw5();
      Keypad.B1.addActionListener(check1);
      Keypad.B2.addActionListener(check2);
      Keypad.B3.addActionListener(check3);
      Keypad.B4.addActionListener(check4);
      Keypad.B5.addActionListener(check5);
      
      screen.GDChinh.revalidate();
   }
   
   public class withdraw1 implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
        transaction(50000);
      }
   }
   public class withdraw2 implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
        transaction(100000);
      }
   }
   public class withdraw3 implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
        transaction(200000);
      }
   }
   public class withdraw4 implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
        transaction(500000);
      }
   }
   public class withdraw5 implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
        transaction(2000000);
      }
   }
} 


