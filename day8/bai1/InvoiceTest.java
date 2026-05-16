package day8.bai1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class InvoiceTest {
    private static ArrayList<Invoice> invoices = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mockData();
        int choice;
        do {
            System.out.println("\n--- INVOICE MANAGEMENT MENU ---");
            System.out.println("1. Add Invoices (at least 10 required)");
            System.out.println("2. Display all Invoices");
            System.out.println("3. Search Invoice by Part Number");
            System.out.println("4. Sort Invoices (by Part Number and Quantity)");
            System.out.println("5. Delete Invoice by Part Number");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: addInvoices(); break;
                case 2: displayInvoices(); break;
                case 3: searchInvoice(); break;
                case 4: sortInvoices(); break;
                case 5: deleteInvoice(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void mockData() {
        invoices.add(new Invoice("P001", "Hammer", 10, 15.5));
        invoices.add(new Invoice("P005", "Screwdriver", 20, 5.0));
        invoices.add(new Invoice("P003", "Wrench", 5, 25.0));
        invoices.add(new Invoice("P002", "Drill", 2, 120.0));
        invoices.add(new Invoice("P004", "Saw", 8, 45.0));
        invoices.add(new Invoice("P008", "Level", 12, 18.0));
        invoices.add(new Invoice("P007", "Tape Measure", 30, 7.5));
        invoices.add(new Invoice("P006", "Pliers", 15, 12.0));
        invoices.add(new Invoice("P010", "Chisel", 4, 22.0));
        invoices.add(new Invoice("P009", "Mallet", 6, 19.5));
        System.out.println("Loaded 10 mock invoices.");
    }

    private static void addInvoices() {
        System.out.print("How many invoices to add? ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Entering Invoice #" + (i + 1));
            String partNumber;
            while (true) {
                System.out.print("Part Number: ");
                partNumber = scanner.nextLine();
                if (findInvoice(partNumber) == null) break;
                System.out.println("Error: Part Number already exists!");
            }
            System.out.print("Description: ");
            String desc = scanner.nextLine();
            System.out.print("Quantity: ");
            int qty = scanner.nextInt();
            System.out.print("Price per item: ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            invoices.add(new Invoice(partNumber, desc, qty, price));
        }
    }

    private static void displayInvoices() {
        if (invoices.isEmpty()) {
            System.out.println("No invoices to display.");
            return;
        }
        System.out.printf("%-15s | %-20s | %-10s | %-12s | %-12s\n", 
            "Part Number", "Description", "Quantity", "Price", "Total");
        System.out.println("-----------------------------------------------------------------------------------");
        for (Invoice inv : invoices) {
            System.out.println(inv);
        }
    }

    private static Invoice findInvoice(String partNumber) {
        for (Invoice inv : invoices) {
            if (inv.getPartNumber().equalsIgnoreCase(partNumber)) {
                return inv;
            }
        }
        return null;
    }

    private static void searchInvoice() {
        System.out.print("Enter Part Number to search: ");
        String partNumber = scanner.nextLine();
        Invoice inv = findInvoice(partNumber);
        if (inv != null) {
            System.out.println("Found: " + inv);
        } else {
            System.out.println("Invoice not found.");
        }
    }

    private static void sortInvoices() {
        // Using Bubble Sort as requested (sorting by Part Number, then Quantity)
        int n = invoices.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Invoice inv1 = invoices.get(j);
                Invoice inv2 = invoices.get(j + 1);
                
                int cmp = inv1.getPartNumber().compareTo(inv2.getPartNumber());
                if (cmp > 0 || (cmp == 0 && inv1.getQuantity() > inv2.getQuantity())) {
                    // Swap
                    invoices.set(j, inv2);
                    invoices.set(j + 1, inv1);
                }
            }
        }
        System.out.println("Invoices sorted successfully.");
        displayInvoices();
    }

    private static void deleteInvoice() {
        System.out.print("Enter Part Number to delete: ");
        String partNumber = scanner.nextLine();
        Invoice inv = findInvoice(partNumber);
        if (inv != null) {
            invoices.remove(inv);
            System.out.println("Invoice deleted successfully.");
        } else {
            System.out.println("Invoice not found.");
        }
    }
}
