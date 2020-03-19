package com.nongxin.terminal.dao.weather;

import com.nongxin.terminal.entity.weather.WeatherHistory;

public interface WeatherHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeatherHistory record);

    int insertSelective(WeatherHistory record);

    WeatherHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeatherHistory record);

    int updateByPrimaryKey(WeatherHistory record);

    WeatherHistory selectByDayAndCode(String day,String areaCode);
}