import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleGameCoppola
{
	
	public StackCoppola deal (int playNum)
	{
		Scanner kb = new Scanner(System.in);
		
		String filename = "?";
		//Get's the file from the user
		System.out.println("Please enter the name of the file.");
		filename = kb.next();
		File myFile = new File(filename);
		
		
		int cardTemp = Integer.MIN_VALUE;
		char suitTemp =  '?';
		String fakeSuit = "###";
		int count = 0;
		try
		{
			
			//Scanner puts cards values on the cards
			Scanner input = new Scanner (myFile);
			
			//Creates empty decks
			StackCoppola player1 = new StackCoppola();
			StackCoppola player2 = new StackCoppola();
			//adds from the file to the deck 
			while(input.hasNextLine())
			{
				//Creates an empty card
				CardCoppola card = new CardCoppola();
				
				//assigns values to a variable
				cardTemp = input.nextInt();
				fakeSuit = input.nextLine();
				
				//turns the String into a character
				suitTemp = fakeSuit.charAt(0);
					
					//Adds the values to the card
					card.setValue(cardTemp);
		
					card.setSuit(suitTemp);
					
				//puts the cards into the decks
				if(count % 2 ==  0)
					player1.push(card);
				else
					player2.push(card);
					
			}//while
			
			
			//closes the file
			input.close();
			
			return player1;
		}//try
		
		//Shows an error when the file is not found
		catch(FileNotFoundException ex)
		{
			System.out.println("Failed to find file: "+myFile.getAbsolutePath());
		}//catch
		
		//Tells the user when the wrong dataType has been entered
		catch(InputMismatchException ex)
		{
			System.out.println("Type mismatch for the one or more of the instance variables");
			System.out.println(ex.getMessage());
		}//catch
		
		//Tells the user that the input had the wrong data type
		catch(NumberFormatException ex)
		{
			System.out.println("Type mismatch for the data type I just tried to read");
			System.out.println(ex.getMessage());
		}//catch
		
		//Tells the user that an object is null
		catch(NullPointerException ex)
		{
			System.out.println("Null pointer exception.");
			System.out.println(ex.getMessage());
		}//catch
		
		//Tells the user if they referenced a file that doesn't exist
		catch(Exception ex)
		{
			//Prints out the user's proper error message after inputting the wrong file name
			System.out.println("Uh Oh!! The inputed file name cannot be read. :(");
			System.out.println(ex.getMessage());
			
		}//catch
		
	}//deal
	
	public void play()
	{
		
	}//play
}//BattleGameCoppola
