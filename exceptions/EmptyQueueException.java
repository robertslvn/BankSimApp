// File: EmptyQueueException.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 10, 2013 

package exceptions;

// Class Description 
//   This exception is thrown when the queue is empty

public class EmptyQueueException extends RuntimeException 
{ 
    // Default constructor
    public EmptyQueueException( ) 
    {
    } // end of constructor
    
    // Parameterized constructor
    public EmptyQueueException(String msg)
    {
        super( msg );
        
    } 
    
} 