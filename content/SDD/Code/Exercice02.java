package maison;

import java.util.Arrays;
import java.util.List;

public class Exercice02 {
	
	public static void main(String[] args) {
		String [] tableau = new String[] {"Zinc", "Main", "Boulot", "Chemin", "AirBus"};
		// conversion d'un tableau dans une collection
		List<String> liste = Arrays.asList(tableau);
		System.out.println(liste);
		
		// conversion d'une collection dans un tableau
		Object [] listEnTableau = liste.toArray();
		System.out.println(Arrays.toString(listEnTableau));
	}

}
