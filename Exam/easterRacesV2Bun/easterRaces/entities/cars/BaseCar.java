package easterRaces.entities.cars;

import easterRaces.common.ExceptionMessages;

public abstract class BaseCar implements Car{
    private String model;
    private int horsePower;
    private double cubicCentimeters;
    public static final int VALID_MODEL_SYMBOLS = 4;

    protected BaseCar(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.horsePower = horsePower;
        this.cubicCentimeters = cubicCentimeters;

    }


    private void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.length() < VALID_MODEL_SYMBOLS) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_MODEL, model, VALID_MODEL_SYMBOLS));
        }
        this.model = model;
    }


    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return (this.cubicCentimeters / this.horsePower) * laps;
    }
}
