package builder;


public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Laptop laptop = new LaptopBuilder("Lenovo","ThinkPad")
                .setRAM(16)
                .setSSD(256)
                .build();

        System.out.println(laptop);
    }
}
