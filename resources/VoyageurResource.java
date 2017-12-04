package resources;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class VoyageurResource extends ServerResource {
	
	private Gare gare_;
	
	private List<Voyageur> voyageur_;

	public VoyageurResource(){
	     super();	
	     this.gare_ = (Gare) getApplication().getContext().getAttributes().get("gare");
	    }


	    @Get("json")
	    public Representation getVoyageur() throws Exception
	    {
	        Iterator<Voyageur> it= gare_.voyageurIterator();

	      
	        Collection<JSONObject> jsonVoyageur = new ArrayList<JSONObject>();
	        Voyageur voyageur;
	        while(it.hasNext()){
	        	voyageur = it.next();
	        	String etat = "";
	        	if(train.getEtat == 0){
	        		etat = "en route vers la gare";
	        	}
	        	else if(train.getEtat == 1){
	        		etat = "muni d'un ticket";
	        	}
	        	else if(train.getEtat == 2){
	        		etat = "monté dans un train";
	        	}
	        	JSONObject current = new JSONObject();
	        	current.put("voyageur", "Voyageur " + voyageur.getId() + " : " + etat);
	        	jsonVoyageur.add(current);
	        }
	        JSONArray jsonArray = new JSONArray(jsonVoyageur);


	        return new JsonRepresentation(jsonArray);
	    }
	    
	    @Post("json")
	    public Representation createTweet(JsonRepresentation representation)
	        throws Exception
	    {
	        
	        JSONObject object = representation.getJsonObject();
	        
	        //création du train
	        int id = (int) getRequest().getAttributes().get("id");
	        Voyageur voyageur = new Train(this.gare_.getEspaceQuai(), this.gare_.getEspaceVente(), id);
	        
	        //ajout du train
	        this.gare_.addVoyageur(voyageur);
	        
	        // generate result
	        JSONObject resultObject = new JSONObject();
	        resultObject.put(""voyageur", "Voyageur " + voyageur.getId()");
	        JsonRepresentation result = new JsonRepresentation(resultObject);
	        return result;
	    }

}
