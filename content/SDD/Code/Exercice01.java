package maison;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercice01 {
	
	public static void trierTableau(String[] tableau) {
		Arrays.sort(tableau);
		System.out.println(Arrays.toString(tableau));
	}
	
	public static void trierListe(List<String> liste) {
		Collections.sort(liste);
		System.out.println(liste);
	}
	
	public static void main(String[] args) {
		String [] tableau = new String[] {"Zinc", "Main", "Boulot", "Chemin", "AirBus"};
		trierTableau(tableau);
		
		List<String> liste = new ArrayList<String>();
		liste.add("Zinc");
		liste.add("Main");
		liste.add("Boulot");
		liste.add("Chemin");
		liste.add("AirBus");
		trierListe(liste);
	}
	

}
