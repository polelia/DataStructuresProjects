
package project2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Driver class.
 * Controls the operation of the program. 
 */
public class Game {
    
    public Deck deckArray = new Deck(52);
    public Player[] players;
    private int counter = 0; 
    
     //constructor       
    public Game ()
    {
        players = new Player[4];
        for(int i = 0; i<players.length; i++)
        {
          players[i] = new Player(this,15,i);
        }
    }
    
    /**
     * Controls program operations.
     */
    public void execute()        
    {
        Game game = new Game();
            
        readFile();
        dealCards(7); 
        playGame();
        display();    
    }
    
    /**
     * Plays the game according to the rules.
     */
    private void playGame()
    {
        int num = 7; //number of cards inside each player's hand
        
        while (!deckArray.isEmpty() && num !=0)
        {
            for(int i = 0; i < 4; i++)
            {
              if(num !=0 && !deckArray.isEmpty())
              {
                num = players[i].playHand();
              }  
            }
            counter++; //counts number of rounds
        }      
    }
    
    /**
     * Reads input file using buffered reader.
     * Passes read line as a parameter to Card constructor.
     * Inserts Card objects into Stack(Deck class).
     */
    private void readFile()
    {
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("Cards.Input.txt"));
            String line;
            while ((line = br.readLine()) != null) 
            {
                deckArray.push(new Card(line)); //calls Card constructor, passes string from br as a parameter
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
     * Returns reference to the deck object
     * @return deckArray.
     */
    public Deck getDeck()
    {
        return deckArray;
    }
    
    /**
     * Returns reference to a specified player.
     * @param int index.
     * @return players[ind].
     */
    public Player getPlayer(int ind)
    {
        return players[ind];
    }
    
    /**
     * Deals 7 cards to one player at a time
     * @param numCards - number of cards.
     */
    private void dealCards(int numCards)
    {
        for(int i = 0; i < numCards; i++)
        {
            for (int j = 0; j < players.length; j++) 
            {
                players[j].insert(deckArray.pop());
            }
        }
    }
    
    /**
     * Displays program's output. 
     * 
     */
    private void display()
    {
        System.out.println("After " + counter +" rounds:\n");
        for (int i = 0; i < 4; i++)
        {
            players[i].display(i);
        }
        deckArray.displayStack();
    }
}


