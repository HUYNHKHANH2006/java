package MangNgauNhienN;
import java.util.*;

import java.util.Scanner;

public class MangArray 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int n ;
		ArrayList<Integer>ds=new ArrayList<Integer>();
		System.out.println("Nhap so phan tu trong mang : ");
		Scanner sc = new Scanner(System.in);
		try
		{	
			n = sc.nextInt();
			System.out.println("Nhap cac phan tu : ");
			for (int i = 0 ; i < n ; i++)
			{
				int s = sc.nextInt();
                ds.add(s);
			}
			System.out.println("Cac phan tu trong Mang Array : ");
			for (int s: ds)
			{
				System.out.println(s);
			}
			System.out.println("Nhap phan tu muon them vao");
			
			
			
			
		}
		catch(Exception ex)
		{
			System.out.println("Loi nhap du lieu!");
		}
		finally
		{
			int them = 0, sua = 0, xoa = 0, timkiem = 0;
			them = sc.nextInt();
			ds.add(them);
			 
			System.out.println("Danh sach sau khi them : ");
			for (int s: ds)
			{
				System.out.print(" "+s+" ");
			}
			System.out.println("\n Danh sach truoc khi sua:");
			for (int s : ds)
			{
			    System.out.print(" "+s+" ");
			}

			System.out.println("\n Nhap vi tri can sua:");
			sua = sc.nextInt();

			if (sua != ds.size() )
			{
			    System.out.println("Nhap gia tri moi:");
			    int x = sc.nextInt();
			    ds.set(sua, x);
			}
			else
			{
				System.out.println("Vi tri khong ton tai : ");
			}
			System.out.println("Danh sach sau khi sua:");
			for (int s : ds)
			{
			    System.out.print(" " + s + " ");
			}
			
			
			System.out.println("\n Danh sach truoc khi xoa:");
			for (int s : ds)
			{
			    System.out.print(" "+s+" ");
			}
			
			System.out.println("\n Nhap vi tri can xoa:");
			xoa = sc.nextInt();

			if (xoa != ds.size() )
			{
			    ds.remove(xoa);
			}
			else
			{
				System.out.println("Vi tri khong ton tai : ");
			}
			System.out.println("Danh sach sau khi xoa:");
			for (int s : ds)
			{
			    System.out.print(" " + s + " ");
			}
			
			
			
			System.out.println("\n Danh sach truoc khi tim kiem :");
			for (int s : ds)
			{
			    System.out.print(" "+s+" ");
			}
			
			System.out.println("\n Nhap vi tri can tim kiem :");
			timkiem = sc.nextInt();

			if (timkiem != ds.size() )
			{
			    System.out.println("Vi tri co gia tri " + ds.get(timkiem));
			}
			else
			{
				System.out.println("Vi tri khong ton tai : ");
			}
			SelectionSort(ds);
			
		}

	}
	public static void SelectionSort(ArrayList<Integer> ds)
	{
		int min;
		for(int i=0;i < ds.size();i++)
		{
		min = i;
			for(int j=i+1;j<ds.size();j++)
			{
				if (ds.get(j) < ds.get(min))
				min = j;
			}
			if(min!=i)
			{
				int temp = ds.get(i);
				ds.set(i,ds.get(min)) ;
				ds.set(min, temp);
			}

		}
		System.out.println("\n Danh sach sap xep tang dan :");
		for (int s : ds)
		{
		    System.out.print(" "+s+" ");
		}
		
		
	}
	
}
