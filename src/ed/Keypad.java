package ed;

import java.util.Scanner;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
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

public class Keypad 
{
   private Scanner input; 
   private String userinput;
   public static JButton B1;
   public static JButton B2;
   public static JButton B3;
   public static JButton B4;
   public static JButton B5;
   public JButton B6;
   public JButton B7;
   public JButton B8;
   public JButton B9;
   public JButton B0;
   public JButton space;
   public JButton BClear;
   public JButton BEnter;
   public JButton BDel;
   public JButton BExit;

   public Keypad() {
      input = new Scanner(System.in);    
   } 

   public int getInput() {
      return input.nextInt();
   } 

   public void setbuttons() {
      B1 = new JButton("1");
      B1.setText("1");
      B2 = new JButton("2");
      B3 = new JButton("3");
      B4 = new JButton("4");
      B5 = new JButton("5");
      B6 = new JButton("6");
      B7 = new JButton("7");
      B8 = new JButton("8");
      B9 = new JButton("9");
      B0 = new JButton("0");
      space = new JButton(" ");
      BClear = new JButton("Clear");
      BEnter = new JButton("Enter");
      BDel = new JButton("Del");
      BExit = new JButton("Exit");
   }

   public JPanel addkeypad() {
      JPanel panel = new JPanel();
      panel.setPreferredSize(new Dimension(200, 180)); 
      panel.setBackground(Color.gray);
      panel.setLayout(new GridLayout(5,3)); 
      panel.add(B1);
      panel.add(B2);
      panel.add(B3);
      panel.add(B4);
      panel.add(B5);
      panel.add(B6);
      panel.add(B7);
      panel.add(B8);
      panel.add(B9);
      panel.add(BClear);
      panel.add(B0);
      panel.add(BEnter);
      panel.add(BDel);
      panel.add(space);
      panel.add(BExit);
      
      return panel;
   }

   public String userinput(){
      return userinput; 
   }

   public void resetuserinput(){
      userinput = "";
   }
}