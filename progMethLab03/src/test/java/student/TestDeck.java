package student;

import deck.Deck;
import deck.InsertCardFailedException;
import deck.RemoveCardFailedException;
import card.base.Card;
import card.type.NormalUnitCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestDeck {

    @Test
    void testInsertCardAndRemoveCard() throws InsertCardFailedException, RemoveCardFailedException {
        Card card1 = new NormalUnitCard("Soldier", "Just a soldier", 1, 2, 2);
        Card card2 = new NormalUnitCard("Archer", "Shoots arrows", 1, 1, 1);
        Card[] cards = {card1, card2};
        Deck deck = new Deck("MyDeck", cards);

        // Insert card
        Card card3 = new NormalUnitCard("Mage", "Casts spells", 1, 3, 1);
        int newSize = deck.insertCard(card3);
        assertEquals(3, newSize);

        // Insert more than 4 same card
        Card sameCard = new NormalUnitCard("Soldier", "Just a soldier", 1, 2, 2);
        deck.insertCard(sameCard);
        deck.insertCard(sameCard);
        deck.insertCard(sameCard);
        assertThrows(InsertCardFailedException.class, () -> deck.insertCard(sameCard));

        // Remove card
        Card removed = deck.removeCard(0);
        assertEquals("Soldier", removed.getName());
        assertEquals(5, deck.getDeckSize()); // ตรวจสอบให้ตรงกับ calculation

        // Remove invalid slot
        assertThrows(RemoveCardFailedException.class, () -> deck.removeCard(100));
    }

    @Test
    void testRemoveCard() throws InsertCardFailedException, RemoveCardFailedException {
        Card card1 = new NormalUnitCard("Knight", "Strong", 1, 3, 3);
        Card card2 = new NormalUnitCard("Archer", "Shoots arrows", 1, 1, 1);
        Card[] cards = {card1, card2};
        Deck deck = new Deck("Deck1", cards);

        Card removed = deck.removeCard(0);
        assertEquals("Knight", removed.getName());
        assertEquals(1, deck.getDeckSize());
        assertEquals("Archer", deck.getDeckList()[0].getName());
    }

    @Test
    void testRemoveNonExsistanceCard() throws RemoveCardFailedException {
        Card card1 = new NormalUnitCard("Knight", "Strong", 1, 3, 3);
        Card[] cards = {card1};
        Deck deck = new Deck("Deck2", cards);

        assertThrows(RemoveCardFailedException.class, () -> deck.removeCard(5));
    }
}
