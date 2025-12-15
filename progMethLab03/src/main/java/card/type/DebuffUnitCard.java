package card.type;

import card.base.UnitCard;

public class DebuffUnitCard extends UnitCard {

    private int debuffPower;

    public DebuffUnitCard(String name, String flavorText, int bloodCost, int power, int health, int debuffPower) {
        super(name, flavorText, bloodCost, power, health);
        setDebuffPower(debuffPower);
    }

    // ไม่ต้องใส่ @Override
    public int attackUnit(UnitCard unitCard) {
        int dmg = Math.min(unitCard.getHealth(), this.getPower());
        unitCard.setHealth(unitCard.getHealth() - this.getPower());
        unitCard.setPower(unitCard.getPower() - this.getDebuffPower());
        return dmg;
    }

    public int getDebuffPower() {
        return this.debuffPower;
    }

    public void setDebuffPower(int debuffPower) {
        this.debuffPower = Math.max(0, debuffPower);
    }
}
