package Inheritance;

public class Main {
    public static void main(String[] args) {

        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add("String1");
        randomArrayList.add("String2");
        randomArrayList.add("String3");
        System.out.println(randomArrayList.getRandomElement());
    }
}
