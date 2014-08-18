import java.util.*;
/**
 * Player class for blackjack
 * @author gracie gilbert
 *github: gyg2104
 */
public class Player {
	private ArrayList<Card> hand;

	private Deck deck;
	private boolean containsFullValuedAce; //whether the hand has an ace @ full value
	private int numberAces; //number of aces in a hand being counted as an ace
	private int handTotal; //total of all card pt values in a hand


	public Player(Deck deck){
		hand = new ArrayList<Card>();
		
		this.deck = deck;
		containsFullValuedAce = false;
		numberAces = 0;
		handTotal = 0;
	}

	/**
	 * Adds a card to player's hand
	 * and adjusts the hand total 
	 */
	public void addCard(){
		Card newCard = deck.dealCard();
		hand.add(newCard);

		//check to see if we are adding an ace
		if(newCard.getCardActualValue() == 1){
			//if so, then mark that we are adding a new ace of pt value 11
			//(note that in blackjack, sometimes aces are worth 1 pt if an 11 pt
			//forces hand to go over 21 limit)
			containsFullValuedAce = true;
			numberAces++;
		}

		//add the pt value to hand total
		handTotal += newCard.getCardPValue();
	}
	
	/**
	 * Returns the player's full hand
	 * @return hand
	 */
	public ArrayList<Card> getHand(){
		return hand;
	}

	/**
	 * Returns the total of the card's pt values in a hand
	 * @return
	 */
	public int getHandTotal(){

		/*before returning the hand total,
		 * adjust handTotal if the hand has an ace in it
		 * and is also currently causing player to go over 21
		 */
		if(handTotal > 21 && containsFullValuedAce == true){
			handTotal -= 10;
			//then note that this ace is no longer considered a full value ace
			if(numberAces > 1){
				numberAces--;
			}
			else{
				numberAces--;
				containsFullValuedAce = false;
			}
		}

		return handTotal;
	}

	/**
	 * Discards all cards from player's hand
	 */
	public void clearHand(){
		hand.clear();
		handTotal = 0;
	}


	/**
	 * Prints player's hand
	 */
	public void printHand(){
		int i = 0;
		System.out.println("Your Hand Is:");
		
		for(Card c : hand){
			i++;
			System.out.println("Card "+i+": "+c.toString());

		}
		System.out.println("Hand total is "+ getHandTotal());
	}

}
