package blackjack;
import java.util.Random;
import java.util.Scanner;
public class Game {
 Player []Players=new Player[4];
  private  Card []Cards=new Card[52];

    public Card[] getCards() {
        return Cards;
    }    
   private int Max_score=0;
   public void Generate_deck()
   { 
       int count=0;
       for(int x=0;x<4;x++)
       {
           for(int y=0;y<13;y++)
           {
               if(y>=10&&y<=12)
               {
                   Card card=new Card(x,y,10);
               Cards[count]=card;
               }
               else
               {
                   Card card=new Card(x,y,y+1);
                  Cards[count]=card;
               }
           count++;
           }
       }
   }
  public Card draw()
  {
      Random rand=new Random();
     Card card;
      while(true) 
     {
          int Random_num=rand.nextInt(52);
          card=Cards[Random_num];
          if(card!=null)
          {  
              Cards[Random_num]=null;
              return card;
          }
     }
  }
  public void set_information()
  {
     Scanner input=new Scanner(System.in);
     for(int i=0;i<3;i++)
      {
          Players[i]=new Player();
          System.out.println("Player number "+(i+1)+" Enter your name");
          String Pname=input.nextLine();
          Players[i].setName(Pname);  
          Players[i].getHand()[Players[i].getNumber_of_Cards()]=draw();
          Players[i].increase_Number_of_Cards();
          Players[i].getHand()[Players[i].getNumber_of_Cards()]=draw();
          Players[i].increase_Number_of_Cards();
          Players[i].sum_score();
      }
        Players[3]=new Player();
        Players[3].setName("Dealer");
        Players[3].getHand()[Players[3].getNumber_of_Cards()]=draw();
        Players[3].increase_Number_of_Cards();

        Players[3].getHand()[Players[3].getNumber_of_Cards()]=draw();
        Players[3].increase_Number_of_Cards();
        Players[3].sum_score();
  }
  
 
  public int Mx_score()
  {
    Max_score=0;
    for (int i = 0; i < 3; i++) 
        {
            Players[i].sum_score();
            if(Max_score<=Players[i].getScore()&&Players[i].getScore()<=21)
               Max_score=Players[i].getScore();
        }
  return Max_score;
  }

    Scanner input=new Scanner(System.in);
public void Start_Game(GUI gui){
    for(int i=0;i<3;i++)
    {
        System.out.println(Players[i].getName());
        int answer;
        do
        {
            
       System.out.println("his score is : "+Players[i].getScore());
       System.out.println("1)hit\n2) stand");
       answer=input.nextInt();
       if(answer==1)
       {
            Card returned_random_card=draw();
            Players[i].getHand()[ Players[i].getNumber_of_Cards()] = returned_random_card;
            Players[i].increase_Number_of_Cards();
            gui.updatePlayerHand(returned_random_card,i);
            Players[i].sum_score();
            Players[i].getScore();
       if(Players[i].getScore()>21)
               System.out.println("player number "+(i+1)+" busted ");
       }
       else{
           break;
       }
        }
        while(Players[i].getScore()<21);
        System.out.println(" your total score is "+Players[i].getScore());
  
        if(Players[i].getScore()==21)
            System.out.println("Player number "+(i+1)+" is a black jack");
    }
}
public void dealer_turn(GUI gui)
{
    Players[3].sum_score();

    if(Players[3].getScore()<Mx_score())
        {
              while(Players[3].getScore()<21||Players[3].getScore()<Mx_score())
{
             Card returned_random_card=draw();
            Players[3].getHand()[ Players[3].getNumber_of_Cards()] = returned_random_card;
            Players[3].increase_Number_of_Cards();
            gui.updateDealerHand(returned_random_card, Cards);
            Players[3].sum_score();
            
        
} 
         System.out.println("the dealer score "+Players[3].getScore());
         if(Players[3].getScore()>21){
             System.out.println("Dealer busted");
    if(Players[0].getScore()!=Players[1].getScore()&&Players[0].getScore()!=Players[2].getScore()&&Players[1].getScore()!=Players[2].getScore())
    {
        for (int i = 0; i < 3; i++)
        if(Players[i].getScore()==Mx_score())
        {
        {
     System.out.println(Players[i].getName()+" won ");
        }  
        }
    }
           int counter=0;
           int max=Mx_score();  
           for (int i = 0; i < 3; i++) {
                if(Players[i].getScore()==max)
                 counter++;
             }
           if(counter>1)
                 System.out.println("push");
         }}
         else if(Players[3].getScore()==21&& Mx_score()==21){
            System.out.println("Dealer has a black jack and the game is pushed");
         }
         else if(Players[3].getScore()==21){
         System.out.println("Dealer has a black jack");
         }
        else if(Players[3].getScore()>Mx_score())
             System.out.println("Dealer won");
        else if(Players[3].getScore()==Mx_score())
            System.out.println("Push");
      
         
        
        else if(Players[3].getScore()>Mx_score())
        {
            System.out.println("Dealer Won and his score is "+Players[3].getScore());
        }
        else if(Players[3].getScore()==Mx_score())
        {
            System.out.println("Push and the dealer score is "+Players[3].getScore());
        }
        else if(Players[3].getScore()==21)
            System.out.println("Dealer has a black jack ");

}
}
