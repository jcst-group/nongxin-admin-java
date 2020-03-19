package com.nongxin.terminal.dao.weather;

import com.nongxin.terminal.entity.weather.WeatherHour;
import com.nongxin.terminal.vo.weather.WeatherVo;

import java.util.Date;
import java.util.List;

public interface WeatherHourMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeatherHour record);

    int insertSelective(WeatherHour record);

    WeatherHour selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeatherHour record);

    int updateByPrimaryKey(WeatherHour record);

    List<WeatherHour> getWeather(String areaCode);

    WeatherVo getWeatherByArea(String areaName,String areaLevel);

    WeatherVo getWeatherByCode(String areaCode);

    WeatherVo getLocationWeather(String fullName);

    WeatherHour selectByTimeAndCode(Date time, String areaCode);
}