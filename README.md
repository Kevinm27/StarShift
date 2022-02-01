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
	
PART 2
	PsuedoCode:
		SortHash: Taken from GeeksForGeeks as shown in the source file itself
			According to GeeksForGeeks: the idea of this sorting algorithm is to first store the entry set into a lost and sort the list based on the integers I stored into it previously
			 - List<Map<int, string>> list = new LinkedList<map.entry<string, int>> hm.entrySet
			Now to actually sort it 
			Collections.sort(list, new Comparator<Map<string, int>>(){
				public int compare(map<string, int> o1, map<string, int> o2){
					return the biggest of the two o1 & o2
				}
			});
			
			Make a new hashmap and store the new values inside it using a for loop
			HashMap<int, string> temp
			for(map.entry aa : list)
				temp.put(key, value)
			
			return temp
			---------------------------------
		EnterName: Simple screen but personally there is some complexity to it
		So Far I will just create a new screen with the same background but instead of asking the user to input their name into the terminal, I want to display it onto the screen.
		Add MainApplcation, background, congratulations message, a label to: enter a name, submit the name. Finally, add a string so we can see what the user is typing
		the constructor should just place all the labels in whatever spot you feel like putting.
		Showcontents should be included and don't forget to override it
		Same goes with hidecontents
		Same goes with mousePressed but create a Gobject that stores where the user clicked and if it clicks the submit name label then it call the FileReader file and run the function that inputs a new score with the name just types
		There should be a class called TAdapter which I got from level. It should look something like this
		- private class TAdapter extends KeyAdapter implements KeyListener{
			@override
			public void KeyTyped(KeyEvent e){
				int key = e.getKeyCode
				check the key to see if it matches either the backspace or enter button
				if it hits any key then just add it to the string we created earlier called input or something
				NOTE: SO FAR THIS DOES NOT WORK
			}
		}
		Afterwards it will switch to the leaderboard screen
		------------------------------------------
		Leaderboard: Very simple screen to create after all getters are properly created.
		Add all the basic Labels, Fonts, Colors Show contents just like the Enter name file
		Only difference is the face that we are adding a dynamic number of names and scores
	-	Create a hashmap, this will store the data that will be grabbed from FileReader later
		- Create GLabel[] playerName[10] and playerScore[10]
		-	use a for loop when first going through the constructor which will add the balues and scores from the hashmap using getter from FileReader into the array of labels.
		- Make sure to add and remove the right amount of playerNames and scores because there could be only 9 names out of 10 and accessing the tenth will be null

------------
PART 3
	- The way the file system works is that the file is read and parsed into a hashmap. 
	- To test the implementation just follow the steps after the game ends. Just play the game normally, and once you die it will change the screen if youre score is higher than any of the local scores.
	- To input your name, you must first click on the text that says "Click me to enter"(this was included because the game would switch to fast and I would have extra characters on accident too often). After you click it just click on the console and type your name with an endline after the last character. From here it should send you to the leaderboard with your name in it. You can also view the leaderboard from the main menu. 
		