
CREATE DATABASE IF NOT EXISTS eorder;
USE eorder;

CREATE TABLE ban (
    so_ban  INT          NOT NULL,
    vi_tri  VARCHAR(50)  DEFAULT NULL,
    PRIMARY KEY (so_ban)
) ENGINE=InnoDB;

CREATE TABLE monan (
    ma_mon  INT           NOT NULL AUTO_INCREMENT,
    ten_mon VARCHAR(100)  NOT NULL,
    gia     DECIMAL(10,0) NOT NULL,
    loai    VARCHAR(50)   DEFAULT NULL,
    PRIMARY KEY (ma_mon)
) ENGINE=InnoDB;

CREATE TABLE hoadon (
    ma_hd      INT         NOT NULL AUTO_INCREMENT,
    so_ban     INT         NOT NULL,
    thoi_gian  DATETIME    DEFAULT CURRENT_TIMESTAMP,
    trang_thai VARCHAR(20) DEFAULT 'CHO_XU_LY',
    PRIMARY KEY (ma_hd),
    FOREIGN KEY (so_ban) REFERENCES ban(so_ban)
) ENGINE=InnoDB;

CREATE TABLE chitiet_order (
    ma_hd    INT NOT NULL,
    ma_mon   INT NOT NULL,
    so_luong INT NOT NULL DEFAULT 1,
    PRIMARY KEY (ma_hd, ma_mon),
    FOREIGN KEY (ma_hd)  REFERENCES hoadon(ma_hd),
    FOREIGN KEY (ma_mon) REFERENCES monan(ma_mon)
) ENGINE=InnoDB;

-- Dữ liệu mẫu
INSERT INTO ban (so_ban, vi_tri) VALUES (1,'Cua so A'),(2,'Cua so B'),(3,'Trung tam'),(4,'Ngoai troi');

INSERT INTO monan (ten_mon, gia, loai) VALUES
('Pho bo',         45000, 'Mon chinh'),
('Bun bo Hue',     40000, 'Mon chinh'),
('Com ga xoi mo',  55000, 'Mon chinh'),
('Nuoc cam tuoi',  20000, 'Do uong'),
('Tra dao',        25000, 'Do uong'),
('Ca phe den',     15000, 'Do uong');