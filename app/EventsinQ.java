// File: EventD.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 10, 2013 

package app;

import interfaces.*;

//class for queueable events
public class EventsinQ implements Queueable {
    
    // data members
    protected int arrivalTime;                      // time the customer arrives
    protected int transactionTime;                   // length of customer transaction

    // method members
    // Description: Create an object EventsinQ.
    public EventsinQ( int arivTime, int transTime)
    // Precondition: arivTime and transTime is always >= 0.
    // Postcondition: A new EventsinQ is created with the given arrival and transaction times
    {
        arrivalTime = arivTime;
        transactionTime = transTime;
    }

        
    // Getters   
    // Description: Returns the arrival time
    public int getArrivalTime( )
    {
    	return arrivalTime;
    } 

    // Description: Returns the transaction time
    public int getTransactionTime( )
    {
    	return transactionTime;
    } 

    // Description: Sets the arrival time
    public void setArrivalTime(int time )
    {
    	arrivalTime = time;
        return;     
    } 

    // Description: Sets the transaction time
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
    // NOTE: Compare the two objects by their arrival times
    {
    	int answer = -1;
    	
    	
    	if(this.getArrivalTime() == ((EventsinQ) otherObject).getArrivalTime())
    	{
    		answer = 0;
    	}
    	else if(this.getArrivalTime() > ((EventsinQ) otherObject).getArrivalTime())
    	{
    		answer = 1;
    	}
    	return answer;
    }

} // end of EventsinQ class

