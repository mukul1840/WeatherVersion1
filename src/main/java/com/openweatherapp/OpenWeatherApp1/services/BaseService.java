package com.openweatherapp.OpenWeatherApp1.services;

import com.openweatherapp.OpenWeatherApp1.exception.InvalidCityNameException;
import com.openweatherapp.OpenWeatherApp1.models.WeatherDetails;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.Future;

@Service
public abstract class BaseService {
    @Async
    public abstract Future<List<WeatherDetails>> getWeatherForFive(String city) throws ParseException, InvalidCityNameException;
}
