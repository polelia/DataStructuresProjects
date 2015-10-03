/* 
 * Rename package below to match the package name of your project.
 * Note:  Refer to the package name in the project's primary class file.
 */
package project5;

/**
 * Provides the methods required to implement a hash table of State objects.
 * 
 * This interface MUST be implemented by a class.
 * i.e., public class HashTable implements Hashable {
 * 
 * @author Jim Littleton
 * @since April 5, 2014
 */
public interface Hashable {
    /**
     * Displays the items stored in the hash table.
     * @param ascending True if items ordered from smallest to largest; otherwise, from largest to smallest.
     */
    public void display();
    
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
    public int getHash(String value);
	
    /**
     * Adds an item to the appropriate location of the hash table.
     * @param state The State object to add.
     */
    public void insert(State state);
    
	/**
     * Determines if the specified index of the hash table is empty.
     * @param index The index of the hash table to test.
     * @return True if the specified index of the hash table is empty; otherwise, false.
     */
    public boolean isEmpty(int index);
	
	/**
     * Locates the specified state in the hash table.
     * @param name The state name to find in the hash table.
     * @return A message indicating whether the state was found in the hash table, and the hash and position of the state, if found.
     */
	public String findState(String name);
	
    /**
     * Removes the next State object from the hash table.
     * @return The State object that was removed.
     */
    public State remove();
}
