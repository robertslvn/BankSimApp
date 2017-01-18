// File: MyListInterface.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 10, 2013 

package interfaces;

import exceptions.ElementAlreadyInListException;
import exceptions.ElementNotInListException;
import exceptions.EmptyListException;

//Class description: 
//Creates an interface with to be implemented by the data collection class, MyFlexibleList

public interface MyListInterface {

	public String toString( );
	// Postcondition: concatenates the value of the object's 
	// data members into a string and return this string.

	//Description: Returns the number of elements currently stored in the list
	public int size();
	//Postcondition: Returns 0 if empty otherwise returns the number of elements
	
	//Description: Inserts an element into the list.
	public void insert(Listable element, int place, boolean eventA);
	//Precondition: none
	//Postcondition: "element" has been added to the start of the list.
	//Exception: Throws an ElementAlreadyInListException if "element" is already in the list.
	
	//Description: Deletes this element from the list.
	public void delete() throws EmptyListException;
	//Precondition: List is not empty.
	//Postcondition: deletes the first element from the list. 
	//Exception: Throws an EmptyListException if list is empty.
	
	//Description: Returns the first element
	public Listable retrieve() throws EmptyListException;
	//Precondition: List is not empty.
	//Postcondition: first element is returned but not deleted from the list.
	//If "element" is not found in the list, an exception is thrown.
	//Exception: Throws an EmptyListException if list is empty.
	
	//Description: Deletes all the elements from the list. 
	public void deleteAll();
	//Postcondition: List is empty.

} //End of MyListInterface
