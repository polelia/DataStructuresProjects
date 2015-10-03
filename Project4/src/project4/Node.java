
package project4;

/**
 * Node class
 * Creates and operates nodes.
 */
public class Node  implements Linkable
{
    
    private Node leftChild; // Pointer to the left child node
    private Node rightChild; // Pointer to the right child node
    private State value; // The value stored in the node
    private Node next;
    private Node previous;

    public Node(State item) 
    {
        value = item;
    }

    /**
     * Returns the current node's left child node. 
     * @return the current node's left child node.
     */
    @Override
    public Node getLeftChild() 
    {
        return leftChild;
    }

    /**
     * Returns the current node's right child node. 
     * @return the current node's right child node.
     */
    @Override
    public Node getRightChild() 
    {
        return rightChild;
    }

    /**
     * Sets the current node's left child node.
     * @param node the node to assign to the left child.
     */
    @Override
    public void setLeftChild(Node node) 
    {
        leftChild = node;
    }

    /**
     * Sets the next pointer to the node to the right of the current node.
     * @param node the node to assign to the next pointer.
     */
    @Override
    public void setRightChild(Node node) 
    {
        rightChild = node;
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
     * Returns the node to the left of the current node.
     * @return the node to the left of the current node.
     */
    @Override
    public Node getPrevious()
    {
        return previous;
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
     * Returns the State object stored in the current node.
     * @return the State object stored in the current node.
     */
    @Override
    public State getState()
    {
        return value;
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
