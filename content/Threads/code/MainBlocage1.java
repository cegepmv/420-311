package sd.blocage1;

public class MainBlocage1 {

	public static void main(String[] args) {
		Compte compte = new Compte();
		compte.setSolde(0);

		ActionDepot actionDepot = new ActionDepot(compte);
		Thread threadDepot = new Thread(actionDepot);

		ActionRetrait actionRetrait = new ActionRetrait(compte);
		Thread threadRetrait = new Thread(actionRetrait);

		System.out.println("Solde initial: "+ compte.getSolde());

		threadDepot.start();
		threadRetrait.start();

		try {
			threadDepot.join();
			threadRetrait.join();
			System.out.println("Solde final: "+compte.getSolde());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

}
