
package project3;

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
public class Driver {
    
    private PriorityQueue states = new PriorityQueue();
    private Stack stackAdd = new Stack();
    private Stack stackDelete = new Stack();
    private Stack stackUpdate = new Stack();
   
 /**
 * Controls program operations.
 * @param file1, file2, file3 as a command line arguments (text files)
 */
    public void execute(String file1, String file2, String file3)
    {
        //reads states file
        readStatesFile(file1);
        
        //displays States linked list
        System.out.println("Linked List from Front to Rear: ");
        System.out.println(String.format("%-16s %-16s %-4s %11s %-16s %-8s", "State","Capital","Abbr"," Population"," Region", "Region #"));
        states.frontDisplay();
        System.out.println("");
        System.out.println("Linked List from Rear to Front: ");
        System.out.println(String.format("%-16s %-16s %-4s %11s %-16s %-8s", "State","Capital","Abbr"," Population"," Region", "Region #"));
        states.rearDisplay();
        
        //reads states transactions file
        readTransFile(file2);
        
        //displays add stack
        System.out.println("");
        System.out.println("Add Stack: ");
        System.out.println(String.format("%-16s %-16s %-4s %11s %-16s %-8s", "State","Capital","Abbr"," Population"," Region", "Region #"));
        stackAdd.display();
        
        //displays delete stack
        System.out.println("");
        System.out.println("Delete Stack: ");
        System.out.println(String.format("%-16s %-16s %-4s %11s %-16s %-8s", "State","Capital","Abbr"," Population"," Region", "Region #"));
        stackDelete.displayName();
        
        //displays update stack
        System.out.println("");
        System.out.println("Update Stack: ");
        System.out.println(String.format("%-16s %-16s %-4s %11s %-16s %-8s", "State","Capital","Abbr"," Population"," Region", "Region #"));
        stackUpdate.display();
        
        //inserts states from stack into priority queue
        while(!stackAdd.isEmpty())
        {
            states.insert(stackAdd.pop());
        }
        
        //deletes states indicated in delete stack from priority queue
        while(!stackDelete.isEmpty())
        {
            states.remove(stackDelete.pop().getStateName());
        }
        
        //removes and insertes(updates) states from the priority queue using update stack
        while(!stackUpdate.isEmpty())
        {
            State updateState = stackUpdate.pop();
            states.remove(updateState.getStateName());
            states.insert(updateState);
        }
        
        //prints linked list after all transactions
        System.out.println("");
        System.out.println("Linked List from Front to Rear: ");
        System.out.println(String.format("%-16s %-16s %-4s %11s %-16s %-8s", "State","Capital","Abbr"," Population"," Region", "Region #"));
        states.frontDisplay();
        System.out.println("");
        System.out.println("Linked List from Rear to Front: ");
        System.out.println(String.format("%-16s %-16s %-4s %11s %-16s %-8s", "State","Capital","Abbr"," Population"," Region", "Region #"));
        states.rearDisplay();
        
        //writes all states from the priority queue into an output file
        writeFile(file3);
    }
    
     /**
     * Reads input file using buffered reader.
     * Passes read line as a parameter to State constructor.
     * Inserts state objects into Linked List priority queue states.
     * @param file "States.Input.txt"
     */
    private void readStatesFile(String file)
    {
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) 
            {  
                states.insert(new State(line));  
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
     * Reads input file using buffered reader.
     * Splits read line in two parts.
     * First is used in switch statement. 
     * Second, data, is passes as a parameter to State constructor.
     * @param file "States.Trans.txt"
     * Inserts state objects into Linked List stacks.
     */
    private void readTransFile(String file)
    {
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line, sw, data;
            
            while ((line = br.readLine()) != null) 
            {  
                sw = line.substring(0, 1);
                data = line.substring(1);
                switch(sw)  
                {
                    case "A":
                        if (!stackAdd.isFull())
                        {
                            stackAdd.push(new State(data));
                        }
                    break;
                    case "U":
                        if(!stackUpdate.isFull())
                        {
                            stackUpdate.push(new State(data));
                        }
                    break;
                    case "D":
                        if(!stackAdd.isFull())
                        {
                            String dataDel = data + "(((((((((((((((((99999999(((((((((((((((0"; //adds placeholders in order to create state objects
                            
                            stackDelete.push(new State(dataDel));
                        }
                    break;
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
     * Writes the contents of the states linked list to an output file.
     * @param file "States.Output.txt" 
     *  Closes the file
     */
    public void writeFile(String file) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            while (!states.isEmpty())
            {
                bw.write(states.remove().toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException ex) {
            System.err.format("File Cannot Be Written");
        }
    }     
}
