package com.nongxin.terminal.dao.weather;

import com.nongxin.terminal.entity.weather.WeatherReal;

import java.util.Date;

public interface WeatherRealMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeatherReal record);

    int insertSelective(WeatherReal record);

    WeatherReal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeatherReal record);

    int updateByPrimaryKey(WeatherReal record);

    WeatherReal selectByTimeAndAreaCode(String time, String areaCode);
}