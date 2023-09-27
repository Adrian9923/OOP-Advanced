package composite;

// This is the Leaf
public class Worker implements Employee {
    private String name;
    private long employeeID;
    private String position;

    public Worker(long employeeID, String name, String position) {
        this.employeeID = employeeID;
        this.name = name;
        this.position = position;
    }

    @Override
    public void EmployeeInfo() {
        System.out.println(employeeID + " " + name);
    }
}
