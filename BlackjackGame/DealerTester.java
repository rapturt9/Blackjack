public class DealerTester{

public static void main(String[]args)
{

    Dealer d=new Dealer(); // creates dealer
    Hand h = d.getHand(); // returns its hand
    System.out.println(h.drawCard(new Card(1))); // should print the value of 11
    System.out.println((d.getHand()).evalHand()); 
    System.out.println(d.hit(d).getCardValue()); // gives a card to the dealer's hand and returns its value
    System.out.println((d.getHand()).evalHand()); // should print a value greater than its previous evalHand value due to having been hit
    Player p = new Player();// creates player
    System.out.println((p.getHand()).evalHand()); // should print 0
    System.out.println((d.hit(p)).getCardValue()); // gives the player a card and returns its value
    System.out.println((p.getHand()).evalHand()); //evaluates the players hand after the player receives a hit, so should be greater than the player's previous eval hand
    Player p2 = new Player(); 
    Dealer d2 = new Dealer(); 
    System.out.println((p2.getHand()).evalHand());// should print out 0
    System.out.println((d2.getHand()).evalHand());// should print out 0
    d2.start(p2); // gives the player a card, then gives dealer a card, in that order twice
    
    System.out.println((p2.getHand()).evalHand()); // should print a value much greater than p2's evalHand upon instantiation
    System.out.println((d2.getHand()).evalHand()); // should print a value much greater than d2's evalHand upon instantiation 
    System.out.println((d2.getShoe()).getNumCardsInShoe()); // prints out the number of cards in the shoe 
    for(int i=0; i<25; i++)
    {
    System.out.println("\n"); 
   
    } // prints new lines for prettier formatting 
    (d2.getShoe()).printShoe(); // prints out all the cards in the dealer's shoe 
}



}