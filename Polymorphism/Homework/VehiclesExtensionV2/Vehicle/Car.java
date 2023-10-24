package Vehicle;

import java.text.DecimalFormat;

public class Car extends Vehicle{
    private final static double addedConsumption = 0.9;
    DecimalFormat df = new DecimalFormat("0.##");

    protected Car(Double fuelQuantity, Double fuelConsumptionPerKm, Double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm + addedConsumption, tankCapacity);
    }


    @Override
    public void drive(Double kmToDrive) {

        double distanceToTravel = kmToDrive * this.getFuelConsumptionPerKm();
        if (distanceToTravel <= this.getFuelQuantity()){
            setFuelQuantity(this.getFuelQuantity() - distanceToTravel);
            System.out.println("The car travelled " + df.format(kmToDrive) + " km");
        }else {
            System.out.println("The car needs refueling");
        }

    }

    @Override
    public void refuel(Double amountToRefuel) {
        if (amountToRefuel <= 0){
            throw new IllegalArgumentException("The fuel amount must be a positive number");
        }else if (amountToRefuel > this.getTankCapacity()) {
            throw new IllegalArgumentException("The fuel amount exceeds this vehicle's capacity");
        }
        setFuelQuantity(this.getFuelQuantity() + amountToRefuel);
    }

    @Override
    void driveEmpty(Double kmToDrive) {

    }

    @Override
    public String toString() {
        double remainingFuel = this.getFuelQuantity();
        return String.format("Car: %.2f",remainingFuel);
    }
}
