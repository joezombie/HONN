package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import is.ru.honn.ruber.domain.DriverRating;
import is.ru.honn.ruber.drivers.service.DriverService;
import is.ru.honn.ruber.drivers.service.RatingExistsException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Johannes Gunnar Heidarsson on 28.10.2014.
 */
public class RatingApi extends Controller {
    protected static ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/DriverService.xml");
    private static DriverService service = (DriverService) ctx.getBean("driverService");

    public static Result getRatingForDriver(int id){
        return ok(Json.toJson(service.getRatingForDriver(id)));
    }

    public static Result postRatingForDriver(int id){

        JsonNode json = request().body().asJson();
        if(json == null){
            return badRequest("Expection Json data");
        } else{
            DriverRating rating = new DriverRating();
            rating.setComment(json.findPath("comment").asText());
            rating.setRating(json.findPath("rating").asInt());
            rating.setDriverId(id);
            rating.setRiderId((json.findPath("riderId").asInt()));

            try{
                return created(Json.toJson(service.addRating(rating)));
            } catch (RatingExistsException e){
                return internalServerError();
            }
        }

    }

}
