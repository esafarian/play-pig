
import java.util.*;
import java.lang.Math;
public class PlayPig {

	public static void main(String[] args) {
		
	play();	

	}

	public static void play() {
	// when called it begins the game after printing the welcome message and deciding which player goes first
	Scanner reader = new Scanner(System.in);
	welcome();
	
	String input;
	int dice = 0;
	
	System.out.print("Enter player 1's name: ");
	Player one = new Player(reader.nextLine(), 0);
	
	System.out.print("Enter player 2's name: ");
	Player two = new Player(reader.nextLine(), 0);
	
	int score1 = one.getScore();
	int score2 = two.getScore();
	int points1 = 0;
	int points2 = 0;
	
	// true = player one    false = player two
	boolean turn = false;
	String name1 = one.getName();
	String name2 = two.getName();
	
	String result = goesFirst(one.getName(), two.getName());
	System.out.println(result);
	
	if(result.contains(name1)) {
		turn = true;
	}
	
	if(result.contains(name2)) {
		turn = false;
	}
	
	
		// if player one goes first
		while(turn == true) {
			System.out.print("***" + name1 + " ->type any letter to roll the dice:");
			input = reader.nextLine();
			
			dice = (int)(Math.random()*6) + 1;
			points1 += dice;
			
				if(dice > 1) {
					System.out.println(name1 + " - you rolled a " + dice);
					
					System.out.println("Your current round total is now: " + points1);
					System.out.print(name1 + " -> ROLL AGAIN? Type y or n:");
					input = reader.nextLine();
					
					if(input.equals("n")) {
						score1+= points1;
						turn = false;
						System.out.println(name1 + " your turn is over - " + points1 + " points added - your score is now: " + score1);
						System.out.println("-------------- Scoreboard ---------------\nPlayer 1: " + name1 + " score: " + score1 + "\nPlayer 2: " + name2 + " score: " + score2);
					}
					
					if(input.equals("y")){
						dice = (int)(Math.random()*6) + 1;
						System.out.println(name1 + " - you rolled a " + dice);
						if(dice > 1) {
							points1 += dice;
							System.out.println("Your current round total is now: " + points1);
							System.out.print(name1 + " -> ROLL AGAIN? Type y or n:");
							input = reader.nextLine();
					}
					}
				}
				
				if(dice == 1) {
					System.out.println(name1 + " - you rolled a " + dice);
					System.out.println("Bust! Your turn is over. Nothing was added to your score.");
					turn = false;
					System.out.println("-------------- Scoreboard ---------------\nPlayer 1: " + name1 + " score: " + score1 + "\nPlayer 2: " + name2 + " score: " + score2);
				}
			}
		
		
		//if player two goes first
		while(turn == false) {
			System.out.print("***" + name2 + " ->type any letter to roll the dice:");
			input = reader.nextLine();
			
			dice = (int)(Math.random()*6) + 1;
			points2 += dice;
			
				if(dice > 1) {
					System.out.println(name2 + " - you rolled a " + dice);
					System.out.println("Your current round total is now: " + points2);
					System.out.print(name2 + " -> ROLL AGAIN? Type y or n:");
					input = reader.nextLine();
					
					if(input.equals("n")) {
						score2 +=points2;
						turn = true;
						System.out.println(name2 + " your turn is over - " + points2 + " points added - your score is now: " + score2);
						System.out.println("-------------- Scoreboard ---------------\nPlayer 1: " + name1 + " score: " + score1 + "\nPlayer 2: " + name2 + " score: " + score2);
					}
					
					if(input.equals("y")){
						dice = (int)(Math.random()*6) + 1;
						points2 += dice;
						System.out.println(name2 + " - you rolled a " + dice);
						
						if(dice > 1) {
							System.out.println("Your current round total is now: " + points2);
							System.out.print(name2 + " -> ROLL AGAIN? Type y or n:");
							input = reader.nextLine();
					}
					}
				}
				
				if(dice == 1) {
					System.out.println("Bust! Your turn is over. Nothing was added to your score.");
					turn = true;
					System.out.println("-------------- Scoreboard ---------------\nPlayer 1: " + name1 + " score: " + score1 + "\nPlayer 2: " + name2 + " score: " + score2);
				}
			}
	
	}
	
	
	
	public static String goesFirst (String one, String two) {
		// returns the name of the player that will roll first in the actual game
		Scanner reader = new Scanner(System.in);
		String input;
		int roll1 = 0;
		int roll2 = 0;
		
		System.out.print(one + " ->type any letter to roll the dice:");
		input = reader.nextLine();
		
		if(input.length() > 0) {
			roll1 = (int)(Math.random()*6) + 1;
			System.out.println("You rolled a " + roll1);
				
		}
		
		System.out.print(two + " ->type any letter to roll the dice:");
		input = reader.nextLine();
		
		if(input.length() > 0) {
			roll2 = (int)(Math.random()*6) + 1;
			System.out.println("You rolled a " + roll2);
				
		}
		
			if(roll1 > roll2) 
				input = one + " rolled a bigger # and will go first";
		
		
			if(roll2 > roll1) 
				input =  two + " rolled a bigger # and will go first";
		
		
			if(roll1 == roll2) 
				input = "You tied - " + one + " will go first";
		
		
		return input;
	}
		
	
	public static void welcome() {
	// prints out welcome message and game directions	
	System.out.println("*** Welcome to the Game called Pig! ***\n");
	System.out.println("Each player will take turns rolling a dice and the first to reach 100 wins.\r\n" + 
			"If a 1 is rolled on a turn, the player busts and earns nothing for their turn.\r\n" + 
			"If a 1 is NOT rolled the player may choose to keep rolling the dice and\r\n" + 
			"the total of the rolls of their turn will be added to their score.\n");
		
	}
}
