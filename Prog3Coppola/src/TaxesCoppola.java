//Brian Coppola
//Due Feb 18th
//Purpose- to master conditional statements and loops
//Inputs- ID #, Filling Status, Gross Income, Number of Exemptions
//Outputs- ID #, Filing Status, Taxable Income,  Tax Rate, Tax owed, Number of Tax Payers,
//		   Highest Tax, ID # of the highest tax amount, average tax paid
//I Certify that this was completely my own work.

import java.util.Scanner;
import java.text.*;
public class TaxesCoppola 
{
public static void main(String []args)
	{
	// defines the keyboard
	Scanner keyboard = new Scanner(System.in);
	
	//Converts numbers into a format suited for cash
	DecimalFormat moneyStyle = new DecimalFormat("$0.00");
	
	//initializing variables
	String filingStatus = "????";
	double gross = 0.0;
	int exempt = 11;
	double tax = 0.0;
	double rate = 0.0;
	int id = -1;
	char status = '!';
	int people = 0;
	double high = 0;
	int loser = 0;
	double total = 0.0;
	double average = 0.0;
	double incomeTax = 0.0;
	
	//Gets user's information
	System.out.println("This program calculates your taxes");
	
	//User enters a value for ID to either start or end the while loop
	System.out.println("Please enter your Tax ID number <enter zero to quit the program>");
	id = keyboard.nextInt();
		
		while(id != 0)
		{	
				
				
		do
			{
			
			System.out.println("Please enter your Filing Status <s for single, m for Married, h for Head of Household>");
			//User types in their filling status
			filingStatus = keyboard.next();
			//The first letter of the user's input is put in the status variable
			status = filingStatus.charAt(0);	
			//Whatever character status was is now lowercase
			status = Character.toLowerCase(status);
			
			//Makes sure status is either s, m, or h
			switch(status)
			{
			case 's':
				break;
			case 'm':
				break;
			case 'h':
				break;
			default: status = '!' ;
			}//switch
			
			}//do
			
			//validation for status
			while(status == '!' );
		
			//User enters the gross
			System.out.println("What is your gross income");
			gross = keyboard.nextDouble();
			
			do
		  	{
		  	//User enters the number of exemptions
		  	System.out.println("Enter the number of exemptions");
		  	exempt = keyboard.nextInt();
		  	}//do
		  	
		  	//Validation for exemptions
		  	while (!(exempt>=0 && exempt<=10));
			
			//Calcs the taxable income
		  	incomeTax = gross - (exempt * 1600) -  4250 ;
		  	
			//Determines the tax rate
			switch(status) 
				{
					case 's': 
						
						if(incomeTax < 15000)
							rate = .14;
						
						else if(incomeTax >=15000 && incomeTax <= 50000)
								rate = .22;
			
							else
								rate = .31;		
					break;
					
					case 'm':
						if(incomeTax < 25000)
							rate = .12;
							
						else if (incomeTax >= 25000 && incomeTax <= 135000)
								rate = .20;
							
								else
									rate = .29;
					break;
					
					case 'h':
						if (incomeTax < 30000)
							rate = .13;
							
						else if (incomeTax >= 30000 && incomeTax <= 70000)
								rate = .21;
		
								else
									rate = .30;
					break;
					
					default: status = '!';
							 
				}//switch
		
			
		  
		  		
		  	//Calcs taxes owed
		  	tax = gross * rate;
		  	
		  	//taxes are not owed if taxable income is less than 0
		  	if (incomeTax < 0)
		  		tax = 0;
			
		  	//Prints output for the individual tax payer
			System.out.println("Tax ID: "+ id);
			System.out.println("Filing Status: "+ status);
			System.out.println("Taxable Income: "+ moneyStyle.format(incomeTax));
			System.out.println("Tax Rate: "+ rate);
			System.out.println("Taxes Owed: "+ moneyStyle.format(tax));
			
			//Keeps track of the amount of people paying taxes
			people ++;
			
			//the ID with the highest tax gets saved 
			if (high < tax) 
				{
				high = tax;
				loser = id;
				}//if
			
			//accumulates the total tax
			total += tax;
		
			//Determines whether or not to terminate the loop
			System.out.println("Please enter your Tax ID number <enter zero to quit the program>");
			id = keyboard.nextInt();
		
		}//while
	
	//Calculates the average tax paid
	average = total/ people;
	if (people == 0)
		System.out.println("There is no tax information.");
	else
		{
		//Prints general output for all tax payers
		System.out.println("Number of tax payers: "+ people);
		System.out.println("The highest tax paid was "+ moneyStyle.format(high));
		System.out.println("The highest tax was paid by #"+ loser);
		System.out.println("The total amountof tax paid was "+moneyStyle.format(total));
		System.out.println("The average tax paid was "+ moneyStyle.format(average));
		}//else
}//TaxesCoppola
