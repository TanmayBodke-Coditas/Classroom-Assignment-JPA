package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{



            //author
            //many books
            //publication - 1 book 1 publication
            public static void main(String[] args) throws IOException {

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int choice;

                do {
                    System.out.println("1. Insert zoo");
                    System.out.println("2. Insert Animal");
                    System.out.println("3. queryOne");
                    System.out.println("4. LikeQuery");

                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");
                    choice = Integer.parseInt(reader.readLine());

                    switch (choice) {
                        case 1:
                            DAOImpl.addZoo();
                            break;
                        case 2:
                            DAOImpl.addAnimal();
                            break;
                        case 3:
                            DAOImpl.q1();
                            break;
                        case 4:
                            DAOImpl.LikeQ();
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



