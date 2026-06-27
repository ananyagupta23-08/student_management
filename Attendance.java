import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Attendance {
    private String studentId;
    private String studentName;
    private String date;
    private String status;

    public Attendance(String studentId, String studentName, String date, String status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.date = date;
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public static final String ATTENDANCE_FILE = "attendance.txt";

    public static void markAttendance() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== Mark Attendance =====");

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Date (DD-YY-MM): ");
        String date = scanner.nextLine();

        System.out.print("Enter P for Present or A for Absent: ");
        String status = scanner.nextLine();

        Attendance attendance = new Attendance(studentId, studentName, date, status);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ATTENDANCE_FILE, true))) {
            writer.write(attendance.getStudentId() + "|" + attendance.getStudentName() + "|" + attendance.getDate() + "|" + attendance.getStatus() + "\n");
            System.out.println("Attendance Marked Successfully");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void viewAttendance() {
        System.out.println("\n===== Attendance Records =====");

        try (BufferedReader reader = new BufferedReader(new FileReader(ATTENDANCE_FILE))) {
            String record;
            while ((record = reader.readLine()) != null) {
                String[] data = record.trim().split("\\|");

                System.out.println("Student ID   :" + data[0]);
                System.out.println("Student Name :" + data[1]);
                System.out.println("Date         :" + data[2]);
                System.out.println("Status       :" + data[3]);
                System.out.println("----------------------");
            }
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }
}