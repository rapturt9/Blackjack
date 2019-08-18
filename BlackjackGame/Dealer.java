public class Dealer{
    private Hand h;
    private Shoe s;
    /**
     * Instantiates h and s so that Shoe has between 4 and 7 decks randomly
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */ 
    public Dealer () {
        h=new Hand();
        s=new Shoe((int) (Math.random()*4)+4);
    }
    /**
     * Returns hand
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */ 
    public Hand getHand() {
        return h;
    }
    /**
     * Gives a card from s to the hand of dealer
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */ 
    public Card hit(Dealer d) {
        Card c=s.dealCard();
        h.drawCard(c);
        return c;
    }
    /**
     * Gives a card from s to the hand of player
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */ 
    public Card hit(Player p) {
        Card c=s.dealCard();
        p.getHand().drawCard(c);
        return c;
    }
    /**
     * Adds a card to the players hand, then to the 
     * dealers, then to player, then to dealer.
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */ 
    public void start(Player p) {
        hit(p);
        hit(this);
        hit(p);
        hit(this);
    }
    /**
     * Returns the shoe
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */ 
    public Shoe getShoe() {
        return s;
    }




}

