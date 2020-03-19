package com.nongxin.terminal.vo.nxboard;

import com.nongxin.terminal.util.enumUtil.base.SoilTypeEnum;

import java.math.BigDecimal;
import java.util.List;

public class LotVo {

    private Integer id;

    private Integer baseId;

    private String lotName;

    private String lotCode;

    private String areaCode;

    private BigDecimal lotAcreage;

    private BigDecimal lotRadius;

    private String survey;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private BigDecimal altitude;

    private Short status;

    private SoilTypeEnum soilType;

    private List<String> crop;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public BigDecimal getLotAcreage() {
        return lotAcreage;
    }

    public void setLotAcreage(BigDecimal lotAcreage) {
        this.lotAcreage = lotAcreage;
    }

    public BigDecimal getLotRadius() {
        return lotRadius;
    }

    public void setLotRadius(BigDecimal lotRadius) {
        this.lotRadius = lotRadius;
    }

    public String getSurvey() {
        return survey;
    }

    public void setSurvey(String survey) {
        this.survey = survey;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getAltitude() {
        return altitude;
    }

    public void setAltitude(BigDecimal altitude) {
        this.altitude = altitude;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public SoilTypeEnum getSoilType() {
        return soilType;
    }

    public void setSoilType(SoilTypeEnum soilType) {
        this.soilType = soilType;
    }

    public List<String> getCrop() {
        return crop;
    }

    public void setCrop(List<String> crop) {
        this.crop = crop;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
