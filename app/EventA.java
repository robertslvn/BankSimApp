// File: EventA.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 10, 2013 

package app;

import interfaces.*;

//class for arrival events
public class EventA implements Listable  {


    // data members
    protected int arrivalTime;                      // time that customer arrives
    protected int transactionTime;                   // length of the customers transaction

    // method members
    
    // Description: Create an object EventA.
    public EventA( int arivTime, int transTime)
    // Precondition: arivTime and transTime always >= 0.
    // Postcondition: A new EventA is created with the given arrival time and trasaction time
    {
        arrivalTime = arivTime;
        transactionTime = transTime;
    }

    // Getters   
    // Description: Returns the arrival time.
    public int getTime( )
    {
    	return arrivalTime;
    } 

    // Description: Returns the transaction time
    public int getTransactionTime( )
    {
    	return transactionTime;
    }
    
    //Setters
    // Description: Sets the arrival time.
    public void setArrivalTime(int time )
    {
    	arrivalTime = time;
        return;     
    } 

    // Description: Sets the transaction time.
    public void setTransactionTime( int time )
    {
    	transactionTime = time;
        return;
    } 

    
    public String toString( )    
    // Postcondition: concatenate the value of the object's 
    //                data members into a string and return this string.
    {
        return( "\tArrival Time: " + arrivalTime + "\n\tTransaction Time: "
        		+ transactionTime);

    }
    
    // Description: decides whether this object is equal to, > than or < than otherObject
    public int compareTo( Listable otherObject )
    // Postcondition: returns 0 if both objects match (are equal)
    //                returns 1 if this object > otherObject
    //                returns -1 if this object < otherObject
    //NOTE: Compare the two objects by their arrival times
    {
    	int answer = -1;
    	
    	//Compare the two objects by their arrival times
    	if(this.getTime() == ((EventA) otherObject).getTime())
    	{
    		answer = 0;
    	}
    	else if(this.getTime() > ((EventA) otherObject).getTime())
    	{
    		answer = 1;
    	}
    	return answer;
    } 

} // end of EventA class

