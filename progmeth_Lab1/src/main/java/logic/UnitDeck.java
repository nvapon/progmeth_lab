package logic;

import java.util.ArrayList;

public class UnitDeck {
    private ArrayList<CardCounter> cardsInDeck;
    private String deckName;

    public UnitDeck (String deckName){
        this.setDeckName (deckName);
        this.cardsInDeck = new ArrayList<>();
    }

    public void setDeckName (String deckName) {
        if (deckName.isBlank()) { this.deckName = "Untitled Deck"; }
        else { this.deckName = deckName; }
    }

    public String getDeckName() { return this.deckName; }

    public void addCard(UnitCard newCard, int count){ //help
        if (count > 0){
            if (this.existsInDeck(newCard)) {
                for (CardCounter counter: cardsInDeck) {
                    if (counter.getCard().equals(newCard)) {
                        counter.setCount(counter.getCount() + count);
                    }
                }
            }
            else { this.cardsInDeck.add(new CardCounter(newCard, count)); }
        }
    }

    public void removeCard(UnitCard toRemove, int count ){
        if ( this.existsInDeck(toRemove) && count > 0 ) {
            for (int i=0; i<cardsInDeck.size(); i++) {
                if (cardsInDeck.get(i).getCard().equals(toRemove)) {
                    int newCount = cardsInDeck.get(i).getCount()-count;
                    if ( newCount > 0) cardsInDeck.get(i).setCount(newCount);
                    else cardsInDeck.remove(i);
                }
            }
        }
    }

    public int cardCount() {
        int total = 0;
        for (CardCounter counter: cardsInDeck) {
            total += counter.getCount();
        }
        return total;
    }

    public boolean existsInDeck(UnitCard card){ //help
        for (CardCounter counter: cardsInDeck ) {
            if (counter.getCard().equals(card) ) { return true; }
        }
        return false;
    }

    public boolean equals(UnitDeck other) { return this.deckName.equals(other.deckName);}
    public ArrayList<CardCounter> getCardsInDeck() { return cardsInDeck; }
}

