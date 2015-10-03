
package project3;

/**
 * Priority Queue class.
 * Stores states objects in the doubly-linked list.
 */
public class PriorityQueue implements Queueable {

    private Node front = null;
    private Node rear = null;

    /**
     * Displays the items stored in the queue.
     */
    @Override
    public void display() 
    {
      Node temp = front;
      while(temp != null) 
      {
         System.out.println(temp.toString());
         temp = temp.getNext();
      }
    }

    /**
     * Displays the items in the queue from front to rear.
     */
    @Override
    public void frontDisplay() {
        Node temp = front;

        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.getNext();
        }
    }

    /**
     * Adds a State object to the appropriate location of the queue.
     *
     * Note: The isFull method should be called first to prevent errors.
     *
     * @param state The State to add.
     */
    @Override
    public void insert(State state) {
        
        Node newState = new Node(state);
        Node temp = front;
        if (front == null) {
            front = newState;
            rear = front;
        } 
        else 
        {
            // Determine correct position for state
            while (temp != null && (temp.getState().getStateName().compareToIgnoreCase(newState.getState().getStateName()))<0) 
            {
                temp = temp.getNext();
            }
            
            // Insert at rear
            if (temp == null || temp.getNext() == null) 
            {
                rear.setNext(newState);
                newState.setPrevious(rear);
                rear = newState;
            } 
            
            // Insert at front
            else if (temp.getPrevious() == null) 
            {
                front.setPrevious(newState);
                newState.setNext(front);
                front = newState;
            }
            
            // In the middle
            else 
            {
                newState.setNext(temp);
                newState.setPrevious(temp.getPrevious());
                temp.setPrevious(newState);
                newState.getPrevious().setNext(newState);
            } 
        }
    }
    
    /**
     * Determines if the queue is empty.
     *
     * @return True if the queue is empty; otherwise, false.
     */
    @Override
    public boolean isEmpty() 
    {
        return front == null;
    }

    /**
     * Determines if the queue is full.
     *
     * @return True if the queue is full; otherwise, false.
     */
    @Override
    public boolean isFull() 
    {
      return false;
    }

    /**
     * Displays the items in the queue from rear to front.
     */
    @Override
    public void rearDisplay() 
    {
        Node temp = rear;
        while (temp != null) 
        {
            System.out.println(temp.toString());
            temp = temp.getPrevious();
        }
    }

    /**
     * Removes a State object from the front of the queue.
     *
     * Note: The isEmpty method should be called first to prevent errors.
     *
     * @return The State object that was removed.
     */
    @Override
    public State remove() 
    {
        Node temp = front;
        
        front = front.getNext();
        
        if(!isEmpty())
        {
        front.setPrevious(null);
        }
        
        return temp.getState();
    }

    /**
     * Removes a State object from the queue.
     *
     * Note: The isEmpty method should be called first to prevent errors.
     *
     * @param itemName The name of the State object to search for and remove.
     * @return The State object that was removed.
     */
    @Override
    public State remove(String itemName) 
    {
        Node temp1, temp2; 
        Node removeState = front.searchNodes(itemName, front);
        
        //state object to delete located at the front
        if (removeState.getPrevious() == null)
        {
            front = front.getNext();
            front.setPrevious(null);
        }
        
        //state object to delete located at the end
        else if (removeState.getNext() == null)
        {
            temp1 = rear.getPrevious();
            rear.setPrevious(null);
            rear = temp1;
            rear.setNext(null);
        }
        
        //state object is located somewhere in the middle
        else 
        {
            temp1 = removeState.getPrevious();
            temp2 = removeState.getNext();
            temp1.setNext(temp2);
            temp2.setPrevious(temp1);
            removeState.setNext(null);
            removeState.setPrevious(null); 
        }
        return removeState.getState();
    }
}
