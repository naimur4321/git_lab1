import java.io.*;
import java.util.*;

public class EmployeeManager {

    public static String[] readEmployees() throws Exception {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Constants.EMPLOYEE_FILE)))) {
            return reader.readLine().split(",");
        }
    }

    public static void writeEmployees(String data) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.EMPLOYEE_FILE))) {
            writer.write(data);
        }
    }

    
    public static void main(String[] args) {

        // Argument validation
        if (args.length != 1) {
            System.out.println(Constants.ERROR_ARGUMENTS);
            System.out.println(Constants.USAGE_MESSAGE);
            return;
        }

        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                for (String employee : readEmployees()) {
                    System.out.println(employee.trim());
                }
            } catch (Exception e) {}
            System.out.println("Data Loaded.");
        }

        else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployees();
                System.out.println("Random Employee: " +
                        employees[new Random().nextInt(employees.length)].trim());
            } catch (Exception e) {}
            System.out.println("Data Loaded.");
        }

        else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                String nameInput = args[0].substring(1);
                writeEmployees(String.join(",", readEmployees()) + ", " + nameInput);
            } catch (Exception e) {}
            System.out.println("Data Loaded.");
        }

        else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String searchName = args[0].substring(1);
                boolean found = Arrays.stream(readEmployees())
                        .map(String::trim)
                        .anyMatch(emp -> emp.equals(searchName));

                System.out.println(found
                        ? "Employee \"" + searchName + "\" found!"
                        : "Employee \"" + searchName + "\" NOT found.");
            } catch (Exception e) {}
            System.out.println("Data Loaded.");
        }

        else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployees();

                int wordCount = employees.length;

                int charCount = String.join(",", employees).length();

                System.out.println(wordCount + " word(s) | " + charCount + " characters");
            } catch (Exception e) {}
            System.out.println("Data Loaded.");
        }

        else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployees();
                String nameInput = args[0].substring(1);

                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].trim().equals(nameInput)) {
                        employees[i] = "Updated";
                    }
                }

                writeEmployees(String.join(",", employees));
            } catch (Exception e) {}
            System.out.println("Data Updated.");
        }

        else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                List<String> employeeList = new ArrayList<>(Arrays.asList(readEmployees()));
                employeeList.remove(args[0].substring(1));
                writeEmployees(String.join(",", employeeList));
            } catch (Exception e) {}
            System.out.println("Data Deleted.");
        }
    }
}