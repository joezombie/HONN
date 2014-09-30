package is.ru.honn.ruber.process;

import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;
import is.ru.honn.ruber.service.RuberService;
import is.ru.honn.ruber.service.RuberServiceStub;
import is.ru.honn.ruber.service.ServiceException;
import is.ruframework.domain.RuException;
import is.ruframework.process.RuAbstractProcess;
import is.ruframework.process.RuProcessContext;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johannes Gunnar Heidarsson on 30.9.2014.
 */
public class TripImportProcess extends RuAbstractProcess {

    RuberService service;

    public TripImportProcess() {
        super();
    }

    @Override
    public void startProcess() {
        RuProcessContext ctx = getProcessContext();

        List tripList = new ArrayList();

        try {
            URL tripsUrl = new URL(ctx.getImportURL().toString());
            log.info("Reading json from: " + ctx.getImportURL().toString());
            BufferedReader in = new BufferedReader(new InputStreamReader(tripsUrl.openStream()));

            JSONParser parser = new JSONParser();

            JSONObject json = (JSONObject) parser.parse(in);

            JSONArray trips = (JSONArray) json.get("history");

            for (int i = 0; i < trips.size(); i++) {
                JSONObject jsonTrip = (JSONObject) trips.get(i);
                Trip trip = new Trip();
                trip.setStartTime(((Long) jsonTrip.get("start_time")).intValue());
                trip.setRequestTime(((Long) jsonTrip.get("request_time")).intValue());
                trip.setDistance(((Double) jsonTrip.get("distance")).floatValue());
                trip.setProductId((String) jsonTrip.get("product_id"));
                trip.setEndTime(((Long) jsonTrip.get("end_time")).intValue());
                trip.setUuid((String) jsonTrip.get("uuid"));
                trip.setStatus(TripStatus.completed);

                log.info("Adding trip: " + trip.toString());
                service.addTrips(trip);
            }

        } catch (Exception e) {
            String tmp = "Unable to read JSON file: " + e.toString();
            log.severe(tmp);
        }

        log.info("Finished");

    }

    @Override
    public void beforeProcess() {
        super.beforeProcess();
        this.service = new RuberServiceStub();
    }

    @Override
    public void afterProcess() {
        super.afterProcess();
    }

}
