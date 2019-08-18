import java.util.Scanner;
import java.lang.Integer;
public class Game 
{
    private static Player p; 
    private static Dealer d;
    private static Scanner sc=new Scanner(System.in);
    /**
     * Creates the player and dealer, while maintaing that the shoe is shuffled, in between hands, when falls below 75 cards. Also asks the player how many chips they are betting, then starts the round, dealing the cards and displaying them. Calls the method playerTurn(), and after each separate round checks the players chips then asks them if they would like the be finished or continue to another round.
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */ 
    public static void main(String [] args)
    {    
        p=new Player();
        d=new Dealer();
        boolean go = true; 
        while(go&&p.getChip()>0)
        {

            if((d.getShoe()).getNumCardsInShoe()<75)
            {
                (d.getShoe()).shuffleShoe(); 
            }
            /*while(bet%10!=0 && bet>0)
            {
            System.out.println("How many chips are you betting?"); 
            bet = Integer.parseInt(sc.next());
            p.betChange(bet); 

            }*/
            p.getHand().reset();
            d.getHand().reset();
            d.start(p); 
            playerTurn(p, d); 
            String ans=""; 

            while(!ans.equals("yes")&&!ans.equals("no")&&p.getChip()>0)
            {
                System.out.println("Would you like to play another round?(yes/no)");
                ans = sc.next(); 
            }
            go = (ans.equals("yes"))? true: false;         

        }
        System.out.println("The player ended with "+p.getChip());
    }

    
    /**
     * Ask for, and checks the players bet, and checks the value of their cards, follows the players directions  and pays the winner the appropriate number of chips
     * if the player wins with blackjack they get their bet plus 1.5x their bet.
     * 
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */ 
    public static void playerTurn(Player p, Dealer d)
    {
        String anotherPCard="";
        System.out.println("You have "+p.getChip()+" chips");
        System.out.println("How much would you like to bet? (has to be a multiple of 10)");
        int bet=sc.nextInt();
        p.betChange(bet);
        while(p.getBet()==0){
            System.out.println("This is not a valid bet. The bet has to be positive and a multiple of 10. Please enter your bet.");
            bet=sc.nextInt();
            p.betChange(bet);
        }
        System.out.println("Your hand contains: " +p.getHand().getCards().get(0).toString()+", " +p.getHand().getCards().get(1).toString());
        System.out.println("Your total is: "+p.getHand().evalHand());
        System.out.println("The dealer is showing: "+d.getHand().getCards().get(1).toString());
        if(p.getHand().evalHand()==21){ 
            if(d.getHand().evalHand()==21){
                System.out.println("The dealer's up-card is a "+d.getHand().getCards().get(1).toString());
                System.out.println("The dealer's hole-card is a "+d.getHand().getCards().get(0).toString());
                System.out.println("You and the dealer both have blackjack! The game is a push and you get your chips back");

                bet=p.getBet();
                p.betReset(true);
                p.betChange(bet);
                p.betReset(true);
                p.betChange(bet*3);
                p.betReset(false);
                return;
            }
            System.out.println("The dealer's up-card is a "+d.getHand().getCards().get(1).toString());
            p.betReset(true);
            System.out.println("You have blackjack! You have gained "+bet*1.5+" chips and now have "+p.getChip()+" chips");
            return;
        }
        if(d.getHand().getCards().get(1).getCardValue()==10){
            if(d.getHand().evalHand()==21){
                System.out.println("The dealer's up-card is a "+d.getHand().getCards().get(1).toString());
                System.out.println("The dealer's hole-card is a "+d.getHand().getCards().get(0).toString());
                System.out.println("The dealer has blackjack!");
                System.out.println("You have lost "+p.getBet()+" chips");
                p.betReset(false);
                System.out.println("You now have "+p.getChip()+" chips");
                return;
            }
        }

        System.out.println("Would you like to hit, stand, or double down? Enter h, s, or d.");
        String u=sc.next();
        while(true){
            while(!u.equals("h")&&!u.equals("s")&&!u.equals("d")){ 
                System.out.println("Invalid answer");
                System.out.println("Enter h for hit, s for stand, and d for double down");
                u=sc.next();
            }
            if(u.equals("h")){
                System.out.println("You got a "+d.hit(p).toString());

                System.out.print("Now the player has ");     
                for (int i =0; i<p.getHand().getCards().size(); i++)
                {
                    anotherPCard = (i!=p.getHand().getCards().size()-1)? ""+p.getHand().getCards().get(i)+" and ": ""+p.getHand().getCards().get(i).toString();
                    System.out.print(anotherPCard); 
                }
                System.out.println();

                if(p.getHand().evalHand()>21){             
                    System.out.println("Your card total is "+p.getHand().evalHand()+" and you bust");
                    System.out.println("You have lost "+p.getBet()+" chips");
                    p.betReset(false);
                    System.out.println("You now have "+p.getChip()+" chips");
                    return;         
                }
                System.out.println("Your card total is now "+p.getHand().evalHand());           
                System.out.println("Would you like to hit, stand, or double down? Enter h, s, or d.");
                u=sc.next();
            }
            if(u.equals("s")){
                System.out.println("The play goes to the dealer's turn\n");
                dealerTurn(p,d);
                return;
            }
            if(u.equals("d")){ 
                if(p.getBet()*2<=p.getChip()){
                    p.betChange(p.getBet());
                    System.out.println("Your bet has changed to "+p.getBet());
                    System.out.println("You got a "+d.hit(p).toString());
                    System.out.print("Now the player has ");     
                    for (int i =0; i<p.getHand().getCards().size(); i++)
                    {
                        anotherPCard = (i!=p.getHand().getCards().size()-1)? ""+p.getHand().getCards().get(i)+" and ": " "+p.getHand().getCards().get(i).toString();
                        System.out.print(anotherPCard); 
                    }
                    System.out.println();
                    if(p.getHand().evalHand()>21){             
                        System.out.println("Your card total is "+p.getHand().evalHand()+" and you bust");
                        System.out.println("You have lost "+p.getBet()+" chips");
                        p.betReset(false);
                        System.out.println("You now have "+p.getChip()+" chips");
                        return;           
                    }
                    System.out.println("Your card total is now "+p.getHand().evalHand());
                    System.out.println("The play goes to the dealer's turn\n");
                    dealerTurn(p,d);
                    return;
                } else {
                    System.out.println("You don't have enough chips to double down.");
                    System.out.println("Would you like to hit, stand, or double down? Enter h, s, or d.");
                    u=sc.next();
                }
            }
        }
    }

    
    /** 
     * Shows dealers cards, hits if less than 16, shows dealers new card 
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */ 

