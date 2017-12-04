package resources;

import Main.Gare;
import internals.Train;
import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TrainsResource extends ServerResource {
	
	private Gare gare_;
	
	private List<Train> trains_;

	public TrainsResource(){
	     super();	
	     this.gare_ = (Gare) getApplication().getContext().getAttributes().get("gare");
	    }


	    @Get("json")
	    public Representation getTrains() throws Exception
	    {
	        Iterator<Train> it= gare_.trainIterator();

	      
	        Collection<JSONObject> jsonTains = new ArrayList<JSONObject>();
	        Train train;
	        while(it.hasNext()){
	        	train = it.next();
	        	String etat = "";
	        	if(train.getEtat() == 0){
	        		etat = "en route vers la gare";
	        	}
	        	else if(train.getEtat() == 1){
	        		etat = "en attente d'une voie libre";
	        	}
	        	else if(train.getEtat() == 2){
	        		etat = "garé";
	        	}
	        	else if(train.getEtat() == 3){
	        		etat = "reparti";
	        	}
	        	JSONObject current = new JSONObject();
	        	current.put("train", "Train " + train.getId() + " : " + etat);
	        	jsonTains.add(current);
	        }
	        JSONArray jsonArray = new JSONArray(jsonTains);


	        return new JsonRepresentation(jsonArray);
	    }
	    
	    @Post("json")
	    public Representation createTweet(JsonRepresentation representation)
	        throws Exception
	    {
	        
	        JSONObject object = representation.getJsonObject();
	        
	        //création du train
	        int vitesse = (int) getRequest().getAttributes().get("vitesse");
	        int nbPlace = (int) getRequest().getAttributes().get("nbPlace");
	        int id = (int) getRequest().getAttributes().get("id");
	        Train train = new Train(this.gare_.getEspaceQuai(), vitesse, nbPlace, id);
	        
	        //ajout du train
	        this.gare_.addTrain(train);
	        
	        // generate result
	        JSONObject resultObject = new JSONObject();
	        resultObject.put("train", "Train " + train.getId());
	        JsonRepresentation result = new JsonRepresentation(resultObject);
	        return result;
	    }


}
