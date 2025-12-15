package entity.counter;

import entity.base.Container;
import entity.base.Ingredient;
import entity.base.Item;
import logic.Player;

public class Bin extends Counter{
    public Bin(){
        super("Bin");
    }

    public void interact(Player p){
        if(!p.isHandEmpty()){
            Item i = p.getHoldingItem();
            if(i instanceof Ingredient){
                p.setHoldingItem(null);
            }
            else if(i instanceof Container){
                ((Container)i).clearContent();
            }
        }
    }
}
