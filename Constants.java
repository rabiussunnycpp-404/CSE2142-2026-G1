
public final class Constants {

    private Constants() {
    }

    // Name of the file containing employee data.
    static final String EMPLOYEE_FILE = "employees.txt";

    // Delimiter used to separate employees.
    static final String EMPLOYEE_DELIMITER = ",";

    // Separator used when appending a new employee.
    static final String EMPLOYEE_APPEND_SEPARATOR = ", ";

    // Command to display all employees.
    static final String LIST_EMPLOYEES = "employeeData";

    // Command to display a random employee.
    static final String RANDOM_EMPLOYEE = "searchTerm";

    // Command to count employees.
    static final String COUNT_EMPLOYEES = "character";

    // Command to find an employee.
    static final String FIND_EMPLOYEE = "?";

    // Command to add a new employee.
    static final String ADD_EMPLOYEE = "+";

    // Command to update an employee.
    static final String UPDATE_EMPLOYEE = "u";

    // Command to delete an employee.
    static final String DELETE_EMPLOYEE = "d";
}
