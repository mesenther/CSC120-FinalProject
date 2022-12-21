This file will contain documentation for all commands available in your game.

Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.


# SPOILER ALERT

If your game includes challenges that must be overcome to win, also list them below.

My game doesn't really have commands to be typed out by the user, so here are the other ways the program reacts to user input:

    typing a name - the program prompts the user for the names of Player 1 and Player 2 before each game. Once the user enters something and presses Enter, the name is stored as the name of the corresponding Player for the rest of the game.

    clicking a square - clicking any one of the JButtons on the 3X3 grid causes that button to be marked with that Player's symbol. This symbol cannot be replaced for the rest of the game.

Challenges to overcome:

    getting 3 of your symbols in a row before the other Player - each Player must get 3 of their symbols in a row on the board before winning (either horizontally, vertically, or diagonally). The opposing Player will presumably attempt to prevent this by choosing spots that block a combination of 3 and by trying to get 3 of their own symbols in a row first.
