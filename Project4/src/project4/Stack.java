package project4;

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
    @Override
    public void display() 
    {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.getState().toString());
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
    @Override
    public Node pop() 
    {
        Node temp = top;
        top = temp.getNext();
        return temp;
    }

    /**
     * Adds a item to the top of the Stack.
     *
     * Note: The isFull method should be called first to prevent errors.
     *
     * @param item The item to add.
     */
    @Override
    public void push(Node item) 
    {
        if (top == null)
        {
            top = item;
        }
        else
        {
        item.setNext(top);
        top = item;
        }
    }
}
