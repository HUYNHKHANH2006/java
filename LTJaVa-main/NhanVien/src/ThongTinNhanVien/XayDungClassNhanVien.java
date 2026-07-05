package ThongTinNhanVien;
import java.util.*;

public class XayDungClassNhanVien 
{
	public static class NhanVien
	{
	    private String Ho, Ten;
	    private int SoLuongSP;

	    public NhanVien(String Ho, String Ten, int SoLuongSP)
	    {
	        this.Ho = Ho;
	        this.Ten = Ten;

	        if (SoLuongSP < 0)
	            this.SoLuongSP = 0;
	        else
	            this.SoLuongSP = SoLuongSP;
	    }

	    public String getHo() { return Ho; }
	    public String getTen() { return Ten; }
	    public int getSoLuongSP() { return SoLuongSP; }

	    public double getLuong()
	    {
	        double donGia;

	        if (SoLuongSP <= 199) donGia = 0.5;
	        else if (SoLuongSP <= 399) donGia = 0.55;
	        else if (SoLuongSP <= 599) donGia = 0.6;
	        else donGia = 0.65;

	        return SoLuongSP * donGia;
	    }

	    public boolean LonHon(NhanVien nv2)
	    {
	        return this.SoLuongSP > nv2.SoLuongSP;
	    }
	}

	public static void main(String[] args) 
	{
		 Scanner sc = new Scanner(System.in);
	     NhanVien[] ds = null;
	     try
	     {
	         System.out.print("Nhap so nhan vien: ");
	         int n = sc.nextInt();
	         sc.nextLine();

	         ds = new NhanVien[n];

	         for (int i = 0; i < n; i++)
	         {
	             System.out.println("Nhan vien thu " + (i + 1));

	             System.out.print("Ho: ");
	             String ho = sc.nextLine();

	             System.out.print("Ten: ");
	             String ten = sc.nextLine();

	             int sp = 0;
	             boolean hopLe = false;
	             while (!hopLe)
	             {
			          try
			          {
				          System.out.print("So san pham: ");
				          sp = sc.nextInt();
				          sc.nextLine();
				          hopLe = true;
			          }
			          catch (InputMismatchException e)
			          {
				          System.out.println("Phai nhap so nguyen !");
				           sc.nextLine();
			          }
			     }
		
	             ds[i] = new NhanVien(ho, ten, sp);
	           }

	            for (NhanVien nv : ds)
	            {
	                System.out.println(nv.getHo() + " " + nv.getTen() + " & So Luong San pham : " + nv.getLuong());
	            }
	            int lon =0;
// phan nay can sua 
	            for (int i=0; i < ds.length ; i++)
	            {
	                if (ds[0].LonHon(ds[1]))
	                	System.out.println("NV" +ds +" nhieu san pham hon NV" + ds.length);
	                else
	                    System.out.println("NV" +ds.length +" nhieu san pham hon NV" + ds.length);
	            }
	            

	        }
	        catch (Exception e)
	        {
	            System.out.println("Loi chuong trinh: " + e.getMessage());
	        }
	        finally
	        {
	            System.out.println("Da ket thuc chuong trinh");
	            sc.close(); 
	        }

	}

}
