package rpg_tests;

import org.junit.Assert;
import org.junit.Test;;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class HeroTests {
    public static final int TARGET_XP = 10;
    public static final String HERO_NAME = "Adrian";

    @Test
    public void attackGainsExperienceIfTargetIsDead(){
        Target fakeTarget = new Target(){
            public void takeAttack(int attackPoints) { }
            public int getHealth() { return 0; }
            public int giveExperience() { return TARGET_XP; }
            public boolean isDead() { return true; }
        };

        Weapon fakeWeapon = new Weapon() {
            public void attack(Target target) { }
            public int getAttackPoints() { return 10; }
            public int getDurabilityPoints() { return 0; }
        };

        Hero hero = new Hero(HERO_NAME, fakeWeapon);
        hero.attack(fakeTarget);
        Assert.assertEquals("Wrong experience", TARGET_XP, hero.getExperience());
    }
}
