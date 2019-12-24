import java.util.Scanner;
import java.util.Random;
public class War {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String player1 = "";
		
		System.out.println("//////////////////////------------------------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\-----------Welcome!-----------//////////////////////");
		System.out.println("//////////////////////--------To Game Of War!-------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\------------------------------//////////////////////");

		System.out.println("   _____ "  + "   _____  "    + "   ------------------------------  " + "   _____   "  + "  _____  ");
		System.out.println("  |A .  |"  + "  |A ^  |  "   + "  ------------------------------  "  + "  |A _  |  "  + " |A_ _ |  ");
		System.out.println("  | /.\\ |" + "  | / \\ |  "  + "  ------------------------------  "  + "  | ( ) |  "  + " |( v )|  ");
		System.out.println("  |(_._)|"  + "  | \\ / |  "  + "  -----Staring money is 50!-----  "  + "  |(_'_)|  "  + " | \\ / |  ");
		System.out.println("  |  |  |"  + "  |  .  |  "   + "  ------------------------------  "  + "  |  |  |  "  + " |  .  |  ");
		System.out.println("  |____V|"  + "  |____V|  "   + "  ------What is your name?------  "  + "  |____V|  "  + " |____V|  ");
		System.out.println();
		
		System.out.print("Name:");
		player1 = scan.next();
		
		System.out.println("Hello " + player1 + " how many players playing? between 1 and 2");
		int playerNum = scan.nextInt();
		if(playerNum == 2) {
			System.out.println(gameForTwo());
		}
		else {
			System.out.println(gameForOne());
		}
		scan.close();
	}	
	
/*
 * Game For Two Players	
 */
	public static String gameForTwo() {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
			
		final int STARTING_MONEY = 50;
		final int MIN_BET = 1;
		String player1 = "";
		String player2 = "";
		int bet1 = 0;
		int bet2 = 0;
		int money1 = 0;
		int money2 = 0;
		int roundNumber = 1;
		boolean game = true; 
		boolean round = true;
		
		System.out.println("Player number 2 please enter your name");
		System.out.print("Name: ");
		player2 = scan.next();
		System.out.println("Players! Have fun!");
		System.out.println("\nWelcome to the game of war " + player1 + " and " + player2);
		System.out.println("You each start with 50 bucks");	
		money1 = STARTING_MONEY;
		money2 = STARTING_MONEY;
			
		System.out.println("Place your bets for your first round: 1 to 50");
		System.out.println("\nDon't even try betting more than you have or even nothing!");
		System.out.print("What's your bet " + player1 + "?");
		bet1 = scan.nextInt();
		System.out.print("\nWhat's your bet " + player2 + "?");
		bet2 = scan.nextInt();
			
		if((bet1 > STARTING_MONEY)||(bet1 < MIN_BET)||(bet2 > STARTING_MONEY)||(bet2 < MIN_BET)){
			System.out.print("I just told you BETWEEN 1 to 50");
			System.out.println("And one of you tried to bet not as I told");
			System.out.println("Now I don't even want to play with you!!! Bye");
			game = false;
		}
		
		while((game == true)&&(round == true)){
			char cardType1 = getCardSuit();
			char cardType2 = getCardSuit();
				
			int player1Card = r.nextInt(12)+1;
			int player2Card = r.nextInt(12)+1;
				
			System.out.println("//////////---------------------Our Deck---------------------\\\\\\\\\\\\\\\\\\\\");
			// A little delay so that the game will be a bit more playable 
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException ex){												
			}
			System.out.println("Round number: " + roundNumber);
			System.out.println("Are you ready?");
			try {
				Thread.sleep(1500);
			}
			catch (InterruptedException ex){												
			}
			System.out.println();
			System.out.println(player1 + "'s card is: " + player1Card + cardType1 + " And " + player2 +"'s is: " + player2Card + cardType2);
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException ex){											
			}
			System.out.println();
			System.out.println("//////////-------------And now for the results!-------------\\\\\\\\\\\\\\\\\\\\");
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException ex){												
			}
			System.out.println();
	
			if(player1Card > player2Card){
				System.out.println(player1 + " Won!");
				money1 = money1 + bet2;
				money2 = money2 - bet2;
				System.out.println(player1 + " gained " + bet2 + " And now he has " + money1);
				System.out.println("While " + player2 + " lost " + bet2 + " and now he has " + money2);
				System.out.println();
			} 
			else if(player2Card > player1Card){
				System.out.println(player2 + " Won!");
				money2 = money2 + bet1;
				money1 = money1 - bet1;
				System.out.println(player2 + " gained " + bet1 + " And now he has " + money2);
				System.out.println("While " + player1 + " lost " + bet1 + " and now he has " + money1);
				System.out.println();
			}
			else{
				System.out.println("It is a draw!");
				System.out.println("Let's have one more round");
				System.out.println();
			}
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException ex){							
			}
			if((money1 > 0)&&(money2 > 0)){
				System.out.println("//////////--You ain't broke yet, so what will it be?--\\\\\\\\\\\\\\\\\\\\");
				System.out.println();
				System.out.println("1. Play another round");
				System.out.println("2. Leave with the money :-)");
				int choice = scan.nextInt();
					if(choice == 1){
						round = true;
						System.out.print("What's your bet " + player1 + "?" + " (money left: " + money1 + ")");
						bet1 = scan.nextInt();
						if(bet1 > money1){
							System.out.println("Try again, you can't bet more than you have!");
							bet1 = scan.nextInt();
						}
						System.out.print("\nWhat's your bet " + player2 + "?" + " (money left: " + money2 + ")");
						bet2 = scan.nextInt();	
						if(bet2 > money2){
							System.out.println("Try again, you can't bet more than you have!");
							bet2 = scan.nextInt();
						}
						roundNumber++;
					}
					else{
						round = false;
						System.out.println("//////////-----I see you chose to run away----\\\\\\\\\\\\\\\\\\\\");
						System.out.println();
						System.out.println(player1 + " made it out with: " + money1);
						System.out.println();
						System.out.println("And " + player2 + " made it out with: " + money2);
						System.out.println("After you played for " + roundNumber + " rounds.");
						System.out.println();
					}
			}
			else if((money1 <= 0)||(money2 <= 0)){
				game = false;
				System.out.println("//////////------Ow no you got no more to bet on-------\\\\\\\\\\\\\\\\\\\\");
				System.out.println();
				System.out.println("We played for " + roundNumber + " rounds!");
				if(money1 > money2) {
					System.out.println("And the winner is: " + player1 + "!");
				}
				else if(money2 > money1) {
					System.out.println("And the winner is: " + player2 + "!");
				}
				System.out.println("I guess you better have more luck next time... Bye Bye!");
				System.out.println();
			}
		}
			
		scan.close();
		String end = "//////////----------------END GAME----------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\";
		return end;
	}
		
