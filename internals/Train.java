package internals;

public class Train extends Thread{

	private int vitesse;
	private int etat;
	private EspaceQuai quai;
	private int placeDisponible;
	private int id;
	
	public Train(EspaceQuai quai, int vitesse, int placeDisponible, int id) {
		this.quai = quai;
		this.vitesse = vitesse;
		this.setEtat(0);
		this.placeDisponible = placeDisponible;
		this.id = id;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	
	public void entrerEnGare(){
		this.setEtat(1);
		quai.entreTrain(this);
		this.setEtat(2);
	}
	
	public void sortirDeGare(){
		quai.sortieTrain(this);
		this.setEtat(3);
	}
	
	public boolean addVoyageur(){
		boolean res = false;
		if(this.placeDisponible > 0){
			this.placeDisponible--;
			res = true;
		}
		return res;
	}
	
	public void run(){
		System.out.println("Le train numero " + this.id + " arrive en gare");
		entrerEnGare();
		System.out.println("Le train numero " + this.id + " est entré en gare");
		try { Thread.sleep(10000); } catch(InterruptedException e) {}
		sortirDeGare();
		System.out.println("Le train numero " + this.id + " est sortie de gare");
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	public int getId(){
		return this.id;
	}

}
