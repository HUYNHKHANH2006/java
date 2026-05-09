public class Executive extends Employee {
    private double bonus;

    public Executive(String name, String address, String phone, String socialSecurityNumber, double payRate) {
        super(name, address, phone, socialSecurityNumber, payRate);
        this.bonus = 0.0;
    }

    public void awardBonus(double bonus) {
        this.bonus += bonus;
    }

    @Override
    public double pay() {
        double totalPay = payRate + bonus;
        bonus = 0.0; // Reset bonus after payment
        return totalPay;
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Executive\nBonus: $" + bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
