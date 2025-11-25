package sd.blocage1;

public class ActionRetrait implements Runnable{

	private Compte compte;
	
	public ActionRetrait(Compte compte) {
		super();
		this.compte = compte;
	}


	@Override
	public void run() {
		for (int i=0; i<100; i++){
			compte.retrait(999);
			}
	}

}
