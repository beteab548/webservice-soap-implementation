package com.example.api;

import com.example.model.Weather;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.*;

@Path("/weather")
public class WeatherService {

    private static final Map<String, Weather> data = new HashMap<>();

    static {
        data.put("Addis Ababa", new Weather("Addis Ababa", 21.5, "Sunny"));
        data.put("Bahir Dar", new Weather("Bahir Dar", 24.3, "Partly Cloudy"));
        data.put("Hawassa", new Weather("Hawassa", 22.0, "Rainy"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Weather> getAllCities() {
        return data.values();
    }

    @GET
    @Path("/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public Weather getWeatherByCity(@PathParam("city") String city) {
        Weather weather = data.get(city);
        if (weather == null) throw new NotFoundException("City not found");
        return weather;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Weather addWeather(Weather weather) {
        data.put(weather.getCity(), weather);
        return weather;
    }
}
