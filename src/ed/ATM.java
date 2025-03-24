package ed;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class ATM 
{
   private boolean userDung; 
   private int currentAccountNumber; 
   private ATMView atmview; 
   private Keypad keypad; 
   private CashDispenser cashDispenser; 
   private DepositSlot depositSlot; 
   private BankDatabase bankDatabase; 
   private String userinput = "";
   private int position = 0;
   private static ATM uniqueinstance;
   Iterator Users = BankDatabase.createIterator();
   private int loginAttempts = 0;
  
   private static final int BALANCE_INQUIRY = 1;
   private static final int WITHDRAWAL = 2;
   private static final int DEPOSIT = 3;
   private static final int EXIT = 4;

   public ATM() 
   {
      userDung = false; 
      currentAccountNumber = 0; 
      atmview = new ATMView();      
      keypad = new Keypad();
      cashDispenser = new CashDispenser(); 
      depositSlot = new DepositSlot(); 
      bankDatabase = new BankDatabase();
   } 

   public void run()
   {
      startlogin(); 
   }

   void startlogin() 
   {	   	   
      position = 0;
      atmview.createlogin();
      userinput = "";	   
      authenticate check = new authenticate();
      atmview.GDChinh.revalidate();
      atmview.Inputfield2.setText("");
      keypad.setbuttons();
      addkeypadlisteners();
      atmview.GDChinh.add(keypad.addkeypad(), BorderLayout.EAST);
      atmview.GDChinh.revalidate();
      keypad.BEnter.addActionListener(check);
      atmview.GDChinh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      atmview.GDChinh.setSize(530, 380);
      atmview.GDChinh.setVisible(true);
      atmview.GDChinh.revalidate();
      atmview.GDChinh.setLocationRelativeTo(null);
   }

   public void authenticateuser(int pin) {
      System.out.println("Đang kiểm tra PIN: " + pin);
      if (loginAttempts > 2) {
         atmview.messageJLabel8.setText("Nhập sai mã PIN! Hệ thống tạm khóa trong 30s");
         try {
            Thread.sleep(30000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         loginAttempts = 0;
         atmview.messageJLabel8.setText("Hãy thử lại.");
         atmview.Inputfield2.setText("");
         return;
      }

      userDung = bankDatabase.ktUser(pin);
      System.out.println("ktUser trả về: " + userDung);

      if (userDung) {
         loginAttempts = 0;
         int accountNumber = bankDatabase.getaccpin(pin);
         System.out.println("Số tài khoản tìm được: " + accountNumber);
         currentAccountNumber = accountNumber;
         atmview.GDChinh.getContentPane().removeAll();
         atmview.GDChinh.revalidate();
         createmenu();
         atmview.GDChinh.add(keypad.addkeypad(), BorderLayout.EAST); 
         atmview.GDChinh.repaint();
         atmview.GDChinh.revalidate();

      } else {
         loginAttempts++;
         atmview.messageJLabel8.setText(
            "Sai mã PIN. Bạn còn " + (3 - loginAttempts) + " lần thử.");
         atmview.Inputfield2.setText("");
      }
   } 

   private class authenticate implements ActionListener
   {
      public void actionPerformed(ActionEvent e) {
         try {
            int PIN = Integer.parseInt(atmview.Inputfield2.getText());
            authenticateuser(PIN);
         } catch (NumberFormatException ex) {
            atmview.messageJLabel8.setText("Vui lòng nhập mã PIN hợp lệ.");
            atmview.Inputfield2.setText("");
         }
      }
   }
	  
	   public void createmenu() {
		      atmview.setSize(400, 300);
		      balancecheck check1 = new balancecheck();
		      Depositcheck check2 = new Depositcheck();
		      Withdrawcheck check3 = new Withdrawcheck();
		      Exitcheck check4 = new Exitcheck();
		      atmview.GDChinh.getContentPane().removeAll();
		      atmview.GDChinh.revalidate();
		      atmview.createmenu();
		      Account Account1 = bankDatabase.getAccount(currentAccountNumber);
		      atmview.messageJLabel.setText("Welcome " + Account1.getUsername());
		      keypad.B1.addActionListener(check1);
		      keypad.B2.addActionListener(check3);
		      keypad.B3.addActionListener(check2);
		      keypad.B4.addActionListener(check4);
		      atmview.messageJLabel2.addActionListener(check1);
		      atmview.messageJLabel3.addActionListener(check3);
		      atmview.messageJLabel4.addActionListener(check2);
		      atmview.messageJLabel5.addActionListener(check4);
		      atmview.GDChinh.add(keypad.addkeypad(), BorderLayout.EAST);
		      atmview.GDChinh.revalidate();
		      atmview.GDChinh.repaint();
		   }
	  
	   private class balancecheck implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	    	  userinput = "";
	    	  performTransactions(1);
	      }
	      }
	   
	   private class Depositcheck implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	    	  userinput = "";
	    	  performTransactions(3);
	      }
	      }
	   
	   private class Withdrawcheck implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	    	  userinput = "";
	    	  performTransactions(2);
	      }
	      }
	   
	   private class Exitcheck implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	    	  startlogin();
	      }
	      }
	   
	   
	   private void performTransactions(int a) 
	   {
		        
      Transaction currentTransaction = null;

               currentTransaction = 
                  createTransaction(a);
               keypad.setbuttons();
          	 addkeypadlisteners();
  
           userinput = "";
           atmview.Inputfield2.setText(userinput);
               currentTransaction.execute();
               
               Backcheck Back = new Backcheck();
               atmview.Exit.addActionListener(Back);
               atmview.GDChinh.revalidate();
               
	   }
	   public class Backcheck implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {  
	        createmenu();
	        atmview.GDChinh.add( keypad.addkeypad(), BorderLayout.CENTER);
	        atmview.GDChinh.revalidate();
	        userinput="";
	    	  atmview.Inputfield2.setText(userinput);
	      }
	   }
	   private Transaction createTransaction(int type) {
		      Transaction temp = null; 
		      atmview.getContentPane().removeAll();
		      atmview.revalidate();   
		      if (type == 1) {
		         temp = new BalanceInquiry(currentAccountNumber, atmview, bankDatabase);
		      } else if (type == 2) {
		         temp = new Withdrawal(currentAccountNumber, atmview, bankDatabase, keypad, cashDispenser);
		      } else if (type == 3) {
		         atmview.setSize(530, 380); 
		         temp = new Deposit(currentAccountNumber, atmview, bankDatabase, keypad, depositSlot);
		      }
		      return temp;
		   }

   
   public void addkeypadlisteners(){
	   BtnClick BC = new BtnClick();
	   BClear BC1 = new BClear();
	   keypad.B1.addActionListener(BC);
	   keypad.B2.addActionListener(BC);
	   keypad.B3.addActionListener(BC);
	   keypad.B4.addActionListener(BC);
	   keypad.B5.addActionListener(BC);
	   keypad.B6.addActionListener(BC);
	   keypad.B7.addActionListener(BC);
	   keypad.B8.addActionListener(BC);
	   keypad.B9.addActionListener(BC);
	   keypad.B0.addActionListener(BC);
	   keypad.BClear.addActionListener(BC1);
   }
   
   public class BtnClick implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
    	JButton b = (JButton)e.getSource();
		String label = b.getText();
        userinput = userinput + label;
        atmview.Inputfield2.setText(userinput);      
      }
   }
   public class BClear implements ActionListener
   {
      public void actionPerformed( ActionEvent e)
      {
    	  userinput = "";
    	  atmview.Inputfield2.setText(userinput);
      }
      }

   	public static ATM getinstance() {
        if (uniqueinstance == null) {
           uniqueinstance = new ATM();
        }
        return uniqueinstance;
     }

}
   
