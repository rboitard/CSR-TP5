package internals;

public class Voyageur extends Thread{
	
	private EspaceQuai quai;
	private EspaceVente vente;
	private int id;
	private int etat;

	public Voyageur(EspaceQuai quai, EspaceVente vente, int id) {
		this.quai = quai;
		this.vente = vente;
		this.id = id;
		this.etat = 0;
	}
	
	public void run(){
		if(this.vente.getTicket()){
			this.setEtat(1);
			System.out.println("le voyageur " + this.id + " a acheté un billet et entre en quai");
			this.quai.entrerVoyageur();
			this.setEtat(2);
			System.out.println("le voyageur " + this.id + " est entré dans un train");
		}
		else{
			System.out.println("le voyageur " + this.id + " n'a pas trouvé de billet disponible");
		}
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	public int getIdVoyageur(){
		return this.id;
	}
	
	
	

}
