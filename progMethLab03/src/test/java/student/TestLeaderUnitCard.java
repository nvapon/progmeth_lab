package student;

import card.type.LeaderUnitCard;
import card.type.NormalUnitCard;
import card.base.UnitCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestLeaderUnitCard {

    @Test
    void testBuffUnit() {
        LeaderUnitCard leader = new LeaderUnitCard("Leader", "Boosts allies", 2, 3, 3, 1, 2);
        UnitCard[] allies = {
                new NormalUnitCard("A1", "", 1, 2, 2),
                null,
                new NormalUnitCard("A3", "", 1, 1, 1)
        };
        leader.buffUnit(allies);

        assertEquals(3, allies[0].getPower());
        assertEquals(4, allies[0].getHealth());
        assertEquals(2, allies[2].getPower());
        assertEquals(3, allies[2].getHealth());
    }

    @Test
    void testAttack() {
        LeaderUnitCard leader = new LeaderUnitCard("Leader", "Boosts allies", 2, 3, 3, 1, 2);
        UnitCard defender = new NormalUnitCard("Defender", "", 1, 2, 2);

        int dmg = leader.attackUnit(defender);
        assertEquals(2, dmg);
        assertEquals(0, defender.getHealth());
    }
}
