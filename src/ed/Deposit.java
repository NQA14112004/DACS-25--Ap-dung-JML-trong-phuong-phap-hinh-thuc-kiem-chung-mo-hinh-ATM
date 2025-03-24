package ed;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposit extends Transaction {
    private double amount; 
    private Keypad keypad; 
    private DepositSlot depositSlot; 

    public Deposit(int userAccountNumber, ATMView atmScreen, BankDatabase atmBankDatabase,
                   Keypad atmKeypad, DepositSlot atmDepositSlot) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        keypad = atmKeypad;
        depositSlot = atmDepositSlot;
    }

    @Override
    public void execute() {
        GDSendMoney();
    }

    public void transaction(double amount) {
        BankDatabase bankDatabase = getBankDatabase();
        ATMView screen = getScreen();

        if (amount <= 0) {
            screen.messageJLabel8.setText("Số tiền gửi phải lớn hơn 0.");
            return;
        }

        if (depositSlot.nhanTienGui()) { // Giả lập việc nhận phong bì tiền
            bankDatabase.credit(getAccountNumber(), amount);
            screen.messageJLabel8.setText("Gửi tiền thành công! Số tiền: " + String.format("%,.0f", amount) + "vnd");
            System.out.println("Đã gửi: " + amount + "vnd, Tổng số dư: " + bankDatabase.getTongDu(getAccountNumber()) + "vnd");
        } else {
            screen.messageJLabel8.setText("Gửi tiền thất bại. Vui lòng thử lại.");
        }
    }

    private void GDSendMoney() {
        ATMView atmview = getScreen();
        atmview.createDepositGUI();
        atmview.GDChinh.add(keypad.addkeypad(), BorderLayout.EAST);

        // Cập nhật listener cho bàn phím số để điền vào Inputfield3
        updateKeypadListeners(atmview);

        // Gán ActionListener cho nút "Xác nhận"
        JButton confirmButton = atmview.getConfirmButton();
        if (confirmButton != null) {
            confirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        amount = Double.parseDouble(atmview.Inputfield3.getText());
                        if (amount <= 0) {
                            atmview.messageJLabel8.setText("Vui lòng nhập số tiền hợp lệ.");
                            return;
                        }
                        // Mở cửa sổ xác nhận
                        showConfirmationDialog(amount);
                    } catch (NumberFormatException ex) {
                        atmview.messageJLabel8.setText("Vui lòng nhập số tiền hợp lệ.");
                    }
                }
            });
        } else {
            System.out.println("Không tìm thấy nút Xác nhận!");
        }

        atmview.GDChinh.revalidate();
    }

    // Tạo cửa sổ xác nhận
    private void showConfirmationDialog(double amount) {
        ATMView screen = getScreen();
        JDialog confirmationDialog = new JDialog(screen.GDChinh, "Xác nhận giao dịch", true);
        confirmationDialog.setLayout(new BorderLayout());
        confirmationDialog.setSize(300, 150);
        confirmationDialog.setLocationRelativeTo(screen.GDChinh);

        // Thông báo số tiền
        JLabel message = new JLabel("Bạn muốn gửi " + String.format("%,.0f", amount) + "vnd?", SwingConstants.CENTER);
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
                screen.messageJLabel8.setText("Giao dịch đã bị hủy.");
                confirmationDialog.dispose();
            }
        });

        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        confirmationDialog.add(buttonPanel, BorderLayout.SOUTH);

        confirmationDialog.setVisible(true);
    }

    // Cập nhật listener cho bàn phím số
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
}