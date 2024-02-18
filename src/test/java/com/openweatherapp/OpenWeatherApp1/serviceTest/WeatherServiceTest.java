package com.openweatherapp.OpenWeatherApp1.serviceTest;

import com.openweatherapp.OpenWeatherApp1.exception.InvalidCityNameException;
import com.openweatherapp.OpenWeatherApp1.models.WeatherDetails;
import com.openweatherapp.OpenWeatherApp1.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WeatherServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherService weatherService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetWeatherForFive_ValidCity() throws Exception {
        String city = "London";
        String mockJsonResponse = "{ \"list\": [ { \"main\": { \"temp\": 10, \"pressure\": 1013, \"humidity\": 70 }, \"weather\": [ { \"description\": \"Cloudy\" } ], \"wind\": { \"speed\": 5 }, \"dt_txt\": \"2024-02-18 12:00:00\" } ], \"city\": { \"name\": \"London\" } }";
        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(mockJsonResponse);
        Future<List<WeatherDetails>> weatherDetailsFuture = weatherService.getWeatherForFive(city);
        List<WeatherDetails> weatherDetailsList = weatherDetailsFuture.get();
        assertEquals(5, weatherDetailsList.size());
    }

    @Test
    public void testGetWeatherForFive_InvalidCity() throws Exception {
        String city = "InvalidCity";
        when(restTemplate.getForObject(anyString(), eq(String.class))).thenThrow(HttpClientErrorException.NotFound.class);
        try {
            weatherService.getWeatherForFive(city);
        } catch (InvalidCityNameException e) {
            assertEquals("Invalid city name provided.", e.getMessage());
        }
    }
}
