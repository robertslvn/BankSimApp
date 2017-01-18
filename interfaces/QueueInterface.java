//
//Filename: QueueInterface.java
//author: Robert Silvan
//StdNumber: 301118114
//Date: July 10, 2013

package interfaces;
import exceptions.*;

public interface QueueInterface {
    
public void enqueue(Queueable element) throws EmptyQueueException;
//Adds an element to the queue.
//Precondition: element is the item to be inserted
//Postcondition: If the operation was successful, element 
//is at the back of the queue. Throws QueueException when the operation is not 
//successful, if needed!

public Queueable dequeue() throws EmptyQueueException;
//Removes an element from the queue. It also returns it.
//Precondition: Queue is not empty.
//Postcondition: If the queue is not empty, the  item that was added to the 
//queue earliest is returned and the item is removed. 
//Throws EmptyQueueException if queue is empty. Throws QueueException when the operation is not 
//successful, if needed.

public void dequeueAll();
//Removes all elements from the queue.
//Postcondition: isEmpty() returns “true”.
        
public Queueable peek() throws EmptyQueueException;
//Retrieves an element from the queue and returns it.
//Precondition: Queue is not empty.
//Postcondition: the queue is unchanged.
//Throws EmptyQueueException if queue is empty.
//Throws QueueException when the operation is not 
//successful, if needed!
        
public boolean isEmpty( );
//Precondition: none
//Postcondition:Returns “true” is the queue is empty, otherwise returns 
//“false”.

}