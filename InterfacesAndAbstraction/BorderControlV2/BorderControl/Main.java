package BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Identifiable> fakeIds = new ArrayList<>();
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String command = bfr.readLine();
        while (!command.equals("End")) {

            if (command.contains("-")) {
                String[] cmdParts = command.split("\\s+");
                String robotName = cmdParts[0];
                String robotId = cmdParts[1];
                fakeIds.add(new Robot(robotName, robotId));
            }else {
                String[] cmdParts = command.split("\\s+");
                String citizenName = cmdParts[0];
                int age = Integer.parseInt(cmdParts[1]);
                String citizenId = cmdParts[2];
                fakeIds.add(new Citizen(citizenName, age, citizenId));
            }

            command = bfr.readLine();
        }

        String idCheck = bfr.readLine();
        fakeIds.stream()
                .filter(e -> e.getId().endsWith(idCheck))
                .forEach(e -> System.out.println(e.getId()));

    }

}
