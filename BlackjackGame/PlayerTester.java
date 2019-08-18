public class PlayerTester{
  
  
  public static void main(String[] args)
  {
    
    Player p = new Player(); 
    Hand h = p.getHand(); 
    Card c = new Card(0);
    System.out.println(h.drawCard(c)); //should be 0
    System.out.println(p.getBet()); //should be 0
    System.out.println(p.getChip()); //should be 1000   
        p.betChange(9000); //doesn't do anything
    System.out.println(p.getBet()); //should print out 0
        p.betChange(100); //adds 100 to bet
    System.out.println(p.getBet()); //should be 100
    System.out.println(p.getChip()); //should be 1000
    p.doubleDown(); //doubles bet
    System.out.println(p.getBet()); //should be 200
    System.out.println(p.getChip()); //should be 1000
    p.betReset(false); //bet becomes 0 and chips lose 200
    System.out.println(p.getBet()); //should be 0
    System.out.println(p.getChip()); //should be 800
    p.betChange(100); //bet becomes 100
    p.betReset(true); //bet becomes 0 and 100 is added to chips
    System.out.println(p.getBet()); //should be 0
    System.out.println(p.getChip()); //should be 1100
    p.betChange(-100); // should not work due to being a negative bet 
    System.out.println(p.getBet());  //should be 0
    System.out.println(p.getChip()); //should be 900
    p.betReset(true); //does nothing
    p.betChange(17);  //should not do anything due to not being a multiple of 10
    System.out.println(p.getBet()); //should print 0
    p.betReset(true); //does nothing
    System.out.println(p.getChip()); //should be 900
    
    p.betChange(40); //adds 40 to bet
    p.getHand().reset(); 
    p.getHand().drawCard(new Card(2)); //ace of diamonds 
    p.getHand().drawCard(new Card(45)); //queen of spades 
    p.betReset(true); //blackjack (bet*1.5 is gained)
    System.out.println(p.getChip());
  }

}
