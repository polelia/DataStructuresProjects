package project3;

/**
 * Provides the methods required to implement a Node object in a linked-list.
 * 
 * This interface MUST be implemented by a class.
 * i.e., public class Node implements Linkable {
 * 
 * @author Jim Littleton
 * @since February 14, 2014
 * @version 14.10.17
 */
public interface Linkable {
    
    /**
     * Returns the node to the right of the current node.
     * @return the node to the right of the current node.
     */
    public Node getNext();
    
    /**
     * Returns the node to the left of the current node.
     * @return the node to the left of the current node.
     */
    public Node getPrevious();
    
    /**
     * Returns the State object stored in the current node.
     * @return the State object stored in the current node.
     */
    public State getState();
    
    /**
     * Returns the node containing the specified name.
     * @param stateName The name to search for.
     * @param node The node to start searching from.
     * @return the node containing the specified name.
     */
    public Node searchNodes(String stateName, Node node);
    
    /**
     * Sets the next pointer to the node to the right of the current node.
     * @param node the node to assign to the next pointer.
     */
    public void setNext(Node node);
    
    /**
     * Sets the previous pointer to the node to the left of the current node.
     * @param node the node to assign to the previous pointer.
     */
    public void setPrevious(Node node);
	
	/**
     * Returns a formatted string containing the State data.
     * @return a formatted string containing the State data.
     */
    public String toString();
}
