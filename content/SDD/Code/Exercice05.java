package maison;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Exercice05 {
	
	public static void main(String[] args) {
		
		Map<String, String> mapNonTriee = new HashMap<String, String>();
		mapNonTriee.put("2", "Bob");
		mapNonTriee.put("4", "David");
		mapNonTriee.put("3", "Brent");
		mapNonTriee.put("7", "Charles");
		mapNonTriee.put("5", "zing");
		mapNonTriee.put("6", "brandon");
		mapNonTriee.put("8", "amelie");
		mapNonTriee.put("2", "Alain");
		
		Map<String, String> mapTriee = new TreeMap<String, String>(mapNonTriee);
		System.out.println(mapTriee);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
