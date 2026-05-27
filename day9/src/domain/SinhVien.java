package domain;

public class SinhVien {
    private String maSV, hoTen, ngaySinh, maLop;
    private double diemTB;

    public SinhVien() {}

    public SinhVien(String maSV, String hoTen, String ngaySinh, double diemTB, String maLop) {
        this.maSV     = maSV;
        this.hoTen    = hoTen;
        this.ngaySinh = ngaySinh;
        this.diemTB   = diemTB;
        this.maLop    = maLop;
    }

    public String getMaSV()     { return maSV; }
    public String getHoTen()    { return hoTen; }
    public String getNgaySinh() { return ngaySinh; }
    public double getDiemTB()   { return diemTB; }
    public String getMaLop()    { return maLop; }

    public void setMaSV(String v)     { maSV     = v; }
    public void setHoTen(String v)    { hoTen    = v; }
    public void setNgaySinh(String v) { ngaySinh = v; }
    public void setDiemTB(double v)   { diemTB   = v; }
    public void setMaLop(String v)    { maLop    = v; }

    public String xepLoai() {
        if (diemTB >= 9.0) return "Xuất sắc";
        if (diemTB >= 8.0) return "Giỏi";
        if (diemTB >= 7.0) return "Khá";
        if (diemTB >= 5.0) return "Trung bình";
        return "Yếu";
    }

    @Override
    public String toString() {
        return String.format("SinhVien{%s, %s, %s, DiemTB=%.1f, XepLoai=%s, Lop=%s}",
            maSV, hoTen, ngaySinh, diemTB, xepLoai(), maLop);
    }
}
