/**
 * 
 * @author Brian Coppola<br>
 *This class is used for linked lists
 *All the methods are going to be used for the shopping cart
 */
public class KeyedListCoppola {
	/**
	 * The Instance variable for that reference's the first node in the linked list
	 */
	private NodeCoppola myHead;
	
	/**
	 * The default constructor for the linked list
	 */
	public KeyedListCoppola()
	{
		myHead = null;
	}//nullConstructor
	
	/**
	 * Clear's everything in the entire list
	 */
	public void clear()
	{	
		myHead = null;
	}//clear
	
	/**
	 * Adds new items into the linked list
	 * @param purchased the item being transfered from the main
	 * @return a boolean that informs the user if they successfully added into the linked list
	 */
	public boolean add(ItemCoppola purchased)
	{
		//Initialize local variables
		boolean success = false;
		boolean added  = false;
		NodeCoppola pre = null;
		NodeCoppola curr = myHead;
		NodeCoppola holder = new NodeCoppola();
		ItemCoppola duplicate  = null;
		
		//CHECK for duplicates
		duplicate = retrieve(purchased.getName());
		
		if(duplicate == null)
		{	
			//must be added into the linked list
			added = true;
			
			//Holder for the new object
			holder.setData(purchased);
			
			//Loops until it reaches the end of the Linked list
			while((curr != null) && (success != true) )
			{
				
				//Sees if the product name is greater than the location name 
				if (purchased.getName().compareToIgnoreCase(curr.getData().getName()) < 0 ) 
				{
					success = true;
				}//if
				
				else
				{
					//Goes to the next Node in the Linked list
					pre = curr;
					curr = curr.getNext();
				}//else
				
			}//while
			
			//Adds to the first new Node in the Linked list
			if (pre == null)
			{
				myHead = holder;
				holder.setNext(curr);
			}//if
			
			//Adds when it is passed the first Node in the Linked list
			else
			{
				pre.setNext(holder);
				holder.setNext(curr);
			}//else
		}//if
		return added;
	}//add
	
	/**
	 * removes a desired item from the linked list
	 * @param itemName the string that the user is inputing
	 * @return tells the user if the item was deleted
	 */
	public boolean remove (String itemName)
	{
		//Initializes local variables
		boolean delete = false;
		NodeCoppola pre = null;
		NodeCoppola curr = myHead;

		
		//Finds if the item is in the list
		while( curr != null && delete == false )
		{
			//Sees if the item's name is in the list
			if(itemName.compareToIgnoreCase(curr.getData().getName()) == 0)
			delete = true;
			
			else
			{
				pre = curr;
				curr = curr.getNext();
			}//else
			
		}//while
		
		if(delete)
		{
			//deletes only when first node should be deleted
			if(pre == null)
			{
				myHead = curr.getNext();
				
			}//if
			
			//deletes an item past the first node
			else 
				{
					//Makes a reference to two nodes ahead of the current node
					pre.setNext(curr.getNext());
				}//else
		}//if
		
		return delete;
		
	}//remove
	
	/**
	 * gives the user all the information about the item of choice 
	 * @param search the string that the user inputed 
	 * @return the item that was searched for or return's null
	 */
	public ItemCoppola retrieve(String search)
	{
		//Initializes the local variables
		NodeCoppola curr = myHead;
		boolean found = false;
		ItemCoppola place = null;
		
		while(curr != null && found == false)
		{
			//finds if the user's input is in the linked list
			if(search.compareToIgnoreCase(curr.getData().getName()) == 0)
				found = true;
			
			//Goes to the next Node in the Linked List when the item is not found 
			else
			{
				//Makes the current Node the next Node in the Linked list 
				curr = curr.getNext();
				
			}//else
			
		}//while
		
		if(found)
			place = curr.getData();
		
		return place;
		
	}//retrieve
	
	/**
	 * Tells the user if the list is empty
	 * @return a boolean telling the if the list is empty or not
	 */
	public boolean isEmpty()
	{
		//Initializes the local variables
		NodeCoppola curr = myHead;
		boolean empty = false;
		
		//Finds if anything is in the first item
		if(curr == null)
			empty = true;
		
		return empty;
	}//isEmpty
	
	/**
	 * Always tells the user that the list is not full
	 * @return false
	 */
	//A LINKED LIST IS ALMOST NEVER FULL
	public boolean isFull()
	{
		return false;
	}//isFull
	
	/**
	 * Prints all of the toStings associated to objects in the list 
	 */
	public void print ()
	{
		NodeCoppola curr = myHead;
		
		if(curr == null)
			System.out.println("There is nothing in the list");
		
		while(curr != null)
		{
			System.out.println(curr.getData().toString());
			curr = curr.getNext();
		}//while
		
	}//print
	
	/**
	 * Finds how many items are in the linked list
	 * @return tells the user how many items are in the shopping cart
	 */
	public int getCount()
	{
		//Initializing local variables
		int count = 0;
		NodeCoppola curr = myHead;
		
		//Loops until it reaches the end of the Linked list is reached
		while(curr != null)
		{
			//Increments the count
			count += curr.getData().getQuant();
			
			//Goes to the next spot in the Linked list
			curr = curr.getNext();
		}//while
		
		return count; 
	}//getCount
	
	/**
	 * Calcs the total price of everything in the shopping cart
	 * @return the cost of the entire shopping cart
	 */
	public double calcTotal()
	{
		//Initializes local variables
		NodeCoppola curr = myHead;
		double total = 0.0;
		
		while(curr != null )
		{
			total+= curr.getData().getPrice() * curr.getData().getQuant();
			curr = curr.getNext();
		}//while
		
		return total;
	}//calcTotal
}//KeyedlistCoppola
