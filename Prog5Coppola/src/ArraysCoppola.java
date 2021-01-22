//Brian Coppola
//Prog 5
// Due March 4th
//Purpose- understand how to properly use arrays in Java and master methods
//Inputs- choice, multiple lists,
//Outputs- multiple lists, golf scores, 
//		   tells user if there are more positive or negative numbers, 
//		   finds the max of  the negative numbers, and prints out
//		   the number of time it appeared
//I certify that this lab is entirely my own work
import java.util.Scanner;
import java.util.ArrayList;

public class ArraysCoppola
{
	//Allows the keyboard to be used for each method
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String args[])
	{
	//initializes variables within main
	int choices = 0;
	String choice = "???";
	
	
	do  
		{
			//Tells the user his/her options
			System.out.println("1) Let's Go Golfing");
			System.out.println("2) More More Positives or More Negatives?");
			System.out.println("3) How Many Maxes");
			System.out.println("0) Quit");
			
			//User enters an integer associated with the desired task
			System.out.println("Enter in the number associated with the task you want.");
			choice = keyboard.next();
			//grabs the first value in the string and converts it to a character
			choices = choice.charAt(0);
			
			//switch statement activates certain methods based on the users input
			switch(choices)
			{
			case '1':
				golf();
				break;
			case '2':
				plusMinus();
				break;
			case '3':
				negatives();
				break;
			case '0':
				//End of the program
				System.out.println("Thank you for running the program! :)");
				break;
			default:
				//Menu continues to loop until the user enters valid input
				System.out.println("You put in invaild input!!");
			}//switch
			
		}//do
	
	//loop ends when 0 is entered as the first character in the string
	while( choices != '0');

	}//main
	
	//Golf
	//No Parameters
	//No Returns
	//Purpose- User inputs golfing info into multiple lists 
	public static void golf()
	{
		//initializes lists
		int [] parValue = new int [9]; 
		int [] strokes =  new int [9];
		
		//Loops until the list of Par Values is filled 
		for(int count = 0; count < parValue.length; count++)
			{
			//Keeps track of where the user is in the list
			System.out.println("Enter the Par value for hole "+(count+1)+"." );
			
			//User enters the par value for the specified hole
			parValue[count] = keyboard.nextInt();
				
			//validation
			while (parValue[count] <= 0)
			{
				System.out.println("invalid input!! Please enter in a positive value!!");
				parValue[count]= keyboard.nextInt();
			}//while
			
			}//for
		
		//Loops until the list of strokes is filled
		for(int counter = 0; counter < strokes.length; counter++)
			{
			//Keeps track of where the user is for the specified hole
			System.out.println("Enter the amount of strokes you made on hole "+(counter + 1)+".");
			
			//User enters the amount of strokes for each specific hole 
			strokes[counter] = keyboard.nextInt();
			
			//validation
			while (strokes[counter] <= 0)
			{
				System.out.println("invalid input!! Please enter a positive value!!");
				strokes[counter] = keyboard.nextInt();
			}//while
			
			}//for
		//starts the score method
		score( parValue, strokes);
	}//golf
	
	//Score
	//Parameters- list of par values, and list of strokes per hole
	//Returns- none
	//Purpose- Calculates and prints out the golfing score
	public static void score(int [] par, int [] num)
	{
		//initializes values
		int eagle = 0;
		int bird = 0;
		int pars = 0;
		int bogeys = 0;
		int doubleBogeys = 0;
		int other = 0;
		int result = 0;
		
		//Loops until all scores are Calculated
		for(int count = 0; count < par.length; count++)
		{
		// strokes and par values are subtracted to calculate the score for each hole
		result = num[count] - par[count];
		
		//The result determines which type of score for each hole will increase
			switch(result)
			{
			case -2:
				eagle++;
				break;
			case -1:
				bird++;
				break;
			case 0:
				pars++;
				break;
			case 1:
				bogeys++;
				break;
			case 2:
				doubleBogeys++;
				break;
			default:
				other++;
				break;
			}//switch
			
		}//for
		
		//Prints out final results of all the games
		System.out.println("Eagles :"+eagle);
		System.out.println("Birdies :"+bird);
		System.out.println("Pars :"+pars);
		System.out.println("Boogeys :"+ bogeys);
		System.out.println("Double Boogeys :"+doubleBogeys);
		System.out.println("Others :"+other);
		
	}//score

	//Plus Minus
	//Parameters- None
	//Returns- None
	//Purpose- Creates a list of numbers that will be used for more calculations
	public static void plusMinus()
	{
		//Initializes local variables for the method
		int values [] = new int [20];
		int count = 0;
		
		//User enters values into the array
		do
		{
			
			//Keeps track of where the user is in the list
			System.out.println("Enter in value "+((count+1))+".<hit 0 to quit>");
			//User enters a number in to the list
			values[count] = keyboard.nextInt();
				
			//Increments the count by one 
			count++;
			
		}//do
		
		//continues to loop until count reaches twenty or when 0 is entered into the list 
		while ((count) < (values.length) && values[count-1] != 0);
		
		//sends the program to the next method
		negativesAndPositives(values, count);
		
	}//plusMinus	
	
	//Negatives and Positives
	//Parameters- list of numbers, size of the list
	//Returns- None
	//Purpose- To inform the user if there are more positive or negative numbers in the list
	public static void negativesAndPositives(int [] numbers,  int length)
	{
		//initializing local variables within the method
		int positive = 0;
		int negative = 0;
		int counter = 0;
		
		//Calculates the amount of positives and negatives within the list
		for ( counter = 0; length > counter; counter++)
		{
			//Finds Number of positive numbers within the list
			if (numbers[counter] > 0)
				positive++;
			//Finds the number of negative numbers within the list
			else if (numbers[counter] != 0)
					negative++;
		}//for
		
		//prints out all even integers within the list
		if (positive > negative)
		{
			System.out.println("There are more positive numbers than negative numbers.");
			
			//Loops through the list until all even integers are printed
			for(counter = 0; length > counter; counter++)
			{
				if(numbers[counter] > 0)
					System.out.print(numbers[counter]+", ");
			
			}//for
			System.out.println("");
		}//if
		
		//prints out all odd integers within the list
		else if(negative > positive)
			{
			System.out.println("There are more negative numbers than positive numbers.");
			
				//Loops through the list until all odd numbers are printed
				for (counter = 0; length > counter; counter++)
				{
					if (numbers[counter] < 0)
						System.out.print(numbers[counter]+" ,");
				}//for
				System.out.println("");		
			}//if
			else
				
			//When positives and negatives are tied we print out all integers within the list
			{
				System.out.println("There is an equal amount of positve and  negative numbers");
				//Loops through until all values are printed
				for  (counter = 0; length > counter; counter ++)
					if (numbers[counter]!=0)
					System.out.print(numbers[counter]+" ,");
				System.out.println("");
			}//else
		
	}//negativesAndPositives
	
	//Negatives
	//Parameters- None
	//Returns- None
	//Purpose- Creates a list of negative numbers
	public static void negatives()
	{
		//initializes all local variables within the method
		double list [] = new double [10];
		int count= 0 ;
		
		//user creates a list of negative doubles
		do
		{
			
			//Keeps track of where the user is in the list
			System.out.println("Enter a negative integer number "+((count+1))+" <End by inputing a postive integer>");
			//User inputs information
			list[count] = keyboard.nextDouble();
			
			//forces an integer to equal if the integer
			if(list[0] >= 0 && list.length >= 0)
				list[0] = 0;
			//increments the count by 1
			count++;
		}//do
		//Loops until the count is equal to the length of the list 
		while(count < (list.length) && list[count-1] < 0);
		
		maxFinder(list, count);
		
	}//negatives
	
	//Max Finder
	//Parameters- array, and its size
	//Returns- None
	//Purpose- Finds the max, and the amount of times it appears within the list
	public static void maxFinder(double array [], int size)
	{
		//initializes all local variables within the method
		double maxVal = array[0];
		int tracker = 0;
	
		//Loops through the array
		for( int counter = 0; counter < size; counter++)
		{
			if(array[counter] < 0 )
			//prints out the array
			System.out.print(array[counter]+", ");
			
			//Finds the max Value
			if( maxVal < array[counter] && array[counter] < 0)
				maxVal = array[counter];
			
		}//for
		//Loop finds each instance of the max within the list
		for( int num = 0; num < size; num++)
		{
			if (maxVal == array[num])
				tracker++;
		}//for
		
		//prints output
		System.out.println("");
		System.out.println("Max Value: "+ maxVal);
		System.out.println("Max Value Apeared: "+ tracker);
		
	}//maxFinder
}//ArraysCoppola
			