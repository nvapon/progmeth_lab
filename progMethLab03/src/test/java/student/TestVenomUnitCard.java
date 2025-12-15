package student;

import card.type.VenomUnitCard;
import card.type.NormalUnitCard;
import card.base.UnitCard;
import player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestVenomUnitCard {

    @Test
    void testAttackAndDead() {
        VenomUnitCard venom = new VenomUnitCard("Venom", "Deadly", 2, 3, 3);
        NormalUnitCard defender = new NormalUnitCard("Defender", "Normal", 1, 2, 2);

        // Test attackUnit
        int dmg = venom.attackUnit(defender);
        assertEquals(2, dmg);
        assertEquals(0, defender.getHealth());

        // Test dead method
        Player player = new Player("Alice");
        int dmgToPlayer = venom.dead(player);
        assertEquals(3, dmgToPlayer);
        assertEquals(3, player.getCurrentDamagePoint()); // เปลี่ยนจาก getDamage() เป็น getCurrentDamagePoint()
    }
}
