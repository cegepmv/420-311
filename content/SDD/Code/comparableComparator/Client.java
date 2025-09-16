package dev.zaratechs.comparableComparator;

public class Client implements Comparable<Client>{
	
	private int numCompte;
	private String prenom;
	private String nom;
	private double solde;
	
	public Client() {
	}

	public Client(int numCompte, String prenom, String nom, double solde) {
		this.numCompte = numCompte;
		this.prenom = prenom;
		this.nom = nom;
		this.solde = solde;
	}
	
	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "ClientBean [numCompte=" + numCompte + ", prenom=" + prenom
				+ ", nom=" + nom + ", solde=" + solde + "]";
	}


	@Override
	public int compareTo(Client o) {
		return Integer.compare(this.getNumCompte(), o.getNumCompte());
	}
}
