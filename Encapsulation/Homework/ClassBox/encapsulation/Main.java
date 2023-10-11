package encapsulation;


import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        try {
        double length = Double.parseDouble(bfr.readLine());
        double width = Double.parseDouble(bfr.readLine());
        double height = Double.parseDouble(bfr.readLine());
        Box box = new Box(length, width, height);
        System.out.println(box);
    }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
