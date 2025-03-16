package ed;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposit extends Transaction
{
   private double amount; 
   private Keypad keypad; 
   private DepositSlot depositSlot;
   private final static int HUYGD = 0; 

   public Deposit(int userAccountNumber, ATMView atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      DepositSlot atmDepositSlot) {
      super(userAccountNumber, atmScreen, atmBankDatabase);
      keypad = atmKeypad;
      depositSlot = atmDepositSlot;
   }

   @Override
   public void execute()
   {
	  NhapTienGui();
   }
   public void makedeposit(double amount){
      BankDatabase bankDatabase = getBankDatabase();
      ATMView screen = getScreen();
      if (amount != HUYGD)
      {
         screen.messageJLabel2.setText( "\nVui long nhap so tien " + amount + "vnd vao khe!");
         boolean daNhanTien = depositSlot.nhanTienGui();

         if (daNhanTien)
         {  
        	 screen.messageJLabel2.setText("\nNhan tine thanh cong ");
              screen.messageJLabel3.setText("\nLuu Y: So Tien Chi Kha Dung Khi Ngan Hang Da Xac Minh");
            
            bankDatabase.credit(getAccountNumber(), amount); 
         } 
         else {
        	 screen.messageJLabel2.setText("\nChung toi chua nhan duoc tien tu ban");
         } 
      }
      else 
      {
    	  screen.messageJLabel2.setText("\nGiao dich bi huy...");
      } 
   }

   private void NhapTienGui(){
      ATMView screen = getScreen(); 

      screen.createDepositGUI(); 
      screen.GDChinh.add( keypad.addkeypad(), BorderLayout.CENTER);
      Depositcheck check1 = new Depositcheck();  
      keypad.BEnter.addActionListener( check1 );
      screen.GDChinh.revalidate();
      } 

   private class Depositcheck implements ActionListener
   {
      public void actionPerformed( ActionEvent e ) {   	   
    	 double amount = Integer.parseInt( screen.Inputfield2.getText() );      
         makedeposit(amount);       
      }
   }
}
