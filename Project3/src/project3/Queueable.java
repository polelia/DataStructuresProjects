package project3;

/**
 * Provides the methods required to implement a priority queue as a linked-list.
 * 
 * This interface MUST be implemented by a class.
 * i.e., public class PriorityQueue implements Queueable {
 * 
 * @author Jim Littleton
 * @since February 14, 2014
 * @version 14.10.17
 */
public interface Queueable {
    /**
     * Displays the items stored in the queue.
     */
    public void display();
    
    /**
     * Displays the items in the queue from front to rear.
     */
    public void frontDisplay();


    /**
     * Adds a State object to the appropriate location of the queue.
     *
     * Note:  The isFull method should be called first to prevent errors.
     * @param state The State to add.
     */
    public void insert(State state);


    /**
     * Determines if the queue is empty.
     * @return True if the queue is empty; otherwise, false.
     */
    public boolean isEmpty();
    

    /**
     * Determines if the queue is full.
     * @return True if the queue is full; otherwise, false.
     */
    public boolean isFull();
    
    /**
     * Displays the items in the queue from rear to front.
     */
    public void rearDisplay();


    /**
     * Removes a State object from the front of the queue.
     * 
     * Note:  The isEmpty method should be called first to prevent errors.
     * @return The State object that was removed.
     */
    public State remove();
    
   /**
     * Removes a State object from the front of the queue.
     * 
     * Note:  The isEmpty method should be called first to prevent errors.
     * @param itemName The name of the State object to search for and remove.
     * @return The State object that was removed.
     */
    public State remove(String itemName);
}