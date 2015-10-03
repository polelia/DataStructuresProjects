package project2;

/**
 * Provides the methods for a Discard Pile objects.
 */
public class Queue implements Queueable 
{
    private int maxSize, front, rear, numEl;
    private Card[] discardPile;
    
    //constructor
    public Queue(int size) 
    {
        maxSize = size;
        discardPile = new Card[maxSize];
        front = numEl = 0;
        rear = -1;
    }
    
    /**
     * Adds a Card object to the appropriate location of the queue.
     * Note:  The isFull method should be called first to prevent errors.
     * @param card The Card object to add.
     */
    @Override
    public void insert(Card card)
    {
        
        discardPile[++rear] = card;
        
        numEl++;
        
    }
    
    /**
     * Determines if the queue is empty.
     * @return True if the queue is empty; otherwise, false.
     */
    @Override
    public boolean isEmpty() 
    {
    return numEl == 0;
    }
    
    /**
     * Determines if the queue is full.
     * @return True if the queue is full; otherwise, false.
     */
    @Override
    public boolean isFull() 
    {
        return numEl == maxSize;
    }
    
     /**
     * Removes a Card object from the front of the queue.
     * 
     * Note:  The isEmpty method should be called first to prevent errors.
     * @return The Card object that was removed.
     */
    @Override
    public Card remove()
    {
        if (!isEmpty())
        {
            numEl--;
        }
        return discardPile[front++];  
    }
    
    /**
     * Removes a Card object from the specified position in the queue.
     * 
     * Note:  The isEmpty method should be called first to prevent errors.
     * @param position The position of the queue at which to remove the Card object.
     * @return The Card object that was removed.
     */
    @Override
    public Card remove(int position)
    {
        for(int i = position; i<numEl;i++)
        {
            discardPile[i] = discardPile[i+1];
            numEl--;       
        }
        return discardPile[position];
    }

    /**
     * Returns the Card object at the front of the queue.
     * 
     * Note:  The isEmpty method should be called first to prevent errors.
     * @return The Card object at the front of the queue.
     */
    @Override
    public Card peek()
    {
        return discardPile[front];
    }
    
    /**
     * Returns the value of the Card object at the specified position in the queue.
     * 
     * @param position The position of the queue at which to peek.
     * @return the value of the Card object at the specified position in the queue.
     */
    @Override
    public int peek(int position)
    {
        return discardPile[position].getValue();
    }
    
    /**
     * Displays the Card objects stored in the queue.
     */
    @Override
    public void displayQueue() 
    {
        for (int x = front; x <= rear; x++) {
            System.out.format("%s ", discardPile[x]);
        }
    }
}