    public static void dealerTurn(Player p, Dealer d)
    {
        boolean blackjack = (d.getHand().evalHand()==21)? true: false; 
        int total = d.getHand().evalHand();
        int bet;
        System.out.println("The dealer's hole card is "+d.getHand().getCards().get(0)+" and also has "+d.getHand().getCards().get(1));  
        String anotherDCard;
        while (total<=16)
        {

            System.out.println("The dealer took a hit"); 

            d.hit(d);
            System.out.print("Now the dealer has "); 
            for (int i =0; i<d.getHand().getCards().size(); i++)
            {
                anotherDCard = (i!=d.getHand().getCards().size()-1)? ""+d.getHand().getCards().get(i)+" and ": " "+d.getHand().getCards().get(i).toString();
                System.out.print(anotherDCard); 
            }
            System.out.println();

            total =  d.getHand().evalHand();
            System.out.println("The dealer total is "+total);
        }

        System.out.println("End of round: ");

        System.out.print("Now the dealer has "); 
        for (int i =0; i<d.getHand().getCards().size(); i++)
        {
            anotherDCard = (i!=d.getHand().getCards().size()-1)? ""+d.getHand().getCards().get(i)+" and ": ""+d.getHand().getCards().get(i).toString();
            System.out.print(anotherDCard); 
        }
        System.out.println();
        System.out.println("The player's hand has a value of "+p.getHand().evalHand()); 
        System.out.println("The dealer's hand has a value of "+d.getHand().evalHand());

        if(blackjack)
        {
            System.out.println("The dealer won! The dealer had a blackjack!");
            p.betReset(false);
        }
        if(d.getHand().evalHand()>21){
            System.out.println("The dealer busted! The player automatically wins!");
            p.betReset(true);

        }
        else if (d.getHand().evalHand()==p.getHand().evalHand())
        {
            System.out.println("You and the dealer both have a total of "+d.getHand().evalHand());
            System.out.println("The game becomes a push and you get your chips back");
            bet=p.getBet();
            p.betReset(true);
            p.betChange(bet);
            p.betReset(false);
            return;
        }
        else 
        {
            if(d.getHand().evalHand()<p.getHand().evalHand())
            {
                System.out.println("The player won the game because their hand was "+(p.getHand().evalHand()-d.getHand().evalHand())+" points closer to 21 than the hand of the dealer");
                p.betReset(true);
            }
            else
            {
                System.out.println("The dealer won the game because their hand was "+(d.getHand().evalHand()-p.getHand().evalHand())+" points closer to 21 than the hand of the dealer");
                p.betReset(false);
            }

        }

        System.out.println("Now you have "+p.getChip()+" chips.");

    }

}

    
    
/*
public void betReset(boolean win){
if(win){
if((this.getHand()).evalHand()==21&&this.getHand().getCards().size()==2){
chips+=bet*1.5;
bet=0;
}  
else{
chips+=bet;
}      
}
else{
chips-=bet;
}
bet=0;
}
 */    

    