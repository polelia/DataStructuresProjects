
package project4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Driver class.
 * Controls operations of the program. 
 */
public class Driver 
{
    private Stack stackStates = new Stack();
    private int[] populDel = new int[17];
    private BinaryTree stateTree = new BinaryTree();
    
    /**
     * Performs some string formatting to display
     * Executes the search and display operations of the program
     * @param fileA
     * @param fileB
     * @param fileD 
     */
    public void execute( String fileA, String fileB, String fileD)
    {
        readStatesFile(fileA, fileB); 
        
        System.out.println(String.format("%-16s %-16s %-4s %11s %-16s %-8s", "State","Capital","Abbr"," Population"," Region", "Region #"));
        stackStates.display();
        
        while (!stackStates.isEmpty()) //inserts state oblects from the stack to the binary tree
        {
            stateTree.insert(stackStates.pop());
        }
        System.out.println(" ");
        System.out.println("State data (Ascending by Population): ");
        System.out.println(String.format("%-16s %-16s %-4s %11s %-16s %-8s", "State","Capital","Abbr"," Population"," Region", "Region #"));
        stateTree.display(true);
        System.out.println(" ");
        System.out.println("State data (Descending by Population): ");
        System.out.println(String.format("%-16s %-16s %-4s %11s %-16s %-8s", "State","Capital","Abbr"," Population"," Region", "Region #"));
        stateTree.display(false);
        System.out.println("");
        
        readDeleteFile(fileD);
        
        System.out.println("Deleted States: ");
        System.out.println(String.format("%-16s %-16s %-4s %11s %-16s %-8s", "State","Capital","Abbr"," Population"," Region", "Region #"));
        
        for(int i = 0; i < populDel.length; i++) //removes states from the tree based on the population values from the delete file
        {
           System.out.println((stateTree.remove(populDel[i])).toString());
        }
        
        System.out.println(" ");
        System.out.println("State data (Ascending by Population): ");
        System.out.println(String.format("%-16s %-16s %-4s %11s %-16s %-8s", "State","Capital","Abbr"," Population"," Region", "Region #"));
        
        stateTree.display(true);
        
        System.out.println(" ");
        System.out.println("State data (Descending by Population): ");
        System.out.println(String.format("%-16s %-16s %-4s %11s %-16s %-8s", "State","Capital","Abbr"," Population"," Region", "Region #"));
        
        stateTree.display(false);
        
        System.out.println(" ");
        
    }
    
    /**
     * Reads input files using buffered reader.
     * Passes read line as a parameter to State constructor.
     * Inserts state objects into Stack.
     * @param fileA, fileB "States.Input.A.txt", "States.Input.B.txt")
     */
    private void readStatesFile(String fileA, String fileB)
    {
        try 
        {
            BufferedReader brA = new BufferedReader(new FileReader(fileA));
            BufferedReader brB = new BufferedReader(new FileReader (fileB));
            String lineA;
            String lineB;
            
            lineA = brA.readLine();
            lineB = brB.readLine();
            while ((lineA) != null || (lineB) != null) 
            {  
                if (lineB == null) //second fileB is empty, read from fileA
                {
                    stackStates.push(new Node(new State (lineA)));
                    lineA = brA.readLine();
                }
              
                else if (lineA == null) // when file A is empty, read from fileB
                {
                    stackStates.push(new Node(new State(lineB)));
                    lineB = brB.readLine();
                }
                
                else if (lineA.compareToIgnoreCase(lineB) < 0) //if state from A is smaller than one from B, state A is pushed into stack
                {
                    stackStates.push(new Node(new State (lineA)));
                    lineA = brA.readLine();
                }
                
                else if (lineA.compareToIgnoreCase(lineB)> 0) //if state A is greater then the one from B, B is pushed into stack 
                {                   
                    stackStates.push(new Node(new State(lineB)));
                    lineB = brB.readLine();
                }      
            }    
            brA.close();
            brB.close();
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
    private void readDeleteFile(String fileD)
    {
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(fileD));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null)
            {   
                populDel[count] = Integer.parseInt(line.trim()); //populates an array with the values parsed into integers
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
}
