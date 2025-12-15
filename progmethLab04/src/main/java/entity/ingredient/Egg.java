package entity.ingredient;

import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Egg extends Ingredient implements Cookable {
    private int cookedPercentage;

    public Egg(){
        super("Egg");
        cookedPercentage = 0;
    }

    @Override
    public void cook() {
        cookedPercentage += 12;
        int x = cookedPercentage;
        if(0< x && x <= 50){
            setName("Raw Egg");
            setEdible(false);
        }
        else if(50 < x && x <= 80){
            setName("Sunny Side Egg");
            setEdible(true);
        }
        else if(50 < x && x <= 100){
            setName("Fried Egg");
            setEdible(true);
        }
        else if( x > 100 ){
            setName("Burnt Egg");
            setEdible(false);
        }
    }

    @Override
    public boolean isBurnt() {
        if(cookedPercentage > 100){
            return true;
        }
        else { return false; }
    }

    public String toString() {
        return StringUtil.formatNamePercentage(getName(),getCookedPercentage());
    }

    public void setCookedPercentage(int cookedPercentage) {
        this.cookedPercentage = cookedPercentage;
    }

    public int getCookedPercentage() { return cookedPercentage; }
}
