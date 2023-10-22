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
                Identifiable robot = new Robot(robotId, robotName);
                fakeIds.add(robot);
            }else {
                String[] cmdParts = command.split("\\s+");
                String citizenName = cmdParts[0];
                int age = Integer.parseInt(cmdParts[1]);
                String citizenId = cmdParts[2];
                Identifiable citizen = new Citizen(citizenName, age, citizenId);
                fakeIds.add(citizen);
            }

            command = bfr.readLine();
        }

        String idCheck = bfr.readLine();
        for (Identifiable fakeId : fakeIds) {
            if (fakeId.getId().substring(fakeId.getId().length() - 3).contains(idCheck)){
                System.out.println(fakeId);
            }
        }

    }

}
