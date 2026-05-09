import java.util.ArrayList;

public class Staff {
    private ArrayList<StaffMember> staffList;

    public Staff() {
        this.staffList = new ArrayList<>();
    }

    public void addStaff(StaffMember member) {
        staffList.add(member);
    }

    public void removeStaff(StaffMember member) {
        staffList.remove(member);
    }

    public void payday() {
        System.out.println("===== PAYDAY =====");
        for (StaffMember member : staffList) {
            System.out.println(member);
            System.out.println("Payment: $" + String.format("%.2f", member.pay()));
            System.out.println("---");
        }
        System.out.println("==================");
    }

    public ArrayList<StaffMember> getStaffList() {
        return staffList;
    }

    public int getStaffCount() {
        return staffList.size();
    }
}
