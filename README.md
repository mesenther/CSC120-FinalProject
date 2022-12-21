# CSC120 Final Project: Tic Tac Toe Game

For my final project, I made a 2 player Tic-Tac-Toe game with user interface. 

When the program runs, the user is prompted for the name of Player 1, then Player 2. Then, (once the JFrame application is selected) a 3X3 grid array of JButton objects appears, each of which can be selected by a Player and marked with that Player's corresponding symbol. Once three instances of a particular symbol are selected either horizontally, vertically, or diagonally, the Player with that symbol wins. If neither Player achieves this before all spots are selected, the game ends in a tie.

## User Interface/Interactions:
* Implements JFrame, with a JPanel full of a 3X3 grid array of JButton objects (with no initial text)
* Pop-up Player name prompts: the game does not start until the user inputs names of both players into a JOptionPane object, which then associates those names with those Players for the remainder of the game.
* Each JButton in the grid array has an action listener, so when it is clicked it will display the symbol of the Player that clicked it and become disabled (so it cannot be clicked again).
* The program also has a key listener associated with the backspace key, so when said key is pressed, the last JButton is cleared of its symbol and reenabled.
* Pop-up End messages: if a 3-symbol is detected horizontally, vertically, or diagonally in any direction, then the JOptionPane reappears to say that the associated Player has won. If the game is a tie, the JOptionPane will say this instead once all of the spots in the grid array are selected.

## The Player Class:
* The Player class is very simple (as of now), storing only name and symbol attributes along with getters for those attributes and a constructor.
* Two instances of this class are created at the start of the game to represent each Player; Player 1 automatically has the symbol "X" and Player 2 automatically has the symbol "O"
* Once the user inputs the names of the Players, they are initialized with those names as their name attributes
* This class is only used to set the symbol of the most recently clicked JButton, and to display the winning Player's name

## Checking for a Win:
* Implemented by the checkWin() method
* Uses 1 nested for loop to iterate through every JButton both horizontally and vertically (by switching rows and columns); since this method runs every single turn, it would be far more memory demanding to create 3 nested for loops (one for each check)
* Each method of winning has 1 corresponding variable per symbol, which is increased by 1 every time that symbol is detected to be in a spot corresponding to that method of winning
* If any of these variables reaches 3, an end message is triggered with the Player that has that symbol
* If none of these variables reaches 3 after the number of turns indicates that every spot has filled, another end message is triggered with no parameters, which says that the game has ended in a tie

## Resetting the Game:
* checkWin() is called every time a JButton is clicked, and returns either false (the game has not ended) or true (the game has ended); if the latter applies, then the reset method will be activated
* reset() resets the entire game by reducing the number of turns back to 0, reenabling all JButtons with no displayed symbols, and reinitializing the Players

# Design justification:
I decided to have the Tic-Tac-Toe board be entirely displayed by a user interface. Originally I was considering just displaying everything to the terminal, but that seemed like it could get confusing with only typed characters to indicate the boxes. Plus I'd never done any user interface projects in Java, so I could learn something new.

# Reflection:
My overall approach to tackling this project was to handle the action/key listeners first, then build the rest of the code around that once it was working. As a result, I learned a ton about how Java classes can be used to respond to a user. I learned that the Action Listener class is actually an interface (which is why I couldn't directly create an instance of it), and it's the same with Key Listener. After trying to figure out how to call actionPerformed from the rest of the code, I eventually realized it actually executes automatically as soon as the action (in this case, clicking a button) is detected, and I used that to my advantage by having that decide when a turn occurs. In addition, I learned about java swing and how it can be used with JFrame, JPanel, and JButton to display a Tic Tac Toe grid.

The disadvantage to implementing Tic Tac Toe in this way is that I don't have "states" of the board to compare with win states or to connect with other states through single moves, so I couldn't easily implement an unbeatable AI player like I wanted to. The minimax algorithm that the AI would need requires knowing these states, but they aren't currently stored the way I have it now. I wish I stored the states to make this implementation easier, but unfortunately I didn't have time. With unlimited time, I definitely would've added that AI element (and I still hope to). Another thing I wish I fixed was the Player input prompt. Currently if a player does not put in any name, they're called "null", which I also intend to fix.

The most helpful piece of feedback was from my brother. He playtested the game and noticed that it was declaring that a player won early because the code originally detected a diagonal win even when the diagonal buttons weren't three in a row. This made me realize I needed two variables for the two ways to win diagonally, not just one.

If I could give my past self advice on this project, I'd tell her not to start before researching everything about Action Listener and planning out how everything should work. I spent way too much time writing and rewriting code instead of slowing down and figuring it out step by step.
