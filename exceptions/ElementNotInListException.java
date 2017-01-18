// File name: ElementNotInListException.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 10, 2013 

package exceptions;

//Class Description: 
//This exception is thrown when the element does not exist in the data collection

public class ElementNotInListException extends Exception
{
	//Default constructor
	public ElementNotInListException()
	{
	}//end of default constructor
	
    // Parameterized constructor
	public ElementNotInListException(String msg)
	{
		super(msg);
		
	}//end of constructor
}// end of ElementNotInListException class
