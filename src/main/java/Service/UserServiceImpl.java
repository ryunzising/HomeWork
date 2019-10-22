package Service;

import DAO.FlightDao;
import POJO.flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private FlightDao flightDaoimpl;
    @Override
    public List<flight> queryBySchedules(String Schedules) {
       return flightDaoimpl.queryBySchedules(Schedules);
    }

    @Override
    public List<flight> queryByAirlines(String Airlines) {
        return flightDaoimpl.queryByAirlines(Airlines);
    }

    @Override
    public List<flight> queryByDeCity(String City) {
        return flightDaoimpl.queryByDeCity(City);
    }

    @Override
    public List<flight> queryByLaCity(String City) {
        return flightDaoimpl.queryByLaCity(City);
    }

    @Override
    public int addFlightData(String de_city, String la_city, String schedules, String airlines, String models, String de_airport, String la_airport) {
        return flightDaoimpl.addFlightData(de_city,la_city,schedules,airlines,models,de_airport,la_airport);
    }
}
