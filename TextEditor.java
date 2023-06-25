import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Text Editor");
        System.out.println("============");
        System.out.println("1. Create a new file");
        System.out.println("2. Open an existing file");
        System.out.println("0. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                createNewFile(scanner);
                break;
            case 2:
                openExistingFile(scanner);
                break;
            case 0:
                System.out.println("Exiting the text editor...");
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
        }
    }

    private static void createNewFile(Scanner scanner) {
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.println("Enter the file contents (press Ctrl+Z or Ctrl+D to save and exit):");

            String line;
            while ((line = scanner.nextLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }

        System.out.println("File created successfully.");
    }

    private static void openExistingFile(Scanner scanner) {
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while opening the file: " + e.getMessage());
        }
    }
}
