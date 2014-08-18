import java.util.Scanner;
/**
 * Game class for blackjack
 * @author gracie gilbert
 *github: gyg2104
 */

public class Game {

	private Player player;
	private Dealer dealer;

	private Scanner scan;
	private boolean continueHit;
	private boolean continueDealerHit;



	public Game(Player p1, Dealer d1){
		player = p1;
		dealer = d1;
		scan = new Scanner(System.in);
		continueHit = true;
		continueDealerHit = true;

	}
	public void playGame(){
		initializeGame();
		continueGame();
	}

	/**
	 * adds 2 cards to user's and dealer's hands
	 * before the user plays, they can only
	 * see one of the dealer's cards
	 */
	public void initializeGame(){
		System.out.println("Starting new game");
	
		player.clearHand();
		dealer.clearHand();
		player.addCard();
		dealer.addCard();
		player.addCard();
		dealer.addCard();
		player.printHand();
		dealer.showFirstCard();

	}
	
	/**
	 * This does the actual gameplay
	 * in which first, the player tries their luck
	 * and then the results of the dealer's attempts are shown
	 */
	public void continueGame(){
		
		while(continueHit && player.getHandTotal() < 21){
			playerPlay();
			if(continueHit)
				player.printHand();
			
		}
		System.out.println("--- Dealer's turn ---");
		
		while(continueDealerHit && dealer.getHandTotal() < 21){
			dealerPlay();
		}
		
		dealer.printHand();
		
		System.out.println("Dealer's total was "+ dealer.getHandTotal());
		
		//figure out the winner, and display to user
		int winner = findWinner();
		String winMessage;
		switch(winner){
		case 0:
			winMessage = "It was a tie";
			break;
		case 1:
			winMessage = "You won";
			break;
		case 2:
			winMessage = "Dealer won";
			break;
		default:
			winMessage = "Invalid Winner";
			break;
		}
		System.out.println(winMessage);
	}
	
	/**
	 * If the user wants to stay, don't add cards, else add a card
	 */
	public void playerPlay(){

		boolean hitMe = hitOrStay();
		if(hitMe){
			player.addCard();
		}
		else{
			continueHit = false;
		}
	}

	/**
	 * Dealer decides whether to hit or stay
	 */
	public void dealerPlay(){
		boolean hitMe = dealer.shouldHit();
		if(hitMe){
			dealer.addCard();
		}
		else{
			continueDealerHit = false;
		}
	}

	/**
	 * Asks user to choose whether to hit or stay
	 * and returns their choice
	 * @return hit
	 */
	public boolean hitOrStay(){
		boolean hit;
		String h = "H";
		String s = "S";
		System.out.println("Press H to hit, S to Stay");
		String response = scan.nextLine();
		System.out.println(response);
		while(!(response.equals(h)||(response.equals(s)))){
			System.out.println("Invalid response, please try again");
			response = scan.nextLine();
		}
		if(response.equals("H")){
			hit = true;
		}
		else{
			
			hit = false;
		}
		return hit;
	}

	/**
	 * Figures out who won, and returns
	 * an int that represents which 
	 * 
	 */
	public int findWinner(){
		int playerTotal = player.getHandTotal();
		int dealerTotal = dealer.getHandTotal();
	
		if((playerTotal > 21 && dealerTotal > 21) || (playerTotal == dealerTotal)){
			
			return 0; //tie
		}
		else if(dealerTotal > 21){
			return 1; //player won
		}
		else if(playerTotal > 21){
			return 2; //dealer won
		}
		else if(playerTotal > dealerTotal){
			return 1; //player won
		}
		else{
			return 2; //dealer won
		}
		
	}
	

}
