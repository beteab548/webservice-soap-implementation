package org.example.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.example.model.Weather;
import java.util.HashMap;
import java.util.Map;

@WebService
public class WeatherSOAPService {

    private final Map<String, Weather> weatherData = new HashMap<>();

    public WeatherSOAPService() {
        weatherData.put("Addis Ababa", new Weather("Addis Ababa", "Sunny", 21));
        weatherData.put("Bahir Dar", new Weather("Bahir Dar", "Partly Cloudy", 24));
        weatherData.put("Hawassa", new Weather("Hawassa", "Rainy", 22));
        System.out.println("Weather service started with cities: " + weatherData.keySet());
    }

    @WebMethod
    public Weather getWeather(String city) {
        System.out.println("getWeather called with city: '" + city + "'");

        // Handle null case gracefully
       

        Weather result = weatherData.get(city);
        if (result == null) {
            return new Weather(city, "No data available", 0);
        }

        return result;
    }

    @WebMethod
    public double toFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    @WebMethod
    public double toCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}