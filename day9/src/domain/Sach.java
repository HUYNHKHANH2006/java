package domain;

public class Sach {
    private String maSach, tenSach, tacGia, theLoai;
    private int namXB, soLuong;
    private double giaBan;

    public Sach() {}

    public Sach(String maSach, String tenSach, String tacGia, String theLoai,
                int namXB, int soLuong, double giaBan) {
        this.maSach   = maSach;
        this.tenSach  = tenSach;
        this.tacGia   = tacGia;
        this.theLoai  = theLoai;
        this.namXB    = namXB;
        this.soLuong  = soLuong;
        this.giaBan   = giaBan;
    }

    public String getMaSach()   { return maSach; }
    public String getTenSach()  { return tenSach; }
    public String getTacGia()   { return tacGia; }
    public String getTheLoai()  { return theLoai; }
    public int    getNamXB()    { return namXB; }
    public int    getSoLuong()  { return soLuong; }
    public double getGiaBan()   { return giaBan; }

    public void setMaSach(String v)   { maSach   = v; }
    public void setTenSach(String v)  { tenSach  = v; }
    public void setTacGia(String v)   { tacGia   = v; }
    public void setTheLoai(String v)  { theLoai  = v; }
    public void setNamXB(int v)       { namXB    = v; }
    public void setSoLuong(int v)     { soLuong  = v; }
    public void setGiaBan(double v)   { giaBan   = v; }

    @Override
    public String toString() {
        return String.format("Sach{%s, %s, %s, NamXB=%d, SL=%d, Gia=%,.0f}",
            maSach, tenSach, tacGia, namXB, soLuong, giaBan);
    }
}
