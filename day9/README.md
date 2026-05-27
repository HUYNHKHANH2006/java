day9/
├── sql/
│   └── all_schemas.sql          
└── src/
    ├── data/
    │   ├── JavaConnection.java   ← Kết nối DB Bài 1 (qlgiaovien)
    │   ├── JavaConnectionB2.java ← Kết nối DB Bài 2 (eorder)
    │   ├── JavaConnectionB3.java ← Kết nối DB Bài 3 (qlsinhvien)
    │   ├── JavaConnectionB4.java ← Kết nối DB Bài 4 (qlthuVien)
    │   ├── JdbcKhoa.java
    │   ├── JdbcGiaoVien.java
    │   ├── JdbcSinhVien.java
    │   ├── JdbcSach.java
    │   └── JdbcDocGia.java
    ├── domain/
    │   ├── Khoa.java
    │   ├── GiaoVien.java
    │   ├── SinhVien.java
    │   ├── Sach.java
    │   └── DocGia.java
    └── test/
        ├── Bai1Test.java         ← Main class Bài 1
        ├── EOrderApp.java        ← Main class Bài 2
        ├── Bai3Test.java         ← Main class Bài 3
        └── Bai4Test.java         ← Main class Bài 4
```

## Cách chạy

### 1. Chuẩn bị CSDL
```sql
-- Chạy file này trong MySQL Workbench hoặc CLI:
source sql/all_schemas.sql
```

### 2. Thêm MySQL JDBC Driver vào classpath
Tải `mysql-connector-j-8.x.x.jar` và thêm vào Build Path của IDE.

### 3. Cập nhật mật khẩu
Mở các file `JavaConnection*.java` và đổi:
```java
private static final String PASS = "admin";  // ← đổi thành pass của bạn
```

### 4. Chạy từng bài
| Bài | Main class      | Database    |
|-----|-----------------|-------------|
| 1   | `Bai1Test`      | qlgiaovien  |
| 2   | `EOrderApp`     | eorder      |
| 3   | `Bai3Test`      | qlsinhvien  |
| 4   | `Bai4Test`      | qlthuVien   |

## Tổng quan từng bài

### Bài 1 – Quản lý Khoa & Giáo Viên
- CRUD bảng `KHOA` và `GIAOVIEN`
- Truy vấn danh sách GV Nam thuộc khoa CNTT

### Bài 2 – E-Order (Quán ăn nhanh)
- Console app với menu xem món, tạo order, xem order hôm nay
- Sử dụng transaction (commit/rollback) khi tạo hóa đơn + chi tiết

### Bài 3 – Quản lý Sinh Viên
- CRUD bảng `SINHVIEN`
- Xếp loại học lực theo điểm TB
- Lọc SV giỏi (≥ 8.0) và lọc theo lớp

### Bài 4 – Quản lý Thư Viện
- CRUD bảng `SACH` và `DOCGIA`
- Đăng ký mượn / trả sách qua bảng `MUONSACH`
- Xem sách đang mượn của từng độc giả
