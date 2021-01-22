/**
 * @author Brian Coppola<br>
 * This is the class definition for the shopping cart
 * */
public class ShoppingCartCoppola
{
	/**
	 * The Instance Variable for the max amount of items in the list
	 */
	private ItemCoppola [] myItems;
	/**
	 * The Instance Variable for the amount of objects within the list
	 */
	private int mySize;
	
	/**
	 * The default constructor of the shopping cart
	 */
	public ShoppingCartCoppola()
	{
	    myItems = new ItemCoppola [10]; 
		mySize = 0;

	}//null constructor
	
	/**
	 * @return The number of objects in the list
	 */
	public int getSize()
	{
		return mySize;
	}//getSize
	
	/**
	 * Adds items into the list and tells the user if there isn't enough room
	 * @param nextItem is the place holder of the new item added into the list
	 * @return A boolean value that tells the user if there if enough room for there item in main
	 */
	public boolean addToCart(ItemCoppola nextItem)
	{
		//Initializes local variable
		boolean room = false;
		
		//Only adds an item when the number of items in the cart is less than the length of the list
		if (mySize < myItems.length)
		{
			//adds an item 
			myItems[mySize] = nextItem;
			//boolean is now true
			room = true;
			//the Size increments by 1 to represent the number of Objects in the list
			mySize++;
			
		}//if
		
		return room;
		
	}//addToCart
	
	/**
	 * Finds the the item with the lowest base price
	 * @return The item with the lowest base price
	 */
	public ItemCoppola findLeastExpensive()
	{
		//Initializes local variables
		double min = Integer.MAX_VALUE;
		int index = -1;
		
		//Makes sure that there are objects in the list
		if (mySize > 0)
		{
			//Loops through all of the Objects in the list
			for( int count = 0; count < mySize; count++)
			{
				//Finds the item with the lowest base price
				if (myItems[count].getPrice() < min)
				{
					//Saves the value of the lowest price
					min = myItems[count].getPrice();
					//Saves the location in the list
					index = count;
				}//if
				
			}//for
			return myItems[index];
		}//if
		
		//Makes sure the program doesn't crash when there are no items
		else
			return null;
		
	}//leastExpensive
	
	/**
	 * Finds the item with the highest base price
	 * @return The item with the highest base price
	 */
	public ItemCoppola findMostExpensive()
	{
		//Initializes local variables
		double max = Integer.MIN_VALUE;
		int tracker = -1;
		//Checks that there are objects within the list
		if(mySize > 0)
		{	
			//Loops through the objects within the list
			for (int counter = 0; counter < mySize; counter++)
			{
				//Finds the item with the highest base price
				if (myItems[counter].getPrice() > max)
				{
					//Saves the price and location in the list
					max = myItems[counter].getPrice();
					tracker = counter;
				}//if
					
			}//for
			return myItems[tracker];
		}//if
		
		//Makes sure the program doesn't crash when there are no items
		else
			return null;
	}//MostExpensive
	
	/**
	 * Finds the total price in the cart
	 * @return The total price of all the items
	 */
	public double calcTotal()
	{
		//Initializes local variable
		double total = 0.0;
		
		//Loops through all Objects in the list
		for (int count = 0; count < mySize; count++)
		{
			//Multiplies the price and quantity for each item and accumulates them
			total += myItems[count].getPrice()* myItems[count].getQuant();
		}//for
		return total;
	}//calcTotal
	
	/**
	 * Prints a description for each object in the list
	 */
	public void printList()
	{
		if(mySize > 0)
			{	
			//Loops through the objects in the list
			for(int counter = 0; mySize > counter; counter++)
			{
				System.out.println(myItems[counter].toString());
			}//for
		}//if
		else
		//Gives the user i
		System.out.println("There are no items in the list");
	}//printList
	
	/**
	 * Deletes the highest item in the list
	 */
	public void delete()
	{
		//Initializes local variables
		double max = Integer.MIN_VALUE;
		int tracker = -1;
		int hold = 0;
		
		//Checks that there are objects within the list
		if(mySize > 0)
		{	
		//Loops through the objects within the list
		for (int counter = 0; counter < mySize; counter++)
			{
				//Finds the item with the highest base price
				if (myItems[counter].getPrice() > max)
				{						
					//Saves the price and location in the list
					max = myItems[counter].getPrice();
					tracker = counter;
				}//if
							
			}//for
			
			//rearranges the items in the list
			for (int count = 0; count < mySize; count++ )
			{        
				//puts the highest item in the back
			 	if(tracker < count)
			 	{
			 		//switchs the order of the items
			 		myItems[hold]  = myItems [count];
			 		myItems[count] = myItems [tracker];
			 		myItems[tracker] = myItems [hold];
			 	}//if
			}//for
			
			//The highest is not in the range of mySize anymore
			mySize--;
		}//if
		else
			System.out.println("There are no items to delete \n");
	}//delete
}//ShoppingCartCoppola
