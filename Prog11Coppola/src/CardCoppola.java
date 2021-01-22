
public class CardCoppola 
{

	private int myValue;
	
	private char mySuit;
	
	public CardCoppola()
	{
		myValue = 0;
		mySuit = '?';
	}//null constructor
	
	public CardCoppola(int newValue, char newSuit)
	{
		myValue = newValue;
		mySuit = newSuit;
		
	}//full constructor
	
	public void setValue (int newValue)
	{
		myValue = newValue;
	}//setValue
	
	public int getValue ()
	{
		return myValue;
	}//getValue
	
	public void setSuit(char newSuit)
	{
		mySuit = newSuit;
	}//setSuit
	
	public char getSuit()
	{
		return mySuit;
	}//getSuit
	
	public String toString()
	{
		String stats = "Suit: "+mySuit;
		       stats += "Card Value: "+myValue;
		       
		return stats;
	}//toString
}//CardCoppola

