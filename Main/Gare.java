package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import internals.EspaceQuai;
import internals.EspaceVente;
import internals.Train;
import internals.Voyageur;

public class Gare {
	
	private List<Train> listTrain;
	private List<Voyageur> listVoyageur;
	private EspaceQuai espaceQuai;
	private EspaceVente espaceVente;
	

	public Gare() {
		this.listTrain = new ArrayList<Train>();
		this.listVoyageur = new ArrayList<Voyageur>();
		this.espaceQuai = new EspaceQuai(4);
		this.espaceVente = new EspaceVente(50);
	}
	
	public void addTrain(Train train){
		this.listTrain.add(train);
	}
	
	public Iterator<Train> trainIterator(){
		return this.listTrain.iterator();
	}
	
	public void addVoyageur(Voyageur voyageur){
		this.listVoyageur.add(voyageur);
	}

	public Iterator<Voyageur> voyageurIterator(){
		return this.listVoyageur.iterator();
	}
	
	public EspaceQuai espaceQuai(){
		return this.espaceQuai;
	}
	
	public EspaceVente espaceVente(){
		return this.espaceVente;
	}
	
	public static void test1()
	{
		
				System.out.println("run test 1 : assez de ticket, 3 trains et 2 voies");
				
				//Create espace quai and espace vente
				EspaceQuai quai = new EspaceQuai(2);
				EspaceVente vente = new EspaceVente(10);
				
				//Create voyageurs
				Voyageur voyageur1 = new Voyageur(quai, vente, 1); 
				Voyageur voyageur2 = new Voyageur(quai, vente, 2); 
				Voyageur voyageur3 = new Voyageur(quai, vente, 3); 
				Voyageur voyageur4 = new Voyageur(quai, vente, 4); 
				Voyageur voyageur5 = new Voyageur(quai, vente, 5); 
				
				//Create Trains
				Train train1 = new Train(quai, 300, 3, 1);
				Train train2 = new Train(quai, 75, 2, 2);
				Train train3 = new Train(quai, 180, 4, 3);
				
				//Run Threads
				
				voyageur1.start();
				voyageur2.start();
				voyageur3.start();
				voyageur4.start();
				voyageur5.start();
				
				train1.start();
				train2.start();
				train3.start();
	}
	
	public static void test2()
	{
				System.out.println("run test 2 : pas asser de ticket, 3 trains et 2 voies");
				
				//Create espace quai and espace vente
				EspaceQuai quai = new EspaceQuai(2);
				EspaceVente vente = new EspaceVente(5);
				
				//Create voyageurs
				Voyageur voyageur1 = new Voyageur(quai, vente, 1); 
				Voyageur voyageur2 = new Voyageur(quai, vente, 2); 
				Voyageur voyageur3 = new Voyageur(quai, vente, 3); 
				Voyageur voyageur4 = new Voyageur(quai, vente, 4); 
				Voyageur voyageur5 = new Voyageur(quai, vente, 5); 
				
				//Create Trains
				Train train1 = new Train(quai, 300, 3, 1);
				Train train2 = new Train(quai, 75, 2, 2);
				Train train3 = new Train(quai, 180, 4, 3);
				
				//Run Threads
				
				voyageur1.start();
				voyageur2.start();
				voyageur3.start();
				voyageur4.start();
				voyageur5.start();
				
				train1.start();
				train2.start();
				train3.start();
	}
	
	public static void test3()
	{ 
				System.out.println("run test 3 : assez de ticket, pas asser de place dans les 3 trains et 2 voies");
				
				//Create espace quai and espace vente
				EspaceQuai quai = new EspaceQuai(2);
				EspaceVente vente = new EspaceVente(10);
				
				//Create voyageurs
				Voyageur voyageur1 = new Voyageur(quai, vente, 1); 
				Voyageur voyageur2 = new Voyageur(quai, vente, 2); 
				Voyageur voyageur3 = new Voyageur(quai, vente, 3); 
				Voyageur voyageur4 = new Voyageur(quai, vente, 4); 
				Voyageur voyageur5 = new Voyageur(quai, vente, 5); 
				
				//Create Trains
				Train train1 = new Train(quai, 300, 3, 1);
				Train train2 = new Train(quai, 75, 2, 2);
				Train train3 = new Train(quai, 180, 4, 1);
				
				//Run Threads
				
				voyageur1.start();
				voyageur2.start();
				voyageur3.start();
				voyageur4.start();
				voyageur5.start();
				
				train1.start();
				train2.start();
				train3.start();
	}

}
