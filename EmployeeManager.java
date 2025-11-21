import java.io.*;
import java.util.*;

public class EmployeeManager {

    // Method for reading employees
    public static String[] readEmployees() throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Constants.EMPLOYEE_FILE)));
        String line = reader.readLine();
        reader.close();
        return line.split(",");
    }

    // Method for writing employees
    public static void writeEmployees(String data) throws Exception {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.EMPLOYEE_FILE));
        writer.write(data);
        writer.close();
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
                String[] employees = readEmployees();
                for (String employee : employees) {
                    System.out.println(employee.trim());
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployees();
                Random rand = new Random();
                int randomIndex = rand.nextInt(employees.length);
                System.out.println("Random Employee: " + employees[randomIndex].trim());
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                String nameInput = args[0].substring(1);
                String[] employees = readEmployees();
                String updatedData = String.join(",", employees) + ", " + nameInput;
                writeEmployees(updatedData);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployees();
                String searchName = args[0].substring(1);
                boolean found = false;
                for (String emp : employees) {
                    if (emp.trim().equals(searchName)) {
                        found = true;
                        break;
                    }
                }
                System.out.println(found ? "Employee found!" : "Employee NOT found.");
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployees();
                String data = String.join(",", employees);
                System.out.println(employees.length + " word(s) | " + data.length() + " characters");
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
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
            } catch (Exception e) {
            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readEmployees();
                String nameInput = args[0].substring(1);
                List<String> employeeList = new ArrayList<>(Arrays.asList(employees));
                employeeList.remove(nameInput);
                writeEmployees(String.join(",", employeeList));
            } catch (Exception e) {
            }
            System.out.println("Data Deleted.");
        }
    }
}