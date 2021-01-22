import java.util.Scanner;
//Brian Coppola
//Prog 6
//Due March 11th
//Purpose- to master classes and methods
//Inputs- Width, FillStyle, Number of Steps
//Outputs- Description, Area,  Steps, and Thick Steps
//I certify that this lab was entirely my own work, but I discussed it with Ajrun Bhan

public class StepsDemoCoppola 
{

	public static void main(String[]args)
	{
		//getting the keyboard
		Scanner kb = new Scanner(System.in);
		
		//initializing the variables
		char choice = '?';
		String fake = "???";
		
		int width;
		int height;
		char fill;
		String fakeFill ="??????";
		
		int space = 0;
		String description = "None";
		
		StepsCoppola  Steps = new StepsCoppola ();
		//loops until the user chooses to end the program
		while(choice != 'Q')
		{
			//Gives the user all their options
			System.out.println("W: Asign the Step Width");
			System.out.println("N: Assign the number of Steps");
			System.out.println("F: Assign the FillStyle");
			System.out.println("A: Calculate the Area");
			System.out.println("T: Text Description of the Steps");
			System.out.println("D: Draw the Steps");
			System.out.println("X: Draw Thick Steps");
			System.out.println("Q: Quit");
			
			//User chooses a task
			System.out.println("Enter the letter associated with your desired task.");
			//allows the user to type more than one character
			fake = kb.next();
			
			//converts the user's String to a character by assigning the first character to choice
			choice = fake.charAt(0);
			//Forces choice to be read as an upper case
			choice = Character.toUpperCase(choice);  
			
			//Uses choice to determine the output
			switch(choice)
			{
				case 'W':
				
					//gets the width
					System.out.println("Choose a width of the steps <must be positive>");
					width = kb.nextInt();
					
					//validates the width
					while (width < 0)
						{
							System.out.println("Your width must be positive!!!");
							width = kb.nextInt();
						}//while
					//Set's the user's width
					Steps.setStepWidth(width);
					
					break;
					
				case 'N':
					//User chooses the number of steps
					System.out.println("Enter the amount of desired steps<must be positive>");
					height = kb.nextInt();
						
						//validates the input for the height
						while(height < 0)
						{
							System.out.println("Your amount of steps must be positive!!!");
							height = kb.nextInt();
							
						}//while
					//Set's the user's width
					Steps.setNumSteps(height);
					break;
					
				case'F':
					//User chooses the Fill Style
					System.out.println("Choose the Fill Style");
					//allows the user to enter more than one character
					fakeFill = kb.next();
					//converts the user's input to a single character
					fill = fakeFill.charAt(0);
					
					//Set's the user's Fill Style
					Steps.setFillStyle(fill);
					break;
					
				case'A':
					 //Calculates the area
					space = Steps.calcArea();
					
					//Output's the area
					System.out.println("The area is "+space+".");
					break;
					
				case'T':
					//Gives the user a general description of the steps
					description = Steps.toString();
					System.out.println(description);
					break;
				
				case'D':
					//Outputs the steps
					Steps.drawSteps();
					
					break;
					
				case'X':
					//Outputs Thick Steps
					Steps.drawThickSteps();
					
					break;
					
				case'Q':
					//Quits the program
					System.out.println("Thanks for using the program");
					break;
					
				default:
					//Tells user that their input is invalid
					System.out.println("Plaese enter a valid value!!");
					//Formats properly
					System.out.println();
					break;
					
			}//switch
			
		}//while
		
	}//main

}//StepsDemo
