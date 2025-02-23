import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
	private int customerNumber;
	private int pinNumber;
	private double TKchinh = 0;
	private double TKtietKiem = 0;

	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	public Account() {
	}

	public Account(int customerNumber, int pinNumber) {
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
	}

	public Account(int customerNumber, int pinNumber, double chinh, double tietkiem) {
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
		this.TKchinh = chinh;
		this.TKtietKiem = tietkiem;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public double getTKchinh() {
		return TKchinh;
	}

	public double getTKtietKiem() {
		return TKtietKiem;
	}

	public double RutTien(double amount) {
		TKchinh = (TKchinh - amount);
		return TKchinh;
	}

	public double RutTienTietKiem(double amount) {
		TKtietKiem = (TKtietKiem - amount);
		return TKtietKiem;
	}

	public double NapTien(double amount) {
		TKchinh = (TKchinh + amount);
		return TKchinh;
	}

	public double GuiTietKiem(double amount) {
		TKtietKiem = (TKtietKiem + amount);
		return TKtietKiem;
	}

	public void ChuyenTietKiem(double amount) {
		TKchinh = TKchinh - amount;
		TKtietKiem = TKtietKiem + amount;
	}

	public void RutVeTaiKhoanChinh(double amount) {
		TKtietKiem = TKtietKiem - amount;
		TKchinh = TKchinh + amount;
	}

	public void RutTienTuTaiKhoanThanhToan() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nSo du tai khoan hien tai: " + moneyFormat.format(TKchinh));
				System.out.print("\nSo tien muon rut: ");
				double amount = input.nextDouble();
				if ((TKchinh - amount) >= 0 && amount >= 0) {
					RutTien(amount);
					System.out.println("\nSo du tai khoan hien tai: " + moneyFormat.format(TKchinh));
					end = true;
				} else {
					System.out.println("\nSo du khong du!");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nLua chon khong hop le!");
				input.next();
			}
		}
	}

	public void RutTienTuTaiKhoanTietKiem() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nSo Tien Tiet Kiem:  " + moneyFormat.format(TKtietKiem));
				System.out.print("\nSo tien muon rut:  ");
				double amount = input.nextDouble();
				if ((TKtietKiem - amount) >= 0 && amount >= 0) {
					RutTienTietKiem(amount);
					System.out.println("\nSo tien tiet kiem hien tai: " + moneyFormat.format(TKtietKiem));
					end = true;
				} else {
					System.out.println("\nSo du khong du!");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nLua chon khong hop le!");
				input.next();
			}
		}
	}

	public void NapTienVaoTaiKhoanChinh() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nSo du hien tai:  " + moneyFormat.format(TKchinh));
				System.out.print("\nSo tien muon gui:  ");
				double amount = input.nextDouble();
				if ((TKchinh + amount) >= 0 && amount >= 0) {
					NapTien(amount);
					System.out.println("\nSo du hien tai: " + moneyFormat.format(TKchinh));
					end = true;
				} else {
					System.out.println("\nSo du khong the am!");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nLua chon khong hop le!");
				input.next();
			}
		}
	}

	public void GuiTienTietKiem() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nTien tiet kiem hien tai: " + moneyFormat.format(TKtietKiem));
				System.out.print("\nSo tien ban muon gui tiet kiem: ");
				double amount = input.nextDouble();

				if ((TKtietKiem + amount) >= 0 && amount >= 0) {
					GuiTietKiem(amount);
					System.out.println("\nSo tien tiet kiem hien tai: " + moneyFormat.format(TKtietKiem));
					end = true;
				} else {
					System.out.println("\nKhong the am!");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nLua chon khong hop le!");
				input.next();
			}
		}
	}

	public void getTransferInput(String accType) {
		boolean end = false;
		while (!end) {
			try {
				if (accType.equals("Checkings")) {
					System.out.println("\nChon tai khoan muon chuyen tien toi:");
					System.out.println("1.Tai khoan tiet kiem");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) {
					case 1:
						System.out.println("\nSo du tai khoan hien tai: " + moneyFormat.format(TKchinh));
						System.out.print("\nSo tien ban muon gui tiet kiem: ");
						double amount = input.nextDouble();
						if ((TKtietKiem + amount) >= 0 && (TKchinh - amount) >= 0 && amount >= 0) {
							ChuyenTietKiem(amount);
							System.out.println("\nTien tiet kiem hien tai: " + moneyFormat.format(TKtietKiem));
							System.out.println("\nSo du hien tai: " + moneyFormat.format(TKchinh));
							end = true;
						} else {
							System.out.println("\nVi khong the am!");
						}
						break;
					case 2:
						return;
					default:
						System.out.println("\nLua chon khong hop le!");
						break;
					}
				} else if (accType.equals("Savings")) {
					System.out.println("\nChon tai khoan muon chuyen toi: ");
					System.out.println("1. Tai khoan chinh");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) {
					case 1:
						System.out.println("\nSO tien tiet kiem hien tai: " + moneyFormat.format(TKtietKiem));
						System.out.print("\nSo tien muon rut: ");
						double amount = input.nextDouble();
						if ((TKchinh + amount) >= 0 && (TKtietKiem - amount) >= 0 && amount >= 0) {
							RutVeTaiKhoanChinh(amount);
							System.out.println("\nSO du hien tai: " + moneyFormat.format(TKchinh));
							System.out.println("\nTien tiet kiem hien tai: " + moneyFormat.format(TKtietKiem));
							end = true;
						} else {
							System.out.println("\nVi khong the am!");
						}
						break;
					case 2:
						return;
					default:
						System.out.println("\nLua chon khong hop le!");
						break;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("\nLua chon khong hop le!");
				input.next();
			}
		}
	}
}