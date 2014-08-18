import java.util.Scanner;

public class Tester {

	public static void main(String[] args){
		Deck deck = new Deck();
		deck.buildDeck();
		deck.shuffleDeck();
		
		Player player = new Player(deck);
		Dealer dealer = new Dealer(deck);
		Scanner scan = new Scanner(System.in);
		boolean cont = true;
		while(cont){
			Game g = new Game(player, dealer);
			g.playGame();
			System.out.println("Play again? y for yes, any other char to quit");
			String playAgain = scan.nextLine();
			if(playAgain.equals("y")){
				cont = true;
			}
			else{
				
				cont = false; 
			}
		}
		
		
	}
	
}
