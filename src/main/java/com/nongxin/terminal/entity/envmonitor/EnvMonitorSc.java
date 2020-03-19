package com.nongxin.terminal.entity.envmonitor;

import java.math.BigDecimal;
import java.util.Date;

public class EnvMonitorSc {
    private Integer id;

    private BigDecimal airTemperature;

    private BigDecimal airHumidity;

    private BigDecimal airPressure;

    private BigDecimal windSpeed;

    private BigDecimal windDirection;

    private BigDecimal rainfall;

    private BigDecimal soilTemperature;

    private BigDecimal soilHumidity;

    private BigDecimal soilPh;

    private Date monitorTime;

    private Date updateTime;

    private Integer equipmentId;

    private Integer factoryId;

    private Equipment equipment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(BigDecimal airTemperature) {
        this.airTemperature = airTemperature;
    }

    public BigDecimal getAirHumidity() {
        return airHumidity;
    }

    public void setAirHumidity(BigDecimal airHumidity) {
        this.airHumidity = airHumidity;
    }

    public BigDecimal getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(BigDecimal airPressure) {
        this.airPressure = airPressure;
    }

    public BigDecimal getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(BigDecimal windSpeed) {
        this.windSpeed = windSpeed;
    }

    public BigDecimal getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(BigDecimal windDirection) {
        this.windDirection = windDirection;
    }

    public BigDecimal getRainfall() {
        return rainfall;
    }

    public void setRainfall(BigDecimal rainfall) {
        this.rainfall = rainfall;
    }

    public BigDecimal getSoilTemperature() {
        return soilTemperature;
    }

    public void setSoilTemperature(BigDecimal soilTemperature) {
        this.soilTemperature = soilTemperature;
    }

    public BigDecimal getSoilHumidity() {
        return soilHumidity;
    }

    public void setSoilHumidity(BigDecimal soilHumidity) {
        this.soilHumidity = soilHumidity;
    }

    public BigDecimal getSoilPh() {
        return soilPh;
    }

    public void setSoilPh(BigDecimal soilPh) {
        this.soilPh = soilPh;
    }

    public Date getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}