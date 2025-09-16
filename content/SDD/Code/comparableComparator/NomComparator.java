package dev.zaratechs.comparableComparator;

import java.util.Comparator;

public class NomComparator implements Comparator<Client>{


	@Override
	public int compare(Client o1, Client o2) {
		return o1.getNom().compareTo(o2.getNom());
	}
}
