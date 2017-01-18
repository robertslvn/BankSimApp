// File: Queueable.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 10, 2013 
// Description: interface for objects of class type that are to be queued


package interfaces; 

public interface Queueable {  
   
   public String toString( );
   // Postcondition: Concatenates the value of the object's 
   //                data members into a string and return this string.
   
   // returns the arrival time
   public int getArrivalTime();
   //Postcondition: returns the arrival time
   
   public int getTransactionTime();
   //Postcondition: returns the transaction time
   
} // end of interface Queueable