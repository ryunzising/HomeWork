package Service;

import POJO.flight;

import java.util.List;

public interface UserService {
    public List<flight> queryBySchedules(String Schedules);
    public List<flight> queryByAirlines(String Airlines);
    public List<flight> queryByDeCity(String City);
    public List<flight> queryByLaCity(String City);
    public int addFlightData(String de_city,String la_city,String schedules,String airlines,String models,String de_airport,String la_airport);
}
