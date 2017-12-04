package internals;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EspaceQuai {
	
	private final int nbVoieMax;
	private List<Train> listTrain;
	
	private int nbVoieLibre;

	public EspaceQuai(int voiesMax) {
		this.nbVoieMax = voiesMax;
		this.nbVoieLibre = this.nbVoieMax;
		listTrain = new ArrayList();
	}
	
	public synchronized  void entreTrain(Train t){
		while(nbVoieLibre == 0){
			try {
	            wait();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
		try { Thread.sleep(10000/t.getVitesse()); } catch(InterruptedException e) {}
		listTrain.add(t);
		nbVoieLibre--;
		notifyAll();
	}
	
	public synchronized void sortieTrain(Train t){
		listTrain.remove(t);
		nbVoieLibre++;
		notifyAll();
	}
	
	public synchronized void entrerVoyageur(){
		boolean entrer = false;
		while(!entrer){
			Iterator<Train> it = this.listTrain.iterator();
			while(it.hasNext() && !entrer){
				entrer = it.next().addVoyageur();
			}
			if(!entrer){
				try {
		            wait();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			}
		}
	}

}
