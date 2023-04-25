package Library;

import org.example.DAOImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice;

        do {
            System.out.println("1. Insert Library");
            System.out.println("2. Insert Book");
            System.out.println("3. queryOne");
            System.out.println("4. queryTwo");

            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    DAOImpl1.addLibrary();
                    break;
                case 2:
                    DAOImpl1.addBook();
                    break;
                case 3:
                    DAOImpl1.q1();
                    break;
                case 4:
                    DAOImpl1.q2();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();

        } while (choice != 0);

    }
}
