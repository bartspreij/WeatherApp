package nl.nobami.weatherapp.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private Double longitude;
    private Double latitude;
    private Double temperature;
    private LocalDate date = LocalDate.now();
    private String city;

    public Weather() {}

    public Weather(Double latitude, Double longitude, Double temperature, String city) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperature = temperature;
        this.city = city;
    }
}
