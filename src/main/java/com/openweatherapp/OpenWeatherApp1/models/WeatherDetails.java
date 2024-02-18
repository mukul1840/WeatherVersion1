package com.openweatherapp.OpenWeatherApp1.models;


import com.fasterxml.jackson.annotation.JsonProperty;



public class WeatherDetails {

    @JsonProperty("Today's Weather")
    private ForecastWeather forecastWeather;

    @JsonProperty("Today's Weather")
    public void setForecastWeather(ForecastWeather forecastWeather) {
        this.forecastWeather = forecastWeather;
    }


}
