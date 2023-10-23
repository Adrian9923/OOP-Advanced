package BirthDays;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Birthable> years = new ArrayList<>();
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String command = bfr.readLine();

        while (!command.equals("End")) {

            String[] cmdParts = command.split("\\s+");
            if (cmdParts.length == 5) {
                years.add(new Citizen(cmdParts[1], Integer.parseInt(cmdParts[2]), cmdParts[3], cmdParts[4]));
            }else if (cmdParts.length == 3 && (!cmdParts[1].contains("-"))) {
                years.add(new Pet(cmdParts[1], cmdParts[2]));
            }

            command = bfr.readLine();
        }

        String checkYear = bfr.readLine();
        years.stream()
                .filter(e -> e.getBirthDate().endsWith(checkYear))
                .forEach(e -> System.out.println(e.getBirthDate()));
    }

}
