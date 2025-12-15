package logic;

public class CardCounter {
	
	private UnitCard card;
	private int count;
	
	public String toString() {
        return  this.getCard() + " x " + this.getCount();
	}

    public CardCounter(UnitCard card, int count) {
        this.setCard (card);
        this.setCount (count);
    }

    public void setCard(UnitCard card) { //ตั้งมั้ย?
        this.card = card;
    }

    public void setCount(int count) {
        if (count < 0) { this.count = 0; }
        else { this.count = count; }
    }

    public UnitCard getCard() { return this.card; }
    public int getCount() { return this.count; }
}
