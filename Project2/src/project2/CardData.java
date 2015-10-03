package project2;

/**
 * Provides operations for managing a deck of playing cards.
 */
public abstract class CardData {
    public static final int CARDS_PER_SUIT = 13;
    
    public static final String CARD_FACE_ACE = "A";
    public static final String CARD_FACE_JACK = "J";
    public static final String CARD_FACE_KING = "K";
    public static final String CARD_FACE_QUEEN = "Q";
    
    public static final String NETBEANS_CLUBS = "\u2663";
    public static final String NETBEANS_DIAMONS = "\u001B[31m\u2666\u001B[0m";
    public static final String NETBEANS_HEARTS = "\u001B[31m\u2665\u001B[0m";
    public static final String NETBEANS_SPADES = "\u2660";
    public static final String NON_NETBEANS_CLUBS = "C";
    public static final String NON_NETBEANS_DIAMONS = "D";
    public static final String NON_NETBEANS_HEARTS = "H";
    public static final String NON_NETBEANS_SPADES = "S";
    
    protected String face; // 2 to 10, Jack, Queen, King and Ace
    protected int value; // 0 to 12
    protected String suit; // Spades, Hearts, Clubs and Diamonds
    
    /**
     * Returns the Face of the card (2 to 10, J, Q, K and A).
     * @param id The value of the card (0 to 12)
     * @return the Face of the card (2 to 10, J, Q, K and A).
     */
    protected String generateFace(int id) {
        String cardFace;
        
        value = id % CARDS_PER_SUIT;
        switch(value) {
            case 9:
                cardFace = CARD_FACE_JACK;
                break;
            case 10:
                cardFace = CARD_FACE_QUEEN;
                break;
            case 11:
                cardFace = CARD_FACE_KING;
                break;
            case 12:
                cardFace = CARD_FACE_ACE;
                break;
            default:
                cardFace = Integer.toString(value + 2);
                break;
        }
        return cardFace;
    }
    
    /**
     * Returns the Suit of the card (Spades, Hearts, Clubs and Diamonds)
     * 
     * Note:  If netbeans is true, an image is displayed; otherwise, text is displayed.
     * @param id The value of the card (0 to 12)
     * @param netbeans True if using NetBeans; otherwise, false.
     * @return returns the Suit of the card (Spades, Hearts, Clubs and Diamonds)
     */
    protected String generateSuit(int id, boolean netbeans) {
        String cardSuit;
        
        switch(id / CARDS_PER_SUIT) {
            case 0:
                cardSuit = netbeans ? NETBEANS_SPADES : NON_NETBEANS_SPADES;
                break;
            case 1:
                cardSuit = netbeans ? NETBEANS_HEARTS : NON_NETBEANS_HEARTS;
                break;
            case 2:
                cardSuit = netbeans ? NETBEANS_CLUBS : NON_NETBEANS_CLUBS;
                break;
            case 3:
                cardSuit = netbeans ? NETBEANS_DIAMONS : NON_NETBEANS_DIAMONS;
                break;
            default:
                cardSuit = null;
                break;
        }
        return cardSuit;
    }
}
