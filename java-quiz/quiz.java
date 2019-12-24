import java.util.Scanner;
public class TestYourself{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int answer, finalScore = 0, score = 0;
		
		System.out.println("**********************************************");
		System.out.println("\t Welcome to the Youtube quiz!");
		System.out.println("\t How deep are you in Youtube?");
		System.out.println("**********************************************");

//first question
		System.out.println("First Question");
		System.out.println("------------------");
		System.out.println("Have you heard about T-series vs Pewdipie?");
		System.out.println("1. It's some contest between an european and indian media comapnies.");
		System.out.println("2. There is no such thing.");
		System.out.println("3. It's a famous rap song by C-mob and Eminem");
		System.out.println("4. It's about the most subscribed channel on Youtube.");
		System.out.println("------------------");
		System.out.println("Please choose an answer: ");
		System.out.println("------------------");

		answer = scan.nextInt();
		if(answer == 1){
			score = 2;
		}
		else if(answer == 4){
			score = 5;
		}
		else{
			score = 0;
		}
		finalScore = finalScore + score;

//second question
		System.out.println("Second Question");
		System.out.println("------------------");	
		System.out.println("What's the most controversional bad behavior Logan Paul known for?");
		System.out.println("1. Did a pretty disrespectful video in Japan");
		System.out.println("2. Lied to his fans about an illness");
		System.out.println("3. Pretending to be gay");
		System.out.println("4. It was his brother Jake Paul who did all this and not Logan");
		System.out.println("------------------");
		System.out.println("Please choose an answer: ");
		System.out.println("------------------");

		answer = scan.nextInt();
		if(answer == 3){
			score = 2;
		}
		else if(answer == 1){
			score = 5;
		}
		else if(answer == 2){
			score = 3;
		}
		else{
			score = 0;
		}
		finalScore = finalScore + score;

//third question
		System.out.println("Third Question");
		System.out.println("------------------");		
		System.out.println("How did Jacksepticeye got his name?");
		System.out.println("1. He thought about it while drunk with friends");
		System.out.println("2. In his childhood he got an infection in his eye");
		System.out.println("3. His fans chose this name for him");
		System.out.println("4. He took this name after a favorite character");
		System.out.println("------------------");
		System.out.println("Please choose an answer: ");
		System.out.println("------------------");
		
		answer = scan.nextInt();
		if(answer == 1){
			score = 2;
		}
		else if(answer == 2){
			score = 5;
		}
		else{
			score = 0;
		}
		finalScore = finalScore + score;

//forth question
		System.out.println("Fourth Question");
		System.out.println("------------------");	
		System.out.println("What is \" =3 \" ?");
		System.out.println("1. A very old and closed youtube channel");
		System.out.println("2. A special tag for preimum users");
		System.out.println("3. A web series name");
		System.out.println("4. Trick question, there is no such thing.");
		System.out.println("------------------");
		System.out.println("Please choose an answer: ");
		System.out.println("------------------");
		
		answer = scan.nextInt();
		if(answer == 1){
			score = 4;
		}
		else if(answer == 3){
			score = 5;
		}
		else{
			score = 0;
		}	
		finalScore = finalScore + score;

//fifth question
		System.out.println("Fifth Question?");
		System.out.println("------------------");
		System.out.println("Who were the first 5 to hit 1 milion subscribers?");
		System.out.println("1. DanTDM, JackSepticEye, Good Mythical Morning, KSI and Jimmy Fallon");
		System.out.println("2. RihannaVEVO, freddiew, nigahiga, Fred and Machinima");
		System.out.println("3. Smosh, Equals Three, Pewdiepie, Machinima and collegeHumor");
		System.out.println("4. RayWilliamJohnson, ShaneDawsonTV, Smosh, NigaHiga and Fred");
		System.out.println("------------------");
		System.out.println("Please choose an answer: ");
		System.out.println("------------------");

		answer = scan.nextInt();
		if(answer == 1){
			score = 2;
		}
		else if(answer == 4){
			score = 5;
		}
		else{
			score = 0;
		}
		finalScore = finalScore + score;

		System.out.print("~~~~~~~~~~~~~~~~~~~~");
		System.out.print(" Quiz Result ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~");

		if(finalScore >= 0 && finalScore < 10){
			System.out.println("Your final score is: " + finalScore + "!" +
			"\n Your knowledge on Youtube is quite low" +
			"\n I suppose you got life outside of the enternet");
		}
		else if(finalScore >= 10 && finalScore < 20){
			System.out.println("Your final score is:" + finalScore + "!" +
			"\n You got some answers right, and some wrong" +  
			"\n You are part of the majority in the world!"); 
		}
		else if(finalScore >= 20 && finalScore < 24){
			System.out.println("Your final score is:" + finalScore + "!" + 
			"\n Your knowledge about Youtube is almost perfect" + 
			"\n You are probably not older than 30, or are you?");
		}
		else if(finalScore >= 24){
			System.out.println("Your final score is:" + finalScore + "!" + 
			"\n WOW! You got the highest score possible!" + " are you a wizard?" +
			"\n Do you remember how your street looks like??" +	
			"\n You really should get out some more.");
		}
		else{
			System.out.println("Oops!" +
			"\n There is an error here" +
			"\n Please do the quiz again" +
			"\n And please choose between 1-4");
		}
		scan.close();
	}
}
