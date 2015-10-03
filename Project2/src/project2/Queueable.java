package project2;
/**
 * Provides the methods required to implement a priority queue of Card objects.
 * 
 * This interface MUST be implemented by a class.
 * i.e., public class Queue implements Queueable {
 * i.e., public class PriorityQueue implements Queueable {
 * 
 * @author Jim Littleton
 * @since January 30, 2014
 */
public interface Queueable {
    
    /**
     * Displays the Card objects stored in the stack.
     * 
     * Hint: Start at numElems - 1 and work your way down to 0.
     */
    public void displayQueue();
    
    /**
     * Adds a Card object to the appropriate location of the queue.
     *
     * Note:  The isFull method should be called first to prevent errors.
     * @param card The Card object to add.
     */
    public void insert(Card card);
    
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
     * Returns the Card object at the front of the queue.
     * 
     * Note:  The isEmpty method should be called first to prevent errors.
     * @return The Card object at the front of the queue.
     */
    public Card peek();
    
    /**
     * Returns the value of the Card object at the specified position in the queue.
     * 
     * @param position The position of the queue at which to peek.
     * @return the value of the Card object at the specified position in the queue.
     */
    public int peek(int position);
    
    /**
     * Removes a Card object from the front of the queue.
     * 
     * Note:  The isEmpty method should be called first to prevent errors.
     * @return The Card object that was removed.
     */
    public Card remove();
    
    /**
     * Removes a Card object from the specified position in the queue.
     * 
     * Note:  The isEmpty method should be called first to prevent errors.
     * Hint:  Move all items to the right of the removed item one position to the left.
     * @param position The position of the queue at which to remove the Card object.
     * @return The Card object that was removed.
     */
    public Card remove(int position);
}
