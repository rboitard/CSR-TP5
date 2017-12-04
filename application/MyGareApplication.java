package application;

import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import resources.TrainsResource;
import resoucres.VoyageurResource;

public class MyGareApplication extends Application{

    public MyGareApplication(Context context)
    {
        super(context);
    }

    @Override
    public Restlet createInboundRoot()
    {
        Router router = new Router(getContext());
        router.attach("/voyageurs", VoyagerusResource.class);
        router.attach("/trains", TrainsResource.class);
        return router;
    }
}
