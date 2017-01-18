// File: NodeQ.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 10, 2013 

package dataCollections;

import interfaces.*;

//node for queuerefbased
public class NodeQ 
{
	// data members
	private Queueable element;
	private NodeQ next;

	// constructors
	public NodeQ() {
		this(null, null);
	} // end constructor

	public NodeQ(Queueable newElement) {
		this(newElement, null);
	} // end constructor
        
        public NodeQ(Queueable newElement, NodeQ nextNode) {
		element = newElement;
		next = nextNode;
	} // end constructor

	// getters
	public Queueable getElement() {
		return element;
	} // end getElement

	public NodeQ getNext() {
		return next;
	} // end getNext
        
	// setters
	public void setElement(Queueable newElement) {
		element = newElement;
	} // end setElement

	public void setNext(NodeQ nextNode) {
		next = nextNode;
	} // end setNext
        

}  // end NodeQ