package domain;

public class Khoa {
    private String maKhoa, tenKhoa, trgKhoa, ngtLap;

    public Khoa() {}

    public Khoa(String maKhoa, String tenKhoa, String ngtLap, String trgKhoa) {
        this.maKhoa  = maKhoa;
        this.tenKhoa = tenKhoa;
        this.ngtLap  = ngtLap;
        this.trgKhoa = trgKhoa;
    }

    public String getMaKhoa()  { return maKhoa; }
    public String getTenKhoa() { return tenKhoa; }
    public String getNgtLap()  { return ngtLap; }
    public String getTrgKhoa() { return trgKhoa; }

    public void setMaKhoa(String v)  { maKhoa  = v; }
    public void setTenKhoa(String v) { tenKhoa = v; }
    public void setNgtLap(String v)  { ngtLap  = v; }
    public void setTrgKhoa(String v) { trgKhoa = v; }

    @Override
    public String toString() {
        return "Khoa{" + maKhoa + ", " + tenKhoa + ", " + ngtLap + ", " + trgKhoa + "}";
    }
}
