package composite;

// Company Director class that will work as a composite layer:
import java.util.ArrayList;
import java.util.List;

public class Director implements Employee {
    private List<Employee> ListOfEmployees = new ArrayList<Employee>();

    @Override
    public void EmployeeInfo() {
        for(Employee employee:ListOfEmployees) {
            employee.EmployeeInfo();
        }
    }

    public void addEmployee(Employee employee) {
        ListOfEmployees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        ListOfEmployees.remove(employee);
    }
}
