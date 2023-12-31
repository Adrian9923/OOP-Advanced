package Telephony;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        List<String> numbers = Arrays.stream(bfr.readLine().split("\\s+"))
                .collect(Collectors.toList());
        List<String> urls = Arrays.stream(bfr.readLine().split("\\s+"))
                .collect(Collectors.toList());


        Smartphone smartphone = new Smartphone(numbers,urls);
        for (String number : numbers) {
            System.out.println(smartphone.call(number));
        }

        for (String url : urls) {
            System.out.println(smartphone.browse(url));
        }


    }

}
