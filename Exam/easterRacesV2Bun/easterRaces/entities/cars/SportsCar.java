package easterRaces.entities.cars;

import easterRaces.common.ExceptionMessages;

public class SportsCar extends BaseCar{
    private static final int MINIMUM_HORSEPOWER = 200;
    private static final int MAXIMUM_HORSEPOWER = 450;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, 3000);
        if (horsePower < MINIMUM_HORSEPOWER || horsePower > MAXIMUM_HORSEPOWER) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }
    }
}
