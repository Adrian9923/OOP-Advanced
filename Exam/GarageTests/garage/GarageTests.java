package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GarageTests {
    private Car car;
    private Garage garage;

    @Before
    public void createInstances() {
        this.garage = new Garage();
        this.car = new Car("Dacia", 200, 1500);
    }

    @Test
    public void constructorShouldInitializeAnArrayList() {
        Assert.assertNotNull(this.garage.getCars());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getCarsShouldThrowAnExceptionIfTheCollectionIsModified() {
        this.garage.getCars().add(this.car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionIfNullCar() {
        this.garage.addCar(null);
    }

    @Test
    public void getCountShouldReturnCorrectResult() {
        this.garage.addCar(this.car);
        Assert.assertEquals(1,this.garage.getCount());
    }

    @Test
    public void findAllCarsWithMaxSpeedAboveShouldReturnTheCorrectResult() {
        Car anotherCar = new Car("Tesla", 250, 2500);
        this.garage.addCar(anotherCar);
        this.garage.addCar(this.car);

        Assert.assertEquals(2,this.garage.findAllCarsWithMaxSpeedAbove(150).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCarShouldThrowAnExceptionIfTheParameterIsNull() {
        this.garage.addCar(null);
    }

    @Test
    public void addCarShouldAddTheCarSuccessfully() {
        this.garage.addCar(this.car);
        Assert.assertEquals("Dacia", this.garage.getCars().get(0).getBrand());
    }

    @Test
    public void getTheMostExpensiveCarShouldReturnTheCorrectResult() {
        Car anotherCar = new Car("Tesla", 250, 2500);
        this.garage.addCar(this.car);
        this.garage.addCar(anotherCar);

        Assert.assertEquals("Tesla", this.garage.getTheMostExpensiveCar().getBrand());
    }

    @Test
    public void getTheMostExpensiveCarShouldThrowAnExceptionIfNullGarageSize() {
        Assert.assertNull(this.garage.getTheMostExpensiveCar());
    }

    @Test
    public void findAllCarsByBrandShouldReturnTheCorrectSize() {
        this.garage.addCar(this.car);
        Car anotherCar = new Car("Dacia", 210, 1700);
        this.garage.addCar(anotherCar);
        Assert.assertEquals(2, this.garage.findAllCarsByBrand("Dacia").size());
    }

}