package project3;

/**
 * Provides the methods required to implement a Stack as a linked-list.
 * 
 * This interface MUST be implemented by a class.
 * i.e., public class Stack implements Stackable {
 * 
 * @author Jim Littleton
 * @since February 14, 2014
 * @version 14.10.17
 */
public interface Stackable {
    /**
     * Displays the items stored in the Stack.
     */
    public void display();
    
    /**
     * Determines if the Stack is empty.
     * @return True if the Stack is empty; otherwise, false.
     */
    public boolean isEmpty();
    
    /**
     * Determines if the Stack is full.
     * @return True if the Stack is full; otherwise, false.
     */
    public boolean isFull();
    
    /**
     * Removes a item from the top of the Stack.
     * 
     * Note:  The isEmpty method should be called first to prevent errors.
     * @return The item that was removed.
     */
    public State pop();
    
    /**
     * Adds a item to the top of the Stack.
     * 
     * Note:  The isFull method should be called first to prevent errors.
     * @param item The item to add.
     */
    public void push(State item);
}
