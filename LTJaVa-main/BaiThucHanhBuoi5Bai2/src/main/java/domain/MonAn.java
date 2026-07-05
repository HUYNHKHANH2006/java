package domain;

public class MonAn {
    private int    maMon;
    private String tenMon;
    private long   gia;
    private String loai;

    public MonAn() {}

    public MonAn(int maMon, String tenMon, long gia, String loai) {
        this.maMon  = maMon;
        this.tenMon = tenMon;
        this.gia    = gia;
        this.loai   = loai;
    }

    public int    getMaMon()        { return maMon; }
    public void   setMaMon(int v)   { this.maMon = v; }
    public String getTenMon()       { return tenMon; }
    public void   setTenMon(String v){ this.tenMon = v; }
    public long   getGia()          { return gia; }
    public void   setGia(long v)    { this.gia = v; }
    public String getLoai()         { return loai; }
    public void   setLoai(String v) { this.loai = v; }

    @Override
    public String toString() {
        return String.format("[%2d] %-20s %,8d VND", maMon, tenMon, gia);
    }
}