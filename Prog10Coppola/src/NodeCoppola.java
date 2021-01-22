/**
 * 
 * @author Brian Coppola<br>
 *This is the class definition for the Node class<br>
 *
 *Methods in the class: getters and setters for the data and the reference to the next Node
 */
public class NodeCoppola 
{
	/**
	 * Instance Variable for the data in the linked list
	 */
	private ItemCoppola myData;
	
	/**
	 * Instance Variable for the data for reference for the next Node in the linked list
	 */
	private NodeCoppola myNext;
	
	/**
	 * Default constructor for the Node Class
	 */
	public  NodeCoppola()
	{
		
		myData = null;
		myNext = null;
		
	}//Null constructor
	
	/**
	 * getter for the node's data
	 * @return the object that is stored in the data 
	 */
	public ItemCoppola getData()
	{
		return myData;
	}//getData
	
	/**
	 * The setter that sets an object to a specified node
	 * @param newData that has been inputed by the user or file
	 */
	public void setData(ItemCoppola newData)
	{
		myData = newData;
	}//setData
	
	/**
	 * gets the next node in the linked list
	 * @return the next Node in the linked list
	 */
	public NodeCoppola getNext()
	{
		return myNext;
	}//getNode
	
	/**
	 * sets the reference to the next Node in the list
	 * @param newNext creates a new reference to be added into the linked list
	 */
	public void setNext(NodeCoppola newNext)
	{
		myNext = newNext;
	}//setNext
	
	
}//Node Coppola
