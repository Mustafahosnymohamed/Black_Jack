package blackjack;
public class Card {
private int suit ;
private int rank;
private int value;
public Card (int suit,int rank,int value)
{
    this.suit=suit;
    this.rank=rank;
    this.value=value;
}
public Card(Card object)
{
    this.suit=object.suit;
    this.rank=object.rank;
    this.value=object.value;
}

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
}
