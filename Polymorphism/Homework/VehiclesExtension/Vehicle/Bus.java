package Vehicle;

import java.text.DecimalFormat;

public class Bus extends Vehicle{
    private final static double addedConsumption = 1.4;
    DecimalFormat df = new DecimalFormat("0.##");

    public Bus(Double fuelQuantity, Double fuelConsumptionPerKm, Double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity);
    }

    @Override
    void drive(Double kmToDrive) {
        double distanceToTravel = kmToDrive * this.getFuelConsumptionPerKm();
        if (distanceToTravel <= this.getFuelQuantity()){
            setFuelQuantity(this.getFuelQuantity() - distanceToTravel);
            System.out.println("The bus travelled " + df.format(kmToDrive) + " km");
        }else {
            System.out.println("The bus needs refueling");
        }
    }

    @Override
    void refuel(Double amountToRefuel) {
        if (amountToRefuel < 0){
            throw new IllegalArgumentException("The fuel amount must be a positive number");
        }else if (amountToRefuel > this.getTankCapacity()) {
            throw new IllegalArgumentException("The fuel amount exceeds this vehicle's capacity");
        }
        setFuelQuantity(this.getFuelQuantity() + amountToRefuel);
    }

    public void driveEmpty(Double kmToDrive){
        setFuelConsumptionPerKm(this.getFuelConsumptionPerKm() + addedConsumption);
        double distanceToTravel = kmToDrive * this.getFuelConsumptionPerKm();
        if (distanceToTravel <= this.getFuelQuantity()){
            setFuelQuantity(this.getFuelQuantity() - distanceToTravel);
            System.out.println("The bus travelled " + df.format(kmToDrive) + " km");
        }else {
            System.out.println("The bus needs refueling");
            setFuelConsumptionPerKm(this.getFuelConsumptionPerKm() - addedConsumption);
        }
    }

    @Override
    public String toString() {
        double remainingFuel = this.getFuelQuantity();
        return String.format("Bus: %.2f",remainingFuel);
    }
}
