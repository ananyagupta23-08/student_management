import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Batch {
    private String batchId;
    private String name;
    private String timing;
    private String teacher;

    public Batch(String batchId, String name, String timing, String teacher) {
        this.batchId = batchId;
        this.name = name;
        this.timing = timing;
        this.teacher = teacher;
    }

    public String getBatchId() {
        return batchId;
    }

    public String getName() {
        return name;
    }

    public String getTiming() {
        return timing;
    }

    public String getTeacher() {
        return teacher;
    }

    public static final String BATCH_FILE = "batches.txt";

    public static void createBatch() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== Create Batch =====");

        System.out.print("Enter Batch ID: ");
        String batchId = scanner.nextLine();

        System.out.print("Enter Batch Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Batch Timing: ");
        String timing = scanner.nextLine();

        System.out.print("Enter Teacher Name: ");
        String teacher = scanner.nextLine();

        Batch batch = new Batch(batchId, name, timing, teacher);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BATCH_FILE, true))) {
            writer.write(batch.getBatchId() + "|" + batch.getName() + "|" + batch.getTiming() + "|" + batch.getTeacher() + "\n");
            System.out.println("Batch Created Successfully");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void viewBatches() {
        System.out.println("\n===== Batch List =====");

        try (BufferedReader reader = new BufferedReader(new FileReader(BATCH_FILE))) {
            String batch;
            while ((batch = reader.readLine()) != null) {
                String[] data = batch.trim().split("\\|");

                System.out.println("Batch ID   :" + data[0]);
                System.out.println("Batch Name :" + data[1]);
                System.out.println("Timing     :" + data[2]);
                System.out.println("Teacher    :" + data[3]);
                System.out.println("----------------------");
            }
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }
}