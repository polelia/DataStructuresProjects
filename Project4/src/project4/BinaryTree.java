package project4;
/**
 * Inserts into, deletes from, and displays the binary tree
 * The extra credit methods are created in this class
 * 
 */
public class BinaryTree 
{

    public Node root = null;

    /**
     * Displays the State objects stored in the Binary Tree.
     *
     * @param ascending True if State objects ordered from smallest to largest;
     * otherwise, from largest to smallest.
     */
    public void display(boolean ascending) 
    {
        if (ascending) 
        {
            displayTreeLNR(root); // Display values in ascending order
        } else 
        {
            displayTreeRNL(root); // Display values in descending order
        }
    }

    /**
     * Adds a State object to the appropriate location of the Binary Tree.
     *
     * @param state The State object to add.
     */
    public void insert(Node state) 
    {
        Node temp = root;
        if (temp == null) 
        {
            root = state;
        } 
        else 
        {
            Insert(root, state);
        }
    }
/**
 * Inserts a node to the binary tree at the correct location by states population
 * @param current
 * @param node 
 */
    private void Insert(Node current, Node node) 
    {
        Node temp = current;

        if (node.getState().getStatePopulation() < temp.getState().getStatePopulation()) //compares population
        {
            if (temp.getLeftChild() == null) 
            {
                temp.setLeftChild(node); //smaller than the current node

            } 
            else 
            {
                temp = temp.getLeftChild(); //moves to the next left child
                Insert(temp, node);
            }
        } 
        else //current state population is smaller that the inserted state
        {
            if (temp.getRightChild() == null) 
            {
                temp.setRightChild(node);                
            } 
            else 
            {                
                temp = temp.getRightChild();                
                Insert(temp, node);
            }
        }
    }

    /**
     * Determines if the Binary Tree is empty.
     *
     * @return True if the Binary Tree is empty; otherwise, false.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Removes a State object with the specified population from the Binary
     * Tree.
     *
     * Note: The isEmpty method should be called first to prevent errors.
     *
     * @param population The population of the State to remove.
     * @return The State object that was removed.
     */
    public Node remove(int population) 
    {
        boolean found = false, isLeftChild = false;
        Node parent = root, temp = root;
        while (!found) // Search the tree for the specified node
        {
            if (population == temp.getState().getStatePopulation()) // Once the node to delete is found
            { 
                found = true;
                // Determine how many children the node has and call the appropriate delete method
                if (temp.getLeftChild() == null && temp.getRightChild() == null) 
                {
                    deleteNoChildren(parent, isLeftChild); 
                } 
                else if (temp.getLeftChild() == null || temp.getRightChild() == null) 
                {
                    deleteSingleChild(parent, isLeftChild, temp); 
                } 
                else 
                {
                    deleteWithChildren(parent, isLeftChild, temp);
                }
            } 
            else // Go to the next node
            {
                parent = temp;
                if (population < temp.getState().getStatePopulation()) 
                {
                    isLeftChild = true;
                    temp = temp.getLeftChild();
                } 
                else 
                {
                    isLeftChild = false;
                    temp = temp.getRightChild();
                }
            }
        }
        return temp;
    }
/**
 * Deletes a node that has no children
 * @param parent
 * @param parentsLeftChild 
 */
    private void deleteNoChildren(Node parent, boolean parentsLeftChild) 
    {
        if (parent == root && parent.getLeftChild() == null)
        {
            root = null;
        } else if (parentsLeftChild) 
        {
            parent.setLeftChild(null);
        } else {
            parent.setRightChild(null);
        }
    }
/**
 * Deletes a node that has a single child
 * @param parent
 * @param parentsLeftChild
 * @param temp 
 */
    private void deleteSingleChild(Node parent, boolean parentsLeftChild, Node temp) 
    {
        if (temp.getLeftChild() == null) // Determine which child exists
        {
            if (parentsLeftChild) // Determine path from parent deleted node is on
            {
                parent.setLeftChild(temp.getRightChild()); // Update parent’s left pointer
            } 
            else 
            {
                parent.setRightChild(temp.getRightChild()); // Update parent’s right pointer
            }
        } 
        else 
        {
            if (parentsLeftChild) // Determine path from parent deleted node is on
            {
                parent.setLeftChild(temp.getLeftChild()); // Update parent’s left pointer
            } 
            else 
            {
                parent.setRightChild(temp.getLeftChild()); // Update parent’s right pointer
            }
        }
    }
/**
 * Deletes a node that has two children
 * @param parent
 * @param parentsLeftChild
 * @param node 
 */
    private void deleteWithChildren(Node parent, boolean parentsLeftChild, Node node) 
    {
        Node lastNode = null;
        if (parentsLeftChild) // If the node to delete is parent’s left child
        {
            lastNode = node.getRightChild(); // Start with the node’s right child path
            while (lastNode.getLeftChild() != null) // Find lowest left child on the path
            {
                lastNode = lastNode.getLeftChild();
            }

           // Update the leftChild pointers of the parent node and the last node
            lastNode.setLeftChild(node.getLeftChild());
            parent.setLeftChild(node.getRightChild());
        }
    }
/**
 * Traverses the tree by LNR and displays the nodes of the tree 
 * @param node 
 */
    private void displayTreeLNR(Node node) {

        if (node != null) 
        {
            displayTreeLNR(node.getLeftChild());
            System.out.println(node.getState().toString());
            displayTreeLNR(node.getRightChild());
        }
    }
/**
 * Traverses the tree by RNL and displays the nodes of the tree
 * @param node 
 */
    private void displayTreeRNL(Node node) 
    {
        if (node != null) 
        {
            displayTreeRNL(node.getRightChild());
            System.out.println(node.getState().toString());
            displayTreeRNL(node.getLeftChild());
        }
    }

}
