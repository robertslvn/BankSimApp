// File: EventD.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 10, 2013 

package app;

import interfaces.*;

//class for departure events
public class EventD implements Listable  {


    // data members
    protected int departureTime;                      // time the customer departs
   
    // method members
    // Description: Create an object EventD.
    public EventD( int departTime)
    // Precondition: departTime is always >= 0.
    // Postcondition: A new eventD is created with the given departure time
    {
        departureTime = departTime;
    }

        
    // Getters   
    // Description: Returns the departure time
    public int getTime( )
    {
    	return departureTime;
    } 
    
    // Description: Returns 0, filler method
    public int getTransactionTime() {
    
    return 0;
    }
    
    // Description: Sets the departure time
    public void setDepartureTime(int time )
    {
    	departureTime = time;
        return;     
    }
    
    public String toString( )    
    // Postcondition: concatenate the value of the object's 
    //                data members into a string and return this string.
    {
        return( "\tDeparture Time: " + departureTime);

    } 

    // Description: decides whether this object is equal to, > than or < than otherObject
    public int compareTo( Listable otherObject )
    // Postcondition: returns 0 if both objects match (are equal)
    //                returns 1 if this object > otherObject
    //                returns -1 if this object < otherObject
    // Note: Compare the two objects by their departure time
    {
    	int answer = -1;
    	
    	if(this.getTime() == ((EventD) otherObject).getTime())
    	{
    		answer = 0;
    	}
    	else if(this.getTime() > ((EventD) otherObject).getTime())
    	{
    		answer = 1;
    	}
    	return answer;
    } 

} // end of EventD class

