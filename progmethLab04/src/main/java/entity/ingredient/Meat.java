package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Meat extends Ingredient implements Choppable, Cookable {
    private boolean chopState;
    private int cookedPercentage;

    public Meat(){
        super("Meat");
        chopState = false;
        cookedPercentage = 0;
    }


    public int getCookedPercentage() { return cookedPercentage; }

    @Override
    public void chop() {
        if(!isChopped() && cookedPercentage == 0) {
            chopState = true;
            setName("Minced Meat");
        }
    }

    @Override
    public boolean isChopped() {
        return chopState;
    }

    @Override
    public void cook() {
        if(!isChopped()) {
            cookedPercentage += 10;
            int x = cookedPercentage;
            if( 0 < x && x <= 50){
                setName("Raw Meat");
                setEdible(false);
            }
            else if(50 < x && x <= 80){
                setName("Medium Rare Steak");
                setEdible(true);
            }
            else if(80 < x && x <= 100){
                setName("Well Done Steak");
                setEdible(true);
            }
            else if(x > 100){
                setName("Burnt Steak");
                setEdible(false);
            }
        }
        else{
            cookedPercentage += 15;
            int x = cookedPercentage;
            if( 0 < x && x <= 80){
                setName("Raw Burger");
                setEdible(false);
            }
            else if(80 < x && x <= 100){
                setName("Cooked Burger");
                setEdible(true);
            }
            else if(x > 100){
                setName("Burnt Burger");
                setEdible(false);
            }
        }
    }

    @Override
    public boolean isBurnt() {
        if(cookedPercentage > 0){ return true; }
        else { return false; }
    }

    public String toString(){
        return StringUtil.formatNamePercentage(getName(),getCookedPercentage());
    }
}
