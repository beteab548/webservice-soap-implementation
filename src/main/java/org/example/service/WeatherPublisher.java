package org.example.service;

import jakarta.xml.ws.Endpoint;

public class WeatherPublisher {
    public static void main(String[] args) {
        String url = "http://localhost:8081/ws/weather";
        Endpoint.publish(url, new WeatherSOAPService());
        System.out.println("SOAP Weather Service running at: " + url + "?wsdl");
    }
}
