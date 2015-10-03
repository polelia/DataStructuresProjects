
package project3;

/**
 * State class
 * Creates and displays state objects
 */
public class State 
{
    private String stateName;
    private String capital;   //capital of state
    private String abbr;      //abbreviation of state name
    private int population;   //population of state
    private String region;    //region of state
    private String regionNum; //region number
     
     //constructor
    public State(String obj1)
    {
        stateName = obj1.substring(0, 15);
        capital = obj1.substring(15, 30);
        abbr = obj1.substring(30, 32);
        population = Integer.parseInt(obj1.substring(32, 40).trim());
        region = obj1.substring(40, 55);
        regionNum = obj1.substring(55);
    }
    
     /**
     * Returns state name
     * @return a name of a student 
     */
    public String getStateName()
    {  
        return stateName;
    }
    
    /**
    * Displays content of the state object.
    * @return string-representation of an object
    */
    @Override
    public String toString()
    {
        return (String.format("%-16s %-16s %-4s %,11d %-16s %-8s", stateName,capital,abbr,population," " + region, regionNum));
    }
}
