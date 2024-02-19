package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {

    private static final String COMPUTER_MANUFACTURER = "Lenovo";
    private static final String COMPUTER_MODEL_THINKPAD = "ThinkPad";
    private static final String COMPUTER_MODEL_IDEAPAD = "IdeaPad";
    private static final double COMPUTER_PRICE_THINKPAD = 900;
    private static final double COMPUTER_PRICE_IDEAPAD = 1000;
    private static final int EMPTY_COLLECTION_SIZE = 0;
    private static final int INDEX_ZERO = 0;
    private static final int EXPECTED_SIZE_COLLECTION = 2;

    private ComputerManager computerManager;
    private Computer thinkPad;
    private Computer ideaPad;

    @Before
    public void initializeTestObjects() {
        this.computerManager = new ComputerManager();
        this.thinkPad = new Computer(COMPUTER_MANUFACTURER, COMPUTER_MODEL_THINKPAD, COMPUTER_PRICE_THINKPAD);
        this.ideaPad = new Computer(COMPUTER_MANUFACTURER, COMPUTER_MODEL_IDEAPAD, COMPUTER_PRICE_IDEAPAD);
    }

    @Test
    public void constructorShouldInitializeAnArrayList() {
        Assert.assertNotNull(this.computerManager.getComputers());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getComputersShouldThrowAnExceptionIfTheCollectionIsModified() {
        this.computerManager.getComputers().add(this.thinkPad);
    }

    @Test
    public void getCountShouldReturnTheCorrectSize() {
        Assert.assertEquals(EMPTY_COLLECTION_SIZE, this.computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addComputerShouldThrowAnExceptionIfTheParameterIsNull() {
        this.computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addComputerShouldThrowAnExceptionIfTheComputerExists() {
        this.computerManager.addComputer(this.thinkPad);
        this.computerManager.addComputer(this.thinkPad);
    }

    @Test
    public void addComputerShouldAddTheComputerSuccessfully(){
        this.computerManager.addComputer(this.thinkPad);
        Assert.assertEquals(COMPUTER_MANUFACTURER, this.computerManager.getComputers().get(INDEX_ZERO).getManufacturer());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeComputerShouldThrowAnExceptionIfTheComputerDoesNotExist() {
        this.computerManager.removeComputer(COMPUTER_MANUFACTURER, COMPUTER_MODEL_THINKPAD);
    }

    @Test
    public void removeComputerShouldRemoveTheComputerSuccessfully(){
        this.computerManager.addComputer(this.thinkPad);
        this.computerManager.removeComputer(COMPUTER_MANUFACTURER, COMPUTER_MODEL_THINKPAD);
        Assert.assertTrue(this.computerManager.getComputers().isEmpty());
    }

    @Test
    public void removeComputerShouldReturnTheDeletedComputer() {
        this.computerManager.addComputer(this.thinkPad);
        Computer computer = this.computerManager.removeComputer(COMPUTER_MANUFACTURER, COMPUTER_MODEL_THINKPAD);
        Assert.assertTrue(computer.getManufacturer().equals(COMPUTER_MANUFACTURER) &&
                computer.getModel().equals(COMPUTER_MODEL_THINKPAD));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerShouldThrowAnExceptionIfTheManufacturerIsNull() {
        this.computerManager.getComputer(null, COMPUTER_MODEL_IDEAPAD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerShouldThrowAnExceptionIfTheModelIsNull() {
        this.computerManager.getComputer(COMPUTER_MANUFACTURER, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerShouldThrowAnExceptionIfTheComputerDoesNotExist() {
        this.computerManager.getComputer(COMPUTER_MANUFACTURER, COMPUTER_MODEL_THINKPAD);
    }

    @Test
    public void getComputerShouldReturnTheComputer() {
        this.computerManager.addComputer(this.thinkPad);
        Computer found = this.computerManager.getComputer(COMPUTER_MANUFACTURER, COMPUTER_MODEL_THINKPAD);
        Assert.assertTrue(found.getManufacturer().equals(COMPUTER_MANUFACTURER) &&
                found.getModel().equals(COMPUTER_MODEL_THINKPAD));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputersByManufacturerShouldThrowAnExceptionIfNullIsPassed() {
        this.computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void getComputersByManufacturerShouldReturnACollection() {
        this.computerManager.addComputer(this.thinkPad);
        this.computerManager.addComputer(this.ideaPad);
        List<Computer> computers = this.computerManager.getComputersByManufacturer(COMPUTER_MANUFACTURER);

        Assert.assertEquals(EXPECTED_SIZE_COLLECTION, computers.size());
    }
}