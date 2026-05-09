public class StaffManagementDemo {
    public static void main(String[] args) {
        Staff staff = new Staff();

        // Create various staff members
        Volunteer volunteer = new Volunteer("John Smith", "123 Main St", "555-1001");
        
        Executive executive = new Executive("Jane Doe", "456 Oak Ave", "555-1002", "123-45-6789", 2000);
        executive.awardBonus(500);
        
        Hourly hourly = new Hourly("Bob Johnson", "789 Pine Rd", "555-1003", "987-65-4321", 15.50);
        hourly.addHours(40);
        
        Hourly hourly2 = new Hourly("Alice Williams", "321 Elm St", "555-1004", "456-78-9012", 18.75);
        hourly2.addHours(35);

        // Add staff to the staff list
        staff.addStaff(volunteer);
        staff.addStaff(executive);
        staff.addStaff(hourly);
        staff.addStaff(hourly2);

        System.out.println("Total staff members: " + staff.getStaffCount());
        System.out.println();

        // Process payroll
        staff.payday();
    }
}
