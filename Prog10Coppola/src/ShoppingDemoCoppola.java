import java.util.*;
import java.text.*;
import java.io.*;

public class ShoppingDemoCoppola
	{
		/**
		 * @author Brian Coppola<br>
		 *Prog 10  <br>
		 *Due Thursday April 18th before 1:30<br>
		 *Purpose: To learn how to create a linked list and use the node class<br>
		 *Input: user's choice, quantity, cost, and name of item<br>
		 *Output: Validation checks, least/most expensive items, number of items in the cart, total cost of everything in the cart,<br>
		 *		  details of each item in the cart, good bye statement<br>
		 *Certification of Authenticity: I certify that this is my own work. I did discuss with the programming lab<br>  
		 * @param args stuff for main<br>
		 */
		public static void main (String args [])
		{
			Scanner kb = new Scanner(System.in);
			DecimalFormat moneyStyle = new DecimalFormat ("$0.00");
			
			//Initializes variables
			
			//All the variables that will come from the file
			String filename = "?!?!";
			int numItems = 0;
			
			
			char choice =  '#';
			String choices = "####";
			
			String name;
			int quant = 0;
			double price = 0.0;
			boolean roomy = false;
			
			KeyedListCoppola cart = new KeyedListCoppola();
		
			//Get's the file from the user
			System.out.println("Please enter the name of the file.");
			filename = kb.next();
			File myFile = new File(filename);
			
			try
			{
				//Scanner put's items into the shopping cart
				Scanner input = new Scanner (myFile);
				
				//gets the number f items in the list
				numItems = input.nextInt();
				
				//adds items in the file to the list 
				for(int count = 0; count < numItems; count++)
				{
					//Makes a new item
					ItemCoppola item = new ItemCoppola();
					
					//Sets the name of the item from the file
					name = input.next();
					item.setName(name);
					
					//Sets the quantity of the item from the file
					quant = input.nextInt();
					item.setQuant(quant);
					
					//Sets the price of the item file
					price = input.nextDouble();
					item.setPrice(price);
					
					//adds items from the list into the cart
					cart.add(item);
					
				}//for
				
				//closes the file
				input.close();
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


		while(choice != '0')
		{
			System.out.println("1. Add an item to the list.");
			System.out.println("2. Delete an item from the list.");
			System.out.println("3. Print each item from the list.");
			System.out.println("4. Search for a user specified item in the list.");
			System.out.println("5. Count the total number of items in the list.");
			System.out.println("6. Total the cost amount of items in the list.");
			System.out.println("7. Determine wether the list is empty.");
			System.out.println("8. Determine wether the list is full.");
			System.out.println("9. Clear the list");
			System.out.println("0. Quit");
			
			System.out.println("Please enter the number associated with your desired task.");
			choices = kb.next();
			choice = choices.charAt(0);
			
			switch (choice)
			{
				case '1':
					//Gets information for the item and puts it into an object
					
					System.out.println("Please enter in all the information for the new item.\n");
					
					ItemCoppola item = new ItemCoppola();
					
					System.out.println("What is the name of the new item?");
					name = kb.next();
					item.setName(name);
					
					System.out.println("How many "+name+"(s) did you purcahse?");
					quant = kb.nextInt();
					
					//validation
					while(quant <= 0)
					{
						System.out.println("Please enter a positive quantity.");
						quant =kb.nextInt();
						
					}//while
					
					item.setQuant(quant);
					
					System.out.println("What is the price of each inividual item?");
					price =kb.nextDouble();
					
					//validation
					while (price < 0)
					{
						System.out.println("Please enter a positive price");
					}//while
					item.setPrice(price);
					
					//Determines if there is enough space in the cart
					roomy = cart.add(item);
					
					//Prints if the  item is true
					if(roomy == true)
						System.out.println("The item was added to the cart!! :)");
						else
							//prints the when the item is not added to the cart
							System.out.println("The item was not added in the cart... :(");
					break;
					
				case '2':
					//Initializes all the local variables
					boolean gone = false;
					String removed = ":(";
					
					//get's the name of the desired item that you want to delete
					System.out.println("Enter the name of the item you want to delete.");
					removed = kb.next();
					
					//sets to boolean 
					gone = cart.remove(removed);
					
					//boolean tells the user accurate information
					if(gone)
					{
						System.out.println(removed +" has been sucessfully deleted.");
					}//if
					
					else
					System.out.println(removed +" is not in your cart.");
					
					break;
					
				case '3':
					//Prints the entire list
					cart.print();
					break;
				
				case '4':
					//Initializes all the Variables
					String search = "??";
					ItemCoppola holder = null;
					
					//User enters the name of the item they want to find
					System.out.println("Please enter the name of the item you want to find.");
					search = kb.next();
					
					//holder gets the desired item
					holder = cart.retrieve(search);
					
					//prints the toString when the item isn't null
					if(holder != null)
						System.out.println(holder.toString());
					
					//Tells the user the item is not in the list when null 
					else
						System.out.println("There is no item called "+search+".");
					
					break;
				case '5':
					
					//Tells the user the amount of items in the list
					System.out.println("There are "+cart.getCount()+" in the list.");
					break;
				
				case '6':
					//Tells the user the total amount
					System.out.println("The total cost of everything in the is "+ moneyStyle.format (cart.calcTotal()));
					
					break;
				case '7':
					//Tells the user if the list is empty or not
					if(cart.isEmpty())
						System.out.println("The list is currently empty.");
					else
						System.out.println("The list is not currently empty");
					break;
					
				case '8':
					//Tells the user if the list full or not
					if (cart.isFull())
						System.out.println("The list is currently full");
					else
						System.out.println("The list is currently not full");
					
					break;
				case '9':
					//Clears the list
					cart.clear();
					
					//Informs the user when the action is done
					System.out.println("The list is now cleared.");
					
					break;
				case'0':
					System.out.println("Goodbye thanks for useing the program :) ");
					
					break;
					
				default:
					System.out.println("Please enter a valid number.");
					
			}//switch
		}//while
		kb.close();
	}//main
}//class