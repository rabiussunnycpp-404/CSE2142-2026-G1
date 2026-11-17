
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

        if (args[0].equals("employeeData")) {
            System.out.println("Loading data ...");
            try {
                String employeeData = loadEmployeeData("employees.txt");
                String employees[] = employeeData.split(",");
                for (String employee : employees) {
                    System.out.println(employee);
                }
            } catch (Exception employees) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("searchTerm")) {
            System.out.println("Loading data ...");
            try {
                String employeeData = loadEmployeeData("employees.txt");
                System.out.println(employeeData);
                String employees[] = employeeData.split(",");
                Random random = new Random();
                int randomIndex = random.nextInt(employees.length);
                System.out.println(employees[randomIndex]);
            } catch (Exception employees) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                String employeeName = args[0].substring(1);

                saveEmployeeData(
                        ", " + employeeName,
                        "employees.txt",
                        true);
            } catch (Exception employees) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String employeeData = loadEmployeeData("employees.txt");
                String employees[] = employeeData.split(",");
                boolean found = false;
                String searchTerm = args[0].substring(1);
                for (int employeeIndex = 0; employeeIndex < employees.length && !found; employeeIndex++) {
                    if (employees[employeeIndex].equals(searchTerm)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("character")) {
            System.out.println("Loading data ...");
            try {
                String employeeData = loadEmployeeData("employees.txt");
                char[] characters = employeeData.toCharArray();
                boolean inWord = false;
                int employeeCount = 0;
                for (char character : characters) {
                    if (character == ' ') {
                        if (!inWord) {
                            employeeCount++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(employeeCount + " word(searchTerm) found " + characters.length);
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                String employeeData = loadEmployeeData("employees.txt");
                String employees[] = employeeData.split(",");
                String employeeName = args[0].substring(1);
                for (int employeeIndex = 0; employeeIndex < employees.length; employeeIndex++) {
                    if (employees[employeeIndex].equals(employeeName)) {
                        employees[employeeIndex] = "Updated";
                    }
                }
                saveEmployeeData(
                        String.join(",", employees),
                        "employees.txt",
                        false);
            } catch (Exception exception) {
            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                String employeeData = loadEmployeeData("employees.txt");
                String employees[] = employeeData.split(",");
                String employeeName = args[0].substring(1);
                List<String> employeeList = new ArrayList<>(Arrays.asList(employees));
                employeeList.remove(employeeName);
                saveEmployeeData(
                        String.join(",", employeeList),
                        "employees.txt",
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
