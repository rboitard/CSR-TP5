package application;

import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import resources.TrainsResource;
import resources.VoyageursResource;

public class MyGareApplication extends Application{

    public MyGareApplication(Context context)
    {
        super(context);
    }

    @Override
    public Restlet createInboundRoot()
    {
        Router router = new Router(getContext());
        router.attach("/voyageurs", VoyageursResource.class);
        router.attach("/trains", TrainsResource.class);
        return router;
    }
}
