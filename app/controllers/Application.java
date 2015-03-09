package controllers;

import play.*;
import play.mvc.*;
import views.html.*;

import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseObject;

import java.util.Random;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.ArrayList;

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
    
    public static Result simulationProcess() throws ParseException {
        //Parse.initialize("F9nh7vqHu38Mi3WfxaNfeqfxtyPG0P19iEJ6dbtw", "Gs5FtrAnSiEvRyFd2668vtTNq8AXV9mqdQLXDr7f");
            int count = 0;
            Double[] timings = {4.0,7.0,10.0,13.0,16.0,19.0};
            ArrayList<Double> myArray = new ArrayList<Double>();
            
        while(count < 6) {
            int sick=0;
            int ambtemp = randInt(79, 107);
            int humdity = randInt(39, 101);
            double heatindex= 0.5*(ambtemp+61.0+((ambtemp-68.0)*1.2)+(humdity*0.094));
            heatindex= Math.ceil(heatindex);
            double expbodytemp= (4/13)*heatindex + 25;
            int randomgen= randInt(0, 5);
             double genbodytemp=expbodytemp + randomgen;
            if(count < 6 ) {
                if((genbodytemp-expbodytemp)>2)
                {
                    sick=1;
                    System.out.println("Ambient Temperature " + ambtemp);
                    System.out.println("Humidity " + humdity);
                    System.out.println("HeatIndex " + heatindex);
                    System.out.println("Expected body temperature " + expbodytemp);
                    System.out.println("Measured body temperature " + genbodytemp);
                    System.out.println("Sick " + sick); 
                    System.out.println("-------------------------------------------------");
                    myArray.add(timings[count]);
                    myArray.add(genbodytemp);
                    count = count + 1;
                }
               
            }
            else {
                break;
            }
        }
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(myArray);
        System.out.println(jsonResponse);
        System.out.println(myArray);
        return ok(simulate.render(myArray));
    }

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

}

