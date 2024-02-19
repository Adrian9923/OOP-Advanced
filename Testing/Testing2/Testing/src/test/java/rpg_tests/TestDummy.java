package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class TestDummy {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 10;
    private static final int EXPECTED_HEALTH = DUMMY_HEALTH - AXE_ATTACK;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeTestObjects(){
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void weaponAttackLosesDummyHealth(){
        // Act
        this.axe.attack(this.dummy);

        // Assert
        Assert.assertEquals("Wrong Health, ",
                EXPECTED_HEALTH,
                this.dummy.getHealth());
    }
}
