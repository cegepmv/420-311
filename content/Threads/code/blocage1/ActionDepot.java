public class ActionDepot implements Runnable{
	
	private Compte compte;
	
	public ActionDepot(Compte compte) {
		super();
		this.compte = compte;
	}



	@Override
	public void run() {
		for (int i=0; i<100; i++){
			compte.depot(1000);
			}
		
	}

}
