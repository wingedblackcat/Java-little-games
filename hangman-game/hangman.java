import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class HangMan {

	public static void main(String[] args) {
		
		System.out.println(gameTurn());
	}
	
	//Gets nothing, and returns a String as the result of the game.
	public static String gameTurn() {
		Scanner scan = new Scanner(System.in);
		
		int guess = 10;
		boolean game = true;
		String[] randomWord = {"software","boy","magic","computer"};	
		String wordToGuess = randomWordArray(randomWord);
		String wordToPrint = wordToStarString(wordToGuess);
		String result = "";
		
		System.out.println("\t _" + "                                                       =========");
		System.out.println("\t| |" + "                                                       +---+");
		System.out.println("\t| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __" + "             |   |");
		System.out.println("\t| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\" + "            o   |");
		System.out.println("\t| | | | (_| | | | | ( | | | | | | | (_| | | | |" + "          /|\\  |");
		System.out.println("\t|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|" + "          / \\  |");
		System.out.println("\t                    __/ |" + "                                     |");
		System.out.println("\t                   |___/" + "                                 =========");
		
		System.out.println("\nWelcome player to a game of Hangman!");
		System.out.println("You have 10 tries to guess the right word," + " and save the stickman");
		System.out.println("Don't let the stickman die!");
		System.out.println("Good luck!");
		
		while(game) {
			System.out.println("\nWrong guesses left: " + guess);		
			System.out.println("Your word to guess is: " + wordToPrint);
			System.out.print("Enter you guess: ");
			
			String guessTry = scan.next();
			guessTry.toLowerCase();
			if (guessTry.equals(wordToGuess)) {
				System.out.println("You guessed the whole word!");
				System.out.println("You saved the stickman!!");
				game = false;
			}
			else {
				char charGuess = guessTry.charAt(0);
			
				if(Character.isLetter(charGuess)) {
				
					int[] indexCharInWord = indexCharInWord(wordToGuess, charGuess);
					if(indexCharInWord.length != 0) {
						for(int i = 0; i < indexCharInWord.length;i++) {
							wordToPrint = starToCharInWord(wordToGuess, wordToPrint, indexCharInWord[i]);	
						}	
					}
					else {
						System.out.println("Wrong guess, try again");
						guess--;
					}
				}
				else {
					System.out.println("Please try again and use letters only!");
				}
				if(!checkForStar(wordToPrint)) {
					result = "You have saved the stickman!";
					game = false;
				}
				if(guess == 0) {
					result = "Ow no you failed saving the stickman!";
					game = false;
				}
			}
		}	
		scan.close();		
		return result;
	}
	
	/* Gets a String array and returns one String from that String array. 
	 * String[] stringArray = a string array from which to get a word to the game.
	 * return = the randomly selected word from the given array. 
	 */
	public static String randomWordArray (String[] stringArray) {
		Random r = new Random();
		String result = stringArray[r.nextInt(stringArray.length)];
		return result;
	}
		
	/* Gets a String and returns a new String at the same length of asterisks.
	 * String selectedWord = String to get from the length of the string to return.
	 * result = String of asterisks at the same length of the selectedWord.
	*/
	public static String wordToStarString (String selectedWord) {
		String result = "";
		for(int i = 0; i < selectedWord.length(); i++) {		
			result = result + "*";
		}	
		return result;
	}
	
	/* Gets a String and a char and return the index in which that char appears in the string.
	 * String str = the string on which we check the char on.
	 * char a = the char we check that appears in str.
	 * return = an integer array of the index in which the char appears in the string.
	 */
	public static int[] indexCharInWord (String str, char a) {
		String whereChar = "";	
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == a) {
				whereChar = whereChar + i;
			}
		}
		int[] index = stringToIntArray(whereChar);
		return index;
	}
	/*	Gets a string that consist only integers and returns a integer array.
	 * 	String str = the string to change to int array.
	 *  return = the int array which consist the indexes based on the str
	 */
	public static int[] stringToIntArray(String str) {
		int[] index = new int[str.length()];
		for(int i = 0; i < index.length; i++) {
			index[i] = Character.getNumericValue(str.charAt(i));
		}
		return index;
	}
	
	//Gets two strings and an integer, returns a new String.
	public static String starToCharInWord (String guessStr, String printStr, int index) {
		String toChange = new String(printStr);
		String changeWith = new String(guessStr);
		
		char[] changeWith1 = changeWith.toCharArray();
		char[] toChange1 = toChange.toCharArray();
		
		toChange1[index] = changeWith1[index];
		String result = new String(toChange1);
		
		return result;
	}
	
	//Gets a String and returns a boolean.
	public static boolean checkForStar(String wordToCheck) {
		boolean starsLeft = true;
		int[] no = new int[0];
		if(Arrays.equals(indexCharInWord(wordToCheck,'*'),no)) {
			starsLeft = false;
		}
		return starsLeft;
	}
	
}
