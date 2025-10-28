## Report Document - [Link](https://drive.google.com/file/d/1vG4lkt_D6ykmDmnWxjngEVQnx_UTq651/view?usp=sharing) 
# Weather SOAP Web Service

A simple SOAP-based web service that provides weather information for Ethiopian cities. This service allows clients to retrieve weather data and perform temperature unit conversions.

## Features

- Get current weather information for major Ethiopian cities
- Convert temperatures between Celsius and Fahrenheit
- Simple and lightweight implementation using JAX-WS (Metro)
- Auto-generated WSDL for easy client integration

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher

## Getting Started

### Building the Project

```bash
mvn clean package
```

### Running the Service

```bash
java -jar target/weather-soap-service-1.0-SNAPSHOT.jar
```

The service will start and be available at:  
`http://localhost:8081/ws/weather?wsdl`

## Available Operations

### Get Weather by City
- **Operation**: `getWeather`
- **Input**: City name (String)
- **Output**: Weather object containing city name, description, and temperature in Celsius
- **Example**: Get weather for Addis Ababa
  ```xml
  <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
                   xmlns:ser="http://service.example.org/">
     <soapenv:Header/>
     <soapenv:Body>
        <ser:getWeather>
           <arg0>Addis Ababa</arg0>
        </ser:getWeather>
     </soapenv:Body>
  </soapenv:Envelope>
  ```

### Convert Celsius to Fahrenheit
- **Operation**: `toFahrenheit`
- **Input**: Temperature in Celsius (double)
- **Output**: Temperature in Fahrenheit (double)

### Convert Fahrenheit to Celsius
- **Operation**: `toCelsius`
- **Input**: Temperature in Fahrenheit (double)
- **Output**: Temperature in Celsius (double)

## Sample Cities

- Addis Ababa
- Bahir Dar
- Hawassa

## Project Structure

```
src/
├── main/
   ├── java/
      └── org/example/
          ├── Main.java           # Main application class
          ├── model/
          │   └── Weather.java    # Weather data model
          └── service/
             ├── WeatherPublisher.java   # Service publisher
             └── WeatherSOAPService.java # SOAP service implementation
                     # Test classes
```

## Dependencies

- JAX-WS API (Jakarta EE 9+)
- JAXB API and Runtime
- Jakarta Activation
- JAX-WS Tools

## Testing the Service

You can test the SOAP service using any SOAP client like SoapUI, Postman, or by generating a client from the WSDL.
