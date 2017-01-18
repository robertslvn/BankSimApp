// File: BSA.java
// Author: Robert Silvan
// Std Number: 301118114
// Lab Number: D106
// Created on: July 10, 2013 

package app;

import dataCollections.*;
import exceptions.ElementAlreadyInListException;
import exceptions.ElementNotInListException;
import exceptions.EmptyListException;
import java.util.Scanner;
import java.io.*;
import interfaces.*;

public class BSA {
    private MyFlexibleList events;         //list of events
    private QueueRefBased queue;           //queue of events
    EventA anEvent = new EventA(1,1);      //initialize, will use later
    int numProcessed = 0;                  //number of customers processed
    double totalTime = 0;                  //total wait time, starts at 0
    int totalTransTime = 0;                //total transaction time, starts at 0
    int firstEventTime;                    //time of the first event
    int Time = 0;                          //current time
       
    //initialize the list and queue in constructor
    public BSA() {
    System.out.println("Welcome to the Simulation");    
    events = new MyFlexibleList();
    queue = new QueueRefBased();
     } // end of default constructor
    
    //performs the simulation on the file filename
    public void simulate(String fileName) throws ElementAlreadyInListException, EmptyListException, ElementNotInListException{
    
    try {
        File inFile = new File(fileName);              
        Scanner fileInput = new Scanner(inFile);
    
        //read the entire file, use its data to create events, and place those events into an ordered list
        while (fileInput.hasNext()) {
            int arrivalTime = fileInput.nextInt();
            int transTime = fileInput.nextInt();
            anEvent = new EventA(arrivalTime, transTime);
            events.insert(anEvent, anEvent.getTime(), true);
            }
        fileInput.close();
        }
    catch (FileNotFoundException e){
        System.out.println(e);
        }
    
    firstEventTime = events.retrieve().getTime();  //get time of first event from list
    Time = Time + firstEventTime; //set current time as the time of the first event
    
    //while the list is no empty, run the simulation
    while (events.size() != 0){

    //if the current event is an arrival event, turn it into an EventA object and process it
    if (events.retrieve() instanceof EventA) {
        EventA tempr = new EventA(events.retrieve().getTime(), events.retrieve().getTransactionTime());
        processArrival(tempr, events, queue);
        totalTransTime = totalTransTime + tempr.getTransactionTime();  //transaction time up to this point
        numProcessed++;    //update number of people processed
        }
    
    //if the current event is a departure event, turn it into an EventD object and process it
     else  {
        EventD tempr = new EventD(events.retrieve().getTime());
        processDeparture(tempr, events, queue);
        }
    }
    //output the final results
    System.out.println("Total number of people processed: " + numProcessed);
    System.out.println("Average amount of time spent waiting: " + totalTime / numProcessed + " minutes");
    }
    
    //other methods used in simulate()
    //process the arrival event
    public void processArrival(EventA arrivalEvent, MyFlexibleList anEventList, QueueRefBased bankQueue) throws EmptyListException, ElementNotInListException, ElementAlreadyInListException {
        System.out.println("Processing a arrival event at time: " + arrivalEvent.getTime());   //print out current event time
        boolean atFront = bankQueue.isEmpty();  //check if queue is empty
        
        //turn the event into a queueable event and enqueue it into the queue
        EventsinQ tempevent = new EventsinQ(arrivalEvent.getTime(), arrivalEvent.getTransactionTime());
        bankQueue.enqueue((tempevent));
        
        anEventList.delete(); //delete the event from the events list
        
        // if the queue is empty, customer is at front of line and begins transaction immediately
        if (atFront) {
            if (arrivalEvent.getTime() > Time){  
                Time = arrivalEvent.getTime();}
        Time = Time + arrivalEvent.getTransactionTime();
        EventD departEvent = new EventD(Time);   //create departure event at current time
        anEventList.insert(departEvent, departEvent.getTime(), false);
        totalTransTime = 0;
        firstEventTime = arrivalEvent.getTime();
        
    
         } 
        else{
        totalTime = totalTime + totalTransTime - arrivalEvent.getTime() + firstEventTime;}
        
    }
    //process the departure event
    public void processDeparture(EventD departureEvent, MyFlexibleList anEventList, QueueRefBased bankQueue) throws EmptyListException, ElementNotInListException, ElementAlreadyInListException {
        System.out.println("Processing a departure event at time: " + departureEvent.getTime()); //print out the current event time
        bankQueue.dequeue(); //remove the first event from the queue
       
        anEventList.delete(); //delete the event from the list
        
        //customer at front of line begins transaction if queue isnt empty
        if (!queue.isEmpty()) {
            Queueable tempor = bankQueue.peek();
            Time = Time + tempor.getTransactionTime();
            EventD departEvent = new EventD(Time);   //create departure event at current time
            anEventList.insert(departEvent, departEvent.getTime(), false);
            }
        else{
        Time = 0;
        }
    }
    //main method
    public static void main(String[] args) throws ElementAlreadyInListException, EmptyListException, ElementNotInListException {
    BSA theBSA = new BSA();  //create new BSA object
    Scanner in = new Scanner(System.in); //get file from user
    System.out.println("Please enter the full filepath of the input text file as per the following format - C:\\Users\\user\\Desktop\\Input.txt");
    String filename = in.nextLine(); //read file name
    theBSA.simulate(filename); //simulate the users file
    }
    }
   
    
