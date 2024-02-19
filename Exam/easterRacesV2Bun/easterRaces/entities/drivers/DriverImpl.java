package easterRaces.entities.drivers;

import easterRaces.common.ExceptionMessages;
import easterRaces.entities.cars.Car;

public class DriverImpl implements Driver{
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;
    public static final int VALID_NAME_SYMBOLS = 5;

    public DriverImpl(String name) {
        this.setName(name);
        this.canParticipate = false;
    }


    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < VALID_NAME_SYMBOLS) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME,name,VALID_NAME_SYMBOLS));
        }
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(ExceptionMessages.CAR_INVALID);
        }
        this.car = car;
        this.canParticipate = true;
    }

    @Override
    public void winRace() {
        numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }
}
