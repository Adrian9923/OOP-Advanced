package facade;

public class ComputerFacade {
    public static void run(CPU cpu, HardDrive hardDrive, Memory memory) {
        cpu.processData();
        hardDrive.readData();
        memory.load();
    }
}
