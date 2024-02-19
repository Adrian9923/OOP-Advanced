package test.christmas;

import christmas.Present;
import christmas.PresentBag;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChristmasTests {
    private Present present;
    private PresentBag presentBag;

    @Before
    public void createInstances() {
        this.presentBag = new PresentBag();
        this.present = new Present("Name", 1.5);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionIfNullPresent() {
        this.presentBag.create(null);
    }

    @Test
    public void getCountShouldReturnCorrectResult() {
        this.presentBag.create(this.present);

        Assert.assertEquals(1,this.presentBag.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShouldThrowAnExceptionIfThePresentNameAlreadyExists() {
        this.presentBag.create(present);
        Present present = new Present("Name", 1.6);
        this.presentBag.create(present);
    }

    @Test
    public void createShouldIncrementTheSizeOfTheCollection() {
        this.presentBag.create(this.present);

        Assert.assertEquals(1, this.presentBag.getPresents().size());
    }

    @Test
    public void createShouldReturnTheCorrectString() {
        String expectedResult = String.format("Successfully added present %s with magic %.2f",this.present.getName(), this.present.getMagic());

        String actualResult = this.presentBag.create(this.present);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = NullPointerException.class)
    public void removeShouldThrowAnExceptionIfNameIsNull() {
        this.presentBag.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void removeShouldThrowAnExceptionIfNameIsEmpty() {
        this.presentBag.remove("");
    }

    @Test
    public void removeShouldRemovePresentSuccessfully() {
        this.presentBag.create(this.present);
        boolean result = this.presentBag.remove("Name");

        Assert.assertTrue(result);
    }

    @Test
    public void removeShouldNotRemovePresent() {
        this.presentBag.create(this.present);
        boolean result = this.presentBag.remove("Name2");

        Assert.assertFalse(result);
    }

    @Test
    public void getPresentWithLeastMagicShouldReturnPresent() {
        this.presentBag.create(this.present);
        Present present = new Present("Name2", 1.60);
        this.presentBag.create(present);
        Present presentWithLeastMagic = this.presentBag.getPresentWithLeastMagic();

        Assert.assertEquals(1.50, presentWithLeastMagic.getMagic(), 0.0);
    }

    @Test
    public void getPresentWithLeastMagicShouldReturnNull() {
        Present presentWithLeastMagic = this.presentBag.getPresentWithLeastMagic();

        Assert.assertNull(presentWithLeastMagic);
    }

    @Test
    public void getPresentShouldReturnTheCorrectPresent() {
        this.presentBag.create(this.present);
        Present present = this.presentBag.getPresent("Name");

        Assert.assertEquals(this.present.getName(), present.getName());
    }

    @Test
    public void getPresentShouldReturnNull() {
        this.presentBag.create(this.present);
        Present present = this.presentBag.getPresent("Name2");
        Assert.assertNull(present);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getPresentsShouldThrowAnExceptionIfModified() {
        this.presentBag.create(this.present);
        this.presentBag.getPresents().add(new Present("Name2", 1.6));
    }
}
