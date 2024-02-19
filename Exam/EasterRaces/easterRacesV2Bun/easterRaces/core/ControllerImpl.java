package easterRaces.core;

import easterRaces.common.ExceptionMessages;
import easterRaces.common.OutputMessages;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.Repository;

import java.util.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;
    private static final int MINIMUM_PARTICIPANTS = 3;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }


    @Override
    public String createDriver(String name) {
        Driver driver = this.driverRepository.getByName(name);
        if (driver != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS, name));
        }

        driver = new DriverImpl(name);
        this.driverRepository.add(driver);
        return String.format(OutputMessages.DRIVER_CREATED, name);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = this.carRepository.getByName(model);
        if (car != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_EXISTS,model));
        }

        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
        }

        this.carRepository.add(car);
        return String.format(OutputMessages.CAR_CREATED,car.getClass().getSimpleName(),model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {

        Driver driver = this.driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }

        Car car = this.carRepository.getByName(carModel);
        if (car == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_NOT_FOUND, carModel));
        }
        driver.addCar(car);
        return String.format(OutputMessages.CAR_ADDED,driverName,carModel);


    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {

        Race race = this.raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }

        Driver driver = this.driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        race.addDriver(driver);
        return String.format(OutputMessages.DRIVER_ADDED,driverName,raceName);

    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }


        List<Driver> participants = new ArrayList<>();
        for (Driver driver : this.driverRepository.getAll()) {
            participants.add(driver);
        }

        if (participants.size() < 3) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID, raceName, MINIMUM_PARTICIPANTS));
        }

        participants.stream()
                .sorted((f,s) -> Double.compare(s.getCar().calculateRacePoints(race.getLaps()), f.getCar().calculateRacePoints(race.getLaps())));


        Driver first = participants.get(0);
        Driver second = participants.get(1);
        Driver third = participants.get(2);

        this.raceRepository.remove(race);

      /*  return String.format(OutputMessages.DRIVER_FIRST_POSITION, first.getName(), raceName)
                + System.lineSeparator()
                + String.format(OutputMessages.DRIVER_SECOND_POSITION, second.getName(), raceName)
                + System.lineSeparator()
                + String.format(OutputMessages.DRIVER_THIRD_POSITION, third.getName(), raceName);

       */
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(OutputMessages.DRIVER_FIRST_POSITION, first.getName(), raceName)).append(System.lineSeparator());
        sb.append(String.format(OutputMessages.DRIVER_SECOND_POSITION, second.getName(), raceName)).append(System.lineSeparator());
        sb.append(String.format(OutputMessages.DRIVER_THIRD_POSITION, third.getName(), raceName));
        return sb.toString().trim();

    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);
        for (Race r : this.raceRepository.getAll()) {
            if (r.getName().equals(name)) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS,name));
            }
        }


        this.raceRepository.add(race);
        return String.format(OutputMessages.RACE_CREATED,name);
    }
}

