import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReader {
	//Followiung code is from geeksforgeeks
	//Link https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
	 public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm){
		 
	     // Create a list from elements of HashMap\
		 List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
		 
		 // Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
		    public int compare(Map.Entry<String, Integer> o1,
		                       Map.Entry<String, Integer> o2)
		    {
		        return (o1.getValue()).compareTo(o2.getValue());
		    }
		});
		 
		// put data from sorted list to hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
		    temp.put(aa.getKey(), aa.getValue());
		}
			return temp;
	    }

	public static void main(String[] args){
		//Vector<Map<String, Integer>> info = new Vector<Map<String, Integer>>();
		HashMap<String, Integer> dataVal = new HashMap<String, Integer>();
		try {
			File leaderboard = new File("C:\\Users\\maldo\\git\\StarShift\\Media\\leaderboard.txt");
			Scanner myReader = new Scanner(leaderboard);
			while(myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] returnedArr1 = data.split(" ", 4);
				
				for(int i = 0; i < returnedArr1.length - 1; i++) {
					int num = Integer.parseInt(returnedArr1[i + 1]);
					dataVal.put(returnedArr1[i], num);

				}
			}
			myReader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		HashMap<String, Integer> sort = sortByValue(dataVal);
		//Sort the hashMap
		
		for(Entry<String, Integer> entry : sort.entrySet()) {
			System.out.println("Name: " + entry.getKey() + ", Score: " + entry.getValue());
		}
		
	}
		
}

