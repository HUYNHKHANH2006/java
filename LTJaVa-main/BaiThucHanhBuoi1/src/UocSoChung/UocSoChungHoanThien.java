package UocSoChung;
import java.util.*;

public class UocSoChungHoanThien {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try
		{
			int choice;
			boolean continueProgram = true;

			while(continueProgram)
			{
				System.out.println("\n======== MENU CAC BAI TOAN ========");
				System.out.println("1. Tim UCLN cua 2 so a, b");
				System.out.println("2. Kiem tra so hoan thien (Perfect number)");
				System.out.println("3. Kiem tra chu so toan la chan");
				System.out.println("4. Tinh chuoi S(x,n)");
				System.out.println("5. Thoat chuong trinh");
				System.out.println("=====================================");
				System.out.print("Chon chuc nang (1-5) ma ban muon thuc hien : ");

				try
				{
					choice = Integer.parseInt(scanner.nextLine().trim());
					switch(choice)
					{
						case 1:
							tinhUCLN();
							break;
						case 2:
							kiemTraSoHoanThien();
							break;
						case 3:
							kiemTraChuSoChay();
							break;
						case 4:
							tinhChuoiS();
							break;
						case 5:
							continueProgram = false;
							System.out.println("\nCam on da su dung chuong trinh!");
							break;
						default:
							System.out.println("Lua chon khong hop le! Vui long chon tu 1-5 : ");
					}
				}
				catch(NumberFormatException ex)
				{
					System.out.println("Loi Vui long nhap mot so nguyen hop le! ");
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Loi he thong: " + ex.getMessage());
			ex.printStackTrace();
		}
		finally
		{
			if(scanner != null)
			{
				scanner.close();
				System.out.println("\nĐa đong ket noi ");
			}
		}

	}

	// Hàm 1: Tính ƯCLN của 2 số
	public static void tinhUCLN()
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.println("\n--- TINH UCLN CUA 2 SO ---");
			System.out.print("Nhap so a: ");
			int a = sc.nextInt();

			System.out.print("Nhap so b: ");
			int b = sc.nextInt();

			int ucln = timUCLN(a, b);
			System.out.println("\n UCLN(" + a + ", " + b + ") = " + ucln);

		}
		catch(NumberFormatException ex)
		{
			System.out.println("Loi Vui long nhap so nguyen duong hop le!");
		}
		catch(Exception ex)
		{
			System.out.println("Loi : " + ex.getMessage());
		}
	}

	// Hàm phụ: Tìm ƯCLN bằng thuật toán Euclid
	public static int timUCLN(int a, int b)
	{
		try
		{
			while(b != 0)
			{
				int temp = b;
				b = a % b;
				a = temp;
			}
			return a;
		}
		catch(Exception ex)
		{
			System.out.println("Loi khi tinh UCLN: " + ex.getMessage());
			return -1;
		}
	}

	// Hàm 2: Kiểm tra số hoàn thiện
	public static void kiemTraSoHoanThien()
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.println("\n--- KIEM TRA SO HOAN THIEN ---");
			System.out.print("Nhap so n: ");
			int n = sc.nextInt();

			if(n <= 0)
			{
				throw new NumberFormatException("So phai lon hon 0!");
			}

			int tongUocSo = 0;
			StringBuilder uocSo = new StringBuilder();

			// Tìm các ước số của n
			for(int i = 1; i < n; i++)
			{
				if(n % i == 0)
				{
					tongUocSo += i;
					uocSo.append(i).append(", ");
				}
			}

			// Xóa dấu phẩy cuối cùng
			if(uocSo.length() > 0)
			{
				uocSo.setLength(uocSo.length() - 2);
			}

			System.out.println("\nCac uoc so cua " + n + ": " + uocSo);
			System.out.println("Tong cac uoc so : " + tongUocSo);

			if(tongUocSo == n)
			{
				System.out.println( n + " La so hoan thien!");
			}
			else
			{
				System.out.println(n + " Khong phai la so hoan thien!");
			}

		}
		catch(NumberFormatException ex)
		{
			System.out.println("Loi Vui long nhap so nguyen duong hop le ! ");
		}
	}

	// Hàm 3: Kiểm tra chữ số toàn chẵn
	public static void kiemTraChuSoChay()
	{
		try
		{
			System.out.println("\n--- KIEM TRA CHu SO TOAN CHAN ---");
			System.out.print("Nhap so n: ");
			Scanner sc = new Scanner(System.in);
			String n = sc.nextLine();

			if(n.isEmpty())
			{
				throw new NumberFormatException("Vui long nhap mot so!");
			}

			boolean toanchusoChay = true;
			StringBuilder chiTiet = new StringBuilder();

			for(char c : n.toCharArray())
			{
				int digit = Character.getNumericValue(c);
				chiTiet.append(digit);

				if(digit % 2 != 0)
				{
					toanchusoChay = false;
					chiTiet.append("(le), ");
				}
				else
				{
					chiTiet.append("(chan), ");
				}
			}

			System.out.println("\nChi tiet cac chu so : " + chiTiet);

			if(toanchusoChay)
			{
				System.out.println( n + " Toan bo chu so nhap deu la so chan!");
			}
			else
			{
				System.out.println( n + " Khong phai toan bo so vua nhap deu la so chan!");
			}

		}
		catch(NumberFormatException ex)
		{
			System.out.println("Loi: " + ex.getMessage());
		}
	}

	// Hàm 4: Tính chuỗi S(x,n)
	public static void tinhChuoiS()
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.println("\n--- TINH CHUOI S(x,n) ---");
			System.out.println("Cong thuc: S(x,n) = x + x³/3! + x⁵/5! + ... + x^(2n+1)/(2n+1)!");

			System.out.print("Nhap gia tri x: ");
			int x = sc.nextInt();
			System.out.print("Nhap gia tri n: ");
			int n = sc.nextInt();
			double ketQua = tinhS(x, n);

			System.out.println("\n--- KET QUA ---");
			System.out.print("S(" + x + ", " + n + ") = " + String.format("%.10f", ketQua));

			for(int i = 1; i <= n; i++)
			{
				int power = 2 * i + 1;
				long factorial = tinhGiaiThua(power);
				double term = Math.pow(x, power) / factorial;
				System.out.print(" + " + String.format("%.6f", term));
			}

			System.out.println("\n Ket qua cuoi cung: " + String.format("%.10f", ketQua));

		}
		catch(NumberFormatException ex)
		{
			System.out.println("Loi Vui long nhap gia tri so hop le!");
		}
	}

	// Hàm phụ: Tính chuỗi S(x,n)
	public static double tinhS(double x, int n)
	{
		try
		{
			double tong = x;
			for(int i = 1; i <= n; i++)
			{
				int power = 2 * i + 1;
				long factorial = tinhGiaiThua(power);
				tong += Math.pow(x, power) / factorial;
			}
			return tong;
		}
		catch(Exception ex)
		{
			System.out.println("Loi khi tinh chuoi: " + ex.getMessage());
			return -1;
		}
	}

	// Hàm phụ: Tính giai thừa
	public static long tinhGiaiThua(int n)
	{
		try
		{
			if(n == 0 || n == 1)
			{
				return 1;
			}

			long ketQua = 1;
			for(int i = 2; i <= n; i++)
			{
				ketQua *= i;
			}
			return ketQua;
		}
		catch(Exception ex)
		{
			System.out.println("Loi khi tinh giai thua: " + ex.getMessage());
			return -1;
		}
	}

}