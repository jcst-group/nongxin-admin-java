package com.nongxin.terminal.entity.weather;

import java.math.BigDecimal;
import java.util.Date;

public class WeatherReal {
    private Integer id;

    private Float aqi;

    private BigDecimal co;

    private BigDecimal no2;

    private BigDecimal o3;

    private BigDecimal pm10;

    private BigDecimal pm25;

    private BigDecimal so2;

    private BigDecimal airTem;

    private String airHum;

    private String windDirection;

    private String windPower;

    private Date monitorTime;

    private String areaCode;

    private String weather;

    private String weatherCode;

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

    public BigDecimal getCo() {
        return co;
    }

    public void setCo(BigDecimal co) {
        this.co = co;
    }

    public BigDecimal getNo2() {
        return no2;
    }

    public void setNo2(BigDecimal no2) {
        this.no2 = no2;
    }

    public BigDecimal getO3() {
        return o3;
    }

    public void setO3(BigDecimal o3) {
        this.o3 = o3;
    }

    public BigDecimal getPm10() {
        return pm10;
    }

    public void setPm10(BigDecimal pm10) {
        this.pm10 = pm10;
    }

    public BigDecimal getPm25() {
        return pm25;
    }

    public void setPm25(BigDecimal pm25) {
        this.pm25 = pm25;
    }

    public BigDecimal getSo2() {
        return so2;
    }

    public void setSo2(BigDecimal so2) {
        this.so2 = so2;
    }

    public BigDecimal getAirTem() {
        return airTem;
    }

    public void setAirTem(BigDecimal airTem) {
        this.airTem = airTem;
    }

    public String getAirHum() {
        return airHum;
    }

    public void setAirHum(String airHum) {
        this.airHum = airHum == null ? null : airHum.trim();
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

    public Date getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }
}