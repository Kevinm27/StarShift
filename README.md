# COMP55GroupProject
A project created during my Fall 2021 Semester in Comp 55 Application Development with three other class mates.

For Software Engineering class I will add a new feature to this game
In the game there is a score system but no way to actually compare to how you did to others.
This is where the leaderboard system comes in. I plan on creating a system that reads a text file
from the local directory and displays it onto the screen using a HashMap. The HashMap will allow me 
to quicky look up the Name of the score when displaying the data onto the graphics screen.

The general files i would need to add include
	- SortHash file that will sort the scores for me (I will most likely grab the source code from an outside source like geeks for geeks)
	- FileReader source code file that will be able to open a file and grab all the info parsing it into a string and text
		- This will also let us know if we have a score able to be put on the leaderboard
		- Will store the data onto a hashmap and sort it calling the sorthash file, and will be able to check for simple errors
	- Leaderboard screen which will actually show all the names and corresponding scores of every player accessing the public functions from FileReader
	- EnterName screen which will only prompt the user to enter a name if their score is higher than at least one of the existing scores in the leaderboard text file. This will be the only confusing part of the project for me as I am not familiar with KeyListeners and how I can show what the user types onto the screen.
I will probably have to change existing files as well (if some are changed and not mentioned it is only to adapt the file to new screen or etc)
	- Level: the score is resetted every time the player dies, so I changed it when the game starts so I can access old scores
	- MainApplication: Added the reset score function to when the game actually starts.
	

	PsuedoCode:
		SortHash: Taken from GeeksForGeeks as shown in the source file itself
		