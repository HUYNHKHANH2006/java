package PhuongTrinhBac2.com;
import java.util.*;
import java.math.*;
public class Bac2 {

	public static void main(String[] args) {
		System.out.println("Nhập a:");
		int a=new Scanner(System.in).nextInt();
		System.out.println("Nhập b:");
		int b=new Scanner(System.in).nextInt();
		System.out.println("Nhập c:");
		int c=new Scanner(System.in).nextInt();
		if (a==0 )
		{
			if (b == 0)
			{
				if (c == 0)
				{
					System.out.println("Phuong Trinh Vo So Nghiem :");
				}
				else
				{
					System.out.println("Phuong Trinh Vo Nghiem :");
				}
			}
			else
			{
				int x= -c / b;
				System.out.println("Gia tri :" + c);
			}
			
		}
		else
		{
			int delta= b*b - 4*a*c;
			System.out.println("Gia tri :" + delta);
			if (delta < 0 )
			{
				System.out.println("Phuong Trinh Vo Nghiem :");
			}
			else
			{
				if (delta == 0)
				{
					int x= -b / 2*a;
					System.out.println("Gia tri :" + x);
				}
				else
				{
					float x1= (-b -(float)Math.sqrt(delta))/(2*a);
					float x2= (-b +(float)Math.sqrt(delta))/(2*a);
					System.out.println("PT có 2 nghiệm");
					System.out.println("x1 = " +x1);
					System.out.println("x2 = " +x2);
				}
			}
				
		}
	}
}			
		
