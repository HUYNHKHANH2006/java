import java.util.Scanner;

class NhanVien {
    private String ho;           
    private String ten;          
    private int soSanPham;       
    private double donGia;       
    
    // Constructor
    public NhanVien(String ho, String ten, int soSanPham) {
        this.ho = ho;
        this.ten = ten;
        this.soSanPham = soSanPham;
        tinhDonGia();
    }
    
    // Tính đơn giá theo số sản phẩm
    private void tinhDonGia() {
        if (soSanPham >= 1 && soSanPham <= 199) {
            donGia = 0.5;
        } else if (soSanPham >= 200 && soSanPham <= 399) {
            donGia = 0.55;
        } else if (soSanPham >= 400 && soSanPham <= 599) {
            donGia = 0.6;
        } else if (soSanPham >= 600) {
            donGia = 0.65;
        } else {
            donGia = 0.0;
        }
    }
    
    // Tính lương
    public double tinhLuong() {
        return soSanPham * donGia;
    }
    
    // Hàm LonHon: so sánh số sản phẩm của 2 nhân viên
    public boolean lonHon(NhanVien nv2) {
        return this.soSanPham > nv2.soSanPham;
    }
    
    // Xuất thông tin nhân viên
    public void xuat() {
        System.out.println("Ho_ten: " + ho + " " + ten);
        System.out.println("so san pham: " + soSanPham);
        System.out.println("don gia:    " + donGia);
        System.out.printf("Lương: %.2f\n", tinhLuong());
    }
}

public class hamlonhon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Nhập thông tin nhân viên thứ 1
        System.out.println("nhap thong tin nhan vien thu 1");
        System.out.print("nhap ho: ");
        String ho1 = sc.nextLine();
        System.out.print("nhap ten: ");
        String ten1 = sc.nextLine();
        System.out.print("nhap so san pham: ");
        int soSP1 = sc.nextInt();
        sc.nextLine();
        
        NhanVien nv1 = new NhanVien(ho1, ten1, soSP1);
        
        System.out.println("nhap thong tin nhan vien thu 2");
        System.out.print("nhap ho: ");
        String ho2 = sc.nextLine();
        System.out.print("nhap ten: ");
        String ten2 = sc.nextLine();
        System.out.print("nhap so san pham: ");
        int soSP2 = sc.nextInt();
        sc.nextLine();
        
        NhanVien nv2 = new NhanVien(ho2, ten2, soSP2);
        
        System.out.println("thong tin nhan vien thu 1");
        nv1.xuat();
        
        System.out.println("thong tin nhan vien thu 2  ");
        nv2.xuat();
        
//
        System.out.println("\n=== So sánh ===");
        if (nv1.lonHon(nv2)) {
            System.out.println(ho1 + " " + ten1 + " co so san pham nhieu hon " + 
                            ho2 + " " + ten2);
        } else if (nv2.lonHon(nv1)) {
            System.out.println(ho2 + " " + ten2 + " co so san pham nhieu hon " + 
                            ho1 + " " + ten1);
        } else {
            System.out.println("Hai nhan vien co so san pham bang nhau.");
        }
        
        sc.close();
    }
}
