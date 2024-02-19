package santasWorkshop.core;

import santasWorkshop.common.ConstantMessages;
import santasWorkshop.common.ExceptionMessages;
import santasWorkshop.models.*;
import santasWorkshop.repositories.DwarfRepository;
import santasWorkshop.repositories.PresentRepository;
import santasWorkshop.repositories.Repository;


import java.util.ArrayList;
import java.util.List;


public class ControllerImpl implements Controller{
    private Repository<Dwarf> dwarfRepository;
    private Repository<Present> presentRepository;

    public ControllerImpl() {
        this.dwarfRepository = new DwarfRepository();
        this.presentRepository = new PresentRepository();
    }

    @Override
    public String addDwarf(String type, String dwarfName) {
        switch (type) {
            case "Happy":
                Dwarf happyDwarf = new Happy(dwarfName);
                this.dwarfRepository.add(happyDwarf);
                break;

            case "Sleepy":
                Dwarf sleepyDwarf = new Sleepy(dwarfName);
                this.dwarfRepository.add(sleepyDwarf);
                break;

            default: throw new IllegalArgumentException(ExceptionMessages.DWARF_TYPE_DOESNT_EXIST);
        }
        return String.format(ConstantMessages.ADDED_DWARF, type, dwarfName);
    }

    @Override
    public String addInstrumentToDwarf(String dwarfName, int power) {
        Dwarf dwarf = this.dwarfRepository.findByName(dwarfName);
        if (dwarf == null) {
            throw new IllegalArgumentException(ExceptionMessages.DWARF_DOESNT_EXIST);
        }
        Instrument instrument = new InstrumentImpl(power);
        dwarf.addInstrument(instrument);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_DWARF, power, dwarfName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        this.presentRepository.add(present);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        List<Dwarf> suitableDwarfs = new ArrayList<>();
        for (Dwarf model : this.dwarfRepository.getModels()) {
            if (model.getEnergy() > 50) {
                suitableDwarfs.add(model);
            }
        }

        if (suitableDwarfs.size() == 0) {
            throw new IllegalArgumentException(ExceptionMessages.NO_DWARF_READY);
        }
        Present present = this.presentRepository.findByName(presentName);
        Workshop workshop = new WorkShopImpl();

        for (Dwarf suitableDwarf : suitableDwarfs) {
            workshop.craft(present, suitableDwarf);
        }
        String isPresentDone = null;
        if (present.isDone()) {
            isPresentDone = String.format(ConstantMessages.PRESENT_DONE,present.getName(), "done");
        }else {
            isPresentDone = String.format(ConstantMessages.PRESENT_DONE,present.getName(), "not done");
        }

        int brokenCount = 0;
        for (Dwarf suitableDwarf : suitableDwarfs) {
            for (Instrument instrument : suitableDwarf.getInstruments()) {
                if(instrument.isBroken()) {
                    brokenCount++;
                }
            }

        }

        String brokenInstruments = String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenCount);

        return isPresentDone + brokenInstruments;

    }

    @Override
    public String report() {
        int countCraftedPresents = 0;
        for (Present model : this.presentRepository.getModels()) {
            if (model.isDone()){
                countCraftedPresents++;
            }

        }
        String donePresents = String.format("%d presents are done!\nDwarfs info:\n",countCraftedPresents);
        StringBuilder dwarfInfo = new StringBuilder();
        for (Dwarf dwarf : this.dwarfRepository.getModels()) {
            int countInstruments = 0;
            for (Instrument instrument : dwarf.getInstruments()) {
                if (!instrument.isBroken()) {
                    countInstruments++;
                }
            }
            dwarfInfo.append(String.format("Name: %s\nEnergy: %d\nInstruments: %d not broken left\n",
                    dwarf.getName(), dwarf.getEnergy(), countInstruments));

        }

        return donePresents + dwarfInfo.toString().trim();

    }
}
