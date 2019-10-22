package DAO;

import POJO.flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@Repository
@ComponentScan
public class FlightDaoImpl implements FlightDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<flight> queryBySchedules(String Schedules) {
        String sql="SELECT * FROM flight WHERE flight.flight_schedules = ?";
        return jdbcTemplate.query(sql,new FlightRowMapper(),Schedules);
    }

    @Override
    public List<flight> queryByAirlines(String Airlines) {
        String sql = "SELECT * FROM flight WHERE flight.airlines = ?";
        return jdbcTemplate.query(sql, new FlightRowMapper(), Airlines);
    }

    @Override
    public List<flight> queryByDeCity(String City) {
        String sql = "SELECT * FROM flight WHERE flight.departure_city=?";
        return jdbcTemplate.query(sql,new FlightRowMapper(),City);
    }

    @Override
    public List<flight> queryByLaCity(String City) {
        String sql = "SELECT * FROM flight WHERE flight.landing_city=?";
        return jdbcTemplate.query(sql,new FlightRowMapper(),City);
    }

    @Override
    public int addFlightData(String de_city, String la_city, String schedules, String airlines, String models, String de_airport, String la_airport) {
         String sql="INSERT INTO flight VALUES(?,?,?,?,?,?,?)";
         return jdbcTemplate.update(sql,de_city,la_city,schedules,airlines,models,de_airport,la_airport);
    }

}
class FlightRowMapper implements RowMapper<flight> {
    @Override
    public flight mapRow(ResultSet resultSet, int i) throws SQLException {
        flight flight = new flight();
        flight.setDeparture_city(resultSet.getString(1));
        flight.setLanding_city(resultSet.getString(2));
        flight.setFlight_schedules(resultSet.getString(3));
        flight.setAirlines(resultSet.getString(4));
        flight.setAircraft_models(resultSet.getString(5));
        flight.setDeparture_airport(resultSet.getString(6));
        flight.setLanding_airport(resultSet.getString(7));
        return flight;
    }
}
