import java.util.*;
/**
 * Deck class for blackjack
 * @author gracie gilbert
 *github: gyg2104
 */
public class Deck {

	private ArrayList<Card> fullDeck;
	
	public Deck(){
		fullDeck = new ArrayList<Card>();
		
	}
	
	/**
	 * Creates a standard deck with 4 suits and 12 values for total 52 cards
	 */
	public void buildDeck(){
		
		for(int suit = 0; suit <= 3; suit++){
			for(int val = 1; val <= 13; val++){
				fullDeck.add(new Card(suit, val));
			}
		}
		
	}
	
	/**
	 * removes all cards from deck
	 */
	public void clearDeck(){
		fullDeck.clear();
	}
	
	/**
	 * Prints out the deck in whatever order it is currently in
	 */
	public void printDeck(){
		for(Card c : fullDeck){
			System.out.println(c.toString());
		}
	}
	
	/**
	 * shuffles the cards in an existing deck
	 */
	public void shuffleDeck(){
		Collections.shuffle(fullDeck);	
	}
	
	/**
	 * deals a card by removing from deck
	 * @return returnCard
	 */
	public Card dealCard(){
		if(fullDeck.isEmpty()){
			//really though this should throw an exception
			//but in blackjack this is impossible anyway
			System.out.println("Used up all cards; using new deck");
			buildDeck();
			shuffleDeck();
		}
		Card returnCard;
		returnCard = fullDeck.remove(0);
		return returnCard;
	}

}
