package encapsulation;


import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args)  {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        try{
            String name = bfr.readLine();
            int age = Integer.parseInt(bfr.readLine());

            Chicken chicken = new Chicken(name, age);
            System.out.println(chicken);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
