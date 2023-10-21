package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animalsRecord = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("Beast!")) {

            switch (input) {
                case "Cat":
                    try {
                        String command = scanner.nextLine();
                        String[] tokens = command.split("\\s+");
                        String name = tokens[0];
                        int age = Integer.parseInt(tokens[1]);
                        String gender = tokens[2];
                        Cat cat = new Cat(name,age,gender);
                        animalsRecord.add(cat);

                    }catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "Dog":
                    try {
                        String command = scanner.nextLine();
                        String[] tokens = command.split("\\s+");
                        String name = tokens[0];
                        int age = Integer.parseInt(tokens[1]);
                        String gender = tokens[2];
                        Dog dog = new Dog(name,age,gender);
                        animalsRecord.add(dog);

                    }catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "Frog":
                    try {
                        String command = scanner.nextLine();
                        String[] tokens = command.split("\\s+");
                        String name = tokens[0];
                        int age = Integer.parseInt(tokens[1]);
                        String gender = tokens[2];
                        Frog frog = new Frog(name,age,gender);
                        animalsRecord.add(frog);

                    }catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
            }

            input = scanner.nextLine();
        }
        for (Animal animal : animalsRecord) {
            System.out.println(animal);
        }

    }
}
