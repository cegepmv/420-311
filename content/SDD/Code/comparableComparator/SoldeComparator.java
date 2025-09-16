package dev.zaratechs.comparableComparator;

import java.util.Comparator;

public class SoldeComparator implements Comparator<Client>{


	@Override
	public int compare(Client o1, Client o2) {
		return Double.compare(o1.getSolde(), o2.getSolde());
	}
}
