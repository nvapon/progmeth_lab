package student;

import card.type.BuffSpellCard;
import card.type.NormalUnitCard;
import card.base.UnitCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestBuffSpellCard {

    @Test
    void testCastSpell() {
        BuffSpellCard spell = new BuffSpellCard("PowerUp", "Increase POW", 1, true, 3);
        UnitCard unit = new NormalUnitCard("Soldier", "", 1, 2, 2);
        spell.castSpell(unit);

        assertEquals(5, unit.getPower());
    }

    @Test
    void testPowerIncreaseLimits() {
        BuffSpellCard spell = new BuffSpellCard("PowerUp", "Increase POW", 1, true, -5);
        assertEquals(1, spell.getPowerIncrease());
    }
}
