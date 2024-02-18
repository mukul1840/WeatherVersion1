package com.openweatherapp.OpenWeatherApp1.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "city",
        "date",
        "current time",
        "day"
})
public class ForecastWeather {
    @JsonProperty("city")
    private String cityName;

    @JsonProperty("WeatherConditions")
    private WeatherConditions weatherConditions;


    @JsonProperty("date")
    private String date;

    @JsonProperty("day")
    private String day;

    @JsonProperty("current time")
    private String currentTime;

    public String getDay() {return day;}

    public void setDay(String day) {this.day = day;}

    public String getCurrentTime() {return currentTime;}

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public String getCityName() {return cityName;}

    public void setCityName(String cityName) {this.cityName = cityName;}

    public WeatherConditions getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(WeatherConditions weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

}