/**
 * Player class includes player symbol (X or O), player name, and a turn method for 
 */
public class Player {

    // applies to subclasses Human and Computer; implement later
    // maybe implement ActionListener with this class instead (button pressed applies to player)

    String name; // not necessary; axe if needed
    String symbol; 

    /**
     * Constructs a Player with a name and symbol (MUST be different than the other player's!)
     * @param name
     * @param symbol
     */
    public Player(String name, String symbol) {
        this.name = name; 
        this.symbol = symbol;
    }

    /**
     * Implements turn of Player instance; fills specified spot with their symbol
     */
    public void turn() {

    }

}