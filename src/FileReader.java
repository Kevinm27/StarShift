import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReader {
	//Function grabs info from
	//The function grabInfoFrom file will open a file into leaderboard then scan the entire file
	public static HashMap<Integer, String> grabInfoFromFile(){
		HashMap<Integer, String> dataVal = new HashMap<Integer, String>();
		try {
			File leaderboard = new File("C:\\Users\\maldo\\git\\StarShift\\Media\\leaderboard.txt");
			Scanner myReader = new Scanner(leaderboard);
			while(myReader.hasNextLine()) {				
				String data = myReader.nextLine();
				String[] returnedArr1 = data.split(" ", 2);			// The file contains a name with a score associated so 
				int num = 0;										//Split is used to grab both
				
				for(int i = 0; i < returnedArr1.length - 1; i++) {
					try {
						num = Integer.parseInt(returnedArr1[i + 1]);		//On every line in the file the for loop
																			//Will parse the line and grab the number
					}
					catch(NumberFormatException e) {
						System.out.println("Error, invalid name format in file!"); //I assume if there is an error then
																				// the format of the name is bad or the score is
																				//simply too high for an int to hold(which it shouldnt)
					}
					dataVal.put(num, returnedArr1[i]);
				}	
			}
			myReader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		HashMap<Integer, String> sort = SortHash.sortByValue(dataVal);
		return sort;
	}
	public static int getMin(HashMap<Integer, String> data) {
		boolean firstIteration = true;
		int temp = 0;
		for(Entry<Integer, String> entry2 : data.entrySet()) {
			if(firstIteration) {
				temp = entry2.getKey();
				firstIteration = false;
			}
			else if(entry2.getKey() < temp) {
				temp = entry2.getKey();
			}
		}
		return temp;
	}
	public static HashMap<Integer, String> inputNewScore(int score, HashMap<Integer, String> data){
		String userName;
		Scanner myObj = new Scanner(System.in);
		int min = 0;
		if(data.size() < 10) {
			System.out.print("Enter your Name: ");
			userName = myObj.nextLine();
			data.put(score, userName);
		}
		else {
			for(Entry<Integer, String> entry : data.entrySet()) {
				if(score > entry.getKey()) {
					System.out.print("Enter your Name: ");
					userName = myObj.nextLine();
					myObj.close();
					data.put(score, userName);
					min = getMin(data);	
					data.remove(min);
				}
			}	
		}
		data = SortHash.sortByValue(data);

		File leaderboard = new File("C:\\Users\\maldo\\git\\StarShift\\Media\\leaderboard.txt");
		leaderboard.delete();
		try {
			leaderboard.createNewFile();
		} catch (IOException e1) {
			System.out.println("Could not create File.");
			e1.printStackTrace();
		}
		try {
			FileOutputStream editedLeaderboard = new FileOutputStream(leaderboard, true);
			byte[] bytes;
			for(Entry<Integer, String> entry : data.entrySet()) {
				
				bytes = (entry.getValue().replaceAll(" ", "") + " " + entry.getKey() + "\n" ).getBytes();
				try {
					editedLeaderboard.write(bytes);
				} catch (IOException e) {
					System.out.println("Could not write to file.");
					e.printStackTrace();
				}
				
			}
			try {
				editedLeaderboard.close();
			} catch (IOException e) {
				System.out.println("Could not close the file.");
				e.printStackTrace();
			}
		
		} catch (FileNotFoundException e) {
			System.out.println("Could not edit file.");
			e.printStackTrace();
		}
		data = SortHash.sortByValue(data);

		return data;
	}
	

	public static void main(String[] args){
		HashMap<Integer, String> rando = new HashMap<Integer, String>();
		rando = grabInfoFromFile();
		rando = inputNewScore(100, rando);

	}
		
}

