package com.nongxin.terminal.entity.weather;

import java.math.BigDecimal;

public class WeatherHistory {
    private Integer id;

    private Float aqi;

    private BigDecimal minTemperature;

    private BigDecimal maxTemperature;

    private String windDirection;

    private String windPower;

    private String day;

    private String areaCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getAqi() {
        return aqi;
    }

    public void setAqi(Float aqi) {
        this.aqi = aqi;
    }

    public BigDecimal getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(BigDecimal minTemperature) {
        this.minTemperature = minTemperature;
    }

    public BigDecimal getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(BigDecimal maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection == null ? null : windDirection.trim();
    }

    public String getWindPower() {
        return windPower;
    }

    public void setWindPower(String windPower) {
        this.windPower = windPower == null ? null : windPower.trim();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }
}