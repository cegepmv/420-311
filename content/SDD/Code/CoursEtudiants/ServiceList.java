package cal.java03.rencontre10.service;

import java.util.ArrayList;
import java.util.List;

import cal.java03.rencontre10.bean.Cours;
import cal.java03.rencontre10.bean.Etudiant;

public class ServiceList {

	List<Cours> liste = new ArrayList<>();

	// get / set de la liste
	public List<Cours> getListe() {
		return liste;
	}

	public void setListe(List<Cours> liste) {
		this.liste = liste;
	}

	// Méthode de service
	public boolean addCoursToList(Cours cours) {
		return getListe().add(cours);
	}

	/**
	 * @param cours
	 * @return cours de la liste
	 */
	public boolean deleteCoursFromList(Cours cours) {
		return getListe().remove(cours);
	}

	/**
	 * @param cours
	 * @return
	 */
	public boolean deleteEtudiantFromList(Etudiant etudiantRechercher) {

		for (Cours cours : getListe()) {
			if (cours.getEtudiants().contains(etudiantRechercher)) {
				return cours.getEtudiants().remove(etudiantRechercher);
			}
		}
		return false;
	}

	public Cours rechercheCoursBySigle(String sigleRechercher) {

		for (Cours cours : getListe()) {
			if (cours.getSigle().equals(sigleRechercher)) {
				return cours;
			}
		}
		return null;
	}

	public Etudiant rechercheEtudiantById(int idRechercher) {

		for (Cours cours : getListe()) {
			for( Etudiant etudiant : cours.getEtudiants() ) {
				if(etudiant.getId() == idRechercher) {
					return etudiant;
				}
			}
		}
		return null;
	}

}
