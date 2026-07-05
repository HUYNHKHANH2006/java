package Invoico;
import java.util.*;

public class XayDungMoiTruongLop 
{
	public static class Invoice 
	{
	    private String maMatHang;
	    private String moTa;
	    private int soLuong;
	    private double gia;

	    public Invoice(String maMatHang, String moTa, int soLuong, double gia) 
	    {
	        this.maMatHang = maMatHang;
	        this.moTa      = moTa;
	        setSoLuong(soLuong);
	        setGia(gia);
	    }

	    public String getMaMatHang()  
	    { 
	    	return maMatHang; 
	    }
	    public String getMoTa()       
	    { 
	    	return moTa; 
	    }
	    public int    getSoLuong()    
	    { 
	    	return soLuong; 
	    }
	    public double getGia()        
	    { 
	    	return gia; 
	    }

	    public void setMaMatHang(String maMatHang) 
	    { 
	    	this.maMatHang = maMatHang; 
	    }
	    public void setMoTa(String moTa)           
	    { 
	    	this.moTa = moTa; 
	    }

	    public void setSoLuong(int soLuong) 
	    {
	        if (soLuong <= 0)
	            this.soLuong = 0;
	        else
	            this.soLuong = soLuong;
	    }

	    public void setGia(double gia) 
	    {
	        if (gia <= 0)
	            this.gia = 0.0;
	        else
	            this.gia = gia;
	    }

	    public double getInvoiceAmount() 
	    {
	        return soLuong * gia;
	    }
	}
	
	

	public static void main(String[] args) 
	{
        ArrayList<Invoice> danhSach = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int soLuongNhap = 0;
        int luaChon;

        do 
        {
            System.out.println("=== MENU ===");
            System.out.println("1. Nhập danh sách Invoice");
            System.out.println("2. Xuất thông tin Invoice");
            System.out.println("3. Sắp xếp");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Xóa");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            luaChon = sc.nextInt();

            switch (luaChon) 
            {
                case 1: nhapDanhSach(danhSach); 
                break;
                case 2: xuatDanhSach(danhSach);     
                break;
                case 3: sapXep(danhSach);            
                break;
                case 4: timKiem(danhSach, sc);       
                break;
                case 5: xoa(danhSach, sc);           
                break;
                case 0: System.out.println("Tạm biệt!"); 
                break;
                default: System.out.println("Chọn lại!"); 
                break;
            }
        } 
        while (luaChon != 0);
        
        
    }
	
	public static void xoa(ArrayList<Invoice> ds, Scanner sc)
	{
	    if (ds.size() == 0)
	    {
	        System.out.println("Danh sách trống!");
	        return;
	    }

	    sc.nextLine();
	    System.out.print("Nhập mã cần xóa: ");
	    String maXoa = sc.nextLine();

	    for (int i = 0; i < ds.size(); i++)
	    {
	        if (ds.get(i).getMaMatHang().equals(maXoa))
	        {
	            ds.remove(i);
	            System.out.println("Xóa thành công!");
	            return;
	        }
	    }
	    System.out.println("Không tìm thấy mã này!");
	}
	
	public static void timKiem(ArrayList<Invoice> ds, Scanner sc)
	{
	    if (ds.size() == 0)
	    {
	        System.out.println("Danh sách trống!");
	        return;
	    }

	    sc.nextLine();
	    System.out.print("Nhập mã cần tìm: ");
	    String maTim = sc.nextLine();

	    for (Invoice hd : ds)
	    {
	        if (hd.getMaMatHang().equals(maTim))
	        {
	            System.out.println("Mã mặt hàng : " + hd.getMaMatHang());
	            System.out.println("Mô tả       : " + hd.getMoTa());
	            System.out.println("Số lượng    : " + hd.getSoLuong());
	            System.out.println("Đơn giá     : " + hd.getGia());
	            System.out.println("Tổng tiền   : " + hd.getInvoiceAmount());
	            return;
	        }
	    }
	    System.out.println("Không có Invoice với mã này!");
	}
	
