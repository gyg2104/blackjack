/**
 * Card class for blackjack
 * @author gracie gilbert
 *github: gyg2104
 */

public class Card {
	private int suit; //suit repped by #s
	private int value; //how much the card is number wise, 1(ace)-13(king)


	public Card(int suit, int value){
		this.suit = suit;
		this.value = value;

	}

	/**
	 * Returns the name of the card's suit
	 * @return suitString
	 */
	public String getCardSuitName(){
		String suitString;
		switch(suit){
		case 0:
			suitString = "Diamonds";
			break;
		case 1:
			suitString = "Clubs";
			break;
		case 2:
			suitString = "Spades";
			break;
		case 3:
			suitString = "Hearts";
			break;
		default: 
			suitString = "Invalid Suit";
			break;

		}
		return suitString;
	}

	/**
	 * Returns the point value of the card 
	 * @return value
	 */
	public int getCardPValue(){
		int pointVal;
		switch(value){
		/*aces are worth 11 pts - the swinging point value
		will be adjusted for in the NAME class rather than here */
		case 1:
			pointVal = 11;
			break;
		//jacks, queens, kings are all worth 10 pts
		case 11:
		case 12:
		case 13:
			pointVal = 10;
			break;
		//otherwise, the card's pt value is worth the value on the card
		default:
			pointVal = value;
			break;
		}
		
		return pointVal;
	}

	/**
	 * Returns the name of the card's face name, i.e.
	 * if the card is a King, Jack, 2, 3, etc
	 * @return cardFaceName
	 */
	public String getCardFaceName(){
		String cardFaceName;
		switch(value){
		case 1:
			cardFaceName = "Ace";
			break;
		case 11:
			cardFaceName = "Jack";
			break;
		case 12:
			cardFaceName = "Queen";
			break;
		case 13:
			cardFaceName = "King";
			break;
		default:
			cardFaceName = ""+value;
			break;

		}
		return cardFaceName;
	}

	/**
	 * returns the actual value of the card, not the point value
	 * @return value
	 */
	public int getCardActualValue(){
		return value;
	}

	public String toString(){
		return getCardFaceName()+" of "+getCardSuitName();
	}

}
