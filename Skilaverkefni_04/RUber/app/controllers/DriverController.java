package controllers;

import is.ru.honn.ruber.domain.Driver;
import is.ru.honn.ruber.domain.DriverDTO;
import is.ru.honn.ruber.drivers.service.DriverService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.mvc.*;
import views.html.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johannes Gunnar Heidarsson on 28.10.2014.
 */
public class DriverController extends Controller {
    protected static ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/DriverService.xml");
    private static DriverService service = (DriverService) ctx.getBean("driverService");

    public static Result getAllDrivers(){
        List<DriverDTO> driverList = new ArrayList<DriverDTO>();

        for(Driver d : service.getAllDrivers()){
            driverList.add(new DriverDTO(d.getId(), d.getUserId(), service.getProductById(d.getProductId()), d.getFullName()));
        }

        return ok(drivers.render(driverList));
    }

    public static Result getDriver(int id){
        Driver driver = service.getDriverById(id);
        DriverDTO driverDto = new DriverDTO(driver.getId(), driver.getUserId(), service.getProductById(driver.getProductId()), driver.getFullName());

        return ok(driver_details.render(driverDto));
    }
}
