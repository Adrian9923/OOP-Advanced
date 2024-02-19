package onlineShop.models.products.components;

public class MotherBoard extends BaseComponent{
    public MotherBoard(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance * 1.25, generation);
    }
}
