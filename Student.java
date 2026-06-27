import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Student {
    private String studentId;
    private String name;
    private String email;
    private String contact;
    private String batch;

    public Student(String studentId, String name, String email, String contact, String batch) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.batch = batch;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getBatch() {
        return batch;
    }

    public static final String FILE_NAME = "students.txt";

    public static void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== Add Student =====");

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Batch: ");
        String batch = scanner.nextLine();

        Student student = new Student(studentId, name, email, contact, batch);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(student.getStudentId() + "|" + student.getName() + "|" + student.getEmail() + "|" + student.getContact() + "|" + student.getBatch() + "\n");
            System.out.println("Student Added Successfully");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void viewStudents() {
        System.out.println("\n===== Student List =====");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String student;
            boolean hasStudents = false;
            while ((student = reader.readLine()) != null) {
                hasStudents = true;
                String[] data = student.trim().split("\\|");

                System.out.println("ID      :" + data[0]);
                System.out.println("Name    :" + data[1]);
                System.out.println("Email   :" + data[2]);
                System.out.println("Contact :" + data[3]);
                System.out.println("Batch   :" + data[4]);
                System.out.println("----------------------");
            }

            if (!hasStudents) {
                System.out.println("No Students Found");
            }
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }

    public static void searchStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== Search Student =====");

        System.out.print("Enter Student ID, Name, Email or Batch: ");
        String keyword = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String student;
            boolean found = false;
            while ((student = reader.readLine()) != null) {
                if (student.toLowerCase().contains(keyword.toLowerCase())) {
                    String[] data = student.trim().split("\\|");

                    System.out.println("ID      :" + data[0]);
                    System.out.println("Name    :" + data[1]);
                    System.out.println("Email   :" + data[2]);
                    System.out.println("Contact :" + data[3]);
                    System.out.println("Batch   :" + data[4]);
                    System.out.println("----------------------");

                    found = true;
                }
            }

            if (!found) {
                System.out.println("Student Not Found");
            }
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }
}