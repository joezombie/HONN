package is.ru.honn.ruber.service;

import is.ru.honn.ruber.domain.*;

import java.util.List;

public interface RuberService {
    public List<Product> getProducts(double latitude, double longitude) throws ServiceException;

    public List<Price> getPriceEstimates(double startLatitude, double startLongitude,
                                         double endLatitude, double endLongitude) throws ServiceException;

    public void addTrips(Trip trip);

    public History getHistory(int offset, int limit);

    public void signup(User user) throws ServiceException;

    public List<User> getUsers();

    public User getUser(String userName);
}
