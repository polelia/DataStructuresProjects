
package project5;

public class Node implements Linkable
{
    private State value;
    private Node next;
    
    //constructor
    public Node(State stateObj)
    {
        value = stateObj;
    }
    /**
     * Returns the node to the right of the current node.
     * @return the node to the right of the current node.
     */
    @Override
    public Node getNext()
    {
        return next;
    }
    /**
     * Returns the state object stored in the current node.
     * @return the state object stored in the current node.
     */
    @Override
    public State getState()
    {
        return value;
    }
    /**
     * Sets the next pointer to the node to the right of the current node.
     * @param node the node to assign to the next pointer.
     */
    @Override
    public void setNext(Node node) 
    {
        next = node;
    }
}