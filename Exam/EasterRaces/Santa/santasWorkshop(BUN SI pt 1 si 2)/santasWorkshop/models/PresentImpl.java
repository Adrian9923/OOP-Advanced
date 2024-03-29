package santasWorkshop.models;


import santasWorkshop.common.ExceptionMessages;

public class PresentImpl implements Present{
    private String name;
    private int energyRequired;

    public PresentImpl(String name, int energyRequired) {
        this.setName(name);
        this.setEnergyRequired(energyRequired);
    }


    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new NullPointerException(ExceptionMessages.PRESENT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergyRequired(int energyRequired) {
        if (energyRequired < 0) {
            throw new IllegalArgumentException(ExceptionMessages.PRESENT_ENERGY_LESS_THAN_ZERO);
        }
        this.energyRequired = energyRequired;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergyRequired() {
        return this.energyRequired;
    }

    @Override
    public boolean isDone() {
        return this.getEnergyRequired() == 0;
    }

    @Override
    public void getCrafted() {
        if (this.getEnergyRequired() - 10 < 0) {
            this.setEnergyRequired(0);
        }else {
            this.setEnergyRequired(this.getEnergyRequired() - 10);
        }
    }
}
