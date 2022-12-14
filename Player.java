/**
 * Player class includes player symbol (X or O), and player name
 */
public class Player {

    // applies to subclasses Human and Computer; implement later
    // maybe implement ActionListener with this class instead (button pressed applies to player)

    private String name; 
    private String symbol; 

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
     * Getter for name attribute
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for symbol attribute
     * @return symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /* Implement this later
    public void turn() {}
    */

}