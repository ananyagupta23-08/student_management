import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Fees {
    private String studentId;
    private String studentName;
    private String totalFees;
    private String paidFees;
    private String paymentDate;

    public Fees(String studentId, String studentName, String totalFees, String paidFees, String paymentDate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.totalFees = totalFees;
        this.paidFees = paidFees;
        this.paymentDate = paymentDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getTotalFees() {
        return totalFees;
    }

    public String getPaidFees() {
        return paidFees;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public static final String FEES_FILE = "fees.txt";

    public static void addFees() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== Add Fees =====");

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Total Fees: ");
        String totalFees = scanner.nextLine();

        System.out.print("Enter Paid Fees: ");
        String paidFees = scanner.nextLine();

        System.out.print("Enter Payment Date: ");
        String paymentDate = scanner.nextLine();

        Fees fees = new Fees(studentId, studentName, totalFees, paidFees, paymentDate);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FEES_FILE, true))) {
            writer.write(fees.getStudentId() + "|" + fees.getStudentName() + "|" + fees.getTotalFees() + "|" + fees.getPaidFees() + "|" + fees.getPaymentDate() + "\n");
            System.out.println("Fees Added Successfully");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void viewFees() {
        System.out.println("\n===== Fees Records =====");

        try (BufferedReader reader = new BufferedReader(new FileReader(FEES_FILE))) {
            String record;
            while ((record = reader.readLine()) != null) {
                String[] data = record.trim().split("\\|");

                int pending = Integer.parseInt(data[2]) - Integer.parseInt(data[3]);

                System.out.println("Student ID   :" + data[0]);
                System.out.println("Student Name :" + data[1]);
                System.out.println("Total Fees   :" + data[2]);
                System.out.println("Paid Fees    :" + data[3]);
                System.out.println("Pending Fees :" + pending);
                System.out.println("Payment Date :" + data[4]);
                System.out.println("----------------------");
            }
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }
}