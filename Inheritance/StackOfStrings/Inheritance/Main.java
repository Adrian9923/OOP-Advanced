package Inheritance;

public class Main {
    public static void main(String[] args) {

        StackOfStrings stackOfStrings = new StackOfStrings();
        stackOfStrings.push("Item1");
        stackOfStrings.push("Item2");
        stackOfStrings.push("Item3");

        System.out.println(stackOfStrings.peek());
        System.out.println(stackOfStrings.pop());

        System.out.println(stackOfStrings.isEmpty());
    }
}
