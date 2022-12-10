import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.HashMap;

/**
 * TicTacToe class runs the game of TicTacToe using 2D matrices and integers, and stores 2 Players
 */
public class TicTacToe implements ActionListener {
    
    //maybe initialize this with a for loop later?
    public static int[][] endStates={{1,2,3},{3,2,1},{4,5,6},{6,5,4},{7,8,9},{9,8,7},{1,5,9},{9,5,1},{3,5,7},{7,5,3},{1,4,7},{7,4,1},{3,6,9},{9,6,3}};
    
    public static HashMap<Integer, String> mapToBoard; // maps integer to "X" or "O" (what we want to see on the board)
    public static int[][] currentState = {{0,0,0}, {0,0,0}, {0,0,0}}; // initialize in constructor?
    public static JButton[][] buttons = {{new JButton("1"),new JButton("2"),new JButton("3")},{new JButton("4"),new JButton("5"),new JButton("6")},{new JButton("7"),new JButton("8"),new JButton("9")}};
    public static int numTurns = 0;
    public static int buttonClicked = -1; // button clicked by player; move to Player class?
    public Player p1; 
    public Player p2;
   
    // add messages 
    // revert action

/*
 * Sets up the general game before starting turns
 */
    public static void setUp() {
        
        JFrame frame = new JFrame("Tic Tac Toe!");
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
        panel.setLayout(new GridLayout(buttons.length, buttons[1].length)); // allows for 3X3 button display
        for (int i=0; i<buttons.length; i++) { 
            for (int j=0; j<buttons[i].length; j++) {
                panel.add(buttons[i][j]); // add every button to panel
            }
        }

        mapToBoard = new HashMap<Integer, String>() {{
            for (int i=0; i<8; i++) { // hardcoded 8; possible to expand board in the future?
                put(i,""); // maps integer (location) to what is stored there (X or O)
            }
        }};
    }
        // p1 = new Player(insert name...); finish Player class first
        // p2 = new Player(insert name...);
    

    /**
     * Gets which button was clicked; implemented from ActionListener
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        buttonClicked = Integer.valueOf(((JButton) e.getSource()).getText());

    }

    /*
     * Converts integer value to a coordinate value (to be found in currentState)
     * @return coordinate value
     */
    public static int[][] convertIntToCoordinate(int spot) {
        return new int[(spot-1)/3][(spot-1)%3];
    }

    /**
     * Gets the symbol of the current Player to mark spot with
     * @return symbol
     */
    public static String getSymbol() { // later change to get symbol from Player parameter?
        if (numTurns%2 == 0) {
            return "X";
        }
        return "O";
    }

    /**
     * Runs through the entire game
     */
    public static void game() {
        int player = numTurns%2 + 1; // if time, change this to grab the actual Player object
        System.out.println("It is Player " + player + "'s turn: "); // display instead of printing
        
        // ideally, use turn() method from Player class to implement this
        // turn() -> actionPerformed() -> convertIntToCoordinate() -> mark coordinate in currentState
        // then use mapToBoard to show actual "X" or "O", then checkEndState()
        
    }

    /**
     * Marks the spot on the board specified by buttonClicked
     * @param spot
     */
    public static void markSpot() {
        // check button clicked, mark corresponding spot in currentState with getSymbol()

    }

    /*public static boolean checkEndState() {
        // compare currentState to endStates; check for certain marked positions that are ALL X or ALL O
    }*/

    public static void main(String[] args) {
        //TicTacToe.setUp();
        //TicTacToe.game();
        // System.out.println(TicTacToe.getSymbol()); works!
        //
        
    }
}