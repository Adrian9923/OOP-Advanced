package template;

public abstract class CarTemplate {
    // a method that will represent the algorithm
    // final bcs it should not be overriden by subclasses
    public final void buildCar() {
        addBrand();
        addModel();
        assembleComponents();
        installEngine();
        System.out.println("Car is built.");
    }

    private void installEngine() {
        System.out.println("Installing the engine...");
    }

    private void assembleComponents() {
        System.out.println("Assembling the components...");
    }

    // 2 abstract methods that will be implemented by subclasses
    public abstract void addModel();
    public abstract void addBrand();

}
