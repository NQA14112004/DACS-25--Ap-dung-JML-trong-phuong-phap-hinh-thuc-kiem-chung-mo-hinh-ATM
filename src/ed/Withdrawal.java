package ed;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Withdrawal extends Transaction
{
    private double amount; // Số tiền rút
    private Keypad keypad; // Bàn phím
    private CashDispenser cashDispenser; // Máy phát tiền
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

    // Xử lý giao dịch rút tiền
    public void transaction(double amount) {
        BankDatabase bankDatabase = getBankDatabase();
        ATMView screen = getScreen();
        boolean cashDispensed = false;
        double soDu = bankDatabase.getSoDu(getAccountNumber());

        if (amount <= soDu) {   
            if (cashDispenser.ktSoDuATM((int) amount)) {
                bankDatabase.debit(getAccountNumber(), amount);
                cashDispenser.dispenseCash((int) amount); 
                cashDispensed = true; 
                screen.messageJLabel7.setText("\nTiền của bạn đã được rút. Vui lòng nhận tiền!");
                double newSoDu = bankDatabase.getSoDu(getAccountNumber());
                screen.messageJLabel8.setText("Available Balance: " + String.format("%,.0f", newSoDu) + "vnd");
                System.out.println("Đã rút: " + amount + "vnd, Tài khoản còn: " + newSoDu + "vnd");
            } else {
                screen.messageJLabel7.setText(
                    "\nXin lỗi! Số tiền trong ATM không đủ.\n\nVui lòng nhập số tiền nhỏ hơn.");
                screen.messageJLabel8.setText("Available Balance: " + String.format("%,.0f", soDu) + "vnd");
            }
        } else {
            screen.messageJLabel7.setText(
                "\nSố dư trong tài khoản không đủ.\n\nHãy chọn số nhỏ hơn."); 
            screen.messageJLabel8.setText("Available Balance: " + String.format("%,.0f", soDu) + "vnd");
        }
    }

    private void GDRutTien() {
        ATMView atmview = getScreen(); 
        double initialBalance = getBankDatabase().getSoDu(getAccountNumber());
        atmview.createWithdrawGUI(initialBalance); 
        atmview.GDChinh.add(keypad.addkeypad(), BorderLayout.EAST);

        // Listener cho các nút lựa chọn số tiền
        withdraw1 check1 = new withdraw1();
        withdraw2 check2 = new withdraw2();
        withdraw3 check3 = new withdraw3();
        withdraw4 check4 = new withdraw4();
        withdraw5 check5 = new withdraw5();
        atmview.messageJLabel2.addActionListener(check1);
        atmview.messageJLabel3.addActionListener(check2);
        atmview.messageJLabel4.addActionListener(check3);
        atmview.messageJLabel5.addActionListener(check4);
        atmview.messageJLabel6.addActionListener(check5);

        // Tìm nút "Xác nhận" và thêm listener
        for (Component comp : atmview.GDChinh.getContentPane().getComponents()) {
            if (comp instanceof JPanel) {
                for (Component subComp : ((JPanel) comp).getComponents()) {
                    if (subComp instanceof JPanel) {
                        for (Component innerComp : ((JPanel) subComp).getComponents()) {
                            if (innerComp instanceof JButton && ((JButton) innerComp).getText().equals("Xác nhận")) {
                                ((JButton) innerComp).addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        try {
                                            amount = Double.parseDouble(atmview.Inputfield3.getText());
                                            if (amount <= 0) {
                                                atmview.messageJLabel7.setText("Vui lòng nhập số tiền hợp lệ.");
                                                return;
                                            }
                                            // Mở cửa sổ xác nhận
                                            showConfirmationDialog(amount);
                                        } catch (NumberFormatException ex) {
                                            atmview.messageJLabel7.setText("Vui lòng nhập số tiền hợp lệ.");
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }

        // Cập nhật listener cho bàn phím số để điền vào Inputfield3
        updateKeypadListeners(atmview);

        atmview.GDChinh.revalidate();
    }

    // Phương thức mới để cập nhật listener cho bàn phím số
    private void updateKeypadListeners(ATMView atmview) {
        keypad.B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = atmview.Inputfield3.getText();
                atmview.Inputfield3.setText(currentText + "1");
            }
        });
        keypad.B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = atmview.Inputfield3.getText();
                atmview.Inputfield3.setText(currentText + "2");
            }
        });
        keypad.B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = atmview.Inputfield3.getText();
                atmview.Inputfield3.setText(currentText + "3");
            }
        });
        keypad.B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = atmview.Inputfield3.getText();
                atmview.Inputfield3.setText(currentText + "4");
            }
        });
        keypad.B5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = atmview.Inputfield3.getText();
                atmview.Inputfield3.setText(currentText + "5");
            }
        });
        keypad.B6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = atmview.Inputfield3.getText();
                atmview.Inputfield3.setText(currentText + "6");
            }
        });
        keypad.B7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = atmview.Inputfield3.getText();
                atmview.Inputfield3.setText(currentText + "7");
            }
        });
        keypad.B8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = atmview.Inputfield3.getText();
                atmview.Inputfield3.setText(currentText + "8");
            }
        });
        keypad.B9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = atmview.Inputfield3.getText();
                atmview.Inputfield3.setText(currentText + "9");
            }
        });
        keypad.B0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = atmview.Inputfield3.getText();
                atmview.Inputfield3.setText(currentText + "0");
            }
        });
        keypad.BClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atmview.Inputfield3.setText("");
            }
        });
        keypad.BDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = atmview.Inputfield3.getText();
                if (currentText.length() > 0) {
                    atmview.Inputfield3.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });
        keypad.BExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ATM atm = ATM.getinstance();
                atm.createmenu(); // Trở lại menu chính
            }
        });
    }

    // Tạo cửa sổ xác nhận
    private void showConfirmationDialog(double amount) {
        ATMView screen = getScreen();
        JDialog confirmationDialog = new JDialog(screen.GDChinh, "Xác nhận giao dịch", true);
        confirmationDialog.setLayout(new BorderLayout());
        confirmationDialog.setSize(300, 150);
        confirmationDialog.setLocationRelativeTo(screen.GDChinh);

        // Thông báo số tiền
        JLabel message = new JLabel("Bạn muốn rút " + String.format("%,.0f", amount) + "vnd?", SwingConstants.CENTER);
        confirmationDialog.add(message, BorderLayout.CENTER);

        // Panel chứa các nút
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton confirmButton = new JButton("Xác nhận");
        JButton cancelButton = new JButton("Hủy");

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transaction(amount); // Thực hiện giao dịch
                confirmationDialog.dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screen.messageJLabel7.setText("Giao dịch đã bị hủy.");
                confirmationDialog.dispose();
            }
        });

        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        confirmationDialog.add(buttonPanel, BorderLayout.SOUTH);

        confirmationDialog.setVisible(true);
    }

    // Các listener cho các nút lựa chọn số tiền
    public class withdraw1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            getScreen().Inputfield3.setText("50000");
        }
    }

    public class withdraw2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            getScreen().Inputfield3.setText("100000");
        }
    }

    public class withdraw3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            getScreen().Inputfield3.setText("200000");
        }
    }

    public class withdraw4 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            getScreen().Inputfield3.setText("500000");
        }
    }

    public class withdraw5 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            getScreen().Inputfield3.setText("2000000");
        }
    }
}