package project2;

/**
 * Provides the methods required to implement a stack of Card objects.
 * 
 * This interface MUST be implemented by a class.
 * i.e., public class Stack implements Stackable {
 * 
 * @author Jim Littleton
 * @since January 30, 2014
 */
public interface Stackable {
    
    /**
     * Displays the Card objects stored in the stack.
     * 
     * Hint: Start at the top and work your way down to 0.
     */
    public void displayStack();
    
    /**
     * Determines if the stack is empty.
     * @return True if the stack is empty; otherwise, false.
     */
    public boolean isEmpty();
    
    /**
     * Determines if the stack is full.
     * @return True if the stack is full; otherwise, false.
     */
    public boolean isFull();
    
    /**
     * Removes a Card object from the top of the stack.
     * @return The Card object that was removed.
     */
    public Card pop();
    
    /**
     * Adds a Card object to the top of the stack.
     * @param card The Card object to add.
     */
    public void push(Card card);
}

