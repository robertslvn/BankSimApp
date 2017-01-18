// File: QueueRefBased.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 10, 2013 

package dataCollections;

import interfaces.*;
import exceptions.*;

public class QueueRefBased implements QueueInterface {
    private NodeQ lastNode;
    
    public QueueRefBased(){
    lastNode = null;
    } // end default constructor
    
    //queue operations
    public boolean isEmpty(){
    return lastNode == null;
    }
    
    public void dequeueAll(){
    lastNode = null;
    }
    
    public void enqueue(Queueable element){
    NodeQ newNode = new NodeQ(element);
    
        if (isEmpty()) {
            newNode.setNext(newNode);
        }
        else {
            newNode.setNext(lastNode.getNext());
            lastNode.setNext(newNode);
        }
        lastNode = newNode;
    }
   
    public Queueable dequeue() throws EmptyQueueException {
        if (!isEmpty()) {
            NodeQ firstNode = lastNode.getNext();
            if (firstNode == lastNode){
                lastNode = null;
            }
            else{
            lastNode.setNext(firstNode.getNext());
            }
            return firstNode.getElement();
        }
        else {
        throw new EmptyQueueException("QueueException on dequeue:" + "queue empty");
        }
    }
    
    public Queueable peek() throws EmptyQueueException {
        if (!isEmpty()) {
            NodeQ firstNode = lastNode.getNext();
            return firstNode.getElement();
        }
        else {
            throw new EmptyQueueException("QueueException on peek:" + "queue empty");
        }
    }
    
}

