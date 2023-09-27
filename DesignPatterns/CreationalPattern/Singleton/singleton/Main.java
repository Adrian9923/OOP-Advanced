package singleton;

public class Main {
    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

        singleton.printMessage();
        System.out.println(singleton);
        System.out.println(singleton1);
        singleton1.printMessage();
    }
}
