// File name: ElementAlreadyInListException.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 10, 2013 

package exceptions;

//Class Description:
//This exception is thrown when the element already exists in the data collection

public class ElementAlreadyInListException extends Exception
{
	//Default constructor
	public ElementAlreadyInListException()
	{
	}// end of default constructor
	
	//Parameterized constructor
	public ElementAlreadyInListException(String msg)
	{
		super(msg);
	}//end of constructor
	
}//end of ElementAlreadyInListException class
