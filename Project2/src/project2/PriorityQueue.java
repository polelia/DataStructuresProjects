package project2;

/**
 * Provides methods for a priority queue of Card objects.
 * Serves as a player's hand.
 */
public abstract class PriorityQueue implements Queueable {
    
    private int maxSize;
    protected int numElems = 0;
    private Card[] array; //number of cards in the hand
    
    //constructor
    public PriorityQueue(int size) 
    {
        maxSize = size;
        array = new Card[maxSize];
    }
    
    /**
     * Adds a Card object to the appropriate location of the queue.
     *
     * Note:  The isFull method should be called first to prevent errors.
     * @param item The Card object to add.
     */
    @Override
    public void insert(Card item) 
    {  
        int i;
        if(numElems == 0) 
        {
            array[numElems++] = item;
        }
        else 
        {
            i = numElems;
            while(i > 0 && item.value < array[i-1].value) {
            array[i] = array[i - 1];
            i--;
            }
            array[i] = item;
            numElems++;
        }   
    }
    /**
     * Determines if the queue is empty.
     * @return True if the queue is empty; otherwise, false.
     */
    @Override
    public boolean isEmpty() 
    { 
        return numElems == 0; 
    }
    
    /**
     * Determines if the queue is full.
     * @return True if the queue is full; otherwise, false.
     */
    @Override
    public boolean isFull() 
    { 
        return numElems == maxSize; 
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
        numElems--;
        return array[0];  
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
        Card removed = array[position];
        for(int i = position; i<numElems-1;i++)
        {
            array[i] = array[i+1]; 
        }
        numElems--; 
        return removed;
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
        return array[0];
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
        return array[position].getValue();
    }

    /**
     * Displays the Cards objects stored in the queue.
     */
    @Override
    public void displayQueue() {
        for (int i = 0; i < numElems; i++) {
            System.out.format("%s ", array[i]);
        }
    }
}
