package prototype;

import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Employees employees = new Employees();
        employees.loadData();

        Employees employees1 = (Employees) employees.clone();
        Employees employees2 = (Employees) employees.clone();

        List<String> list = employees1.getRepository();
        list.add("David");
        List<String> list2 = employees2.getRepository();
        list2.remove("Alex");

        System.out.println("employees repository: " + employees.getRepository());
        System.out.println("employees1 repository: " + employees1.getRepository());
        System.out.println("employees2 repository: " + employees2.getRepository());
    }
}
