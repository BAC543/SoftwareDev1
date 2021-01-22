/**
 * 
 * @author Brian Coppola
 *This is the stepsCoppola
 */
public class StepsCoppola 
{
	/**
	 * Instance Variable for the width of the steps
	 */
	private int myStepWidth;
	/**
	 * Instance variable for the number of steps
	 */
	private int myNumSteps;
	/**
	 *Instance Variable for the fillStyle 
	 */
	private char myFillStyle;
	
	/**
	 * 
	 * @param newWidth
	 * @param newNum
	 * @param newFill
	 */
	public StepsCoppola (int newWidth, int newNum, char newFill)
	{
		myStepWidth = newWidth;
		myNumSteps = newNum;
		myFillStyle = newFill;

	}//constructor
	/**
	 * Default Constructor for the Steps Class
	 */
	public StepsCoppola()
	{
		myStepWidth = 2;
		myNumSteps = 5;
		myFillStyle = '*';
		
	}//null constructor
	
	/**
	 * The setter for the width of each step
	 * @param newWidth The incoming width of the steps
	 */
	public void setStepWidth(int newWidth)
	{
		myStepWidth = newWidth;
	}//setStepWidth
	
	/**
	 * The getter for the width of each step
	 * @return the width of the step
	 */
	public int getStepWidth()
	{
		return myStepWidth;
	}//getStepWidth
	
	/**
	 * The setter for the number of steps output
	 * @param newNum The incoming number of steps
	 */
	public void setNumSteps(int newNum)
	{
		myNumSteps = newNum;
	}//setNumSteps
	
	/**
	 * The getter for the Fill Style
	 * @return The type of character used fir the fillstyle
	 */
	public int getFillStlye()
	{
		return myFillStyle;
	}//getFillStyle
	public void setFillStyle (char newFill)
	{
		myFillStyle = newFill;
	}//FillStyle

	public int calcArea ()
	{
		//initializes all local variables within the method
		int area = 0;
		int count;
			
		for(count = 0;  count < (myNumSteps + 1); count++)
		{
			//Accumulates the individual area of each line
			area += myStepWidth * count;
		}//for
		//returns the area
		return area;
		
	}//calcArea
	public void drawSteps ()
	{
	//initializes local variables to their character type
	int count;
	int counter;
	
		//prints out the steps
		for (count = 0; count < myNumSteps; count++)
		{
			System.out.println();
			for(counter = 0; counter < myStepWidth * (count + 1); counter++)
			{
				System.out.print(myFillStyle);
			}//for (Prints out the fill style for as many times as needed)
			
		}//for (go to the next line of code)
		
		//formats accordingly
		System.out.println();
		System.out.println();
		
	}//drawSteps
	
	public void drawThickSteps()
	{
		//initializes character type for each variables
		int count;
		int counter;
		int track;
			//prints out the steps
			for (count = 0; count < myNumSteps; count++)
			{
				
				for(track = 0; track < myStepWidth; track++)
				{
					//starts printing output on the next line
					System.out.println();
					
					for(counter = 0; counter < myStepWidth * (count +1); counter++)
					{
						System.out.print(myFillStyle);
						
					}//for (prints out the output)
					
				}//for (loops through the through myStepsWidth)
				
			}//for (loops through the value of myNumSteps)
			System.out.println();
	}//ThickSteps
	
	public String toString()
	{
		String result;
		result ="Number of Steps: "+myNumSteps+"\n";
		result += "Width of each step: "+myStepWidth+"\n";
		result +="FillStyle: "+myFillStyle+"\n";
		result +="Area: "+calcArea()+"\n";
		
		return result;
	}//toString

}///StepsCoppola
