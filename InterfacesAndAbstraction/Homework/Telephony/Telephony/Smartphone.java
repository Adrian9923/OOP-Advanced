package Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse(String site) {
        for (int i = 0; i < site.length(); i++) {
            if (Character.isDigit(site.charAt(i))) {
                return "Invalid URL!";
            }
        }
        return "Browsing..." + " " + site;
    }


    @Override
    public String call(String phone) {
        for (int i = 0; i < phone.length(); i++) {
            if (Character.isLetter(phone.charAt(i))) {
                return "Invalid number!";
            }
        }
        return "Calling...";
    }


}
