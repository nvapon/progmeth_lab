package student;

import card.type.NormalUnitCard;
import card.base.UnitCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestNormalUnitCard {
    @Test
    void testConstructor() {
        NormalUnitCard card = new NormalUnitCard("Soldier", "Normal", 1, 2, 3);
        assertEquals("Soldier", card.getName());
        assertEquals(2, card.getPower());
        assertEquals(3, card.getHealth());
    }

    @Test
    void testNonPositiveConstructor() {
        NormalUnitCard card = new NormalUnitCard("Soldier", "Normal", 1, -5, -2);
        assertEquals(1, card.getPower());   // or minimum allowed
        assertEquals(1, card.getHealth());  // or minimum allowed
    }

    @Test
    void testAttack() {
        NormalUnitCard attacker = new NormalUnitCard("Soldier", "Normal", 1, 3, 3);
        UnitCard defender = new NormalUnitCard("Defender", "Normal", 1, 2, 2);

        int damage = attacker.attackUnit(defender);
        assertEquals(2, damage);
        assertEquals(0, defender.getHealth());
    }
}
