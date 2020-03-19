package com.nongxin.terminal.service.weather;

import com.nongxin.terminal.entity.weather.WeatherHour;
import com.nongxin.terminal.vo.weather.WeatherVo;

import java.util.List;

public interface WeatherHourService {

    List<WeatherHour> getWeather(String areaCode);

    WeatherVo getWeatherByArea(String areaName,String areaLevel);

    WeatherVo getWeatherByCode(String areaCode);

    WeatherVo getLocationWeather(String fullName);
}
