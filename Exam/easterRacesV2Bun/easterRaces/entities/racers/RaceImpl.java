package easterRaces.entities.racers;

import easterRaces.common.ExceptionMessages;
import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

public class RaceImpl implements Race{
    private String name;
    private int laps;
    private Collection<Driver> drivers;
    private static final int VALID_NAME_SYMBOLS = 5;
    private static final int INVALID_LAPS = 1;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.drivers = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < VALID_NAME_SYMBOLS) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME,name,VALID_NAME_SYMBOLS));
        }
        this.name = name;
    }

    private void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NUMBER_OF_LAPS,INVALID_LAPS));
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return this.drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver == null){
            throw new IllegalArgumentException(ExceptionMessages.DRIVER_INVALID);
        }
        if (!driver.getCanParticipate()){
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_PARTICIPATE,driver.getName()));
        }
        if (this.getDrivers().contains(driver)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_ALREADY_ADDED,driver.getName(), this.getName()));
        }
        this.drivers.add(driver);
    }
}
