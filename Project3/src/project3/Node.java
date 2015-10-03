
package project3;

/**
 * Node class
 * Creates and operates nodes.
 */
public class Node  implements Linkable{
    private State value;
    private Node next;
    private Node front;
    private Node previous;
    
    //constructor
    public Node(State stateObj){
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
     * Returns the node to the left of the current node.
     * @return the node to the left of the current node.
     */
    @Override
    public Node getPrevious()
    {
        return previous;
    }
    
    /**
     * Returns the State object stored in the current node.
     * @return the State object stored in the current node.
     */
    @Override
    public State getState()
    {
        return value;
    }
    
    /**
     * Returns the node containing the specified name.
     * @param stateName The name to search for.
     * @param node The node to start searching from.
     * @return the node containing the specified name.
     */
    @Override
    public Node searchNodes(String stateName, Node node)
    {
        Node temp = node;
         boolean found = false;

         while(temp != null && !found) {
            
            if(temp.getState().getStateName().equalsIgnoreCase(stateName)) {
               found = true;
            }
            else {
               temp = temp.getNext(); 
            }
         }
         return temp;
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
    
    /**
     * Sets the previous pointer to the node to the left of the current node.
     * @param node the node to assign to the previous pointer.
     */
    @Override
    public void setPrevious(Node node)
    {
        previous = node;
    }
	
    /**
     * Returns a formatted string containing the State data.
     * @return a formatted string containing the State data.
     */
    @Override
    public String toString()
    {
        return value.toString();
    }
}
