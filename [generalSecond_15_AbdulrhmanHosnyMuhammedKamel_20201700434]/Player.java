
package blackjack;


public class Player {
    
    public String Name;
    private int Score = 0;
    private Card  [] card = new Card[11];
    private int count = 0;
 
    public void setScore(int Score) {
        this.Score = Score;
    }

    public void setCard(Card[] card) {
        this.card = card;
    }


    public void setOneCard(Card card)
    {
        if(count < 11)
        {
            this.card[count] = card;
            count++;
            Score += card.getValue();
        }
    }
   

    public int getScore() {
        return Score;
    }

    public Card[] getCard() {
        return card;
    }

   
    
    
}