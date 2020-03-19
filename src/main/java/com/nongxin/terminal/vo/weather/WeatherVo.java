package com.nongxin.terminal.vo.weather;

import com.nongxin.terminal.entity.weather.WeatherForecast;
import com.nongxin.terminal.entity.weather.WeatherHour;
import com.nongxin.terminal.entity.weather.WeatherReal;

import java.util.List;

public class WeatherVo {

    private String areaName;

    private String areaCode ;

    private WeatherReal now;

    private List<WeatherHour> weatherHour;

    private List<WeatherForecast> weatherDay;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public WeatherReal getNow() {
        return now;
    }

    public void setNow(WeatherReal now) {
        this.now = now;
    }

    public List<WeatherHour> getWeatherHour() {
        return weatherHour;
    }

    public void setWeatherHour(List<WeatherHour> weatherHour) {
        this.weatherHour = weatherHour;
    }

    public List<WeatherForecast> getWeatherDay() {
        return weatherDay;
    }

    public void setWeatherDay(List<WeatherForecast> weatherDay) {
        this.weatherDay = weatherDay;
    }
}
