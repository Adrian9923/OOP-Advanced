package FoodShortage;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        List<Buyer> buyers = new ArrayList<>();
        int sum = 0;
        int n = Integer.parseInt(bfr.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = bfr.readLine().split("\\s+");
            if (tokens.length == 4) {
                buyers.add(new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2],  tokens[3]));
            }else {
                buyers.add(new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            }
        }

        String command = bfr.readLine();
        while (!command.equals("End")) {

            for(Buyer buyer : buyers) {
                if (buyer.getName().equals(command)) {
                    buyer.buyFood();
                }

            }

            command = bfr.readLine();
        }

        for (Buyer buyer : buyers) {
            sum += buyer.getFood();
        }
        System.out.println(sum);


    }

}