/*
 * Game For One Player	
 */
	public static String gameForOne() {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
			
		final int STARTING_MONEY = 50;
		final int MIN_BET = 1;
		String player1 = "";
		int bet1 = 0;
		int money1 = 0;
		int roundNumber = 1;
		boolean game = true; 
		boolean round = true;
			
		System.out.println("I guess it's only you and me then :)");
		System.out.println("Welcome to the game of war " + player1);
		System.out.println("You start with 50 bucks");
		money1 = STARTING_MONEY;
					
		System.out.println("Place your bet for your first round: 1 to 50");
		System.out.println("\nDon't even try betting more than you have or even nothing!");
		bet1 = scan.nextInt();
		if((bet1 > STARTING_MONEY)||(bet1 < MIN_BET)){
			System.out.print("I just told you BETWEEN 1 to 50 ");
			System.out.println("And you tried to bet " + bet1);
			System.out.println("Now I don't even want to play with you!!! Bye");
			game = false;
		}
		while((game == true)&&(round == true)){
			char cardType1 = getCardSuit();
			char cardType2 = getCardSuit();
				
			int playerCard = r.nextInt(12)+1;
			int pcCard = r.nextInt(12)+1;
				
			System.out.println("//////////---------------------Our Deck---------------------\\\\\\\\\\\\\\\\\\\\");
			// A little delay so that the game will be a bit more playable 
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException ex){												
			}
			System.out.println("Round number: " + roundNumber);
			System.out.println("Are you ready?");
			try {
				Thread.sleep(1500);
			}
			catch (InterruptedException ex){												
			}
			System.out.println();
			System.out.println("Your card is " + playerCard + cardType1 + " And my card is " + pcCard + cardType2);
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException ex){											
			}
			System.out.println();
			System.out.println("//////////-------------And now for the results!-------------\\\\\\\\\\\\\\\\\\\\");
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException ex){												
			}
			System.out.println();
	
			if(playerCard > pcCard){
				System.out.println("You Won!");
				money1 = money1 + bet1;
				System.out.println("You gained " + bet1 + " And now you have " + money1);
				System.out.println();
			} 
			else if(pcCard > playerCard){
				System.out.println("You Lost!");
				money1 = money1 - bet1;
				System.out.println("You lost " + bet1 + " And now you have " + money1);
				System.out.println();
			}
			else{
				System.out.println("It is a draw!");
				System.out.println("Let's have one more round");
				System.out.println();
			}
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException ex){							
			}
			if(money1 != 0){
				System.out.println("//////////--You ain't broke yet, so what will it be?--\\\\\\\\\\\\\\\\\\\\");
				System.out.println();
				System.out.println("1. Play another round");
				System.out.println("2. Leave with my money :-)");
				int choice = scan.nextInt();
					if(choice == 1){
						round = true;
						System.out.println("Please enter your new bet" + " (money left: " + money1 + ")");
						bet1 = scan.nextInt();
						if(bet1 > money1){
							System.out.println("Try again, you can't bet more than you have!");
							bet1 = scan.nextInt();
						}
						roundNumber++;
					}
					else{
						round = false;
						System.out.println("//////////-----I see you chose to run away----\\\\\\\\\\\\\\\\\\\\");
						System.out.println();
						System.out.println("At least you made it out with: " + money1);
						System.out.println("After we played for " + roundNumber + " rounds.");
						System.out.println();
					}
			}
			else if(money1 == 0){
				game = false;
				System.out.println("//////////------Ow no you got no more to bet on-------\\\\\\\\\\\\\\\\\\\\");
				System.out.println();
				System.out.println("We played for " + roundNumber + " rounds!");
				System.out.println("I guess you better have more luck next time... Bye Bye!");
				System.out.println();
			}
		}
		scan.close();
		String end = "//////////----------------END GAME----------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\";
		return end;		
	}
		
	public static char getCardSuit(){
		Random r = new Random();
		int cardSuitNum = r.nextInt(4)+1;
		char cardType =  ' ';
		switch(cardSuitNum) {
			case 1: cardType = '\u2660';
					break;
			case 2: cardType = '\u2663';
					break;
			case 3: cardType = '\u2665';
					break;
			case 4: cardType = '\u2666';
					break;
		}
		return cardType;	
	}
}
