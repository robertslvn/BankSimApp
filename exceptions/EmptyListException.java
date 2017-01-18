// File name: EmptyListException.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 10, 2013 
package exceptions;

//Class Description 
//This exception is thrown when the data collection is empty

public class EmptyListException extends java.lang.Exception {
	
	//Default constructor
	public EmptyListException()
	{
	}//end of default constructor
	
	//Parameterized constructor
	public EmptyListException(String msg)
	{
		super(msg);
	}//end of constructor

} //end of EmptyListException class
