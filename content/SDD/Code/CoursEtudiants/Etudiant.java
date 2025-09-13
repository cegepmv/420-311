package cal.java03.rencontre10.bean;

public class Etudiant {
	
	private static int compteur =1;
	private int id;
	
	private String prenomNom;
	private String email;
	
	public Etudiant() {
		super();
		this.id = compteur; 
		compteur++;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenomNom() {
		return prenomNom;
	}
	public void setPrenomNom(String prenomNom) {
		this.prenomNom = prenomNom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", prenomNom=" + prenomNom + ", email=" + email + "]";
	}
	

}
