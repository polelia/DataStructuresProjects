
package project2;

/**
 * Collection class. Inherits PriorityQueue class.
 * Player object.
 */
public class Player extends PriorityQueue 
{ 
    public Queue dPile = new Queue(52); //serves as a discard pile
    Game game;
    public int position;
    
    //constructor
    public Player(Game obj, int size, int ind) 
    {
        super(size);
        game = obj;
        position = ind;
    }
    
    /**
     * Returns the player's object position index in the game array.
     * @return position.
     */
    public int getPosition()
    {
        return position;
    }
    
    /**
     * Discards a Card object to the queue discard array.
     * @param card The Card object to discard.
     */
    private void discard(Card card)
    {
        dPile.insert(card);
    }
    
    /**
     * Displays the Cards objects stored in the player's hand.
     */
    private void displayHand()
    {
        displayQueue();
    }
    
    /**
     * Displays the discarded Cards objects stored in the pile.
     */
    private void displayPile()
    {
        dPile.displayQueue();
    }
    
    /**
     * Draws a Card object from the Deck class.
     * @return the Card object from the top of Deck array.
     */
    private Card drawCard()
    {
        return game.getDeck().pop(); 
    }
    
    /**
     * Returns next player object to the current one.
     * @param currentPlayer.
     * @return nextPlayer 
     */
    private Player getNextPlayer (Player currentPlayer)
    {    
        Player nextPlayer = null;
        
        if(currentPlayer == game.getPlayer(0))
            nextPlayer = game.getPlayer(1);
        else if(currentPlayer == game.getPlayer(1))
            nextPlayer = game.getPlayer(2);
        else if(currentPlayer == game.getPlayer(2))
            nextPlayer = game.getPlayer(3);
        else if(currentPlayer == game.getPlayer(3))
            nextPlayer = game.getPlayer(0);
        
        return nextPlayer;
    }
    
    /**
     * Searches for two cards with the same value in the player's hand.
     * @return boolean found
     */
    private boolean matchCards()
    {
        Card card1, card2;
        boolean found = false;
        for(int i = 0; i< numElems-1 && !found; i++)
       {
           if (peek(i) == peek(i+1))
               {
                   card1 = remove(i+1); 
                   discard(card1);
                   card2 = remove(i);
                   discard(card2); 
                   found = true;
               }
       }
        return found;
    }
    
    /**
     * Displays player's name and cards in his hand(priority queue) and discard pile (queue).
     * @param i index of a current player's position in the game object array.
     */
    public void display(int i)
    {
        System.out.println("Player " + (i + 1));
        System.out.print("     Discard: ");
        displayPile();
        System.out.println("");
        System.out.print("     Hand: "); 
        displayHand();
        System.out.println("");   
    }
    
    /**
     * Searches for card with the same value in the next player's hand.
     * If card is found, removes it from the next player's hand.
     * @param val the value of the card we are looking for.
     * @return card that matches search.
     */
    public Card doYouHaveAny(int val)
    {
        Card card = null;
        boolean found = false;
        for(int i = 0; i<numElems && !found; i++)
        {
        if(val == peek(i))
        {
            card = remove(i);
            found = true;
        }
        }
        return card;
    }
    
    /**
     * Performs one player's turn operations.
     * @param numElem number of cards in the player's hand.
     */
    public int playHand()
    {
        Card playCard = null;
        Player next, current;
        boolean val = true;
        
        do //matches cards in player's hand
        {
          val = matchCards();
        }
        while(val);
        
        current = game.getPlayer(getPosition()); //active player object
       
        for(int i = 0; playCard ==null && i<3;i++) //searches for a card in the next player's hand
        {
            next = getNextPlayer(current); //next player
            if(!isEmpty())
            {
            playCard = next.doYouHaveAny(peek().getValue()); 
            }
            current = next; //next player becomes current 
        }
        
        if (playCard != null) //matching card was found
        {
            if(!isFull())
            {
            insert(playCard); //inserts it in the active player's hand
            matchCards();
            }  
        }
        else //matching card wasn't found
        {
            if(!game.deckArray.isEmpty())
            {
            insert(drawCard()); //draws card from the deck and inserts it in the active player's hand
            matchCards();
            }
        }
        return numElems;
    }
}
