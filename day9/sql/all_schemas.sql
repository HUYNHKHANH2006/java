-- ============================================================
-- BÀI 1: Quản lý Khoa & Giáo Viên
-- Database: qlgiaovien
-- ============================================================
CREATE DATABASE IF NOT EXISTS qlgiaovien;
USE qlgiaovien;

CREATE TABLE IF NOT EXISTS KHOA (
    MAKHOA      VARCHAR(10)   NOT NULL,
    TENKHOA     VARCHAR(50)   NOT NULL,
    NGTLAP      DATE,
    TRGKHOA     VARCHAR(50),
    PRIMARY KEY (MAKHOA)
);

CREATE TABLE IF NOT EXISTS GIAOVIEN (
    MAGV        VARCHAR(10)   NOT NULL,
    HOTEN       VARCHAR(50)   NOT NULL,
    HOCVI       VARCHAR(20),
    HOCHAM      VARCHAR(20),
    GIOITINH    VARCHAR(4),
    HESO        FLOAT,
    MUCLUONG    DECIMAL(12,2),
    MAKHOA      VARCHAR(10),
    PRIMARY KEY (MAGV),
    FOREIGN KEY (MAKHOA) REFERENCES KHOA(MAKHOA)
);

INSERT INTO KHOA VALUES
('CNTT', 'Cong nghe Thong tin', '2000-01-01', 'Nguyen Van A'),
('KT',   'Kinh te',             '2001-05-15', 'Tran Thi B'),
('NN',   'Ngoai ngu',           '2002-09-01', 'Le Van C');

INSERT INTO GIAOVIEN VALUES
('GV001', 'Nguyen Minh Tuan', 'ThS', 'GV',  'Nam', 3.0, 5000000, 'CNTT'),
('GV002', 'Tran Thi Lan',     'TS',  'PGS', 'Nu',  4.0, 7000000, 'CNTT'),
('GV003', 'Le Quoc Hung',     'ThS', 'GV',  'Nam', 2.5, 4500000, 'CNTT'),
('GV004', 'Pham Thu Ha',      'CN',  'GV',  'Nu',  2.0, 3500000, 'KT');


-- ============================================================
-- BÀI 2: E-Order
-- Database: eorder
-- ============================================================
CREATE DATABASE IF NOT EXISTS eorder;
USE eorder;

CREATE TABLE IF NOT EXISTS MonAn (
    MaMon     VARCHAR(10)   NOT NULL PRIMARY KEY,
    TenMon    VARCHAR(100)  NOT NULL,
    DonGia    DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS HoaDon (
    MaHD      INT AUTO_INCREMENT PRIMARY KEY,
    SoBan     INT NOT NULL,
    ThoiGian  DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS ChiTietOrder (
    MaHD      INT          NOT NULL,
    MaMon     VARCHAR(10)  NOT NULL,
    SoLuong   INT          NOT NULL,
    PRIMARY KEY(MaHD, MaMon),
    FOREIGN KEY(MaHD)  REFERENCES HoaDon(MaHD),
    FOREIGN KEY(MaMon) REFERENCES MonAn(MaMon)
);

INSERT INTO MonAn VALUES
('M001', 'Hamburger',        35000),
('M002', 'Ga ran',           45000),
('M003', 'Khoai tay chien',  20000),
('M004', 'Nuoc ngot',        15000),
('M005', 'Banh mi',          25000);


-- ============================================================
-- BÀI 3: Quản lý Sinh Viên
-- Database: qlsinhvien
-- ============================================================
CREATE DATABASE IF NOT EXISTS qlsinhvien;
USE qlsinhvien;

CREATE TABLE IF NOT EXISTS SINHVIEN (
    MASV        VARCHAR(10)   NOT NULL,
    HOTEN       VARCHAR(50)   NOT NULL,
    NGAYSINH    DATE,
    DIEMTB      DOUBLE,
    MALOP       VARCHAR(10),
    PRIMARY KEY (MASV)
);

INSERT INTO SINHVIEN VALUES
('SV001', 'Nguyen Van An',  '2003-05-10', 8.5, 'CNTT01'),
('SV002', 'Tran Thi Binh',  '2003-07-22', 7.2, 'CNTT01'),
('SV003', 'Le Minh Cuong',  '2002-11-15', 9.1, 'CNTT02'),
('SV004', 'Pham Thu Dung',  '2003-01-30', 6.0, 'CNTT02'),
('SV005', 'Hoang Van Em',   '2002-09-05', 4.5, 'CNTT01');


-- ============================================================
-- BÀI 4: Quản lý Thư Viện
-- Database: qlthuVien
-- ============================================================
CREATE DATABASE IF NOT EXISTS qlthuVien;
USE qlthuVien;

CREATE TABLE IF NOT EXISTS SACH (
    MASACH      VARCHAR(10)   NOT NULL,
    TENSACH     VARCHAR(100)  NOT NULL,
    TACGIA      VARCHAR(50),
    THELOAI     VARCHAR(20),
    NAMXB       INT,
    SOLUONG     INT           DEFAULT 0,
    GIABAN      DECIMAL(12,2),
    PRIMARY KEY (MASACH)
);

CREATE TABLE IF NOT EXISTS DOCGIA (
    MADOCGIA    VARCHAR(10)   NOT NULL,
    HOTEN       VARCHAR(50)   NOT NULL,
    DIACHI      VARCHAR(100),
    SODIENTHOAI VARCHAR(15),
    NGAYDANGKY  DATE,
    PRIMARY KEY (MADOCGIA)
);

CREATE TABLE IF NOT EXISTS MUONSACH (
    MADOCGIA        VARCHAR(10)  NOT NULL,
    MASACH          VARCHAR(10)  NOT NULL,
    NGAYMUON        DATE         NOT NULL,
    NGAYTRA_DU_KIEN DATE,
    NGAYTRA_THUC_TE DATE,
    PRIMARY KEY (MADOCGIA, MASACH, NGAYMUON),
    FOREIGN KEY (MADOCGIA) REFERENCES DOCGIA(MADOCGIA),
    FOREIGN KEY (MASACH)   REFERENCES SACH(MASACH)
);

INSERT INTO SACH VALUES
('S001', 'Lap trinh Java co ban',     'Nguyen Tien Dung', 'CNTT', 2020, 10, 150000),
('S002', 'Co so du lieu',             'Tran Manh Hung',   'CNTT', 2019, 5,  120000),
('S003', 'Ke toan doanh nghiep',      'Pham Thi Lan',     'KT',   2021, 8,  200000),
('S004', 'Tieng Anh chuyen nganh IT', 'Hoang Van Nam',    'NN',   2022, 0,   95000);

INSERT INTO DOCGIA VALUES
('DG001', 'Nguyen Van An', 'Ha Noi',  '0901234567', '2024-01-10'),
('DG002', 'Tran Thi Binh', 'TP.HCM', '0912345678', '2024-02-15');
