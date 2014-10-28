package controllers;

import is.ru.honn.ruber.drivers.service.DriverNotFoundException;
import is.ru.honn.ruber.drivers.service.DriverService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Johannes Gunnar Heidarsson on 28.10.2014.
 */
public class DriverApi extends Controller {
    protected static ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/DriverService.xml");
    private static DriverService service = (DriverService) ctx.getBean("driverService");

    public static Result getDrivers(){
        return ok(Json.toJson(service.getAllDrivers()));
    }

    public static Result getDriverById(int id){
        try {
            return ok(Json.toJson(service.getDriverById(id)));
        } catch(DriverNotFoundException e){
            return notFound("Driver not found");
        }
    }
}
