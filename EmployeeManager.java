
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {
        // Check arguments
        if (args == null || args.length != 1) {
            System.out.println(
                    "Usage: java EmployeeManager (employeeData | searchTerm | character | +NAME | ?NAME | uNAME | dNAME)");
            return;
        }

        if (args[0].equals(Constants.LIST_EMPLOYEES)) {
            System.out.println("Loading data ...");
            try {
                String[] employees = loadEmployeeData(Constants.EMPLOYEE_FILE)
                        .split(Constants.EMPLOYEE_DELIMITER);
                for (String employee : employees) {
                    System.out.println(employee);
                }
            } catch (Exception employees) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals(Constants.RANDOM_EMPLOYEE)) {
            System.out.println("Loading data ...");

            try {
                String[] employees = loadEmployeeData(Constants.EMPLOYEE_FILE)
                        .split(Constants.EMPLOYEE_DELIMITER);

                System.out.println(
                        employees[new Random().nextInt(employees.length)]);

            } catch (Exception employees) {
            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains(Constants.ADD_EMPLOYEE)) {
            System.out.println("Loading data ...");
            try {
                String employeeName = args[0].substring(1);

                saveEmployeeData(
                        ", " + employeeName,
                        Constants.EMPLOYEE_FILE,
                        true);
            } catch (Exception employees) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains(Constants.FIND_EMPLOYEE)) {
            System.out.println("Loading data ...");

            try {
                String[] employees = loadEmployeeData(Constants.EMPLOYEE_FILE)
                        .split(Constants.EMPLOYEE_DELIMITER);

                String searchTerm = args[0].substring(1);

                int indexLocation = -1;

                for (int employeeIndex = 0; employeeIndex < employees.length; employeeIndex++) {

                    if (employees[employeeIndex].trim()
                            .equals(searchTerm.trim())) {

                        indexLocation = employeeIndex;
                        break;
                    }
                }

                if (indexLocation >= 0) {
                    System.out.println(
                            "Employee '" + searchTerm
                                    + "' found at index " + indexLocation);
                } else {
                    System.out.println(
                            "Employee '" + searchTerm
                                    + "' does not exist");
                }

            } catch (Exception exception) {
            }

            System.out.println("Data Loaded.");
        } else if (args[0].equals(Constants.COUNT_EMPLOYEES)) {
            System.out.println("Loading data ...");

            try {
                String[] employees = loadEmployeeData(Constants.EMPLOYEE_FILE)
                        .split(Constants.EMPLOYEE_DELIMITER);

                System.out.println(
                        String.format("%d employees found", employees.length));

            } catch (Exception exception) {
            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains(Constants.UPDATE_EMPLOYEE)) {
            System.out.println("Loading data ...");
            try {
                String[] employees = loadEmployeeData(Constants.EMPLOYEE_FILE)
                        .split(Constants.EMPLOYEE_DELIMITER);
                String employeeName = args[0].substring(1);
                for (int employeeIndex = 0; employeeIndex < employees.length; employeeIndex++) {
                    if (employees[employeeIndex].equals(employeeName)) {
                        employees[employeeIndex] = "Updated";
                    }
                }
                saveEmployeeData(
                        String.join(
                                Constants.EMPLOYEE_DELIMITER,
                                employees),
                        Constants.EMPLOYEE_FILE,
                        false);
            } catch (Exception exception) {
            }
            System.out.println("Data Updated.");
        } else if (args[0].contains(Constants.DELETE_EMPLOYEE)) {
            System.out.println("Loading data ...");

            try {
                String employeeName = args[0].substring(1);

                List<String> employeeList = new ArrayList<>(
                        Arrays.asList(
                                loadEmployeeData(Constants.EMPLOYEE_FILE)
                                        .split(Constants.EMPLOYEE_DELIMITER)));

                employeeList.remove(employeeName);

                saveEmployeeData(
                        String.join(
                                Constants.EMPLOYEE_DELIMITER,
                                employeeList),
                        Constants.EMPLOYEE_FILE,
                        false);

            } catch (Exception exception) {
            }

            System.out.println("Data Deleted.");
        }
    }

    static String loadEmployeeData(String fileName)
            throws IOException {

        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName))) {

            return reader.readLine();
        }
    }

    static void saveEmployeeData(
            String content, String fileName, boolean append)
            throws IOException {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName, append))) {

            writer.write(content);
        }
    }

}
