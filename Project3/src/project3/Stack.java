package project3;

/**
* Stack class.
* Holds states objects from the transactions text file.
*/
public class Stack implements Stackable 
{
    private Node top;

    /**
     * Displays the items stored in the Stack.
     */
    public void display() 
    {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.getNext();
        }
    }
    
    /**
     * Displays the names of states stored in the Delete Stack.
     */
    public void displayName() 
    {
        Node temp = top;
        while (temp != null) 
        {
            System.out.println(temp.getState().getStateName());
            temp = temp.getNext();
        }
    }

    /**
     * Determines if the Stack is empty.
     *
     * @return True if the Stack is empty; otherwise, false.
     */
    @Override
    public boolean isEmpty() 
    {
        return top == null;
    }

    /**
     * Determines if the Stack is full.
     *
     * @return True if the Stack is full; otherwise, false.
     */
    @Override
    public boolean isFull() 
    {
        return false;
    }

    /**
     * Removes a item from the top of the Stack.
     *
     * Note: The isEmpty method should be called first to prevent errors.
     *
     * @return The item that was removed.
     */
    public State pop() 
    {
        Node temp = top;
        top = temp.getNext();
        return temp.getState();
    }

    /**
     * Adds a item to the top of the Stack.
     *
     * Note: The isFull method should be called first to prevent errors.
     *
     * @param item The item to add.
     */
    @Override
    public void push(State item) 
    {
        Node state = new Node(item);
        state.setNext(top);
        top = state;  
    }
}
