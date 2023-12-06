package nl.nobami.weatherapp.Seeder;

import lombok.RequiredArgsConstructor;
import nl.nobami.weatherapp.Model.Weather;
import nl.nobami.weatherapp.Repository.WeatherRepository;
import org.hibernate.annotations.Comment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {

    private final WeatherRepository weatherRepository;

    @Override
    public void run(String... args) throws Exception {

        long weatherCount = weatherRepository.count();
        if (weatherCount == 0) {
            seedWeather();
            weatherCount = weatherRepository.count();
        } else {
            System.out.println("Weather data already present: " + weatherCount);
        }

        System.out.println("Seeded " + weatherCount + " instances of weather data.");
    }

    public void seedWeather() {


        weatherRepository.saveAll(List.of(
                new Weather(52.14580869222027, 52.145, 3.0, "amersfoort"),
                new Weather(52.14580869222027, 5.3875, 3.0,"Woensel"),
                new Weather(52.14680869222027, 5.3885, 3.5, "Den Haag"),
                new Weather(52.14780869222027, 5.3895, 2.5, "Rotterdam"),
                new Weather(52.14880869222027, 5.3905, 4.0, "Barendrecht"),
                new Weather(52.14980869222027, 5.3915, 3.2, "Woudenberg"),
                new Weather(52.15080869222027, 5.3925, 2.0, "Eersel"),
                new Weather(52.15180869222027, 5.3935, 3.6, "Heerlen"),
                new Weather(52.15280869222027, 5.3945, 3.1, "Maartensdijk"),
                new Weather(52.15380869222027, 5.3955, 2.9, "Roelofsarendveen"),
                new Weather(52.15480869222027, 5.3965, 4.2, "Roermond"),
                new Weather(52.15580869222027, 5.3975, 3.3, "Maastricht"),
                new Weather(52.15680869222027, 5.3985, 2.7, "Groningen"),
                new Weather(52.15780869222027, 5.3995, 3.8, "Apeldoorn"),
                new Weather(52.15880869222027, 5.4005, 3.4, "Arnhem"),
                new Weather(52.15980869222027, 5.4015, 4.1, "Urk")
        ));
    }
}
