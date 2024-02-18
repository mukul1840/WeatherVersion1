package com.openweatherapp.OpenWeatherApp1.services;

import com.openweatherapp.OpenWeatherApp1.constants.ServiceConstants;
import com.openweatherapp.OpenWeatherApp1.dto.WeatherJsonParser;
import com.openweatherapp.OpenWeatherApp1.exception.InvalidCityNameException;
import com.openweatherapp.OpenWeatherApp1.models.WeatherDetails;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
public class WeatherService extends BaseService {
   // Service Method to communicate with Third API OpenWeatherMAp
    @Async
    public Future<List<WeatherDetails>> getWeatherForFive(String city) throws ParseException, InvalidCityNameException {
        try {
            String websiteResponse =  ServiceConstants.webPrefix+city+ServiceConstants.webSuffix;
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(websiteResponse, String.class);
            WeatherJsonParser jsonParser = new WeatherJsonParser();
            return CompletableFuture.completedFuture(jsonParser.parseWeatherJson(result));
        } catch (HttpClientErrorException.NotFound e) {
            throw new InvalidCityNameException("Invalid city name provided.");
        } catch (ParseException e) {
            throw e;
        }
    }


}