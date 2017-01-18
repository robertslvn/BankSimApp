// File: QueueArrayBased.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 10, 2013 

package dataCollections;

import interfaces.*;
import exceptions.*;

public class QueueArrayBased implements QueueInterface {
    private final int MAX_QUEUE = 50;       //max size of queue
    private Queueable[] items;
    private int front, back, count;
    
    public QueueArrayBased(){
    items = new Queueable[MAX_QUEUE];
    front = 0;
    back = MAX_QUEUE-1;
    count = 0;
    } //end default constructor
    
    //queue operations
    public boolean isEmpty() {
    return count == 0;
    } 
    
    public boolean isFull() {
    return count == MAX_QUEUE;
    } 
    
    public void enqueue(Queueable element) throws EmptyQueueException {
    if (!isFull()) {
        back = (back+1) % (MAX_QUEUE);
        items[back] = element;
        ++count;
    }
    else {
    throw new EmptyQueueException("QueueException on enqueue:" + "Queue full");
        }
    }
    
    public Queueable dequeue() throws EmptyQueueException {
    if (!isEmpty()) {
        Queueable queueFront = items[front];
        front = (front+1) % (MAX_QUEUE);
        --count;
        return queueFront;
    }
    else {
    throw new EmptyQueueException("QueueException on dequeue: " + "Queue empty");
        }
    }
    
    public void dequeueAll() {
    items = new Queueable[MAX_QUEUE];
    front = 0;
    back = MAX_QUEUE - 1;
    count = 0;
    }
    
    public Queueable peek() throws EmptyQueueException {
    if (!isEmpty()) {
        return items[front];
    }
    else {
    throw new EmptyQueueException("Queue exception on peek: " + "Queue empty");
    }
    
    }
}
