import java.util.ArrayList;
public class Hand
{
    private ArrayList<Card> cards;
    /**
     * Creates an ArrayList of cards. You can draw new
     * cards, get the value of the hand, get its status
     * (blackjack or bust), and also reset it.
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */  
    public Hand()
    {
        // initialise instance variables
        cards = new ArrayList<Card>(); 
        
    }
    
    /**
     * Adds a specified card to ArrayList cards.
     * @param - Card c, the card that will be put into cards
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */
    public int drawCard(Card c)
    {
        cards.add(c);
        return c.getCardValue();
    }
     /**
     * The number of points that the hand possesses will be calculated 
     * by going through the array list and calculating the sum 
     * of all the points that each card in the hand is deemed
     * in the card class from the getCardValue() method in the Card class  
     * Also, it goes through the hand and changes aces from a value of 11 
     * to 1 if the hand is a bust until it isn't a bust, but if it ends up being
     * a bust even with all aces converted to a value of 1, then the method just
     * returns the value 
     * @param - Card c, the card that will be put into cards
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */     
    public int evalHand()
    {
        int val=0;
        
        for(int i=0;i<cards.size();i++){
            if(cards.get(i).isAce()){
                val+=11;
                
            } else {
                val+=cards.get(i).getCardValue();
            }
        }
 
        for(int i = 0; i<cards.size(); i++)
        {
            if(cards.get(i).isAce())
            {
             if(val<=21){
                    return val;
                }
            cards.get(i).setAceToOne(true); 
            val-=10;
               
            
            }
        }
        
        return val;
    }
    
    /**
     * "deletes" all cards in the arrayList by 
     * setting the arraylist variable to a new 
     * arraylist
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */
    public void reset()
    {
        cards = new ArrayList<Card>();            
    }
    /**
     * Returns "Bust", "Blackjack", or ""
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */
    public String getPrint()
    {
        if(evalHand()==21){
            return "Blackjack";
        }
    
        else if(evalHand()>21){
        return "Bust";
        
        }
        return ""; 
        }
        /**
     * eturns the arraylist of cards
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */
    public ArrayList<Card> getCards()
    {
    return cards; 
    }
    
}