public class KiemTraHinh {
    public static void main(String[] args) {
        // Tao 3 doi tuong hinhChuNhat, hinhTron, hinhVuong
        Hinh hinhChuNhat = new HinhChuNhat("Do", 5, 4);
        Hinh hinhTron = new HinhTron("Xanh", 3);
        Hinh hinhVuong = new HinhVuong("Vang", 4);

        // Hien thi thong tin va tinh toan
        System.out.println("--- Thong tin Hinh Chu Nhat ---");
        System.out.println(hinhChuNhat.LayThongTin());
        System.out.println("Dien tich: " + hinhChuNhat.TinhDienTich());
        System.out.println("Chu vi: " + hinhChuNhat.TinhChuVi());

        System.out.println("\n--- Thong tin Hinh Tron ---");
        System.out.println(hinhTron.LayThongTin());
        System.out.println("Dien tich: " + hinhTron.TinhDienTich());
        System.out.println("Chu vi: " + hinhTron.TinhChuVi());

        System.out.println("\n--- Thong tin Hinh Vuong ---");
        System.out.println(hinhVuong.LayThongTin());
        System.out.println("Dien tich: " + hinhVuong.TinhDienTich());
        System.out.println("Chu vi: " + hinhVuong.TinhChuVi());
    }
}
