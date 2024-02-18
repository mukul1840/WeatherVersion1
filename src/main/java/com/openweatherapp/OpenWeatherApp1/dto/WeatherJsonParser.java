package com.openweatherapp.OpenWeatherApp1.dto;

import com.openweatherapp.OpenWeatherApp1.constants.WeatherApi;
import com.openweatherapp.OpenWeatherApp1.models.*;
import com.openweatherapp.OpenWeatherApp1.utils.WeatherUtilities;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class WeatherJsonParser {
    public List<WeatherDetails> parseWeatherJson(String json) throws ParseException {
        JSONObject root = new JSONObject(json);
        List<WeatherDetails> weatherList = new ArrayList<>();
        JSONArray weatherObject = root.getJSONArray(WeatherApi.LIST);
        JSONObject cityObj = root.getJSONObject(WeatherApi.CITY);
        String cityName = cityObj.getString(WeatherApi.CITY_NAME);
        for (int i = 0; i < 5; i++) {
            JSONObject arrayElement = weatherObject.getJSONObject(i);
            JSONObject jsonObject = arrayElement.getJSONObject(WeatherApi.MAIN);
            String temp = String.valueOf(jsonObject.getInt(WeatherApi.TEMPERATURE));
            String pressure = String.valueOf(jsonObject.getInt(WeatherApi.PRESSURE));
            String humidity = String.valueOf(jsonObject.getInt(WeatherApi.HUMIDITY));
            String sea_level = String.valueOf(jsonObject.getInt(WeatherApi.SEA_LEVEL));
            String grnd_level = String.valueOf(jsonObject.getInt(WeatherApi.GRND_LEVEL));
            String description = arrayElement.getJSONArray(WeatherApi.WEATHER).getJSONObject(0).getString(WeatherApi.DESCRIPTION);
            String windSpeed= String.valueOf(arrayElement.getJSONObject(WeatherApi.WIND).getInt(WeatherApi.SPEED));
            String date = arrayElement.getString(WeatherApi.DATE).substring(0,10);
            String time = arrayElement.getString(WeatherApi.TIME);
            ForecastWeather forecastWeather = new ForecastWeather();
            WeatherConditions weatherConditions = new WeatherConditions();
            WeatherDetails weatherDetails = new WeatherDetails();
            weatherConditions.setTemp(temp +WeatherApi.CELSIUS);
            weatherConditions.setPressure(pressure +WeatherApi.HECTOPASCAL);
            weatherConditions.setHumidity(humidity+WeatherApi.PERCENTAGE);
            weatherConditions.setGrndLevel(grnd_level+WeatherApi.HECTOPASCAL);
            weatherConditions.setSeaLevel(sea_level+WeatherApi.HECTOPASCAL);
            weatherConditions.setWindSpeed(windSpeed+WeatherApi.METER_SEC);
            weatherConditions.setDescription(description);
            weatherConditions.setTime(WeatherUtilities.getWeatherInstanceTime(time));
            forecastWeather.setCityName(cityName);
            forecastWeather.setDate(date);
            forecastWeather.setCurrentTime(WeatherUtilities.getCurrentTime());
            forecastWeather.setDay(WeatherUtilities.getDayOfWeek());
            forecastWeather.setWeatherConditions(weatherConditions);
            weatherDetails.setForecastWeather(forecastWeather);
            weatherList.add(weatherDetails);
        }
        return weatherList;
    }

}