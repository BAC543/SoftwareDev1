
public class NodeCoppola 
{
	private CardCoppola myData;
	private NodeCoppola myNext;
	
	public NodeCoppola()
	{
		myData = null;
		myNext = null;
	}//null constructor
	
	public CardCoppola getData()
	{
		return myData;
	}//getData
	
	public void setData(CardCoppola newData)
	{
		myData = newData;
	}//setData
	
	public NodeCoppola getNext()
	{
		return myNext;
	}//getNext
	
	public void setNext(NodeCoppola newNext)
	{
		myNext = newNext;
	}//setNext
	
}//NodeCoppola
