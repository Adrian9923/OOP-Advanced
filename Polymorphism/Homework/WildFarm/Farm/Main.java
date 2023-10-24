package Farm;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String[] foodParams = scan.nextLine().split("\\s+");
            Food food = produceFood(foodParams);
            switch (data[0]) {
                case "Cat":
                    Cat cat = new Cat(data[1], Double.parseDouble(data[2]), data[3], data[4]);
                    cat.makeSound();
                    try {
                        cat.eat(food);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                    System.out.println(cat.toString());
                    break;
                case "Tiger":
                    Tiger tiger = new Tiger(data[1], Double.parseDouble(data[2]), data[3]);
                    tiger.makeSound();
                    try {
                        tiger.eat(food);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                    System.out.println(tiger.toString());
                    break;
                case "Zebra":
                    Zebra zebra = new Zebra(data[1], Double.parseDouble(data[2]), data[3]);
                    zebra.makeSound();
                    try {
                        zebra.eat(food);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                    System.out.println(zebra.toString());
                    break;
                case "Mouse":
                    Mouse mouse = new Mouse(data[1], Double.parseDouble(data[2]), data[3]);
                    mouse.makeSound();
                    try {
                        mouse.eat(food);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                    System.out.println(mouse.toString());
                    break;
            }
            input = scan.nextLine();
        }
    }

    public static Food produceFood(String[] foodParams) {
        Food food;

        if(foodParams[0].equals("Vegetable")) {
            food = new Vegetable(Integer.parseInt(foodParams[1]));
        } else {
            food = new Meat(Integer.parseInt(foodParams[1]));
        }

        return food;
    }
}
