import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortHash {
	//Following code is from geeksforgeeks
		//Link https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
		 public static HashMap<Integer, String> sortByValue(HashMap<Integer, String> hm){
			 
		     // Create a list from elements of HashMap\
			 List<Map.Entry<Integer, String> > list = new LinkedList<Map.Entry<Integer, String> >(hm.entrySet());
			 
			 // Sort the list
			Collections.sort(list, new Comparator<Map.Entry<Integer, String> >() {
			    public int compare(Map.Entry<Integer, String> o1,
			                       Map.Entry<Integer, String> o2)
			    {
			        return (o2.getKey()).compareTo(o1.getKey());
			    }
			});
			 
			// put data from sorted list to hashmap
			HashMap<Integer, String> temp = new LinkedHashMap<Integer, String>();
			for (Map.Entry<Integer, String> aa : list) {
			    temp.put(aa.getKey(), aa.getValue());
			}
				return temp;
		    }
}
