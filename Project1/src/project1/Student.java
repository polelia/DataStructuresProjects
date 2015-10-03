
package project1;

/**
 * Constructs a Student object
 * @author Nadiia
 */
public class Student {
    
    private String lastName;
    private String firstName;
    private int finalPosition;
    private int projAttempt;  //projects attempted
    private int projCompl;    //projects completed
    private int ttlPoints;    //total points
    
    public Student(String obj1){
        
        //constructor
        firstName = obj1.substring(0, 9).trim();
        lastName = obj1.substring(9, 19).trim();
        finalPosition = (Integer.parseInt(obj1.substring(19, 21).trim()));
        projAttempt = (Integer.parseInt(obj1.substring(21, 23).trim()));
        projCompl = (Integer.parseInt(obj1.substring(23, 24).trim()));
        ttlPoints = (Integer.parseInt(obj1.substring(24).trim()));
}
    
     /**
     * Returns full name
     * @return a name of a student in format "lastName, firstName"
     */
    public String getFullName(){  
        return (lastName + ", " + firstName);
    }
    
    /**
     * Gets number of total points
     * @return number of total points
     */
    public int getPoints(){
        return ttlPoints;
    }
    
    /**
     * Displays content of the student object
     * @return string-representation of an object
     */
    public String toString(){
        return (String.format("%-20s %8d %9d %9d %12d", getFullName(),finalPosition,projAttempt,projCompl,ttlPoints));
    }
    
}
