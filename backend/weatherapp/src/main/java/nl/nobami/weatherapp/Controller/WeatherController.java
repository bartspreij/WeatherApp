package nl.nobami.weatherapp.Controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nl.nobami.weatherapp.Model.Weather;
import nl.nobami.weatherapp.Repository.WeatherRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("api/v1/weather")
public class WeatherController {

    private final WeatherRepository weatherRepository;


    @GetMapping("/root")
    public String root() {
        return "This is the root";
    }

    @GetMapping("/temperature/{temperature}")
    public Iterable<Weather> getWeatherByTemperature(@PathVariable(value = "temperature") Double temperature) {
        return weatherRepository.findByTemperatureBetween(temperature -0.5, temperature +0.5);
    }

    @GetMapping("city/{city}")
    public Iterable<Weather> getWeatherByCity(@PathVariable(value= "city") String city) {
        return weatherRepository.findByCity(city);
    }
}
