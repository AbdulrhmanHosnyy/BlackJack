package blackjack;

import java.util.Random;
import java.lang.Math;
import java.util.Scanner;


public class Game {
    
    public Player [] player = new Player[4];
    public Card [] card = new Card[52];
    int [] highScores = new int [4];
    
    
    Scanner input = new Scanner(System.in);

     public void card_deck()
    {
       
        int s = 0 , r = 0 , v = 1;

        for(int i = 0 ; i < 52 ; i++)
        {
            if(i % 13 == 0 && i != 0)
            {
                s++;
                r = 0;
                v = 1;
            }
            if(v == 11 || v == 12 || v == 13)
                v = 10;
            Card oneCard = new Card(s , r , v);
            card[i] = oneCard;
            r++;
            v++;
            
        
        }
         
    }
    
    public Card random()
    {
        Random rand = new Random();
        
        Card returnedCard;

        while(true)
        {
            int randomChoice = rand.nextInt(51);
            
            if(card[randomChoice] != null)
            {
                returnedCard = new Card(card[randomChoice]);
                
                card[randomChoice] = null;
                
                break;
            }

        }
                
        return returnedCard;
    }
        
    public void set_player()
    {
       
        String Name;
        for (int i = 0; i < 3; i++) {
            
        System.out.println("Enter player " + (i + 1) + " name.");
        
          player[i] = new Player();
          player[i].Name = input.next();
          player[i].setOneCard(random());
          player[i].setOneCard(random());
        }
           
    }
    
    public void set_dealar()
    {
        player[3] = new Player();
        player[3].Name = "Dealer";
        player[3].setOneCard(random());
        player[3].setOneCard(random());
        
       
    }
    
    public void updateScores()
    {
        for (int i = 0; i < 4; i++) {
            if(player[i].getScore() <= 21)
           
               highScores[i] = player[i].getScore();
            
            else
                highScores[i] = 0;
                
        }
    }
 
}

