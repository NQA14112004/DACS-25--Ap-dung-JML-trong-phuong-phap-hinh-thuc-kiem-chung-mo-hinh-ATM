package ed;

import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ATMView extends JFrame
{
   public JFrame GDChinh;
   public static JTextField Inputfield1;
   public static JTextField Inputfield2;
   public static JTextField Inputfield3;
   public static JTextField Inputfield4;
   public JLabel messageJLabel; 
   public JButton messageJLabel2; 
   public JButton messageJLabel3;
   public JButton messageJLabel4;
   public JButton messageJLabel5;
   public JButton messageJLabel6;
   public JLabel messageJLabel7; // Đã khai báo
   public JLabel messageJLabel8;
   public JLabel messageJLabel9;
   public JLabel messageJLabel10;
   public JLabel messageJLabel11;
   public JButton loginbutton; 
   public JButton button1;
   public JButton button2;
   public JButton button3;
   public JButton button4;
   public JButton button5;
   public JButton Exit;
   public int accnum = 0;
   public int PIN = 0;

   public void displayMessage(String message) {
      System.out.print(message); 
   } 
   public void displayMessageLine(String message) {
      System.out.println(message);   
   } 
   public void displayDollarAmount(double amount) {
      System.out.printf("%,.2fvnd", amount);   
   } 

   public void createlogin() {
      GDChinh = new JFrame("ATM");
      GDChinh.setLayout(new BorderLayout());

      JPanel topPanel = new JPanel(new FlowLayout());
      messageJLabel11 = new JLabel(" Vui lòng chèn thẻ tín dụng/ghi nợ vào khe ");
      topPanel.add(messageJLabel11);
      GDChinh.add(topPanel, BorderLayout.NORTH);

      JPanel centerPanel = new JPanel(new FlowLayout());
      messageJLabel = new JLabel("Nhập mã PIN: ");
      Inputfield2 = new JTextField(10);
      Inputfield2.setEditable(false);
      centerPanel.add(messageJLabel);
      centerPanel.add(Inputfield2);
      GDChinh.add(centerPanel, BorderLayout.WEST);

      JPanel bottomPanel = new JPanel(new FlowLayout());
      messageJLabel8 = new JLabel("");
      bottomPanel.add(messageJLabel8);
      GDChinh.add(bottomPanel, BorderLayout.SOUTH);

      GDChinh.repaint();
   }

   public void createmenu() {
      GDChinh.getContentPane().removeAll();
      GDChinh.setLayout(new BorderLayout());

      JPanel topPanel = new JPanel(new FlowLayout());
      messageJLabel = new JLabel("Welcome");
      topPanel.add(messageJLabel);
      GDChinh.add(topPanel, BorderLayout.NORTH);

      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(4, 1, 0, 10));
      messageJLabel2 = new JButton("1 - Check Balance");
      messageJLabel3 = new JButton("2 - Rút Tiền");
      messageJLabel4 = new JButton("3 - Gửi Tiền");
      messageJLabel5 = new JButton("4 - Exit");

      Dimension buttonSize = new Dimension(150, 30);
      messageJLabel2.setPreferredSize(buttonSize);
      messageJLabel3.setPreferredSize(buttonSize);
      messageJLabel4.setPreferredSize(buttonSize);
      messageJLabel5.setPreferredSize(buttonSize);

      buttonPanel.add(messageJLabel2);
      buttonPanel.add(messageJLabel3);
      buttonPanel.add(messageJLabel4);
      buttonPanel.add(messageJLabel5);
      GDChinh.add(buttonPanel, BorderLayout.WEST);

      GDChinh.repaint();
   }

   public void createBalanceGUI(double availableBalance, double totalBalance) {
	      GDChinh.getContentPane().removeAll();
	      GDChinh.setLayout(new BorderLayout());

	      // Phần trên: Tiêu đề
	      JPanel topPanel = new JPanel(new FlowLayout());
	      messageJLabel = new JLabel("Thông Tin Số Dư:");
	      topPanel.add(messageJLabel);
	      GDChinh.add(topPanel, BorderLayout.NORTH);

	      // Phần giữa: Hiển thị thông tin số dư trên từng dòng
	      JPanel infoPanel = new JPanel();
	      infoPanel.setLayout(new GridLayout(3, 1, 0, 10)); // 3 dòng, cách nhau 10 pixel

	      JLabel availableLabel = new JLabel("Available Balance: " + String.format("%,.0f", availableBalance) + "vnd");
	      JLabel totalLabel = new JLabel("Total Balance: " + String.format("%,.0f", totalBalance) + "vnd");
	      infoPanel.add(availableLabel);
	      infoPanel.add(totalLabel);

	      GDChinh.add(infoPanel, BorderLayout.CENTER);

	      // Phần dưới cùng: Nút BACK
	      JPanel bottomPanel = new JPanel(new FlowLayout());
	      Exit = new JButton("BACK");
	      bottomPanel.add(Exit);
	      GDChinh.add(bottomPanel, BorderLayout.SOUTH);

	      GDChinh.repaint();
	   }

