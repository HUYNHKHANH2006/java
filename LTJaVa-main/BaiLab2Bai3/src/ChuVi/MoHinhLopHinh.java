package ChuVi;

import java.util.Scanner;

public class MoHinhLopHinh {
	
	public static class Hinh 
	{
	    
	    protected String mau;  // protected để lớp con dùng được
	    
	    // Constructor — nhận màu từ bên ngoài, gán vào thuộc tính
	    public Hinh(String mau) 
	    {
	        this.mau = mau;
	    }
	    
	    // Lớp con sẽ tự ghi đè (@Override)
	    public double TinhDienTich() 
	    {
	        return 0;
	    }
	    
	    public double TinhChuVi() 
	    {
	        return 0;
	    }
	    
	    public String LayThongTin() 
	    {
	        return "mau : " + mau;
	    }
	}
	
	
	public static class HinhChuNhat extends Hinh {
	    
	    private double chieuDai;
	    private double chieuRong;
	    
	    public HinhChuNhat(String mau, double chieuDai, double chieuRong) {
	        super(mau);                    
	        this.chieuDai  = chieuDai;
	        this.chieuRong = chieuRong;
	    }
	    
	    @Override
	    public double TinhDienTich() {
	        return chieuDai * chieuRong;  
	    }
	    
	    @Override
	    public double TinhChuVi() {
	        return (chieuDai + chieuRong) * 2; 
	    }
	    
	    @Override
	    public String LayThongTin() {
	        return super.LayThongTin()
	             + " | Chieu dai: "  + chieuDai
	             + " | Chieu rong: " + chieuRong
	             + " | Dien tich: "  + TinhDienTich()
	             + " | Chu vi: "     + TinhChuVi();
	    }
	}
	
	
	public static class HinhVuong extends HinhChuNhat 
	{
	    
	    private double canh;     
	    public HinhVuong(String mau, double canh) 
	    {
	        super(mau, canh, canh); 
	        this.canh = canh;    
	    }
	    
	    @Override
	    public String LayThongTin() {
	        return "Hinh vuong | Mau: " + mau   	
	             + " | Canh: "     + canh       
	             + " | Dien tich: " + TinhDienTich()
	             + " | Chu vi: "    + TinhChuVi();
	    }
	}
	
	public static class HinhTron extends Hinh
	{
		private double r;
		public HinhTron(String mau, double r)
		{
			super (mau);
			this.r = r;
		}
		
		@Override
	    public double TinhDienTich() 
		{
	        return Math.PI * r * r;  
	    }
	    
	    @Override
	    public double TinhChuVi() 
	    {
	        return 2 * Math.PI * r  ; 
	    }
	    
	    @Override
		 public String LayThongTin()
		 {
			 return super.LayThongTin() 
					 + " | Hinh Tron " + r
					 + " | Dien Tich : " + TinhDienTich()
					 + " | Chu Vi : " + TinhChuVi();
		 }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try 
		{
			System.out.print("Nhap mau hinh chu Nhat: ");
            String mau = sc.nextLine();
            System.out.print("Nhập Chieu Dai: ");
            double chieuDai = sc.nextDouble();
            System.out.print("Nhập Chieu Rong: ");
            double chieuRong = sc.nextDouble();
            sc.nextLine();
            HinhChuNhat h1 = new HinhChuNhat(mau, chieuDai, chieuRong);
            System.out.println(h1.LayThongTin());
			
            System.out.print("Nhap mau hinh vuong: ");
            String mau1 = sc.nextLine();
            System.out.print("Nhap canh: ");
            double canh = sc.nextDouble();
            sc.nextLine();
            HinhVuong h2 = new HinhVuong(mau1, canh);
            System.out.println(h2.LayThongTin());
            
            System.out.print("Nhap mau hinh tron: ");
            String mau2 = sc.nextLine();
            System.out.print("Nhap ban kinh: ");
            double r = sc.nextDouble();
            HinhTron h = new HinhTron(mau, r);
            System.out.println(h.LayThongTin());
        } 
        catch (Exception ex) 
		{
            System.out.println("Ban nhap sai du lieu!");
            ex.printStackTrace();
        } 
        finally 
        {
            sc.close();
        }

	}

}
