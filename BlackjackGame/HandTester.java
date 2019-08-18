
import java.util.ArrayList;
public class HandTester
{  

    /** Tests behavior and state of the Hand class:
    *   Tests for two random one card hands and their behavior/states
    *   Tests for a blackjack hand and its behavior and state 
    *   Tests for a bust hand and its behavior and state
    */
    
    public static void main (String[] args)
    {
    
        
        Hand h=new Hand();
        Deck d=new Deck();
        System.out.println("General, random one card hand tests: "); 
        ArrayList<Card> ds = d.getDeck(); 
        System.out.println(h.drawCard(ds.get(3))); //gets a random card and prints out its valeue
        System.out.println(h.getPrint()); //should print ""
        System.out.println(h.evalHand()); //should print out the value of the random card
        h.reset(); //testing if it gets rid of all the cards in the hand
        System.out.println(h.getPrint()); //should print ""
        System.out.println(h.evalHand()); //should print 0 because there should be no cards in a reset hand
        System.out.println(h.drawCard(ds.get(14))); //gets a random card and prints out its value.   
        System.out.println(h.getPrint()); //should print ""
        System.out.println(h.evalHand()); //should print the value of the card
        h.reset(); //testing if it gets rid of all the cards in the hand
        System.out.println(h.getPrint()); //should print ""
        System.out.println(h.evalHand()); //should print 0 because there should be no cards in a reset hand
        
        System.out.println("Test for blackjack hand: ");
        Card c1 = new Card(1);
        Card c2 = new Card(41); 
        System.out.println(h.drawCard(c1)); //gets an ace of spades and prints 11
        System.out.println(h.drawCard(c2)); //gets an jack of spades and prints 10
        System.out.println(h.getPrint()); //should print "Blackjack"
        System.out.println(h.evalHand()); //should print 21
        h.reset(); //testing if it gets rid of all the cards in the hand
        System.out.println(h.getPrint()); //should print ""
        System.out.println(h.evalHand()); //should print 0 because there should be no cards in a reset hand
        
        System.out.println("Test for Bust: "); 
        for (int i = 0; i<25; i++)
        {
        h.drawCard(ds.get(i)); // fills the hand with 25 cards, so automatic bust
        }
        
        System.out.println(h.getPrint()); //should print "Bust"
        System.out.println(h.evalHand()); //should print a value greater than 21
        h.reset(); //testing if it gets rid of all the cards in the hand
        System.out.println(h.getPrint()); //should print ""
        System.out.println(h.evalHand()); //should print 0 because there should be no cards in a reset hand
        
        System.out.println("Test success! (hopefully)"); // :)
        
        
    } 
}