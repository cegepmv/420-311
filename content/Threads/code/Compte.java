package sd.blocage1;

public class Compte {

	private double solde;

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public  void depot(double somme) {

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		solde += somme;
	}

	public  void retrait(double somme) {

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		solde -= somme;
	}

}
