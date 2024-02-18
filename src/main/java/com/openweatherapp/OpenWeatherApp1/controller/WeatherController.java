package com.openweatherapp.OpenWeatherApp1.controller;

import com.openweatherapp.OpenWeatherApp1.constants.RestConstants;
import com.openweatherapp.OpenWeatherApp1.exception.InvalidCityNameException;
import com.openweatherapp.OpenWeatherApp1.models.*;
import com.openweatherapp.OpenWeatherApp1.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@RestController
@RequestMapping(RestConstants.API_PATH)
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping(RestConstants.CITY_WEATHER)
    public ResponseEntity<Object> getWeatherForFive(@PathVariable String city) {
        try {
            Future<List<WeatherDetails>> futureWeather = this.weatherService.getWeatherForFive(city);
            List<WeatherDetails> weatherDetails = futureWeather.get();
            return ResponseEntity.ok(weatherDetails);
        } catch (ParseException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while fetching weather data.");
        } catch (InvalidCityNameException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid city name provided.");
        }
    }}



