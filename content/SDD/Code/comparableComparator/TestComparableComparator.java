package dev.zaratechs.comparableComparator;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TestComparableComparator {
	

	public static void main(String[] args) throws IOException {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		List<Client> liste = new ArrayList<>();
		
		Client client3= new Client(100, "Zebre", "Zebre", 96500.00);
		Client client2= new Client(200, "Giles", "Giles", 8700.00);
		Client client1= new Client(300, "Alain", "Alain", 500.00);
		
		liste.add(client3);
		liste.add(client2);
		liste.add(client1);
		System.out.println(liste);
		Collections.sort(liste);
		System.out.println("====================Liste apr�s le Tri========================");
		Collections.reverse(liste);
	//	System.out.println(liste);
		
		System.out.println();
		Collections.sort(liste, new NomComparator());
		System.out.println(liste);
		
		System.out.println();
		Collections.sort(liste, new SoldeComparator());
		Collections.reverse(liste);
		System.out.println(liste);
		
		File file = new File("./listeClient.txt");
		
		//System.out.println(liste);
		FileUtils.writeLines(new File("./data/listeClient.txt"), liste);
		
		//List<ClientBean> listePourLecture = FileUtils.readLines(file);
		//System.out.println(listePourLecture);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
