package nl.nobami.weatherapp.Repository;

import nl.nobami.weatherapp.Model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    public Iterable<Weather> findByTemperature(Weather weather);

    Iterable<Weather> findByTemperatureBetween(double v, double v1);

    Iterable<Weather> findByCity(String city);
}
