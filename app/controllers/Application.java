package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result dashboard() {
        return ok(dashboard.render());
    }

    public static Result viewIndividualCow() {
        return ok(cow.render("Your new application is ready."));
    }
    
    public static Result simulationProcess() {
        return ok(simulate.render());
    }

}
