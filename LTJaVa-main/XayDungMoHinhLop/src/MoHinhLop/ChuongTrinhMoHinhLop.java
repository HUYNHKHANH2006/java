package MoHinhLop;
import java.util.*;

public class ChuongTrinhMoHinhLop 
{

    public class StaffMember 
    {
        protected String name, address, phone;

        public StaffMember(String name, String address, String phone) 
        {
            this.address = address;
            this.name = name;
            this.phone = phone;
        }
        public String toString() 
        {
            return "Tên: " + name + "\nĐia chỉ: " + address + "\nSDT: " + phone;
        }

        public double pay() 
        {
            return 0;
        }
    }

    // 
    public class Volunteer extends StaffMember 
    {
        public Volunteer(String name, String address, String phone) 
        {
            super(name, address, phone);
        }

        public double pay() 
        {
            return 0; 
        }
    }

    //
    public class Employee extends StaffMember 
    {
        protected String socialSecurityNumber; 
        protected double payRate;

        public Employee(String name, String address, String phone, String socialSecurityNumber, double payRate) 
        {
            super(name, address, phone);
            this.socialSecurityNumber = socialSecurityNumber;
            this.payRate = payRate;
        }


        public String toString() 
        {
            return super.toString() + "\nMã số bảo hiểm: " + socialSecurityNumber;
        }

        public double pay() 
        {
            return payRate;
        }
    }

    // 
    public class Executive extends Employee 
    {
        private double bonus;

        public Executive(String name, String address, String phone,
                        String socialSecurityNumber, double payRate, double bonus) 
        {
            super(name, address, phone, socialSecurityNumber, payRate);
            this.bonus = bonus;
        }

        public double pay() 
        {
            return payRate + bonus;
        }


        public String toString() 
        {
            return super.toString() + "\nThưởng: " + bonus;
        }
    }

    //
    public class Hourly extends Employee 
    {
        private int hoursWorked;

        public Hourly(String name, String address, String phone, String socialSecurityNumber, double payRate, int hoursWorked) 
        {
            super(name, address, phone, socialSecurityNumber, payRate);
            this.hoursWorked = hoursWorked;
        }

        public double pay() 
        {
            return payRate * hoursWorked;
        }

        public String toString() 
        {
            return super.toString() + "\nGiờ làm việc: " + hoursWorked;
        }
    }

    // 
    public static void main(String[] args) 
    {
        try 
        {
        	ChuongTrinhMoHinhLop personnel = new ChuongTrinhMoHinhLop();

        } 
        catch (Exception ex) 
        {
            System.out.println("Lỗi: " + ex.getMessage());
        }
    }
}