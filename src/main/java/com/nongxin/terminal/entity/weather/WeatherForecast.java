package com.nongxin.terminal.entity.weather;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class WeatherForecast {
    private Integer id;

    private BigDecimal airPress;

    private BigDecimal dayAirTemperature;

    private String dayWeather;

    private BigDecimal nightAirTemperature;

    private String nightWeather;

    private String dayWindDirection;

    private String dayWindPower;

    private String jiangshui;

    private String nightWindDirection;

    private String nightWindPower;

    private String sunBeginEnd;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date day;

    private String areaCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAirPress() {
        return airPress;
    }

    public void setAirPress(BigDecimal airPress) {
        this.airPress = airPress;
    }

    public BigDecimal getDayAirTemperature() {
        return dayAirTemperature;
    }

    public void setDayAirTemperature(BigDecimal dayAirTemperature) {
        this.dayAirTemperature = dayAirTemperature;
    }

    public String getDayWeather() {
        return dayWeather;
    }

    public void setDayWeather(String dayWeather) {
        this.dayWeather = dayWeather;
    }

    public BigDecimal getNightAirTemperature() {
        return nightAirTemperature;
    }

    public void setNightAirTemperature(BigDecimal nightAirTemperature) {
        this.nightAirTemperature = nightAirTemperature;
    }

    public String getNightWeather() {
        return nightWeather;
    }

    public void setNightWeather(String nightWeather) {
        this.nightWeather = nightWeather;
    }

    public String getDayWindDirection() {
        return dayWindDirection;
    }

    public void setDayWindDirection(String dayWindDirection) {
        this.dayWindDirection = dayWindDirection == null ? null : dayWindDirection.trim();
    }

    public String getDayWindPower() {
        return dayWindPower;
    }

    public void setDayWindPower(String dayWindPower) {
        this.dayWindPower = dayWindPower == null ? null : dayWindPower.trim();
    }

    public String getJiangshui() {
        return jiangshui;
    }

    public void setJiangshui(String jiangshui) {
        this.jiangshui = jiangshui == null ? null : jiangshui.trim();
    }

    public String getNightWindDirection() {
        return nightWindDirection;
    }

    public void setNightWindDirection(String nightWindDirection) {
        this.nightWindDirection = nightWindDirection == null ? null : nightWindDirection.trim();
    }

    public String getNightWindPower() {
        return nightWindPower;
    }

    public void setNightWindPower(String nightWindPower) {
        this.nightWindPower = nightWindPower == null ? null : nightWindPower.trim();
    }

    public String getSunBeginEnd() {
        return sunBeginEnd;
    }

    public void setSunBeginEnd(String sunBeginEnd) {
        this.sunBeginEnd = sunBeginEnd == null ? null : sunBeginEnd.trim();
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }
}