import java.text.DecimalFormat;

/**
 * @author Brian Coppola <br>
 * This is the class definition for the item
 */
public class ItemCoppola
{
	/**
	 * Instance Variable for the item's name
	 */
	private String myName;
	
	/**
	 * Instance Variable for the Quantity of the item
	 */
	private int myQuant;
	
	/**
	 * Instance Variable for the Price of the Item
	 */
	private double myPrice;

	/**
	 * Allows the moneyStyle format to be used any where within the class
	 */
	static DecimalFormat moneyStyle = new DecimalFormat ("$0.00");
	
	/**
	 * The full constructor for ItemCoppola
	 * @param newName The incoming name for the next Item
	 * @param newQuant The incoming quantity for the next Item
	 * @param newPrice The incoming price for the next Item
	 */
	public ItemCoppola(String newName, int newQuant, double newPrice)
	{
		myName = newName;
		myQuant = newQuant;
		myPrice  = newPrice;
	}//full constructor
	/**
	 * The default constructor for Item Coppola
	 */
	public ItemCoppola ()
	{
		myName = "None";
		myQuant = 0;
		myPrice = 0.0;
	}//null constructor
	
	/**
	 * The setter for the for the new Item's name
	 * @param newName the incoming name for this Item
	 */
	public void setName(String newName)
	{
		myName = newName;
	}//setName
	/**
	 * The getter for the Item's name
	 * @return The name of this Item
	 */
	public String getName()
	{
		return myName;
	}//getName
	
	/**
	 * The setter for the new Item's quantity
	 * @param newQuant the incoming quantity for this Item
	 */
	public void setQuant(int newQuant)
	{
		myQuant = newQuant;
	}//setQuant
	
	/**
	 * The getter for the new Item's quantity
	 * @return The user's quantity of this Item
	 */
	public int getQuant()
	{
		return myQuant;
	}//getQuant
	
	/**
	 * The setter for the new Item's price
	 * @param newPrice the incoming base price for this Item
	 */
	public void setPrice (double newPrice)
	{
		myPrice = newPrice;
	}//setPrice
	
	/**
	 * The getter for the new Item's price
	 * @return The base price for this Item
	 */
	public double getPrice ()
	{
		return myPrice;
	}//getPrice
	
	/**
	 * Returns the details about this Item as a String
	 */
	public String toString ()
	{
	String info;
	info ="Item: "+myName+"\n";
	info +="Quantity: "+myQuant+"\n";
	info +="Price: "+moneyStyle.format(myPrice)+"\n";
	
	return info;
	
	}//toString
}//ItemCoppola
