
package project5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Driver class.
 * Controls operations of the program. 
 */
public class Driver 
{
    private String[] queryStates = new String[10];
    private HashTable stateHash = new HashTable(10);
    /**
     * Controls program operations.
     * @param file1, file2 as a command line arguments (text files)
     */
    public void execute(String file1, String file2)
    {
        String message;
        
        readStatesFile(file1); //Read state input file
        stateHash.display();   //Displays hash table content
        readQueryFile(file2);  //Read query file
        
        System.out.println("\nState Locations: ");
        for (String queryState : queryStates) 
        {
            message = stateHash.findState(queryState); //Looks for the matching state name in the hash table 
            System.out.print(message);                 //Returns message if it was found or not
        }
        writeFile();   //writes hash table contents into Output.txt
    }
    
     /**
     * Reads input file using buffered reader.
     * Passes read line as a parameter to State constructor.
     * Inserts state objects into Linked List of states.
     * @param file "States.Input.txt"
     */
    private void readStatesFile(String file)
    {
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String[] data = new String [6];
            while ((line = br.readLine()) != null) 
            {  
                if (line.contains(",")) //comma separated values
                {                  
                    data = line.split(","); //splits line and inserts data into array
                    stateHash.insert(new State (data));
                }
                else //fixed-length format
                {                   
                    stateHash.insert(new State(line)); //passes the whole line as a paramether
                }
            }    
            br.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.err.format("File Not Found Exception\n");
        } 
        catch (IOException e) 
        {
            System.err.format("IO Exception\n");
        } 
        catch (Exception e) 
        {
            System.err.format("Exception\n");
        } 
    }
    /**
     * Reads fileD into the program (population numbers)
     * @param fileD 
     */
    private void readQueryFile(String file)
    {
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null)
            {   
                queryStates[count] = line.trim(); //populates an array
                count++; 
            }  
            br.close();   
        } 
        catch (FileNotFoundException e) 
        {
            System.err.format("File Not Found Exception\n");
        } 
        catch (IOException e) 
        {
            System.err.format("IO Exception\n");
        } 
        catch (Exception e) 
        {
            System.err.format("Exception\n");
        } 
     }
    
    /**
     * Writes the contents of the states hash table to the output file.
     */
    private void writeFile()
    {
        try 
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter("States.Output.txt"));
           
            String line;
            State state; //removed state object
            
            while((state = stateHash.remove()) != null) //iterates until hashTable is empty
            { 
                line = state.toString(); 
                bw.write(line);
                bw.newLine(); 
            } 
            bw.close();
        } 
        catch (IOException ex) 
        {
            System.err.format("File Cannot Be Written");
        } 
    }
}
