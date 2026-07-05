package MangNgauNhienN;
import java.util.*;

public class TinhToanTrenMang 
{

	public static void main(String[] args) 
	{
		
		int n = 0;
		System.out.println("Nhap so phan tu trong mang : ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int A[] = new int [n];
		int dem = 0;
		int tong = 0 , k ,max = A[0],min = A[0];
		
		// TODO Auto-generated method stub
		try
		{	
			System.out.println("Nhap gia tri trong mang :");
			for (int i = 0 ; i < n; i++)
			{
				
				A[i] = sc.nextInt();
			}
			System.out.println("Nhap gia tri k trong mang :");
			k = sc.nextInt();
			System.out.println("Nhung Gia Tri trong Mang :");
			for (int i = 0 ; i < n; i++)
			{
				System.out.println(A[i]);
				tong  +=A[i];
				if (A[i] == k)
				{					
					dem++;
				}
				
				if (A[i] > max)
				{
					max = A[i];
				}
				if (A[i] < min)
				{
					min = A[i];
				}				
			}
			System.out.printf("Tong gia tri trong mang :" + tong);
			System.out.println ("\n" + k + " Xuat hien " + dem +" lan ");
			System.out.printf("\n  Gia tri lon nhat trong mang :" + max);
			System.out.printf("\n Gia tri nho nhat trong mang :" + min);
			System.out.println("\n Cac so nguyen to trong mang:");
			for (int i = 0 ; i < n; i++)
			{
			    if (isPrime(A[i])) {
			        System.out.print(A[i] + " ");
			    }
			}
			System.out.println("\n Sap xep theo thu tu tang dan : ");
			SelectionSort(A);
			System.out.println("\n Sap Xep theo thu tu giam dan : ");
			SelectionSort1(A);
			

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			sc.close();
		}

	}
	public static boolean isPrime(int n) 
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
	public static void SelectionSort(int []A)
	{
		int min;
		for(int i=0;i<A.length;i++)
		{
		min = i;
			for(int j=i+1;j<A.length;j++)
			{
				if (A[j] < A[min])
				min = j;
			}
			if(min!=i)
			{
				int temp = A[i];
				A[i] = A[min];
				A[min] = temp;
			}
		    System.out.println("  " + A[i] );

		}
		
	}
	public static void SelectionSort1(int []A)
	{
		int min;
		for(int i=0;i<A.length;i++)
		{
		min = i;
			for(int j=i+1;j<A.length;j++)
			{
				if (A[j] > A[min])
				min = j;
			}
			if(min!=i)
			{
				int temp = A[i];
				A[i] = A[min];
				A[min] = temp;
			}
		    System.out.println("  " + A[i] );

		}
		
	}
}


