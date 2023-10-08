package encapsulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            String lastName = tokens[1];
            Person person;
            if (tokens.length == 2) {
                person = new Person(name,lastName);
            }else {
                int age = Integer.parseInt(tokens[2]);
                person = new Person(name, lastName, age);
            }
            people.add(person);
        }
        for (Person person : people) {
            System.out.println(person);
        }

    }
}
