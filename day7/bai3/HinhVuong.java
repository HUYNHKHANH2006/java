public class HinhVuong extends HinhChuNhat {
    public HinhVuong(String mau, double canh) {
        super(mau, canh, canh);
    }

    @Override
    public String LayThongTin() {
        return "Mau sac: " + mau + ", Canh: " + chieudai;
    }
}
