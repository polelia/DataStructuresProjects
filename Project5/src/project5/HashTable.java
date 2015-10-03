
package project5;

public class HashTable implements Hashable
{
    private Node[] hashTable;
    
    //constructor
    public HashTable (int i)
    {
         hashTable = new Node[i];
    }
    
     /**
     * Displays the items stored in the hash table.
     */
    @Override
    public void display()
    {
        Node temp = null;
        System.out.println("Hash Table List: ");
        System.out.println(String.format("%-16s %-16s %-4s %11s %-16s %-8s", "State","Capital","Abbr"," Population"," Region", "Region #"));
        for(int x = 0; x < hashTable.length; x++) // Traverse the array
        { 
            temp = hashTable[x];
            System.out.println("\nIndex " + x +":");
            
            while(temp != null) // Traverse the linked list
            { 
                System.out.println(temp.getState().toString());
                temp = temp.getNext(); 
            }
        } 
    }
    /**
     * Determines the hash index based on the input value (a state name).
	 *
	 * The hash function MUST meet the following requirements:
	 *   - Calculate the sum of all the character values in the state name (i.e., A = 65, B = 66, etc.)
	 *   - Calculate the modulus of this sum using the size of the hash table array (i.e., sum % 10)
	 *
     * @param value The value to calculate the hash index.
     * @return the hash index based on the input value.
     */
    @Override
    public int getHash(String value)
    {
        int hash = 0;
        int strLength = value.trim().length();
        for(int i = 0; i < strLength; i++)
        {
            hash += value.charAt(i);
        }
        return hash%10;
    }
	
    /**
     * Adds an item to the appropriate location of the hash table.
     * @param state The State object to add.
     */
    @Override
    public void insert(State state)
    {
        int hash = getHash(state.getStateName());
        Node temp = hashTable[hash];
        Node addState  = new Node(state);

        if(isEmpty(hash)) // Checks if the hashed index of the array is empty
        { 
            hashTable[hash] = addState;
        }

        else if(addState.getState().getStateName().compareToIgnoreCase(temp.getState().getStateName())<0) // Should the value be inserted at the front
        { 
            addState.setNext(temp);
            hashTable[hash] = addState;
        }

        else 
        {
            temp = findNode(hashTable[hash], addState);

            addState.setNext(temp.getNext());

            temp.setNext(addState);
        }
    }
    
    // Recursive method to locate correct location to insert new value
    private Node findNode(Node node, Node value) { 

        if (node.getNext() != null && value.getState().getStateName().compareToIgnoreCase(node.getNext().getState().getStateName())>=0)  
        {
            node = findNode(node.getNext(), value);
        }
        return node;
    }

    /**
     * Determines if the specified index of the hash table is empty.
     * @param index The index of the hash table to test.
     * @return True if the specified index of the hash table is empty; otherwise, false.
     */
    @Override
    public boolean isEmpty(int index){
        return hashTable[index] == null;
    }

	
	/**
     * Locates the specified state in the hash table.
     * @param name The state name to find in the hash table.
     * @return A message indicating whether the state was found in the hash table, and the hash and position of the state, if found.
     */
    @Override
    public String findState(String name)
    {
        String message;
        int pos = 1;        
        int hash = getHash(name); // Calculate the hash for the input state name 

        Node temp = hashTable[hash]; // Go to the first node in the appropriate linked list 
        
        // Traverse the linked list until the value is found or the end of the list is reached
        while(temp != null && !(temp.getState().getStateName().equals(name))) 
        { 
            temp = temp.getNext();
            pos++;
        }

        if(temp != null) // The end of the list wasn't reached
        { 
           message = String.format("%s location is Hash: %d Position: %d\n", name, hash, pos);   
        }
        else //The end of the list was reached
        {
           message = String.format("%s was not found in the hash table.\n", name);
        }
        return message;
    }
	
    /**
     * Traverses hash table and removes one state node at a time
     * @return state object
     */
    @Override
    public State remove()
    { 
       Node temp = null;
       State state = null;
       boolean found = false;
       int j = 0;
       while (!found && j<hashTable.length)  // Traverse the array
       {
           if (hashTable[j] != null)
           {
               temp = hashTable[j];
               if (hashTable[j].getNext() != null) // not the only one node in the list
               {
                   state = temp.getNext().getState();  //state from the next node to the front one that will be removed 
                   hashTable[j].setNext(temp.getNext().getNext()); //removes node next to the first node
                   found = true;
               }
               else
               {
                   hashTable[j] = hashTable[j].getNext(); // linked list contain only one node
                   state = temp.getState();
                   found = true;
               }
           }
           j++;
       }
      return state;
    }
}


