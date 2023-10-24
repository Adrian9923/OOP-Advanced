package Vehicle;

import java.text.DecimalFormat;

public class Truck extends Vehicle{
    DecimalFormat df = new DecimalFormat("0.######");
    public Truck(Double fuelQuantity, Double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm);
    }



    @Override
    public void drive(Double kmToDrive) {
        setFuelConsumptionPerKm(this.getFuelConsumptionPerKm() + 1.6);

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
        double remainingFuel = amountToRefuel * 0.95;
        setFuelQuantity(this.getFuelQuantity() + remainingFuel);
    }

    @Override
    public String toString() {
        double remainingFuel = this.getFuelQuantity();
        return String.format("Truck: %.2f",remainingFuel);
    }
}
