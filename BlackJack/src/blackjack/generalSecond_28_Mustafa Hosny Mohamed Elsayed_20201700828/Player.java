package blackjack;
public class Player {
private String Name;
private int score;    
private Card[] Hand=new Card[11];
private int  number_of_Cards=0;
    public Player() {
        this.score = 0;
    number_of_Cards=0;
    }

    public String getName() {
        return Name;
    }
 
 
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public int getScore() {
        return score;
    }
    
    public Card[] getHand() {
        return Hand;
    }
    public int getNumber_of_Cards() {
        return number_of_Cards;
    }
    public void increase_Number_of_Cards()
    {
        number_of_Cards++;
    }
    
public void  sum_score()
{
    int x=0;
    for (int i = 0; i <number_of_Cards ; i++) {
        x+= Hand[i].getValue();
    }
    score=x;
  
}

}