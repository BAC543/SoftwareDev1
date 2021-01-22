import java.util.*;
import java.text.*;
/**
 * @author Brian Coppola
 *Prog 7 <br>
 *Due Monday April 1st before 1:30<br>
 *Purpose: To master my skills with classes and to understanding how to use multiple classes in one program<br>
 *Input: user's choice, quantity, cost, and name of item<br>
 *Output: Validation checks, least/most expensive items, number of items in the cart, total cost of everything in the cart,<br>
 *		  details of each item in the cart, good bye statement<br>
 *Certification of Authenticity: I certify that this is my own work, but I discussed it with Alex <br>  
 */
public class ShoppingDemoCoppola 
{
	public static void main (String []args)
	{
		Scanner kb = new Scanner(System.in);
		DecimalFormat moneyStyle = new DecimalFormat ("$0.00");
		
		//Initializes variables
		String choices = "???";
		char choice = '?';
		
		String name;
		int quant;
		double price;
			
		boolean roomy = false;
		

		ShoppingCartCoppola Cart = new ShoppingCartCoppola();
		
		//Loops through until the user wishes to quit the program
		while (choice != 'Q')
		{
			//Gives the user their options
			System.out.println("A - Addd an Item to the cart.");
			System.out.println("L - Find the least expensive item in the cart.");
			System.out.println("M - Find the most expensive item in the cart.");
			System.out.println("N - Find the number of items in the cart.");
			System.out.println("T - Find the total cost of all items in the cart.");
			System.out.println("P - Print out details about all items in the cart.");
			System.out.println("D - Delete the most expensive item from the cart.");
			System.out.println("Q - quit");
			System.out.println("\n");
			System.out.println("Please enter the letter associated with the desired task.");
			
			//User enters any amount of characters into a string
			choices  = kb.next();
			
			//The first character in the String is assigned to a variable and is used for carry out a task
			choice = choices.charAt(0);
			choice = Character.toUpperCase(choice);
			
			switch (choice)
			{
				case 'A':
					//Gets information for the item and puts it into an object
					
					System.out.println("Please enter in all the information for the new item.\n");
					
					ItemCoppola Item = new ItemCoppola();
					
					System.out.println("What is the name of the new item?");
					name = kb.next();
					Item.setName(name);
					
					System.out.println("How many "+name+"(s) did you purcahse?");
					quant = kb.nextInt();
					
					//validation
					while(quant <= 0)
					{
						System.out.println("Please enter a positive quantity.");
						quant =kb.nextInt();
						
					}//while
					
					Item.setQuant(quant);
					
					System.out.println("What is the price of each inividual item?");
					price =kb.nextDouble();
					
					//validation
					while (price < 0)
					{
						System.out.println("Please enter a positive price");
					}//while
					Item.setPrice(price);
					
					//Determines if there is enough space in the cart
					roomy = Cart.addToCart(Item);
					
					if(roomy == true)
						System.out.println("The item was added to the cart!! :)");
						else
							System.out.println("The cart is now full, so the item was not added in the cart... :(");
					break;
					
				case 'L':
					 //Finds the least expensive item in the cart
					 if (Cart.findLeastExpensive() != null)
					 System.out.println(Cart.findLeastExpensive().toString());
					 
					 //Gives the user input when there are no items in the list
					 else
						 System.out.println("There are no items in the cart!");
					break;
					
				case 'M':
					//Finds the Most expensive item in the cart
					if(Cart.findMostExpensive() != null)
					System.out.println(Cart.findMostExpensive().toString());
					
					//Gives the user input when there are no items in the cart
					else
						System.out.println("There are no items in the cart!!");
					break;
					
				case 'N':
					//Tells the user how many unique items are in the cart
					System.out.println("There are "+Cart.getSize()+" item(s) in the cart");
					break;
					
				case 'T':
					//Outputs the total cost of the cart
					System.out.println("The total cost of everything in the cart is "+moneyStyle.format(Cart.calcTotal())+".\n");
					break;
				
				case 'P':
					//Outputs all the information for each item in the cart
					Cart.printList();
					break;
				case 'D':
					//Deletes the item wit the highest base price
					Cart.delete();
					break;
				case 'Q':
					//Says good bye before the program ends
					System.out.println("Thanks for running the program!! :)");	
					
			}//switch
			
		}//while
		
	}//main
	
}//Shopping Demo Coppola
