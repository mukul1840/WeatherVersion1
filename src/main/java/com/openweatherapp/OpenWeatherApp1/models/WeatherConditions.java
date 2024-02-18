package com.openweatherapp.OpenWeatherApp1.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "time",
        "temp",
        "pressure",
        "sea_level",
        "grnd_level",
        "humidity",
        "wind_speed",
        "description"
})
public class WeatherConditions {
    @JsonProperty("time")
    private String time;
    @JsonProperty("temp")
    private String temp;
    @JsonProperty("pressure")
    private String pressure;
    @JsonProperty("sea_level")
    private String seaLevel;
    @JsonProperty("grnd_level")
    private String grndLevel;
    @JsonProperty("humidity")
    private String humidity;
    @JsonProperty("wind_speed")
    private String windSpeed;
    @JsonProperty("description")
    private String description;


    public String getTemp() {
        return temp;
    }


    public void setTemp(String temp) {
        this.temp = temp;
    }


    public String getPressure() {
        return pressure;
    }


    public void setPressure(String pressure) {
        this.pressure = pressure;
    }


    public String getSeaLevel() {
        return seaLevel;
    }


    public void setSeaLevel(String sea_level) {
        this.seaLevel = sea_level;
    }


    public String getGrndLevel() {
        return grndLevel;
    }


    public void setGrndLevel(String grnd_level) {
        this.grndLevel =  grnd_level;
    }


    public String getHumidity() {
        return humidity;
    }


    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }



    public String getTime() {return time;}


    public void setTime(String time) {
        this.time = time;
    }



    public String getWindSpeed() {return windSpeed;}


    public void setWindSpeed(String windSpeed) {this.windSpeed = windSpeed;}
}