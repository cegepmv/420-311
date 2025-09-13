package cal.java03.rencontre10.service;

import java.util.HashMap;
import java.util.Map;

import cal.java03.rencontre10.bean.Cours;
import cal.java03.rencontre10.bean.Etudiant;

public class ServiceMap {

	Map<String, Cours> mapCours = new HashMap<>();

	public Map<String, Cours> getMapCours() {
		return mapCours;
	}

	public void setMapCours(Map<String, Cours> mapCours) {
		this.mapCours = mapCours;
	}

	public boolean addCoursToMap(Cours cours) {

		getMapCours().put(cours.getSigle(), cours);

		// return getMapCours().containsValue(cours);

		return getMapCours().containsKey(cours.getSigle());
	}

	
	public boolean deleteCoursToMap(Cours cours) {

		return getMapCours().remove(cours.getSigle(), cours);

	}
	
	public Cours rechercheCoursBySigle(String sigleRechercher) {
		return getMapCours().get(sigleRechercher);
	}
	
	public Etudiant rechercheEtudiantById(int idRechercher) {
		
		for(Cours cours : getMapCours().values()) {
			for( Etudiant etudiant : cours.getEtudiants() ) {
				if(etudiant.getId() == idRechercher) {
					return etudiant;
				}
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
