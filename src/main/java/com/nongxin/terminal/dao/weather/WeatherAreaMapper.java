package com.nongxin.terminal.dao.weather;

import com.nongxin.terminal.entity.weather.WeatherArea;

import java.util.List;

public interface WeatherAreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeatherArea record);

    int insertSelective(WeatherArea record);

    WeatherArea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeatherArea record);

    int updateByPrimaryKey(WeatherArea record);

    List<WeatherArea> getList();

    WeatherArea selectByAreaName(String areaName);
}