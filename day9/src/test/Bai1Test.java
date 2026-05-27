package test;

import data.*;
import domain.*;
import java.util.List;

public class Bai1Test {
    public static void main(String[] args) {
        JdbcKhoa jk = new JdbcKhoa();
        JdbcGiaoVien jgv = new JdbcGiaoVien();

        // -- Thêm khoa mới
        jk.insert(new Khoa("DTVT", "Điện tử Viễn thông", "2010-01-01", "Nguyễn Văn X"));

        // -- Sửa khoa
        jk.update(new Khoa("DTVT", "Điện – Điện tử", "2010-01-01", "Nguyễn Văn X"));

        // -- Xóa khoa (bỏ comment để dùng)
        // jk.delete("DTVT");

        // -- Liệt kê tất cả khoa
        System.out.println("=== Danh sách khoa ===");
        for (Khoa k : jk.select()) System.out.println(k);

        // -- Thêm giáo viên
        jgv.insert(new GiaoVien("GV005", "Đinh Văn Nam", "ThS", "GV",
                                "Nam", 3.5, 5500000, "CNTT"));

        // -- Liệt kê GV Nam của khoa CNTT
        System.out.println("\n=== GV Nam – Khoa CNTT ===");
        List<GiaoVien> list = jgv.selectNamCNTT();
        for (GiaoVien gv : list) System.out.println(gv);
    }
}
