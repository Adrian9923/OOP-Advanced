package composite;

public class Main {
    public static void main (String[] args) {
        Worker firstWorker = new Worker(1, "Michael Peterson", "Marketing");
        Worker secondWorker  = new Worker(2, "Bob Warley", "Marketing");
        Director engDirectory = new Director();
        engDirectory.addEmployee(firstWorker);
        engDirectory.addEmployee(secondWorker);

        Manager firstManager = new Manager(11, "George Bond", "SEO Manager");
        Manager secondManager = new Manager(12, "James Clark", "Marketing Manager");

        Director accDirectory = new Director();
        accDirectory.addEmployee(firstManager);
        accDirectory.addEmployee(secondManager);

        Director directory = new Director();
        directory.addEmployee(engDirectory);
        directory.addEmployee(accDirectory);
        directory.EmployeeInfo();
    }
}
