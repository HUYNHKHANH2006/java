package MangNgauNhienN;
import java.util.*;

public class MangHashMap {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int n = 0;
		int a = 0;
		String b;
		HashMap<Integer, String>map= new HashMap<Integer, String>();
		System.out.println("Nhap so phan tu trong mang : ");
		Scanner sc = new Scanner(System.in);
		try
		{	
			
			n = sc.nextInt();
			System.out.println("Nhap cac phan tu : ");
			for (int i = 0 ; i < n ; i++)
			{
				System.out.print("\n Nhap so : ");
                a = sc.nextInt();
                sc.nextLine();
                System.out.print("\n Nhap kieu String: ");
                b = sc.nextLine();

                map.put(a, b);
			}
			for (Integer key: map.keySet())
			{
				System.out.println(key + " - " + map.get(key));
			}
			
			

		
			
		}
		catch(Exception ex)
		{
			System.out.println("Loi nhap du lieu!");
		}
		finally
		{
			int sua = 0;
			System.out.println("\nDanh sach truoc khi sua:");
            for (Integer key : map.keySet())
            {
                System.out.println(key + " - " + map.get(key));
            }
			
			System.out.println("\n Nhap vi tri can sua:");
			sua = sc.nextInt();
			sc.nextLine();

			if (map.containsKey(sua))
			{
			    System.out.println("Nhap gia tri moi:");
			    int Giatri = sc.nextInt();
			    sc.nextLine();
			    
			    System.out.println("Nhap kieu String moi : ");
			    String Kieu = sc.nextLine();
			    map.remove(sua);
			    map.put(Giatri,Kieu);
			}
			else
			{
			    System.out.println("Key khong ton tai!");
			}
			System.out.println("\nDanh sach sau khi sua:");
            for (Integer key : map.keySet())
            {
                System.out.println(key + " - " + map.get(key));
            }
            
            
            
            System.out.println("\nDanh sach truoc khi xoa:");
            for (Integer key : map.keySet())
            {
                System.out.println(key + " - " + map.get(key));
            }
			System.out.println("\n Nhap vi tri can xoa:");
			int xoa = sc.nextInt();
			sc.nextLine();

			if (map.containsKey(xoa))
			{
			    map.remove(xoa);
			}
			else
			{
			    System.out.println("Key khong ton tai!");
			}
			System.out.println("\nDanh sach sau khi sua:");
            for (Integer key : map.keySet())
            {
                System.out.println(key + " - " + map.get(key));
            }
            
            
            System.out.println("\nDanh sach truoc khi xoa:");
            for (Integer key : map.keySet())
            {
                System.out.println(key + " - " + map.get(key));
            }
            System.out.println("\n Nhap vi tri can tim:");
			int tim = sc.nextInt();
			sc.nextLine();

			if (map.containsKey(tim))
			{
			    System.out.println("Vi tri can tim co gia tri va kieu : " + tim + " - " + map.get(tim));
			    
			}	
			else
			{
			    System.out.println("Key khong ton tai!");
			}
		}
	}

}