public void createWithdrawGUI(double initialBalance) {
    GDChinh.getContentPane().removeAll();
    GDChinh.setLayout(new BorderLayout());

    // Phần trên: Tiêu đề
    JPanel topPanel = new JPanel(new FlowLayout());
    messageJLabel = new JLabel("Lựa Chọn Số Tiền Rút: ");
    topPanel.add(messageJLabel);
    GDChinh.add(topPanel, BorderLayout.NORTH);

    // Phần giữa bên trái: Các nút lựa chọn xếp dọc
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(6, 1, 0, 10));
    messageJLabel2 = new JButton("1 - 50000vnd");
    messageJLabel3 = new JButton("2 - 100000vnd");
    messageJLabel4 = new JButton("3 - 200000vnd");
    messageJLabel5 = new JButton("4 - 500000vnd");
    messageJLabel6 = new JButton("5 - 2000000vnd");
    Exit = new JButton("Cancel");

    Dimension buttonSize = new Dimension(150, 30);
    messageJLabel2.setPreferredSize(buttonSize);
    messageJLabel3.setPreferredSize(buttonSize);
    messageJLabel4.setPreferredSize(buttonSize);
    messageJLabel5.setPreferredSize(buttonSize);
    messageJLabel6.setPreferredSize(buttonSize);
    Exit.setPreferredSize(buttonSize);

    buttonPanel.add(messageJLabel2);
    buttonPanel.add(messageJLabel3);
    buttonPanel.add(messageJLabel4);
    buttonPanel.add(messageJLabel5);
    buttonPanel.add(messageJLabel6);
    buttonPanel.add(Exit);
    GDChinh.add(buttonPanel, BorderLayout.WEST);

    // Khởi tạo messageJLabel7 để hiển thị thông báo giao dịch
    messageJLabel7 = new JLabel("");
    JPanel messagePanel = new JPanel(new FlowLayout());
    messagePanel.add(messageJLabel7);
    GDChinh.add(messagePanel, BorderLayout.CENTER);

    // Phần dưới cùng: Trạng thái số dư ban đầu
    JPanel bottomPanel = new JPanel(new FlowLayout());
    messageJLabel8 = new JLabel("Available Balance: " + initialBalance + "vnd");
    bottomPanel.add(messageJLabel8);
    GDChinh.add(bottomPanel, BorderLayout.SOUTH);

    GDChinh.repaint();
 }

public void createDepositGUI() {
    GDChinh.getContentPane().removeAll();
    GDChinh.setLayout(new BorderLayout());

    JPanel topPanel = new JPanel(new FlowLayout());
    messageJLabel = new JLabel("Nhập Số Tiền Gửi:");
    topPanel.add(messageJLabel);
    GDChinh.add(topPanel, BorderLayout.NORTH);

    JPanel centerPanel = new JPanel(new FlowLayout());
    messageJLabel = new JLabel("Số tiền (vnd): ");
    Inputfield3 = new JTextField(10);
    Inputfield3.setEditable(false);
    centerPanel.add(messageJLabel);
    centerPanel.add(Inputfield3);
    GDChinh.add(centerPanel, BorderLayout.WEST);

    JPanel bottomPanel = new JPanel(new FlowLayout());
    messageJLabel8 = new JLabel("");
    bottomPanel.add(messageJLabel8);
    GDChinh.add(bottomPanel, BorderLayout.SOUTH);

    GDChinh.repaint();
 }

public void setGUI(){
	repaint();
}

public void createAdminpage() {
 GDChinh.setLayout(new GridLayout(2, 1, 10, 10)); 

 JPanel viewPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
 
 messageJLabel = new JLabel("Kiem Tra Nguoi Dung:"); 
 messageJLabel11 = new JLabel("So Tai Khoan:");
 messageJLabel7 = new JLabel("So Du Kha Dung:");
 messageJLabel8 = new JLabel("Tong Du:"); 
 
 button1 = new JButton("Next");
 button4 = new JButton("Truoc"); 
 button3 = new JButton("Xoa"); 

 viewPanel.add(messageJLabel);
 viewPanel.add(messageJLabel11);
 viewPanel.add(messageJLabel7);
 viewPanel.add(messageJLabel8);
 viewPanel.add(button4); 
 viewPanel.add(button1); 
 viewPanel.add(button3); 

 JPanel addPanel = new JPanel(new GridLayout(5, 2, 10, 10));
 
 messageJLabel11 = new JLabel("Them Nguoi Dung:"); 
 messageJLabel7 = new JLabel("Ten Nguoi Dung:");
 messageJLabel8 = new JLabel("So Tai Khoan:"); 
 messageJLabel10 = new JLabel("PIN:");
 messageJLabel9 = new JLabel("So Du:");
 
 Inputfield1 = new JTextField(10); 
 Inputfield2 = new JTextField(10); 
 Inputfield4 = new JTextField(10); 
 Inputfield3 = new JTextField(10); 
 
 button2 = new JButton("Them"); 
 Exit = new JButton("Tro Lai"); 

 addPanel.add(messageJLabel11);
 addPanel.add(new JLabel("")); 
 addPanel.add(messageJLabel7);
 addPanel.add(Inputfield1); 
 addPanel.add(messageJLabel8);
 addPanel.add(Inputfield2); 
 addPanel.add(messageJLabel10);
 addPanel.add(Inputfield4); 
 addPanel.add(messageJLabel9);
 addPanel.add(Inputfield3); 

 JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
 buttonPanel.add(button2); 
 buttonPanel.add(Exit); 

 GDChinh.add(viewPanel);
 GDChinh.add(addPanel);
 GDChinh.add(buttonPanel);

 GDChinh.repaint();
 GDChinh.revalidate();
}


} 
