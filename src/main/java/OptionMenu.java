import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu {
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	HashMap<Integer, Account> data = new HashMap<Integer, Account>();

	public void getLogin() throws IOException {
		boolean end = false;
		int customerNumber = 0;
		int pinNumber = 0;
		while (!end) {
			try {
				System.out.print("\nNhap so tai khoan: ");
				customerNumber = menuInput.nextInt();
				System.out.print("\nNhap ma PIN: ");
				pinNumber = menuInput.nextInt();
				Iterator it = data.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					Account acc = (Account) pair.getValue();
					if (data.containsKey(customerNumber) && pinNumber == acc.getPinNumber()) {
						getAccountType(acc);
						end = true;
						break;
					}
				}
				if (!end) {
					System.out.println("\nNhap sai STK or ma PIN");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nSTK va ma PIN khong chi bao gom nhung con so!");
			}
		}
	}

	public void createAccount() throws IOException {
		int cst_no = 0;
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nNhap so tai khoan cua ban ");
				cst_no = menuInput.nextInt();
				Iterator it = data.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					if (!data.containsKey(cst_no)) {
						end = true;
					}
				}
				if (!end) {
					System.out.println("\nSo nay da duoc dang ki!");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nLua chon khong hop le!");
				menuInput.next();
			}
		}
		System.out.println("\nNhap ma PIN dang ki");
		int pin = menuInput.nextInt();
		data.put(cst_no, new Account(cst_no, pin));
		System.out.println("\nDang ki thanh cong");
		System.out.println("\nChuyen sang dang nhap.............");
		getLogin();
	}


	public void getAccountType(Account acc) {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nChon tai khoan muon truy cao ");
				System.out.println("  1 - Tai khoan chinh.");
				System.out.println("  2 - Tai khoan tiet kiem. ");
				System.out.println("  3 - Exit.");
				System.out.print("\nChoice: ");

				int selection = menuInput.nextInt();

				switch (selection) {
				case 1:
					getChecking(acc);
					break;
				case 2:
					getSaving(acc);
					break;
				case 3:
					end = true;
					break;
				default:
					System.out.println("\nLua chon khong hop le!");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nLua chon khong hop le!");
				menuInput.next();
			}
		}
	}

	public void getChecking(Account acc) {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nTai khoan chinh: ");
				System.out.println("  1 - Kiem tra vi.");
				System.out.println("  2 - Rut tien.");
				System.out.println("  3 - Gui tien.");
				System.out.println("  4 - Cuyen tien.");
				System.out.println("  5 - Exit");
				System.out.print("\nChoice: ");

				int selection = menuInput.nextInt();

				switch (selection) {
				case 1:
					System.out.println("\nCheckings Account Balance: " + moneyFormat.format(acc.getTKchinh()));
					break;
				case 2:
					acc.RutTienTuTaiKhoanThanhToan();
					break;
				case 3:
					acc.NapTienVaoTaiKhoanChinh();
					break;

				case 4:
					acc.getTransferInput("Checkings");
					break;
				case 5:
					end = true;
					break;
				default:
					System.out.println("\nLua chon khong hop le!");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nLua chon khong hop le!.");
				menuInput.next();
			}
		}
	}

	public void getSaving(Account acc) {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nTai khoan tiet kiem: ");
				System.out.println("  1 - Kiem tra tai khoan tiet kiem.");
				System.out.println("  2 - Rut tien tiet kiem.");
				System.out.println("  3 - Gui tien tiet kiem.");
				System.out.println("  4 - Chuyen tien.");
				System.out.println("  5 - Exit");
				System.out.print("Choice: ");
				int selection = menuInput.nextInt();
				switch (selection) {
				case 1:
					System.out.println("\nSavings Account Balance: " + moneyFormat.format(acc.getTKtietKiem()));
					break;
				case 2:
					acc.RutTienTuTaiKhoanTietKiem();
					break;
				case 3:
					acc.GuiTienTietKiem();
					break;
				case 4:
					acc.getTransferInput("Savings");
					break;
				case 5:
					end = true;
					break;
				default:
					System.out.println("\nLua chon khong hop le!");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nLua chon khong hop le!");
				menuInput.next();
			}
		}
	}

	public void mainMenu() throws IOException {
		data.put(952141, new Account(952141, 191904, 1000, 5000));
		data.put(123, new Account(123, 123, 20000, 50000));
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\n  1 - Dang nhap");
				System.out.println("  2 - Dang ki");
				System.out.print("\nChoice: ");
				int choice = menuInput.nextInt();
				switch (choice) {
				case 1:
					getLogin();
					end = true;
					break;
				case 2:
					createAccount();
					end = true;
					break;
				default:
					System.out.println("\nLua chon khong hop le!");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nLua chon khong hop le!");
				menuInput.next();
			}
		}
		System.out.println("\nCam on da su dung ATM.\n");
		menuInput.close();
		System.exit(0);
	}
}