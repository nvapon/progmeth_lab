package entity.counter;

import entity.base.Choppable;
import entity.base.Ingredient;
import entity.base.Item;
import logic.Player;

public class ChoppingBoard extends Counter{
    public ChoppingBoard() {
        super("Chopping Board");
    }

    public void interact(Player p){
        if(!isPlacedContentEmpty()) {
            super.interact(p);
        }

        else if(!p.isHandEmpty() && p.getHoldingItem() instanceof Ingredient) {
            Item i = p.getHoldingItem();
            super.interact(p);
            if(i instanceof Choppable) ((Choppable) i).chop();
        }

    }
}
