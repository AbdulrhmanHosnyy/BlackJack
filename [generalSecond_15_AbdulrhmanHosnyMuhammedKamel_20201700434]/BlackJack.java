
package blackjack;

import java.util.Scanner;

public class BlackJack {

    static Game game = new Game();
    
    public static void playerHitOrStand(GUI gui)
    {
        Scanner scanner = new Scanner(System.in);
                
        for (int i = 0; i < 3; i++) {
            
            int input = 0;

            while(true)
            {
                System.out.println("Player " + (i + 1) + " Your score is " + game.player[i].getScore() + " Click 1 to HIT or 2 to STAND");
                input = scanner.nextInt(); 
                if(input == 1)
                {
                    Card card = game.random();
                    game.player[i].setOneCard(card);
                    gui.updatePlayerHand(card , i);
                }
                else if(input == 2)
                    break;
                
            }
        }
    }
        
    public static void dealerHitOrStand(GUI gui)
    {
        boolean isDealer = true;
        int highScore = 0;
        
        for (int i = 0; i < 3; i++) {
            if(game.highScores[i] > highScore)
                highScore = game.highScores[i];
            if(game.highScores[i] >= game.player[3].getScore())
                isDealer = false;
        }
        if(game.player[3].getScore() == 21 && highScore == 21)
            isDealer = true;
        
        if(isDealer == false)
        {
            while(game.player[3].getScore() < highScore)
            {
                setOneCardToDealer(gui);
            }
            
        }
        else
            return;
       
    }

    public static void setOneCardToDealer(GUI gui)
    {
        Card card = game.random();
        game.player[3].setOneCard(card);
        gui.updateDealerHand(card, game.card);
        
    }
    
    public static void Winner()
    {
        int highest = 0;
        int winner = -1;
        int c = 0;
        
        for (int i = 0; i < 4; i++) {
            if(game.highScores[i] > highest)
            {
                highest = game.highScores[i];
                winner = i;
            }
        }
        for (int i = 0; i < 4; i++) {
            if(game.highScores[i] == highest)
                c++;
        }
        if(winner >= 0 && c == 1)
            System.out.println("THE WINNER IS : " + game.player[winner].Name + " with score = " + highest);
        else
            System.out.println("PUSH game");
    }
    public static void main(String[] args) {
        
        GUI gui = new GUI();
        
        game.card_deck();
        game.set_player();
        game.set_dealar();
        
        gui.runGUI(game.card,
                game.player[0].getCard(),
                game.player[1].getCard(),
                game.player[2].getCard(),
                game.player[3].getCard());
        
        playerHitOrStand(gui);
        
        game.updateScores();
        
        dealerHitOrStand(gui);
        
        game.updateScores();
        
        Winner();
        
        
            
    }
}
