package test;

import data.*;
import domain.*;
import java.util.List;

public class Bai4Test {
    public static void main(String[] args) {
        JdbcSach js   = new JdbcSach();
        JdbcDocGia jdg = new JdbcDocGia();

        // -- Thêm sách
        js.insert(new Sach("S001", "Lập trình Java cơ bản",    "Nguyễn Tiến Dũng", "CNTT", 2020, 10, 150000));
        js.insert(new Sach("S002", "Cơ sở dữ liệu",            "Trần Mạnh Hùng",   "CNTT", 2019, 5,  120000));
        js.insert(new Sach("S003", "Kế toán doanh nghiệp",     "Phạm Thị Lan",     "KT",   2021, 8,  200000));
        js.insert(new Sach("S004", "Tiếng Anh chuyên ngành IT","Hoàng Văn Nam",    "NN",   2022, 0,  95000));

        // -- Sửa sách
        js.update(new Sach("S001", "Lập trình Java nâng cao", "Nguyễn Tiến Dũng", "CNTT", 2023, 12, 180000));

        // -- Liệt kê tất cả sách
        System.out.println("=== Danh sách sách ===");
        for (Sach s : js.select()) System.out.println(s);

        // -- Sách hết
        System.out.println("\n=== Sách đã hết ===");
        for (Sach s : js.selectHetSach()) System.out.println(s);

        // -- Sách theo thể loại
        System.out.println("\n=== Sách thể loại CNTT ===");
        for (Sach s : js.selectByTheLoai("CNTT")) System.out.println(s);

        // -- Thêm độc giả
        jdg.insert(new DocGia("DG001", "Nguyễn Văn An",  "Hà Nội",      "0901234567", "2024-01-10"));
        jdg.insert(new DocGia("DG002", "Trần Thị Bình",  "TP.HCM",      "0912345678", "2024-02-15"));

        // -- Đăng ký mượn sách
        jdg.muonSach("DG001", "S001", "2025-06-30");
        jdg.muonSach("DG001", "S002", "2025-07-01");

        // -- Xem sách đang mượn
        System.out.println("\n=== Sách DG001 đang mượn ===");
        jdg.listSachDangMuon("DG001");

        // -- Trả sách
        // jdg.traSach("DG001", "S001");

        // -- Liệt kê độc giả
        System.out.println("\n=== Danh sách độc giả ===");
        for (DocGia dg : jdg.select()) System.out.println(dg);
    }
}
