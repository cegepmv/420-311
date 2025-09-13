package cal.java03.rencontre10.bean;

import java.util.List;

public class Cours {
	
	private static int compteur = 1;
	private String sigle;
	
	private String nomCours;
	
	private List<Etudiant> etudiants;

	public Cours() {
		super();
		this.sigle= "COURS_"+compteur;
		compteur++;
	}

	public String getSigle() {
		return sigle;
	}

	public void setSigle(String sigle) {
		this.sigle = sigle;
	}

	public String getNomCours() {
		return nomCours;
	}

	public void setNomCours(String nomCours) {
		this.nomCours = nomCours;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	@Override
	public String toString() {
		return "Cours [sigle=" + sigle + ", nomCours=" + nomCours + ", etudiants=" + etudiants + "]";
	}
	
}
