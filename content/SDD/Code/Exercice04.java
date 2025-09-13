package maison;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercice04 {
	
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		set.add("Georges");
		set.add("Emil");
		set.add("Alain");
		System.out.println(set);
		
		List<String> liste = new ArrayList<>(set);
		System.out.println(liste);
		
		List<String> liste02 = new ArrayList<>();
		liste02.addAll(set);
		System.out.println(liste02);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
