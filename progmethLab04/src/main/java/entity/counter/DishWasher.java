package entity.counter;

import entity.base.Item;
import entity.container.Dish;
import logic.Player;

public class DishWasher extends Counter{
    public DishWasher() {
        super("Dish Washer");
    }

    public void interact(Player p){
        if(!isPlacedContentEmpty()) super.interact(p);
        else{
            Item i = p.getHoldingItem();
            if(i instanceof Dish && ((Dish) i).isDirty()) super.interact(p);
        }
    }

    public void update(){
        if(getPlacedContent() instanceof  Dish){
            Item i = getPlacedContent();
            ((Dish)i).clean(15);
        }
    }
}
