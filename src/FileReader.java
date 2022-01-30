import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

public class FileReader {
	//Function grabs info from
	//The function will return the sorted hashmap based on values
	public static HashMap<String, Integer> grabInfoFromFile(){
		HashMap<String, Integer> dataVal = new HashMap<String, Integer>();
		try {
			File leaderboard = new File("C:\\Users\\maldo\\git\\StarShift\\Media\\leaderboard.txt");
			Scanner myReader = new Scanner(leaderboard);
			while(myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] returnedArr1 = data.split(" ", 4);
				int num = 0;
				
				for(int i = 0; i < returnedArr1.length - 1; i++) {
					try {
						num = Integer.parseInt(returnedArr1[i + 1]);
					}
					catch(NumberFormatException e) {
						returnedArr1[i + 1].replaceAll(" ", "");
					}
					dataVal.put(returnedArr1[i], num);
				}	
			}
			myReader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		HashMap<String, Integer> sort = SortHash.sortByValue(dataVal);
		return sort;
	}
	public static int getMin(HashMap<String, Integer> data) {
		boolean firstIteration = true;
		int temp = 0;
		for(Entry<String, Integer> entry2 : data.entrySet()) {
			if(firstIteration) {
				temp = entry2.getValue();
				firstIteration = false;
			}
			else if(entry2.getValue() < temp) {
				temp = entry2.getValue();
			}
		}
		return temp;
	}
	public static HashMap<String, Integer> inputNewScore(int score, HashMap<String, Integer> data){
		String userName;
		Scanner myObj = new Scanner(System.in);
		int min = 0;
		if(data.size() < 10) {
			System.out.print("Enter your Name: ");
			userName = myObj.nextLine();
			data.put(userName, score);
		}
		else {
			for(Entry<String, Integer> entry : data.entrySet()) {
				if(score > entry.getValue()) {
					System.out.print("Enter your Name: ");
					userName = myObj.nextLine();		
					data.put(userName, score);
					min = getMin(data);				
				}
			}	
		}
		Set<Entry<String, Integer>> entries = data.entrySet();
		Iterator<Entry<String, Integer>> iterator = entries.iterator();
		while(iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			int val = entry.getValue();
			if(val == min) {
				iterator.remove();
			}
		}
		data = SortHash.sortByValue(data);
		myObj.close();
		File leaderboard = new File("C:\\Users\\maldo\\git\\StarShift\\Media\\leaderboard.txt");
		leaderboard.delete();
		try {
			leaderboard.createNewFile();
		} catch (IOException e1) {
			System.out.println("An error occurred.");
			e1.printStackTrace();
		}
		try {
			FileOutputStream editedLeaderboard = new FileOutputStream(leaderboard, true);
			byte[] bytes;
			for(Entry<String, Integer> entry : data.entrySet()) {
				bytes = (entry.getKey() + " " + entry.getValue() + "\n" ).getBytes();
				try {
					editedLeaderboard.write(bytes);
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
				
			}
			try {
				editedLeaderboard.close();
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return data;
	}
	

	public static void main(String[] args){
		HashMap<String, Integer> rando = new HashMap<String, Integer>();
		rando = grabInfoFromFile();
		rando = inputNewScore(9999, rando);

	}
		
}

