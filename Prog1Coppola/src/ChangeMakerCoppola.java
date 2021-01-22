//Brian Coppola
//Prog 1
//Due Feb4th at  1:30pm
//Purpose- Tells you what change you need in dollars and cents
//Inputs- Original Amount of money put in
//Outputs- Total number of dollars, $20s, $10s, $5s, $1s, quarters, dimes, nickels, and pennies
//I Certify that this was completely my own work

//imports all classes
import java.util.*;

public class ChangeMakerCoppola 
{
	public static void main(String[] args)
	{
		//initializes variables
		int amount, originalAmount, bills, coins
			,twenties, tens, fives, ones, quarters, dimes, nickels, pennies;
		//Welcome Statement
		System.out.println("Welcome to the change maker.");
		System.out.println("How much change do you have?");
		System.out.println("I will output a combination of coins and bills");
		System.out.println("that equals the amount of money you enter.");
		
		//Allows you to input info from the keyboard
		Scanner keyboard = new Scanner(System.in);
		amount = keyboard.nextInt();
		
		//Calculates Change
		originalAmount=amount;
		
		twenties = amount / 2000;
		amount = amount % 2000;
		
		tens = amount / 1000;
		amount = amount % 1000;
		
		fives = amount / 500;
		amount = amount % 500;
		
		ones = amount / 100;
		amount = amount % 100;
				
		quarters = amount / 25;
		amount = amount % 25;
		
		dimes = amount / 10;
		amount = amount % 10;
		
		nickels = amount / 5;
		amount = amount % 5;
		
		pennies = amount;
		
		//Calculates the amount of bills and coins used
		bills = twenties + tens + fives + ones;
		
		coins = quarters + dimes + nickels + pennies;
		
		System.out.println(
				originalAmount + " cents in bills and coins can be given as:");
		
		//outputs change
		System.out.println(twenties + " twentie(s)");
		System.out.println(tens + " ten(s)");
		System.out.println(fives + " five(s)");
		System.out.println(ones + " one(s)");
		System.out.println(quarters + " quarter(s)");
		System.out.println(dimes + " dime(s)");
		System.out.println(nickels + " nickel(s)" );
		System.out.println(pennies + " pennies");
		
		//outputs the amount of bills and coins used
		System.out.println("You have "+ bills+" bill(s).");	
		System.out.println("You have " + coins +" coin(s).");
		
	}//main
}//ChangMakerCoppola
