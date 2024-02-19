package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {

    @Test
    public void attackedTargetLoosesHealth(){
        //Arrange
        Dummy dummy = new Dummy(10,10);

        //Act
        dummy.takeAttack(5);

        //Assert
       // Assert.assertEquals(5,dummy.getHealth());
        //or
        Assert.assertTrue(dummy.getHealth() == 5);

    }

    @Test(expected = IllegalStateException.class) //Assert
    public void deadDummyCantTakeDamage(){
        // Arrange
        Axe axe = new Axe(10, 1);
        Dummy dummy = new Dummy(20, 10);

// Act
        axe.attack(dummy);
        axe.attack(dummy);

    }

    @Test
    public void deadDummyProvidesXp(){
        // Arrange
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(20, 10);

// Act
        axe.attack(dummy);
        axe.attack(dummy);

        //Assert
        Assert.assertEquals(10,dummy.giveExperience());

    }

  /*  @Test(expected = IllegalStateException.class) //Assert
    public void livingDummyNoProvidesXp(){
        // Arrange
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(30, 10);

// Act
        axe.attack(dummy);
        axe.attack(dummy);

    }

   */
}
