package deck;

import java.util.Arrays;
import card.base.Card;

public class Deck {
    private String name;
    private int deckSize;
    private Card[] deckList;

    // Constructor
    public Deck(String name, Card[] deckList) {
        if (deckList == null) deckList = new Card[0];
        this.name = name;
        this.deckList = Arrays.copyOf(deckList, deckList.length);
        this.deckSize = this.deckList.length;
    }

    // Insert a card at the bottom of deck
    public int insertCard(Card card) throws InsertCardFailedException {
        if (card == null) {
            throw new InsertCardFailedException("Cannot insert null card");
        }

        // นับจำนวนการ์ดชนิดเดียวกัน
        int count = 0;
        for (Card c : deckList) {
            if (c != null && c.getName().equals(card.getName())) {
                count++;
            }
        }

        if (count >= 4) {
            throw new InsertCardFailedException("You can only put 4 of the same cards into the deck");
        }

        // เพิ่มการ์ดท้าย array
        deckList = Arrays.copyOf(deckList, deckSize + 1);
        deckList[deckSize] = card;
        deckSize++;
        return deckSize;
    }

    // Remove card at given slot
    public Card removeCard(int slotNumber) throws RemoveCardFailedException {
        if (slotNumber < 0 || slotNumber >= deckSize) {
            throw new RemoveCardFailedException("Number you insert exceed deck size");
        }

        Card removed = deckList[slotNumber];

        // shift left
        for (int i = slotNumber; i < deckSize - 1; i++) {
            deckList[i] = deckList[i + 1];
        }

        // resize array
        deckList = Arrays.copyOf(deckList, deckSize - 1);
        deckSize--;
        return removed;
    }

    @Override
    public String toString() {
        return "{" + name + "}(" + deckSize + " deck size)";
    }

    // Getters & Setter
    public Card[] getDeckList() { return Arrays.copyOf(deckList, deckSize); }
    public String getName() { return name; }
    public int getDeckSize() { return deckSize; }
    public void setDeckSize(int deckSize) { this.deckSize = deckSize; }
}
