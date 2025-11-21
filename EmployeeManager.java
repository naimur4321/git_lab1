// File Name: EmployeeManager.java

import java.io.*;
import java.util.*;

public class EmployeeManager {

    public static void main(String[] args) {

        // Validate arguments
        if (args.length != 1) {
            System.out.println("Error: Exactly one argument required.");
            System.out.println("Usage:");
            System.out.println("  l     - Load employees");
            System.out.println("  s     - Show random employee");
            System.out.println("  +Name - Add employee");
            System.out.println("  ?Name - Search employee");
            System.out.println("  uName - Update employee");
            System.out.println("  dName - Delete employee");
            System.out.println("  c     - Count words");
            return;
        }

        // Check arguments
        if (args[0].equals("l")) {

            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));

                String line = reader.readLine();
                String[] employees = line.split(",");

                for (String employee : employees) {
                    System.out.println(employee.trim());
                }

                reader.close();
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].equals("s")) {

            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));

                String line = reader.readLine();
                System.out.println(line);

                String[] employees = line.split(",");
                Random randomGenerator = new Random();
                int randomIndex = randomGenerator.nextInt(employees.length);

                System.out.println(employees[randomIndex].trim());

                reader.close();
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].contains("+")) {

            System.out.println("Loading data ...");
            try {
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt", true));

                String nameInput = args[0].substring(1);
                writer.write(", " + nameInput);

                writer.close();
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].contains("?")) {

            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));

                String line = reader.readLine();
                String[] employees = line.split(",");

                boolean found = false;
                String searchName = args[0].substring(1);

                for (int i = 0; i < employees.length && !found; i++) {
                    if (employees[i].trim().equals(searchName)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }

                reader.close();
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].contains("c")) {

            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));

                String line = reader.readLine();
                char[] characters = line.toCharArray();

                boolean inWord = false;
                int wordCount = 0;

                for (char ch : characters) {
                    if (ch == ' ') {
                        if (!inWord) {
                            wordCount++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }

                System.out.println(wordCount + " word(s) found — " + characters.length + " characters");

                reader.close();
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].contains("u")) {

            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));

                String line = reader.readLine();
                String[] employees = line.split(",");

                String nameInput = args[0].substring(1);

                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].trim().equals(nameInput)) {
                        employees[i] = "Updated";
                    }
                }

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt"));

                writer.write(String.join(",", employees));

                writer.close();
                reader.close();
            } catch (Exception e) {
            }
            System.out.println("Data Updated.");

        } else if (args[0].contains("d")) {

            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));

                String line = reader.readLine();
                String[] employees = line.split(",");

                String nameInput = args[0].substring(1);

                List<String> employeeList = new ArrayList<>(Arrays.asList(employees));
                employeeList.remove(nameInput);

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt"));

                writer.write(String.join(",", employeeList));

                writer.close();
                reader.close();

            } catch (Exception e) {
            }
            System.out.println("Data Deleted.");
        }
    }
}