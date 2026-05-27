package domain;

public class GiaoVien {
    private String maGV, hoTen, hocVi, hocHam, gioiTinh, maKhoa;
    private double heSo, mucLuong;

    public GiaoVien() {}

    public GiaoVien(String maGV, String hoTen, String hocVi, String hocHam,
                    String gioiTinh, double heSo, double mucLuong, String maKhoa) {
        this.maGV      = maGV;
        this.hoTen     = hoTen;
        this.hocVi     = hocVi;
        this.hocHam    = hocHam;
        this.gioiTinh  = gioiTinh;
        this.heSo      = heSo;
        this.mucLuong  = mucLuong;
        this.maKhoa    = maKhoa;
    }

    // Getters
    public String getMaGV()      { return maGV; }
    public String getHoTen()     { return hoTen; }
    public String getHocVi()     { return hocVi; }
    public String getHocHam()    { return hocHam; }
    public String getGioiTinh()  { return gioiTinh; }
    public String getMaKhoa()    { return maKhoa; }
    public double getHeSo()      { return heSo; }
    public double getMucLuong()  { return mucLuong; }

    // Setters
    public void setMaGV(String v)      { maGV     = v; }
    public void setHoTen(String v)     { hoTen    = v; }
    public void setHocVi(String v)     { hocVi    = v; }
    public void setHocHam(String v)    { hocHam   = v; }
    public void setGioiTinh(String v)  { gioiTinh = v; }
    public void setMaKhoa(String v)    { maKhoa   = v; }
    public void setHeSo(double v)      { heSo     = v; }
    public void setMucLuong(double v)  { mucLuong = v; }

    @Override
    public String toString() {
        return "GiaoVien{" + maGV + ", " + hoTen + ", " + gioiTinh + ", " + maKhoa + "}";
    }
}
