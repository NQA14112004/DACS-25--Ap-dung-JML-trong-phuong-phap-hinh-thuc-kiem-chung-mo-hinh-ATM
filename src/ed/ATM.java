package ed;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class ATM 
{
   private boolean userDung; 
   private int currentAccountNumber; 
   private ATMView screen; 
   private Keypad keypad; 
   private CashDispenser cashDispenser; 
   private DepositSlot depositSlot; 
   private BankDatabase bankDatabase; 
   private int AdminCheck;
   private String userinput = "";
   private int position = 0;
   private static ATM uniqueinstance;
   Iterator Users =  BankDatabase.createIterator();
  
   private static final int BALANCE_INQUIRY = 1;
   private static final int WITHDRAWAL = 2;
   private static final int DEPOSIT = 3;
   private static final int EXIT = 4;

   public ATM() 
   {
	   
      userDung = false; 
      currentAccountNumber = 0; 
      screen = new ATMView();      
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
	   screen.createlogin();
	   userinput = "";	   
	   authenticate check = new authenticate();
  	   screen.GDChinh.revalidate();
  	   screen.Inputfield2.setText("");
  	   keypad.setbuttons();
  	   addkeypadlisteners();
  	 
  	   screen.GDChinh.add( keypad.addkeypad(), BorderLayout.CENTER);
	   
	   screen.GDChinh.revalidate();
	   keypad.BEnter.addActionListener( check );
	   screen.GDChinh.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	   screen.GDChinh.setSize( 400, 280 );
	   screen.GDChinh.setVisible( true );
	   screen.GDChinh.revalidate();
   }

   public void authenticateuser(int pin){
	   userDung = bankDatabase.ktUser(pin);

      if (userDung)
      {
    	 int accountNumber = bankDatabase.getaccpin(pin);
    	  AdminCheck = bankDatabase.getadmin(pin);
    	  if (AdminCheck == 0){
    	  currentAccountNumber = accountNumber;
    	  screen.GDChinh.getContentPane().removeAll();
    	  screen.GDChinh.revalidate();
    	  createmenu();
    	  screen.GDChinh.add( keypad.addkeypad(), BorderLayout.CENTER);
    	  screen.GDChinh.revalidate();
    	  }
    	  
    	  else
    		  
    		  createAdminGUI();
    	  Iterator UserIterator = BankDatabase.createIterator(); 
    	  Addcheck check = new Addcheck();
    	  Deletecheck check2 = new Deletecheck();
    	  screen.button2.addActionListener(check);
    	  screen.button3.addActionListener(check2);
    	  
         
      } 
      else
         screen.messageJLabel3.setText(
             "Invalid account number or PIN. Please try again.");
   } 

	   private class authenticate implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e ) {

	        int PIN = Integer.parseInt( screen.Inputfield2.getText() );
	        authenticateuser(PIN);
	      }
	   }
	   private class Addcheck implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	   	      BankDatabase.Adduser();
	         
	      }
	   }
	   private class Deletecheck implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	   	      BankDatabase.Deleteuser(position);
	   	      position = position - 1;
	         
	      }
	   }
	   public void createmenu(){
		   screen.setSize( 300, 150 );
	    	  balancecheck check1 = new balancecheck();
	    	  Depositcheck check2 = new Depositcheck();
	    	  Withdrawcheck check3 = new Withdrawcheck();
	    	  Exitcheck check4 = new Exitcheck();
	    	  screen.GDChinh.getContentPane().removeAll();
	    	  screen.GDChinh.revalidate();
	    	  screen.GDChinh.add( keypad.addkeypad(), BorderLayout.CENTER);
	    	  screen.createmenu();
	    	  Account Account1 = bankDatabase.getAccount(currentAccountNumber);
	    	  screen.messageJLabel.setText("Welcome " + Account1.getUsername() + "                                                                                   ");
	    	  
	    	  keypad.B1.addActionListener( check1 );
	    	  keypad.B2.addActionListener(check3);
	    	  keypad.B3.addActionListener(check2);
	    	  keypad.B4.addActionListener(check4);
	    	  screen.GDChinh.revalidate();
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
           screen.Inputfield2.setText(userinput);
               currentTransaction.execute();
               
               
               
               
               Backcheck Back = new Backcheck();
               screen.Exit.addActionListener(Back);
               screen.GDChinh.revalidate();
               
	   }
	   public class Backcheck implements ActionListener
	   {
	      public void actionPerformed( ActionEvent e )
	      {
	    	  
	    	  
	        createmenu();
	        screen.GDChinh.add( keypad.addkeypad(), BorderLayout.CENTER);
	        screen.GDChinh.revalidate();
	        userinput="";
	    	  screen.Inputfield2.setText(userinput);
	      }
	   }

   
   private Transaction createTransaction(int type)
   {
      Transaction temp = null; 
      screen.getContentPane().removeAll();
      screen.revalidate();   
      
         if(type == 1)
            temp = new BalanceInquiry(
               currentAccountNumber, screen, bankDatabase);
                 else if(type == 2)
            temp = new Withdrawal(currentAccountNumber, screen, 
               bankDatabase, keypad, cashDispenser);
         else if(type == 3){ 
        	 screen.setSize( 400, 250 );
            temp = new Deposit(currentAccountNumber, screen, 
               bankDatabase, keypad, depositSlot);}
      return temp;
   }

   public void createAdminGUI(){
	   
	   screen.GDChinh.getContentPane().removeAll();
	   Nextcheck Ncheck = new Nextcheck();
	   Prevcheck Pcheck = new Prevcheck();
	   Exitcheck check4 = new Exitcheck();
	   screen.GDChinh.revalidate();
	   screen.createAdminpage();
	   screen.button1.addActionListener(Ncheck);
	   screen.button4.addActionListener(Pcheck);
	   screen.Exit.addActionListener(check4);
	   screen.GDChinh.revalidate();
	   
   }
   
   public void addkeypadlisteners(){
	   BCheck BC = new BCheck();
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
   
   public class BCheck implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
    	  JButton b = (JButton)e.getSource();
		String label = b.getLabel();
        userinput = userinput + label;
        screen.Inputfield2.setText(userinput);
        
      }
   }
   public class BClear implements ActionListener
   {
      public void actionPerformed( ActionEvent e)
      {

    	  userinput = "";
    	  screen.Inputfield2.setText(userinput);
      }
      }
   
   public class Nextcheck implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
    	  
		IterateUser(BankDatabase.createIterator()); 
      }
      }
   public class Prevcheck implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
    	  
		prevIterateUser(BankDatabase.createIterator()); 
      }
      }
   
   public void IterateUser(Iterator Iterator){
	  if(Iterator.hasNext(position) == true) {
		  position = position + 1;
		  //Display the current user in the GUI message labels.
		   Account AccountItem = (Account)Iterator.next(position);
			screen.messageJLabel2.setText("Username: " + AccountItem.getUsername());
			screen.messageJLabel3.setText("Avaliable Balance: " + AccountItem.getSoDu());
			screen.messageJLabel4.setText("Avaliable Balance: " + AccountItem.getTongDu());
			}
	  
		
   }
   	public void prevIterateUser(Iterator Iterator){
		  if(Iterator.hasPrev(position) == true) {
			  position = position - 1;
			   Account AccountItem = (Account)Iterator.next(position);
				screen.messageJLabel2.setText("Username: " + AccountItem.getUsername());
				screen.messageJLabel3.setText("Avaliable Balance: " + AccountItem.getSoDu());
				screen.messageJLabel4.setText("Avaliable Balance: " + AccountItem.getTongDu());
								
				}
		  
			
	   }
   
	public static ATM getinstance() {
		if (uniqueinstance == null) {
			uniqueinstance = new ATM();
		}
		return uniqueinstance;
	}

}
   
