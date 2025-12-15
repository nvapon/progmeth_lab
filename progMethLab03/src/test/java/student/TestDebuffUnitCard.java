package student;

import card.type.DebuffUnitCard;
import card.type.NormalUnitCard;
import card.base.UnitCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestDebuffUnitCard {

    @Test
    void testSetDebuffPower() {
        DebuffUnitCard card = new DebuffUnitCard("Debuffer", "Debuff enemy", 1, 2, 2, 2);
        card.setDebuffPower(-5);
        assertEquals(0, card.getDebuffPower());
    }

    @Test
    void testAttack() {
        DebuffUnitCard attacker1 = new DebuffUnitCard("Debuff1", "Debuff", 1, 2, 2, 1);
        DebuffUnitCard attacker2 = new DebuffUnitCard("Debuff2", "Debuff", 1, 1, 3, 2);
        NormalUnitCard defender = new NormalUnitCard("Defender", "Normal", 1, 5, 5);

        int dmg1 = attacker1.attackUnit(defender);
        assertEquals(2, dmg1);
        assertEquals(3, defender.getHealth());
        assertEquals(4, defender.getPower());

        int dmg2 = attacker2.attackUnit(defender);
        assertEquals(1, dmg2);
        assertEquals(2, defender.getHealth());
        assertEquals(2, defender.getPower());
    }
}
