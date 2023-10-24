package Vehicle;

import java.text.DecimalFormat;

public class Truck extends Vehicle{
    private final static double addedConsumption = 1.6;
    DecimalFormat df = new DecimalFormat("0.######");

    protected Truck(Double fuelQuantity, Double fuelConsumptionPerKm, Double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm + addedConsumption, tankCapacity);
    }


    @Override
    public void drive(Double kmToDrive) {

        double distanceToTravel = kmToDrive * this.getFuelConsumptionPerKm();
        if (distanceToTravel <= this.getFuelQuantity()){
            setFuelQuantity(this.getFuelQuantity() - distanceToTravel);
            System.out.println("The truck travelled " + df.format(kmToDrive) + " km");
        }else {
            System.out.println("The truck needs refueling");
        }
    }

    @Override
    public void refuel(Double amountToRefuel) {
        if (amountToRefuel <= 0){
            throw new IllegalArgumentException("The fuel amount must be a positive number");
        }else if (amountToRefuel > this.getTankCapacity()) {
            throw new IllegalArgumentException("The fuel amount exceeds this vehicle's capacity");
        }
        double remainingFuel = amountToRefuel * 0.95;
        setFuelQuantity(this.getFuelQuantity() + remainingFuel);
    }

    @Override
    void driveEmpty(Double kmToDrive) {

    }

    @Override
    public String toString() {
        double remainingFuel = this.getFuelQuantity();
        return String.format("Truck: %.2f",remainingFuel);
    }
}
