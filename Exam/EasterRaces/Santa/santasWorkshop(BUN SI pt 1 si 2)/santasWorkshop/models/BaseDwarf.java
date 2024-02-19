package santasWorkshop.models;


import santasWorkshop.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseDwarf implements Dwarf{
    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    protected BaseDwarf(String name, int energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.instruments = new ArrayList<>();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.DWARF_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(int energy) {

        if (energy < 0) {
            throw new IllegalArgumentException(ExceptionMessages.PRESENT_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public void work() {
        if (this.getEnergy() - 10 < 0) {
            this.setEnergy(0);
        }else {
            this.setEnergy(this.getEnergy() - 10);
        }
    }

    @Override
    public void addInstrument(Instrument instrument) {
        this.getInstruments().add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.getEnergy() > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return this.instruments;
    }
}
