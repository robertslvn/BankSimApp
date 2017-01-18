// File: MyFlexibleList.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 10, 2013 

package dataCollections;

import exceptions.*;
import interfaces.*;

// Class Description:
// Constructs a data collection object which can be accessed by the BSA
// This data collection is a doubly headed doubly linked list


public class MyFlexibleList implements MyListInterface {

	// data members
	private Node head = new Node();
	private Node tail = new Node();
	private int numberOfElements;   // current number of Elements

    // method members
	
	// Default constructor
	public MyFlexibleList()
	{
		head.setNext(tail);
		tail.setPrev(head);
		numberOfElements = 0;
	} // end constructor
	
        //Description:   Inserts a Listable element in numerical order (by place) into data collection (collection of Elements)
	public void insert(Listable element, int place, boolean eventA) 
        // Postcondition: A new element is added in the correct position in the sorted data collection
	{	
		if(element!=null)
		{
			boolean found = false; // indicates whether the element is present in the data collection
                        Node tmp = head.getNext();

                        //Loops until the element is found or it reaches the end of the linked list
                        while((tmp.getNext() != null) && (!found))
                            {
                                
                            // if the element is an arrival event and its arrival time is less then or equal to the current node, 
                            // insert before current node
                            if (place <= tmp.getElement().getTime() && eventA == true)
                            {
                                Node newNode = new Node(element); //Creates new node containing the listable element
				Node tmpNode = tmp.getPrev();
				tmp.setPrev(newNode);
				newNode.setNext(tmp);
				tmpNode.setNext(newNode);
				newNode.setPrev(tmpNode);
				numberOfElements++;
                                found = true;  
                            }
                            
                            // if the element is a departure event and its arrival time is less then the current node, 
                            // insert before current node
                           if (place < tmp.getElement().getTime() && eventA == false ){
                                Node newNode = new Node(element); //Creates new node containing the listable element
				Node tmpNode = tmp.getPrev();
				tmp.setPrev(newNode);
				newNode.setNext(tmp);
				tmpNode.setNext(newNode);
				newNode.setPrev(tmpNode);
				numberOfElements++;
                                found = true;
                           }
                           
                           // if the element is an departure event and its arrival time is equal to the current node and the next node is not the same departure time,
                           // insert after current node node
                           if (place == tmp.getElement().getTime() && eventA == false && tmp.getNext().getElement().getTime() != place){
                                Node newNode = new Node(element); //Creates new node containing the listable element
				Node tmpNode = tmp.getNext();
				tmp.setNext(newNode);
				newNode.setPrev(tmp);
				tmpNode.setPrev(newNode);
				newNode.setNext(tmpNode);
				numberOfElements++;
                                found = true;
                           }
                            else
                            {
                                    tmp = tmp.getNext();
                            }
                        }
                        
                        //If none of the if statements are satisfied, insert the element at the end of the list
                        if (found == false)    {
				Node newNode = new Node(element); //Creates new node containing the listable element
				Node tmpNode = tail.getPrev();
				tail.setPrev(newNode);
				newNode.setNext(tail);
				tmpNode.setNext(newNode);
				newNode.setPrev(tmpNode);
				numberOfElements++;
                        }

				

		}
		return;
	} // end of insert method

	/*
	 * Description: This method finds and returns the first element without deleting it
	 *              from the data collection (collection of Elements) 
	 */
	public Listable retrieve() throws EmptyListException
	{
		Listable elementStore = null;
		boolean notFound = true;

		if (numberOfElements <= 0)
		{
			throw new EmptyListException("There are no Elements!");
		}
		else
		{

			
			Node tmp = head.getNext();
			
			elementStore = tmp.getElement();
			notFound = false;

		}
		

		return elementStore;
	} // end of retrieve method
	
	
	/*
	 * Description:   This method finds and deletes the first element
	 *                from the data collection (collection of Elements)
	 */
	public void delete() throws EmptyListException
    // Precondition:  List is not empty.
	// Postcondition: numberOfElements is decremented by 1
	// 				  the element found at the end of the array is now found in the
	// 				  deleted element's position
	{
		boolean deleted = false;
		
		if (numberOfElements <= 0)
		{
			throw new EmptyListException("There are no Elements!");
		}
		else 
		{
			Node tmp = head.getNext();
			
			tmp.getPrev().setNext(tmp.getNext());
			tmp.getNext().setPrev(tmp.getPrev());
			tmp = new Node(null);
			deleted = true;
			numberOfElements--;
				}

			
        return;
	} //end of delete method
	
	/*
	 * Description: Transforms into a string all the elements in the data collection
	 */	
	public String toString( )
	// Postcondition: The string containing all the element information is returned
	{
		String theString = "";
		Node tmp = head.getNext();
		
		if ((numberOfElements <= 0)||(tmp.getNext() == null))
		{
			// No Elements to display
			theString = "\nThere are no Elements!";        
		}
		else 
		{
			theString += "\nDisplaying all Elements:\n";
			while(tmp.getNext() != null)
			{
				theString+="\n"+tmp.getElement().toString()+"\n";
				tmp = tmp.getNext();
			}
		}
		return theString;
	} // end of toString method


	/*
	* Description: Returns the number of elements currently stored in the list
	*/
	public int size() 
	//Postcondition: Returns 0 if empty otherwise returns the number of elements
	{
		return numberOfElements;
	} // end of size method

	/* 
    *  Description: Deletes all the elements from the list. 
	*/
	public void deleteAll() 
	//Postcondition: List is empty.
	{
		head.setNext(tail);
		tail.setPrev(head);
		numberOfElements = 0;
	}
	
} // end of MyFlexibleList data collection class