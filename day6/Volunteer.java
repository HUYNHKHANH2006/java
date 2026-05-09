public class Volunteer extends StaffMember {

    public Volunteer(String name, String address, String phone) {
        super(name, address, phone);
    }

    @Override
    public double pay() {
        return 0.0; // Volunteers don't get paid
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Volunteer\nPay: $0.00";
    }
}
