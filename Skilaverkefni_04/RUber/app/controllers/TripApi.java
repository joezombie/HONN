package controllers;

import is.ru.honn.ruber.drivers.service.DriverService;
import is.ru.honn.ruber.rides.service.RidesService;
import is.ru.honn.ruber.rides.service.TripNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Johannes Gunnar Heidarsson on 28.10.2014.
 */
public class TripApi extends Controller {
    protected static ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/RideService.xml");
    private static RidesService service = (RidesService) ctx.getBean("rideService");

    public static Result getTripsForUser(int id){
        try {
            return ok(Json.toJson(service.getTrip(id)));
        } catch (TripNotFoundException e){
            return notFound(e.getMessage());
        }
    }

}
