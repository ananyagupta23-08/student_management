import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== AI Institute Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Batch Management");
            System.out.println("5. Attendance Management");
            System.out.println("6. Fees Management");
            System.out.println("7. Weekly Reports");
            System.out.println("8. Exit");
            System.out.println();

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                Student.addStudent();
            } else if (choice.equals("2")) {
                Student.viewStudents();
            } else if (choice.equals("3")) {
                Student.searchStudent();
            } else if (choice.equals("4")) {
                while (true) {
                    System.out.println("\n===== Batch Management =====");
                    System.out.println("1. Create Batch");
                    System.out.println("2. View Batches");
                    System.out.println("3. Back");

                    System.out.print("Enter choice: ");
                    String batchChoice = scanner.nextLine();

                    if (batchChoice.equals("1")) {
                        Batch.createBatch();
                    } else if (batchChoice.equals("2")) {
                        Batch.viewBatches();
                    } else if (batchChoice.equals("3")) {
                        break;
                    } else {
                        System.out.println("Invalid Choice");
                    }
                }
            } else if (choice.equals("5")) {
                while (true) {
                    System.out.println("\n===== Attendance Management =====");
                    System.out.println("1. Mark Attendance");
                    System.out.println("2. View Attendance");
                    System.out.println("3. Back");

                    System.out.print("Enter choice: ");
                    String attendanceChoice = scanner.nextLine();

                    if (attendanceChoice.equals("1")) {
                        Attendance.markAttendance();
                    } else if (attendanceChoice.equals("2")) {
                        Attendance.viewAttendance();
                    } else if (attendanceChoice.equals("3")) {
                        break;
                    } else {
                        System.out.println("Invalid Choice");
                    }
                }
            } else if (choice.equals("6")) {
                while (true) {
                    System.out.println("\n===== Fees Management =====");
                    System.out.println("1. Add Fees");
                    System.out.println("2. View Fees");
                    System.out.println("3. Back");

                    System.out.print("Enter choice: ");
                    String feesChoice = scanner.nextLine();

                    if (feesChoice.equals("1")) {
                        Fees.addFees();
                    } else if (feesChoice.equals("2")) {
                        Fees.viewFees();
                    } else if (feesChoice.equals("3")) {
                        break;
                    } else {
                        System.out.println("Invalid Choice");
                    }
                }
            } else if (choice.equals("7")) {
                while (true) {
                    System.out.println("\n===== Weekly Reports =====");
                    System.out.println("1. Add Report");
                    System.out.println("2. View Reports");
                    System.out.println("3. Back");

                    System.out.print("Enter choice: ");
                    String reportChoice = scanner.nextLine();

                    if (reportChoice.equals("1")) {
                        Report.addReport();
                    } else if (reportChoice.equals("2")) {
                        Report.viewReports();
                    } else if (reportChoice.equals("3")) {
                        break;
                    } else {
                        System.out.println("Invalid Choice");
                    }
                }
            } else if (choice.equals("8")) {
                System.out.println();
                System.out.println("Thank You");
                System.out.println();
                break;
            } else {
                System.out.println("Invalid Choice");
            }
        }
    }
}