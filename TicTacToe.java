import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;

/**
 * TicTacToe class runs the game of TicTacToe using 2D matrices and integers, and stores 2 Players
 */
public class TicTacToe implements ActionListener, KeyListener {
    
    
    public int numTurns = 0;
    public Player p1; 
    public Player p2;

    JButton button; // last button pressed
    JFrame frame = new JFrame("Tic Tac Toe!");

    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JButton b5 = new JButton();
    JButton b6 = new JButton();
    JButton b7 = new JButton();
    JButton b8 = new JButton();
    JButton b9 = new JButton(); 

    public JButton buttons[][] = {{b1,b2,b3},{b4,b5,b6},{b7,b8,b9}};

    JOptionPane p = new JOptionPane();

    /* Variables to be implemented with the AI portion later: 
    public int[][] endStates={{1,2,3},{3,2,1},{4,5,6},{6,5,4},{7,8,9},{9,8,7},{1,5,9},{9,5,1},{3,5,7},{7,5,3},{1,4,7},{7,4,1},{3,6,9},{9,6,3}};
    public int[][] currentState = {{0,0,0}, {0,0,0}, {0,0,0}}; 
    //public int buttonClicked = -1; // button clicked by player; move to Player class?

     */

/*
 * Sets up the general game before starting turns
 */
    public void setUp() { // style this up?
        
        // initialize UI
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
        panel.setLayout(new GridLayout(buttons.length, buttons[1].length)); // allows for 3X3 button display
        for (int i=0; i<buttons.length; i++) { 
            for (int j=0; j<buttons[i].length; j++) {
                panel.add(buttons[i][j]); 
                buttons[i][j].addActionListener(this);
                buttons[i][j].addKeyListener(this);
                }
            }

        initializePlayers(); 
    }

    /**
     * Initializes the Players of a new game, with names as input
     */
    public void initializePlayers() {
        p1 = new Player(JOptionPane.showInputDialog(p, "Enter the name of Player 1: "), "X");
        p2 = new Player(JOptionPane.showInputDialog(p, "Enter the name of Player 2: "), "O");
    }   // what if Cancel is chosen? Or X?

    /**
     * Marks button pressed and checks if the game has ended; implemented from ActionListener
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        button = (JButton) e.getSource();
        button.setText(this.getPlayer().getSymbol());
        button.setEnabled(false);
        if (checkWin()) {
            this.reset();
        }
        else {
            numTurns++; 
        }

    }

    /**
     * Reset last move if player presses Enter
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            button.setText("");
            button.setEnabled(true);
            numTurns--;
        }
    }

    /**
     * Required by ActionListener, but no need to implement for this project
     */
    @Override
    public void keyTyped(KeyEvent e) {}
    /**
     * Required by ActionListener, but no need to implement for this project
     */
    @Override
    public void keyReleased(KeyEvent e) {}

    /**
     * Checks for a win or a tie
     * @param spot
     * @return if game is over
     */
    public boolean checkWin() {
        int xHCount = 0; // count horizontal X's
        int oHCount = 0; // count horizontal O's
        int xVCount = 0; // count vertical X's
        int oVCount = 0; // count vertical O's
        int xD1Count = 0; // count diagonal X's (left to right)
        int oD1Count = 0; // count diagonal O's (left to right)
        int xD2Count = 0; // count diagonal X's (right to left)
        int oD2Count = 0; // count diagonal O's (right to left)
        
        // nested for loop iterates through whole board every turn and checks for combinations
        for (int r=0; r<3; r++) {
            for (int c=0; c<3; c++) {
                // check horizontal (and diagonal) combos
                switch (buttons[r][c].getText()) {
                    case "X":
                        xHCount++;
                        if (r == c) {
                            xD1Count++; 
                        }
                        if ((r == 1 && c == 1) || r == c+2 || c == r+2) {
                            xD2Count++;
                        }
                        break;
                        
                    case "O":
                        oHCount++;
                        if (r == c) {
                            oD1Count++;
                        }
                        if ((r == 1 && c == 1) || r == c+2 || c == r+2) {
                            oD2Count++;
                        }
                        break;
                        
                }

                // check vertical combos
                switch (buttons[c][r].getText()) {
                    case "X":
                        xVCount++;
                        break;
                    
                    case "O":
                        oVCount++;
                        break;
                }

            }

            // check if any of the combos reached 3
            if (this.checkWinHelper(xHCount, oHCount) || this.checkWinHelper(xVCount, oVCount) || this.checkWinHelper(xD1Count, oD1Count) || this.checkWinHelper(xD2Count, oD2Count)) {
                this.endMessage(this.getPlayer());
                return true;
            }
            // reset horizontal variables after a row, vertical after a column
            xHCount = 0;
            oHCount = 0;
            xVCount = 0;
            oVCount = 0;
                
        }

        // check for tie
        if (numTurns == 8) {
            this.endMessage();
            return true;
        }

        return false;

    }

    /**
     * Checks if at least one combo in a category (horizontal, vertical, diagonal) has reached 3
     * @param xCount
     * @param oCount
     * @return
     */
    public boolean checkWinHelper(int xCount, int oCount) {
        return (xCount == 3 || oCount == 3);
    }

    /**
     * Returns the current player
     * @return
     */
    public Player getPlayer() {
        if (numTurns%2==0) {
            return p1;
        }
        else {
            return p2;
        }
    }

    /**
     * Displays tie message 
     */
    public void endMessage() {
        JOptionPane.showMessageDialog(p, "It's a tie!");
    }

    /**
     * Overloaded endMessage; displays win message if winner is provided
     * @param player
     */
    public void endMessage(Player player) {
        JOptionPane.showMessageDialog(p, player.getName() + " wins!");
    }

    /**
     * Resets the game after checkWin is true
     */
    public void reset() {
        numTurns = 0;
        for (int r=0; r<3; r++) {
            for (int c=0; c<3; c++) {
                buttons[r][c].setText("");
                buttons[r][c].setEnabled(true);
            }
        }
        initializePlayers();
    }

    public static void main(String[] args) {
        TicTacToe b = new TicTacToe();
        b.setUp();
        
    }
}