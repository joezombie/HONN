package controllers;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripDTO;
import is.ru.honn.ruber.rides.service.RidesService;
import is.ru.honn.ruber.users.service.UserService;
import play.mvc.*;
import views.html.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Johannes Gunnar Heidarsson on 28.10.2014.
 */
public class TripsController extends UserController {

    public static Result AllTrips(){
        String userName = session().get("username");
        if(userName != null) {
            UserService service = (UserService) ctx.getBean("userService");
            RidesService ridesService = (RidesService) ctx.getBean("rideService");

            int userId = service.getUser(userName).getId();

            List<TripDTO> tripDTOList = new ArrayList<TripDTO>();
            for(Trip t : ridesService.getTrip(userId)){
                tripDTOList.add(new TripDTO(new Date(t.getRequestTime() * 1000), t.getDistance() , (t.getEndTime() - t.getStartTime()) / 60, "Driver Name", t.getDriverId()));
            }

            return ok(trips.render(tripDTOList));
        } else {
            return redirect("/");
        }
    }
}
