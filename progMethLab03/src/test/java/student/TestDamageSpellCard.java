package student;

import card.type.DamageSpellCard;
import card.type.NormalUnitCard;
import card.base.UnitCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestDamageSpellCard {

    @Test
    void testCastSpell() {
        DamageSpellCard spell = new DamageSpellCard("Fireball", "Deal damage", 1, true, 3);
        UnitCard unit = new NormalUnitCard("Soldier", "", 1, 2, 5);
        spell.castSpell(unit);

        assertEquals(2, unit.getHealth());
    }

    @Test
    void testSetDamageLimits() {
        DamageSpellCard spell = new DamageSpellCard("Fireball", "Deal damage", 1, true, -2);
        assertEquals(1, spell.getDamage());
    }
}
