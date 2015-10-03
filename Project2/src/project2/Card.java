
package project2;

/**
 * Creates Card objects and access its data.
 */

public class Card extends CardData 
{
    private String cardFace;
    private String cardSuit;
    private int num;
   
    //constructor
    public Card(String obj)
    {
        num = Integer.parseInt(obj.trim());
        cardFace = generateFace(num);
        cardSuit = generateSuit(num,true);
    }
    
    /**
     * Returns the card's face.
     * @return cardFace. 
     */
    public String getFace()
    {
        return cardFace;
    }
    
    /**
     * Returns the card value(numbers between 0 and 12).
     * @return value from the CardData class. 
     */
    public int getValue()
    {
        return value;
    }
    
   /**
     * Converts Card object to string.
     * @return cardFace+cardSuit. 
     */
    @Override
    public String toString()
    {
        return cardFace+cardSuit;
    }
}
