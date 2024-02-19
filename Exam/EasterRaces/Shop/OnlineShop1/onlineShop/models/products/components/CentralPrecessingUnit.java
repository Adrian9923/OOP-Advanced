package onlineShop.models.products.components;

public class CentralPrecessingUnit extends BaseComponent{
    public CentralPrecessingUnit(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance * 1.25, generation);
    }
}
