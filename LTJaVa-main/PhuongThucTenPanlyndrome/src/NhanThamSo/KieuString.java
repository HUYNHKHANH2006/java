package NhanThamSo;
import java.util.*;
public class KieuString 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String s = "madam";
		boolean panlydrom = true;
		
		try
		{	
			for (int i = 0 ; i < s.length(); i++)
			{
				if (s.charAt(i) != s.charAt(s.length()-1-i))
				{
					panlydrom = false;
					break;
				}
			}
			if (panlydrom == true)
			{
				System.out.println("True");
			}
			else
			{
				System.out.println("False");
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Nhap Chuoi : ");
		}
		finally
		{
			for (int i = 0; i <s.length();i++)
			{
				System.out.println(s.charAt(i));
			}
		}

	}

}
