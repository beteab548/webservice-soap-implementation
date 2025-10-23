package com.example.model;

public class Weather {
    private String city;
    private double temperature;
    private String condition;

    public Weather() {}

    public Weather(String city, double temperature, String condition) {
        this.city = city;
        this.temperature = temperature;
        this.condition = condition;
    }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
}
