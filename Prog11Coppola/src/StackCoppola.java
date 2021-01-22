
public class StackCoppola
{
	private NodeCoppola myHead;
	
	public StackCoppola()
	{
		myHead = null;
	}//null constructor
	
	public boolean isEmpty()
	{
		boolean empty = false;
		
		if(myHead == null)
			empty = true;
		return empty;
	}//isEmpty
	
	public boolean isFull()
	{
		return false;
	}//isFull
	
	public boolean push(CardCoppola card)
	{
		boolean pushed = false;
		NodeCoppola curr = myHead;
		NodeCoppola holder = new NodeCoppola();
		holder.setData(card);
		
		//YOU MIGHT WANT TO DELETE THIS BECAUSE LINKED LISTS ARE NEVER GOING TO BE FULL
		if(!isFull())
		{
			myHead = holder;
			holder.setNext(curr);
			
			pushed = true;
		}//if
		
		return pushed;
	}//push
	
	public boolean pop()
	{
	NodeCoppola curr = myHead;
	boolean popped = false;
	
	if(!isEmpty())
		{
			myHead = curr.getNext().getNext();
			popped = true;
		}//if
	return popped;
	
	}//pop
	
}//Stack Coppola
