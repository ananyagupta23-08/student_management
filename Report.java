import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Report {
    private String reportId;
    private String batchName;
    private String week;
    private String completedTopics;
    private String upcomingTopics;
    private String date;

    public Report(String reportId, String batchName, String week, String completedTopics, String upcomingTopics, String date) {
        this.reportId = reportId;
        this.batchName = batchName;
        this.week = week;
        this.completedTopics = completedTopics;
        this.upcomingTopics = upcomingTopics;
        this.date = date;
    }

    public String getReportId() {
        return reportId;
    }

    public String getBatchName() {
        return batchName;
    }

    public String getWeek() {
        return week;
    }

    public String getCompletedTopics() {
        return completedTopics;
    }

    public String getUpcomingTopics() {
        return upcomingTopics;
    }

    public String getDate() {
        return date;
    }

    public static final String REPORT_FILE = "reports.txt";

    public static void addReport() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== Add Weekly Report =====");

        System.out.print("Enter Report ID: ");
        String reportId = scanner.nextLine();

        System.out.print("Enter Batch Name: ");
        String batchName = scanner.nextLine();

        System.out.print("Enter Week: ");
        String week = scanner.nextLine();

        System.out.print("Enter Completed Topics: ");
        String completedTopics = scanner.nextLine();

        System.out.print("Enter Upcoming Topics: ");
        String upcomingTopics = scanner.nextLine();

        System.out.print("Enter Date: ");
        String date = scanner.nextLine();

        Report report = new Report(reportId, batchName, week, completedTopics, upcomingTopics, date);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REPORT_FILE, true))) {
            writer.write(report.getReportId() + "|" + report.getBatchName() + "|" + report.getWeek() + "|" + report.getCompletedTopics() + "|" + report.getUpcomingTopics() + "|" + report.getDate() + "\n");
            System.out.println("Report Added Successfully");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void viewReports() {
        System.out.println("\n===== Weekly Reports =====");

        try (BufferedReader reader = new BufferedReader(new FileReader(REPORT_FILE))) {
            String report;
            while ((report = reader.readLine()) != null) {
                String[] data = report.trim().split("\\|");

                System.out.println("Report ID        :" + data[0]);
                System.out.println("Batch Name       :" + data[1]);
                System.out.println("Week             :" + data[2]);
                System.out.println("Completed Topics :" + data[3]);
                System.out.println("Upcoming Topics  :" + data[4]);
                System.out.println("Date             :" + data[5]);
                System.out.println("---------------------------");
            }
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }
}