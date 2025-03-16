package ed;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceInquiry extends Transaction
{
   private Keypad keypad;

   public BalanceInquiry(int userAccountNumber, ATMView atmScreen, 
      BankDatabase atmBankDatabase) {
      super(userAccountNumber, atmScreen, atmBankDatabase);
   }

   @Override
   public void execute() {
      GDSoDu();
   }

   private void GDSoDu() {
      ATMView screen = getScreen();
      BankDatabase bankDatabase = getBankDatabase();
      double availableBalance = bankDatabase.getSoDu(getAccountNumber());
      double totalBalance = bankDatabase.getTongDu(getAccountNumber());
      screen.createBalanceGUI(availableBalance, totalBalance);
      Backcheck Back = new Backcheck();
      screen.Exit.addActionListener(Back);
      screen.GDChinh.revalidate();
   }

   private class Backcheck implements ActionListener
   {
      public void actionPerformed(ActionEvent e) {
         ATM atm = ATM.getinstance();
         atm.createmenu();
      }
   }
}