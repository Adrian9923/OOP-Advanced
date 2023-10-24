package Vehicle;

import java.text.DecimalFormat;

public class Car extends Vehicle{
    DecimalFormat df = new DecimalFormat("0.##");
    public Car(Double fuelQuantity, Double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm);
    }

    @Override
    public void drive(Double kmToDrive) {
        setFuelConsumptionPerKm(this.getFuelConsumptionPerKm() + 0.9);

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
        setFuelQuantity(this.getFuelQuantity() + amountToRefuel);
    }

    @Override
    public String toString() {
        double remainingFuel = this.getFuelQuantity();
        return String.format("Car: %.2f",remainingFuel);
    }
}
