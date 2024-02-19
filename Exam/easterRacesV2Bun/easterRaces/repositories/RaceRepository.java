package easterRaces.repositories;

import easterRaces.entities.racers.Race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class RaceRepository implements Repository<Race> {
    private Collection<Race> races;

    public RaceRepository() {
        this.races = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {

        for (Race race : this.races) {
            if (race.getName().equals(name)) {
                return race;
            }
        }
        return null;
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.races);
    }

    @Override
    public void add(Race model) {
        this.races.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.races.remove(model);
    }
}
