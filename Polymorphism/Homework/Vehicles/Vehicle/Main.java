package Vehicle;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle car = null;
        Vehicle truck = null;
        for (int i = 0; i < 2; i++) {
            String[] cmdParts = scanner.nextLine().split("\\s+");
            switch (cmdParts[0]) {
                case "Car":
                    car = new Car(Double.parseDouble(cmdParts[1]),Double.parseDouble(cmdParts[2]));
                    vehicles.add(car);
                    break;
                case "Truck":
                    truck = new Truck(Double.parseDouble(cmdParts[1]),Double.parseDouble(cmdParts[2]));
                    vehicles.add(truck);
                    break;
            }

        }


        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            switch (tokens[0]) {
                case "Drive":
                    switch (tokens[1]) {
                        case "Car":
                            car.drive(Double.parseDouble(tokens[2]));
                            break;
                        case "Truck":
                            truck.drive(Double.parseDouble(tokens[2]));
                            break;
                    }
                    break;
                case "Refuel":
                    switch (tokens[1]) {
                        case "Car":
                            car.refuel(Double.parseDouble(tokens[2]));
                            break;
                        case "Truck":
                            truck.refuel(Double.parseDouble(tokens[2]));
                            break;
                    }
                    break;
            }
        }

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }


    }

}
