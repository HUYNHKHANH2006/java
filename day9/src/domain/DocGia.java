package domain;

public class DocGia {
    private String maDocGia, hoTen, diaChi, soDienThoai;
    private String ngayDangKy;

    public DocGia() {}

    public DocGia(String maDocGia, String hoTen, String diaChi,
                  String soDienThoai, String ngayDangKy) {
        this.maDocGia    = maDocGia;
        this.hoTen       = hoTen;
        this.diaChi      = diaChi;
        this.soDienThoai = soDienThoai;
        this.ngayDangKy  = ngayDangKy;
    }

    public String getMaDocGia()    { return maDocGia; }
    public String getHoTen()       { return hoTen; }
    public String getDiaChi()      { return diaChi; }
    public String getSoDienThoai() { return soDienThoai; }
    public String getNgayDangKy()  { return ngayDangKy; }

    public void setMaDocGia(String v)    { maDocGia    = v; }
    public void setHoTen(String v)       { hoTen       = v; }
    public void setDiaChi(String v)      { diaChi      = v; }
    public void setSoDienThoai(String v) { soDienThoai = v; }
    public void setNgayDangKy(String v)  { ngayDangKy  = v; }

    @Override
    public String toString() {
        return "DocGia{" + maDocGia + ", " + hoTen + ", " + diaChi + ", " + soDienThoai + "}";
    }
}
