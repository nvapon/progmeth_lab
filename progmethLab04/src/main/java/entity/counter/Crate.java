package entity.counter;

import entity.base.Ingredient;
import entity.base.Item;
import logic.LogicUtil;
import logic.Player;

public class Crate extends Counter{
    private String myIngredient;
    public Crate(String s){
        super(s+" Crate");
        myIngredient = s;
    }

    public void interact(Player p){
        if(!p.isHandEmpty() || !isPlacedContentEmpty()){
            super.interact(p);
        }
        else{
            try{
                Item i = LogicUtil.createIngredientFromName(myIngredient);
                p.setHoldingItem(i);
            } catch(Exception e){
                p.setHoldingItem(null);
            }
        }
    }

    public String getMyIngredient() { return myIngredient; }
}
