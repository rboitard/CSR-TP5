package internals;

public class EspaceVente {
	
	private int nbBilletMax;
	private int nbBilletLibre;

	public EspaceVente(int billetMax) {
		this.nbBilletMax = billetMax;
		this.nbBilletLibre = this.nbBilletMax;
	}
	
	public synchronized boolean getTicket(){
		boolean res = false;
		if(nbBilletLibre > 0){
			try { Thread.sleep(1000); } catch(InterruptedException e) {}
			this.nbBilletLibre--;	
			res = true;
		}
		return res;
	}

}
