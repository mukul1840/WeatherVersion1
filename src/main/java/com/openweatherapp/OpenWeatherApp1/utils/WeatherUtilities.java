package com.openweatherapp.OpenWeatherApp1.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class WeatherUtilities {
    public  static String getDayOfWeek(){
        Date currentDate = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = timeFormat.format(currentDate);
        SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        String dayOfWeek = dayOfWeekFormat.format(currentDate);
        return dayOfWeek;

    }
    public static String getCurrentTime(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss a");
        String formattedTime = formatter.format(currentDateTime);
        return formattedTime;
    }

    public static String getWeatherInstanceTime(String time) throws ParseException {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH a");
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date formatedTime = simpleDateFormat.parse(time);
        return timeFormat.format(formatedTime);
    }


}
