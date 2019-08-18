import java.util.ArrayList;
public class Player {

private Hand h; 
private int chips; 
private int bet; 


    /**
     * Instantiates the apropriate instance variables
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */ 
     public Player(){
         chips=1000;
         h=new Hand();
         bet=0;
     }
     /** returns the players hand 
     * Returns hand
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */ 
     public Hand getHand(){
         return h;
     }
     /**
     * Changes how much the player has bet only if the 
     * change is positive and makes sure
     * that the bet works 
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */ 
     public void betChange(int b){
       if(b>=0)
       {
         
            if((bet+b)%10==0&&(bet+b)<=chips){
            bet+=b; 
         
       }
         
       }
     }
     /**
     * Resets the bet and either takes away chips or
     * gives chips to the player depending on whether or
     * not they won. If they won, check for blackjack and
     *if blackjack, gives the player 1.5*their bet else adds
     * just their bet amount to their chips.
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */ 
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
    /** checks the player chips to determine if they 
     * have enough to double their bet then draws them 
     * an additional card
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */ 
    public void doubleDown()
    {
        betChange(bet);
      
    }
    /**returns the value of the bet variable. 
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */ 
        public int getBet()
    {
      
      return bet; 
    }
    /** Returns the value of the chips variable
     * @param - none
     * @authors EAR (Edward Kang, Aidan Medina, Ram Potham)
     * @version February 2019
     */ 
    public int getChip()
    {
      return chips;
    } 




}
