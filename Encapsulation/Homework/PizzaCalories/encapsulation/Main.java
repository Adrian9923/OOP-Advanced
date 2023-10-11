package encapsulation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        try {
            Pizza pizza = null;

            String input = bfr.readLine();
            while (!input.equals("END")) {

                String[] tokens = input.split("\\s+");
                switch (tokens[0]) {
                    case "Pizza":
                        String pizzaName = tokens[1];
                        int toppingsCount = Integer.parseInt(tokens[2]);
                        pizza = new Pizza(pizzaName, toppingsCount);
                        break;
                    case "Dough":
                        if (tokens.length == 3) {
                            String flourType = tokens[1];
                            double weight = Double.parseDouble(tokens[2]);
                            pizza.setDough(new Dough(flourType, weight));
                        }else if (tokens.length == 4) {
                            String flourType = tokens[1];
                            String bakingTechnique = tokens[2];
                            double weight = Double.parseDouble(tokens[3]);
                            pizza.setDough(new Dough(flourType, bakingTechnique, weight));
                        }
                        break;
                    case "Topping":
                        if (tokens.length == 4) {
                            String toppingType = tokens[1] + " " + tokens[2];
                            double toppingWeight = Double.parseDouble(tokens[3]);
                            pizza.addTopping(new Topping(toppingType, toppingWeight));
                        }else if (tokens.length == 3) {
                            String toppingType = tokens[1];
                            double toppingWeight = Double.parseDouble(tokens[2]);
                            pizza.addTopping(new Topping(toppingType, toppingWeight));
                        }
                        break;

                }
                input = bfr.readLine();
            }
            System.out.println(pizza);

        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
