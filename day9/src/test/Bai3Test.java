package test;

import data.*;
import domain.*;
import java.util.List;

public class Bai3Test {
    public static void main(String[] args) {
        JdbcSinhVien jsv = new JdbcSinhVien();

        // -- Thêm sinh viên
        jsv.insert(new SinhVien("SV001", "Nguyễn Văn An",   "2003-05-10", 8.5, "CNTT01"));
        jsv.insert(new SinhVien("SV002", "Trần Thị Bình",   "2003-07-22", 7.2, "CNTT01"));
        jsv.insert(new SinhVien("SV003", "Lê Minh Cường",   "2002-11-15", 9.1, "CNTT02"));
        jsv.insert(new SinhVien("SV004", "Phạm Thu Dung",   "2003-01-30", 6.0, "CNTT02"));
        jsv.insert(new SinhVien("SV005", "Hoàng Văn Em",    "2002-09-05", 4.5, "CNTT01"));

        // -- Sửa sinh viên
        jsv.update(new SinhVien("SV001", "Nguyễn Văn An (Sửa)", "2003-05-10", 8.8, "CNTT01"));

        // -- Liệt kê tất cả
        System.out.println("=== Danh sách tất cả sinh viên ===");
        for (SinhVien sv : jsv.select()) System.out.println(sv);

        // -- Liệt kê SV giỏi (điểm >= 8)
        System.out.println("\n=== Sinh viên Giỏi / Xuất sắc (DiemTB >= 8) ===");
        for (SinhVien sv : jsv.selectGioi()) System.out.println(sv);

        // -- Liệt kê theo lớp
        System.out.println("\n=== Sinh viên lớp CNTT01 ===");
        for (SinhVien sv : jsv.selectByLop("CNTT01")) System.out.println(sv);

        // -- Xóa
        // jsv.delete("SV005");
    }
}
