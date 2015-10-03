
package project4;

/**
 * State class
 * Creates and displays state objects
 */
public class State 
{
    private String[] data;
    private String stateName;
    private String capital;   //capital of state
    private String abbr;      //abbreviation of state name
    private int population;   //population of state
    private String region;    //region of state
    private int regionNum; //region number
     
     //constructor
    public State(String obj)
    {
        data = new String [6];
        data = obj.split(",");
        
        stateName = data[0].trim();
        capital = data[1].trim();
        abbr = data[2].trim();
        population = Integer.parseInt(data[3].trim());
        region = data[4].trim();
        regionNum = Integer.parseInt(data[5].trim());
    }
    
     /**
     * Returns state name
     * @return a name of a state 
     */
    public String getStateName()
    {  
        return stateName;
    }
    
    /**
     * Returns state population
     * @return population
     */
    public int getStatePopulation()
    {
        return population;
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