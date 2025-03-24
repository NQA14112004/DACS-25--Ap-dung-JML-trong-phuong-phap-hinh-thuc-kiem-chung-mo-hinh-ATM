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
   public JLabel messageJLabel7;
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

	      JPanel topPanel = new JPanel(new FlowLayout());
	      messageJLabel = new JLabel("Thông Tin Số Dư:");
	      topPanel.add(messageJLabel);
	      GDChinh.add(topPanel, BorderLayout.NORTH);

	      JPanel infoPanel = new JPanel();
	      infoPanel.setLayout(new GridLayout(3, 1, 0, 10)); 

	      JLabel availableLabel = new JLabel("Available Balance: " + String.format("%,.0f", availableBalance) + "vnd");
	      JLabel totalLabel = new JLabel("Total Balance: " + String.format("%,.0f", totalBalance) + "vnd");
	      infoPanel.add(availableLabel);
	      infoPanel.add(totalLabel);

	      GDChinh.add(infoPanel, BorderLayout.CENTER);

	      JPanel bottomPanel = new JPanel(new FlowLayout());
	      Exit = new JButton("BACK");
	      bottomPanel.add(Exit);
	      GDChinh.add(bottomPanel, BorderLayout.SOUTH);

	      GDChinh.repaint();
	   }

   public void createWithdrawGUI(double initialBalance) {
	    GDChinh.getContentPane().removeAll();
	    GDChinh.setLayout(new BorderLayout());

	    // Top panel: Tiêu đề
	    JPanel topPanel = new JPanel(new FlowLayout());
	    messageJLabel = new JLabel("Số tiền muốn rút: ");
	    topPanel.add(messageJLabel);
	    GDChinh.add(topPanel, BorderLayout.NORTH);

	    // Center panel: Các nút lựa chọn và trường nhập liệu
	    JPanel centerPanel = new JPanel(new BorderLayout());

	    // Panel chứa các nút lựa chọn số tiền
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setLayout(new GridLayout(3, 3, 0, 5));
	    messageJLabel2 = new JButton("1-50000vnd");
	    messageJLabel3 = new JButton("2-100000vnd");
	    messageJLabel4 = new JButton("3-200000vnd");
	    messageJLabel5 = new JButton("4-500000vnd");
	    messageJLabel6 = new JButton("5-2000000vnd");
	    Exit = new JButton("  ");

	    Dimension buttonSize = new Dimension(100, 30);
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
	    centerPanel.add(buttonPanel, BorderLayout.WEST);

	    // Panel chứa trường nhập liệu và nút xác nhận
	    JPanel inputPanel = new JPanel(new FlowLayout());
	    Inputfield3 = new JTextField(10); // Trường nhập liệu cho số tiền
	    // Bỏ setEditable(false) để cho phép nhập từ bàn phím vật lý
	    JButton confirmButton = new JButton("Xác nhận"); // Nút xác nhận
	    inputPanel.add(new JLabel("Số tiền (vnd): "));
	    inputPanel.add(Inputfield3);
	    inputPanel.add(confirmButton);
	    centerPanel.add(inputPanel, BorderLayout.CENTER);

	    messageJLabel7 = new JLabel("");
	    JPanel messagePanel = new JPanel(new FlowLayout());
	    messagePanel.add(messageJLabel7);
	    centerPanel.add(messagePanel, BorderLayout.SOUTH);

	    GDChinh.add(centerPanel, BorderLayout.CENTER);

	    // Bottom panel: Hiển thị số dư khả dụng
	    JPanel bottomPanel = new JPanel(new FlowLayout());
	    messageJLabel8 = new JLabel("Available Balance: " + String.format("%,.0f", initialBalance) + "vnd");
	    bottomPanel.add(messageJLabel8);
	    GDChinh.add(bottomPanel, BorderLayout.SOUTH); // Lỗi: customPanel không tồn tại, sửa thành bottomPanel

	    GDChinh.repaint();
	}
   public JButton confirmButton; // Biến để lưu nút "Xác nhận"

   public void createDepositGUI() {
       GDChinh.getContentPane().removeAll();
       GDChinh.setLayout(new BorderLayout());

       // Top panel: Tiêu đề
       JPanel topPanel = new JPanel(new FlowLayout());
       messageJLabel = new JLabel("Nhập Số Tiền Gửi:");
       topPanel.add(messageJLabel);
       GDChinh.add(topPanel, BorderLayout.NORTH);

       // Center panel: Trường nhập liệu và nút xác nhận
       JPanel centerPanel = new JPanel(new BorderLayout());

       // Panel chứa trường nhập liệu và nút xác nhận
       JPanel inputPanel = new JPanel();
       inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

       // Panel chứa nhãn và trường nhập liệu (xếp ngang)
       JPanel fieldPanel = new JPanel(new FlowLayout());
       messageJLabel = new JLabel("Số tiền (vnd): ");
       Inputfield3 = new JTextField(10);
       fieldPanel.add(messageJLabel);
       fieldPanel.add(Inputfield3);

       // Panel chứa nút xác nhận (xếp ngang)
       JPanel confirmPanel = new JPanel(new FlowLayout());
       confirmButton = new JButton("Xác nhận"); // Gán nút vào biến instance
       confirmPanel.add(confirmButton);

       // Thêm các panel vào inputPanel theo chiều dọc
       inputPanel.add(fieldPanel);
       inputPanel.add(confirmPanel);

       centerPanel.add(inputPanel, BorderLayout.CENTER);

       GDChinh.add(centerPanel, BorderLayout.WEST);

       // Bottom panel: Thông báo
       JPanel bottomPanel = new JPanel(new FlowLayout());
       messageJLabel8 = new JLabel("");
       bottomPanel.add(messageJLabel8);
       GDChinh.add(bottomPanel, BorderLayout.SOUTH); // Sửa thành bottomPanel

       GDChinh.repaint();
   }

   // Getter để truy cập nút "Xác nhận"
   public JButton getConfirmButton() {
       return confirmButton;
   }


public void setGUI(){
	repaint();
}



} 
