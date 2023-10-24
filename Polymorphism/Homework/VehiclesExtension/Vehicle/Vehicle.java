package Vehicle;

public abstract class Vehicle {
    protected Double fuelQuantity;
    protected Double fuelConsumptionPerKm;
    protected Double tankCapacity;

    protected Vehicle(Double fuelQuantity, Double fuelConsumptionPerKm, Double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumptionPerKm(fuelConsumptionPerKm);
        setTankCapacity(tankCapacity);
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public Double getFuelConsumptionPerKm() {
        return fuelConsumptionPerKm;
    }

    public Double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumptionPerKm(Double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    abstract void drive(Double kmToDrive);
    abstract void refuel(Double amountToRefuel);
    abstract void driveEmpty(Double kmToDrive);
}
