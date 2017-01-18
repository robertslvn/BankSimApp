// File: Listable.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 10, 2013 
package interfaces;

//Class description: 
//Creates an interface with 2 methods to encapsulate any classes that implement
//this interface

public interface Listable {

	public String toString( );
	// Postcondition: concatenates the value of the object's 
	// data members into a string and return this string.
	
	// Description: decides whether this object is equal to, > than or < than otherObject
	public int compareTo( Listable otherObject );
	// Postcondition: returns 0 if both objects match (are equal)
	// returns 1 if this object > otherObject
	// returns -1 if this object < otherObject
        
        public int getTime();
        //Postcondition: returns the arrival or departure time
        
        public int getTransactionTime();
        //Postcondition: returns the transaction time

} // end of interface Listable