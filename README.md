# CSC120-FinalProject: Tic Tac Toe

For my final project, I made a 2 player Tic-Tac-Toe game with user interface. 

When the program runs, the user is prompted for the name of Player 1, then Player 2. Then, (once the JFrame application is selected) a 3X3 grid array of JButton objects appears, each of which can be selected by a Player and marked with that Player's corresponding symbol. Once three instances of a particular symbol are selected either horizontally, vertically, or diagonally, the Player with that symbol wins. If neither Player achieves this before all spots are selected, the game ends in a tie.

User Interface/Interactions:
    - Implements JFrame, with a JPanel full of a 3X3 grid array of JButton objects (with no initial text)
    - Pop-up Player name prompts: the game does not start until the user inputs names of both players into a JOptionPane object, which then associates those names with those Players for the remainder of the game.
    - Each JButton in the grid array has an action listener, so when it is clicked it will display the symbol of the Player that clicked it and become disabled (so it cannot be clicked again).
    - The program also has a key listener associated with the backspace key, so when said key is pressed, the last JButton is cleared of its symbol and reenabled.
    - Pop-up End messages: if a 3-symbol is detected horizontally, vertically, or diagonally in any direction, then the JOptionPane reappears to say that the associated Player has won. If the game is a tie, the JOptionPane will say this instead once all of the spots in the grid array are selected.

The Player Class:
    - The Player class is very simple (as of now), storing only name and symbol attributes along with getters for those attributes and a constructor.
    - Two instances of this class are created at the start of the game to represent each Player; Player 1 automatically has the symbol "X" and Player 2 automatically has the symbol "O"
    - Once the user inputs the names of the Players, they are initialized with those names as their name attributes
    - This class is only used to set the symbol of the most recently clicked JButton, and to display the winning Player's name

Checking for a Win:
    - Implemented by the checkWin() method
    - Uses 1 nested for loop to iterate through every JButton both horizontally and vertically (by switching rows and columns); since this method runs every single turn, it would be far more memory demanding to create 3 nested for loops (one for each check)
    - Each method of winning has 1 corresponding variable per symbol, which is increased by 1 every time that symbol is detected to be in a spot corresponding to that method of winning
    - If any of these variables reaches 3, an end message is triggered with the Player that has that symbol
    - If none of these variables reaches 3 after the number of turns indicates that every spot has filled, another end message is triggered with no parameters, which says that the game has ended in a tie

Resetting the Game:
    - checkWin() is called every time a JButton is clicked, and returns either false (the game has not ended) or true (the game has ended); if the latter applies, then the reset method will be activated
    - reset() resets the entire game by reducing the number of turns back to 0, reenabling all JButtons with no displayed symbols, and reinitializing the Players
