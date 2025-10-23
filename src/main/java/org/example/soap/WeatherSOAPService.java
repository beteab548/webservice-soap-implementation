package com.example.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService
public class WeatherSOAPService {

    private final Map<String, String> weatherData = new HashMap<>();

    public WeatherSOAPService() {
        weatherData.put("Addis Ababa", "Sunny, 21°C");
        weatherData.put("Bahir Dar", "Partly Cloudy, 24°C");
        weatherData.put("Hawassa", "Rainy, 22°C");
    }

    @WebMethod
    public String getWeather(String city) {
        return weatherData.getOrDefault(city, "No data available for " + city);
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