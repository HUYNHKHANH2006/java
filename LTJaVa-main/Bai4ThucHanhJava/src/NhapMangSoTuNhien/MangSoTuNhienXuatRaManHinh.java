package NhapMangSoTuNhien;

import java.util.*;

public class MangSoTuNhienXuatRaManHinh 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int n = 0;
		System.out.println("Nhap so phan tu trong mang : ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int A[] = new int [n];
		int dem = 0,sole =0,danhsachsole = 0, sochan = 0, danhsachsochan = 0;
		int tong = 0  ,max = A[0],min = A[0];
		SoNguyenTo(n);
		// TODO Auto-generated method stub
		try
		{	
			System.out.println("Nhap gia tri trong mang :");
			for (int i = 0 ; i < n; i++)
			{
				
				A[i] = sc.nextInt();
			}
			System.out.println("Nhung Gia Tri trong Mang :");
			for (int i = 0 ; i < n; i++)
			{
				System.out.println(A[i]);
				if (A[i]%2!=0)
				{		
					sole+=A[i];
				}
				else
				{
					sochan+=A[i];
				}
				
			}
			System.out.println("Tong so le : " + sole );
			System.out.println("Tong so chan : " + sochan );

			for (int i = 0; i < n ; i++)
			{
				if (SoNguyenTo(A[i]))
				{
					System.out.println("La so nguyen to "+A[i]);
				}
				else
				{
					System.out.println("Khong phai so nguyen to "+A[i]);
				}
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			
		}	
		
			

	}
	public static boolean SoNguyenTo(int n) 
	{
	    if (n < 2) return false;

	    for (int i = 2; i <= Math.sqrt(n); i++) 
	    {
	        if (n % i == 0) 
	        {
	            return false;
	        }
	    }
	    return true;
	}

}
