package card.type;

import card.base.UnitCard;

public class NormalUnitCard extends UnitCard {

    public NormalUnitCard(String name, String flavorText, int bloodCost, int power, int health) {
        super(name, flavorText, bloodCost, Math.max(1, power), Math.max(1, health));
    }

    @Override
    public int attackUnit(UnitCard unitCard) {
        // Damage cannot exceed the defender's remaining health
        int damage = Math.min(this.getPower(), unitCard.getHealth());

        // Reduce defender's health but not below 0
        int newHealth = Math.max(0, unitCard.getHealth() - this.getPower());
        unitCard.setHealth(newHealth);

        return damage;
    }
}