	public static void sapXep(ArrayList<Invoice> ds)
	{
		if (ds.size() == 0)
		{
		    System.out.println("Danh sách trống!");
		    return;
		}
	    
	    System.out.println("1. Sắp xếp theo mã mặt hàng");
	    System.out.println("2. Sắp xếp theo số lượng");
	    System.out.print("Chọn: ");
	    Scanner sc = new Scanner(System.in);
	    int luaChon = sc.nextInt();
	    
	    if (luaChon == 1)
	    {
	    	for (int i = 0; i < ds.size() - 1; i++)
	        {
	            int viTriNhoNhat = i;
	            for (int j = i + 1; j < ds.size(); j++)
	            {
	                if (ds.get(j).getMaMatHang()
	                    .compareTo(ds.get(viTriNhoNhat).getMaMatHang()) < 0)
	                    viTriNhoNhat = j;
	            }
	            Invoice tam = ds.get(i);
	            ds.set(i, ds.get(viTriNhoNhat));
	            ds.set(viTriNhoNhat, tam);
	        }
	    }
	    else if (luaChon == 2)
	    {
	    	for (int i = 0; i < ds.size() - 1; i++)
	    	{
	    	    int viTriNhoNhat = i;
	    	    for (int j = i + 1; j < ds.size(); j++)
	    	    {
	    	        if (ds.get(j).getSoLuong() < ds.get(viTriNhoNhat).getSoLuong())
	    	            viTriNhoNhat = j;
	    	    }
	    	 
	    	    Invoice tam = ds.get(i);
	    	    ds.set(i, ds.get(viTriNhoNhat));
	    	    ds.set(viTriNhoNhat, tam);
	    	}
	    }
	}
	
	public static void xuatDanhSach(ArrayList<Invoice> ds)
	{
		if (ds.size() == 0)
		{
		    System.out.println("Danh sách trống!");
		    return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Xem Invoice thứ mấy? (1 - " + ds.size() + "): ");
		int viTri = sc.nextInt();
		if (viTri < 1 || viTri > ds.size())
		{
		    System.out.println("Vị trí không hợp lệ!");
		    return;
		}

		Invoice hd = ds.get(viTri - 1);  

		System.out.println("Mã mặt hàng : " + hd.getMaMatHang());
		System.out.println("Mô tả       : " + hd.getMoTa());
		System.out.println("Số lượng    : " + hd.getSoLuong());
		System.out.println("Đơn giá     : " + hd.getGia());
		System.out.println("Tổng tiền   : " + hd.getInvoiceAmount());
	}
	
	public static void nhapDanhSach(ArrayList<Invoice> ds)
	{
		int soLuongNhap = 0;
		Scanner sc = new Scanner(System.in);
		do 
		{
		    System.out.print("Nhập số lượng (tối thiểu 10): ");
		    soLuongNhap = sc.nextInt();
		    if (soLuongNhap < 10)
		        System.out.println("Phải nhập ít nhất 10!");
		} 
		while (soLuongNhap < 10);
		for (int i = 0; i < soLuongNhap; i++) 
		{
            System.out.println("=== Nhập Invoice " + (i+1) + " ===");
            sc.nextLine(); 
            System.out.print("Mã mặt hàng: ");
            String ma = sc.nextLine();
            
            boolean trung = false;
            for (Invoice hd : ds) 
            {
                if (hd.getMaMatHang().equals(ma)) 
                {
                    trung = true;
                    break;
                }
            }
            
            if (trung) 
            {
                System.out.println("Mã đã tồn tại! Nhập lại Invoice này.");
                i--;  
            } 
            else 
            {
                
                try 
                {
                	System.out.print("Mô tả: ");
                    String moTa = sc.nextLine();
                    System.out.print("Số lượng: ");
                    int soLuong = sc.nextInt();
                    System.out.print("Giá: ");
                    double gia = sc.nextDouble();
                    ds.add(new Invoice(ma, moTa, soLuong, gia));
                    System.out.println("Thêm thành công!");
                } 
                catch (InputMismatchException e) 
                {
                    System.out.println("Lỗi: Phải nhập số!");
                    sc.nextLine();
                    i--; 
                } 
                finally 
                {
                    System.out.println("=== Kết thúc nhập Invoice " + (i+1) + " ===");
                };
            }
        }
		
		
		
	}
}
