package Vehicle;

public abstract class Vehicle {
    protected Double fuelQuantity;
    protected Double fuelConsumptionPerKm;

    protected Vehicle(Double fuelQuantity, Double fuelConsumptionPerKm) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumptionPerKm(fuelConsumptionPerKm);
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public Double getFuelConsumptionPerKm() {
        return fuelConsumptionPerKm;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumptionPerKm(Double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    abstract void drive(Double kmToDrive);
    abstract void refuel(Double amountToRefuel);

}
