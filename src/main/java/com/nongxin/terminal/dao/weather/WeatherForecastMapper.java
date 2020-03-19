package com.nongxin.terminal.dao.weather;

import com.nongxin.terminal.entity.weather.WeatherForecast;

import java.util.Date;
import java.util.List;

public interface WeatherForecastMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeatherForecast record);

    int insertSelective(WeatherForecast record);

    WeatherForecast selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeatherForecast record);

    int updateByPrimaryKey(WeatherForecast record);

    WeatherForecast selectByDayAndAreaCode(Date day,String areaCode);

    List<WeatherForecast> getWeekWeather(String areaCode);
}