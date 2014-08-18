import java.util.*;
/**
 * Dealer class for blackjack
 * @author gracie gilbert
 *github: gyg2104
 */
public class Dealer extends Player {
		
	public Dealer(Deck deck){
		super(deck);
			
	}
	
	
	public void showFirstCard(){
		System.out.println("Dealer's first card: " + getHand().get(0).toString());	
	}
	
	/**
	 * Simple way of deciding whether or not to hit for the dealer
	 * Later I will come back to make more sophisticated way
	 * @return hit
	 */
	public boolean shouldHit(){
		boolean hit;
		if(getHandTotal() > 16){
			hit = false;
		}
		else{
			hit = true;
		}
		return hit;
	}
	
	/**
	 * Overrides player's print hand method to specify that it is the dealer's hand
	 */
	public void printHand(){
		ArrayList<Card> hand = new ArrayList<Card>();
		hand = getHand();
		int i = 0;
		System.out.println("Dealer's Hand Is:");
		
		for(Card c : hand){
			i++;
			System.out.println("Card "+i+": "+c.toString());

		}
		System.out.println("Hand total is "+ getHandTotal());
	}
	
	
}
