package ed;


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
	 public JLabel messageJLabel2; 
	 public JLabel messageJLabel3;
	 public JLabel messageJLabel4;
	 public JLabel messageJLabel5;
	 public JLabel messageJLabel8;
	 public JLabel messageJLabel9;
	 public JLabel messageJLabel10;
	 public JButton loginbutton; 
	 public JButton button1;
	 public JButton button2;
	 public JButton button3;
	 public JButton button4;
	 public JButton button5;
	 public JButton Exit;
	 public int accnum = 0;
	 public int PIN = 0;
	public JLabel messageJLabel6;
	public JLabel messageJLabel7;
	 
	
public void displayMessage(String message) {
   System.out.print(message); 
} 
public void displayMessageLine(String message) {
   System.out.println(message);   
} 
public void displayDollarAmount(double amount)
{
   System.out.printf("%,.2fvnd", amount);   
} 
public void createlogin() {
	
 GDChinh = new JFrame("ATM");
 messageJLabel4 = new JLabel(" Vui long chen the tin dung/ghi no vao khe                            ");
	messageJLabel = new JLabel("  Nhap ma PIN :    ");
	
	 Inputfield1 = new JTextField( 10 );
	 
	 messageJLabel2 = new JLabel(" 														                  ");
	 Inputfield2 = new JTextField( 10 );
	 loginbutton = new JButton("Dang nhap");
	 messageJLabel3 = new JLabel("");
	 GDChinh.setLayout( new FlowLayout() );
	 GDChinh.add(messageJLabel4);
	 GDChinh.add( messageJLabel );
	 
	 GDChinh.add( Inputfield2 );
	 GDChinh.add( messageJLabel2 );
	 GDChinh.add(messageJLabel3);
	 Inputfield2.setEditable(false);
	 GDChinh.repaint();

	
}

public void createmenu(){
	GDChinh.getContentPane().removeAll();
	messageJLabel = new JLabel("Welcome");
	messageJLabel2 = new JLabel("1 - Vi     ");
	messageJLabel3 = new JLabel("2 - Rut Tien  ");
	messageJLabel4 = new JLabel("3 - Gui Tien  ");
	messageJLabel5 = new JLabel("4 - Exit     ");
	GDChinh.setLayout( new FlowLayout() ); 
	GDChinh.add(messageJLabel);
	GDChinh.add( messageJLabel2 ); 
	GDChinh.add( messageJLabel3 ); 
	GDChinh.add( messageJLabel4 ); 
	GDChinh.add( messageJLabel5 );
	GDChinh.repaint();
}

public void creatBalanceGUI(){
	GDChinh.getContentPane().removeAll();
	messageJLabel = new JLabel("Thong Tin So Du:        ");
	messageJLabel2 = new JLabel("So Du Kha Dung:");
	messageJLabel3 = new JLabel("Tong Du :");
	Exit = new JButton("BACK");
	GDChinh.setLayout( new FlowLayout() );
	GDChinh.add(messageJLabel);
	GDChinh.add(messageJLabel2);
	GDChinh.add(messageJLabel3);
	GDChinh.add(Exit);
	GDChinh.repaint();
}

public void createWithdrawGUI() {
 GDChinh.getContentPane().removeAll();
 GDChinh.revalidate();

 messageJLabel = new JLabel("Lua Chon So Tien Rut:           ");
 messageJLabel2 = new JLabel("1 - 50000vnd ");
 messageJLabel3 = new JLabel("2 - 100000vnd ");
 messageJLabel4 = new JLabel("3 - 200000vnd ");
 messageJLabel5 = new JLabel("4 - 500000vnd ");
 messageJLabel6 = new JLabel("5 - 2000000vnd ");
 messageJLabel7 = new JLabel("            Chon So Tien Muon Rut");
 Exit = new JButton("Cancel");

 GDChinh.setLayout(new FlowLayout());
 GDChinh.add(messageJLabel);
 GDChinh.add(messageJLabel2);
 GDChinh.add(messageJLabel3);
 GDChinh.add(messageJLabel4);
 GDChinh.add(messageJLabel5);
 GDChinh.add(messageJLabel6);
 GDChinh.add(Exit);
 GDChinh.add(messageJLabel7);

 GDChinh.repaint();
}

public void CreateDepositGUI(){
	GDChinh.getContentPane().removeAll();
	messageJLabel2 = new JLabel("Vui long nhap so tien muon gui");
	messageJLabel3 = new JLabel("");
	Inputfield2 = new JTextField(20);
	Inputfield2.setEditable(false);
	button1 = new JButton("Gui");
	Exit = new JButton("Cancel");
	GDChinh.add(messageJLabel2);
	GDChinh.add(messageJLabel3);
	GDChinh.add(Inputfield2);
	GDChinh.add(Exit);
	GDChinh.repaint();
}


public void setGUI(){
	repaint();
}

public void createAdminpage() {
 GDChinh.setLayout(new GridLayout(2, 1, 10, 10)); 

 JPanel viewPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
 
 messageJLabel = new JLabel("Kiem Tra Nguoi Dung:"); 
 messageJLabel2 = new JLabel("So Tai Khoan:");
 messageJLabel3 = new JLabel("So Du Kha Dung:");
 messageJLabel4 = new JLabel("Tong Du:"); 
 
 button1 = new JButton("Next");
 button4 = new JButton("Truoc"); 
 button3 = new JButton("Xoa"); 

 viewPanel.add(messageJLabel);
 viewPanel.add(messageJLabel2);
 viewPanel.add(messageJLabel3);
 viewPanel.add(messageJLabel4);
 viewPanel.add(button4); 
 viewPanel.add(button1); 
 viewPanel.add(button3); 

 JPanel addPanel = new JPanel(new GridLayout(5, 2, 10, 10));
 
 messageJLabel6 = new JLabel("Them Nguoi Dung:"); 
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

 addPanel.add(messageJLabel6);
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


} // end class Screen
