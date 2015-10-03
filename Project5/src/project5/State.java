
package project5;

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
    private int regionNum; //region number
     
     //constructor for a single string data
    public State(String obj1)
    {
        stateName = obj1.substring(0, 15).trim();
        capital = obj1.substring(15, 30).trim();
        abbr = obj1.substring(30, 32).trim();
        population = Integer.parseInt(obj1.substring(32, 40).trim());
        region = obj1.substring(40, 55).trim();
        regionNum = Integer.parseInt(obj1.substring(55).trim());
    }
    
    //constructor for an array of string values
    public State(String data[])
    {    
        stateName = data[0].trim();
        capital = data[1].trim();
        abbr = data[2].trim();
        population = Integer.parseInt(data[3].trim());
        region = data[4].trim();
        regionNum = Integer.parseInt(data[5].trim());
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
        return (String.format("%-16s %-16s %-4s %,11d %-16s %8d", stateName,capital,abbr,population," " + region, regionNum));
    }
}
