// File: Node.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 10, 2013 

package dataCollections;

import interfaces.*;

//Node for Myflexiblelist
public class Node 
{
	// data members
	private Listable element;
	private Node next;
        private Node prev;

	// constructors
	public Node() {
		this(null, null, null);
	} // end constructor

	public Node(Listable newElement) {
		this(newElement, null, null);
	} // end constructor
        
        public Node(Listable newElement, Node nextNode, Node prevNode) {
		element = newElement;
		next = nextNode;
                prev = prevNode;
	} // end constructor

	// getters
	public Listable getElement() {
		return element;
	} // end getElement

	public Node getNext() {
		return next;
	} // end getNext
        
        public Node getPrev() {
		return prev;
	} // end getNext
	
	// setters
	public void setElement(Listable newElement) {
		element = newElement;
	} // end setElement

	public void setNext(Node nextNode) {
		next = nextNode;
	} // end setNext
        
        public void setPrev(Node prevNode) {
		prev = prevNode;
	} // end setNext

}  // end Node